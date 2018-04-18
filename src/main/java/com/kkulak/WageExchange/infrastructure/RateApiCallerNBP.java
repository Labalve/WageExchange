package com.kkulak.WageExchange.infrastructure;

import java.math.BigDecimal;
import org.springframework.web.client.RestTemplate;

public class RateApiCallerNBP implements RateApiCaller {

    private final String endpoint = "http://api.nbp.pl/api/exchangerates/rates/a/";
    
    @Override
    public BigDecimal getRate(String from, String to) throws ApiNotRespondingException {
        if (!to.equals("PLN")) {
            throw new IllegalArgumentException("NBPCourseChecker is for converting into PLN only.");
        }
        if (from.equals("PLN")) {
            return new BigDecimal(1);
        }
        RestTemplate restTemplate = new RestTemplate();
        NBPResponse response = restTemplate.getForObject(endpoint + String.valueOf(from).toLowerCase() + "/", NBPResponse.class);
        if (response == null) {
            throw new ApiNotRespondingException("Can't access the current exchange rates.");
        }
        return response.getRate();
    }

}

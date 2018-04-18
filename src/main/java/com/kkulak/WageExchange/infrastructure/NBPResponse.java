package com.kkulak.WageExchange.infrastructure;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NBPResponse {

    private String code;

    private BigDecimal rate;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @SuppressWarnings("unchecked")
    @JsonProperty("rates")
    private void unpackNested(List<Map<String,Object>> rates) {
        Map<String, Object> rate = rates.get(0);
        this.rate = new BigDecimal(rate.get("mid").toString()).setScale(4, BigDecimal.ROUND_HALF_UP);
    }
    
    public void setRate(BigDecimal rates) {
        this.rate = rates;
    }

    public BigDecimal getRate() {
        return rate;
    }

}

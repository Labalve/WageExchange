package com.kkulak.WageExchange.infrastructure;

import java.math.BigDecimal;

public interface RateApiCaller {

    BigDecimal getRate(String from, String to) throws ApiNotRespondingException;
    
}

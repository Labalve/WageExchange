package com.kkulak.WageExchange.domain;

import com.kkulak.WageExchange.infrastructure.ApiNotRespondingException;
import java.math.BigDecimal;

public interface RateChecker {

    BigDecimal getRate(Currency from, Currency to)  throws ApiNotRespondingException ;
    
}

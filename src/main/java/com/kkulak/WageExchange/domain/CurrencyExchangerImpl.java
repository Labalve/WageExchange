package com.kkulak.WageExchange.domain;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;

public class CurrencyExchangerImpl implements CurrencyExchanger {

    @Autowired
    RateChecker rateChecker;
    
    @Override
    public BigDecimal exchange(BigDecimal value, Currency from, Currency to) {
        return value.multiply(new BigDecimal(rateChecker.getRate(from, to)));
    }

}

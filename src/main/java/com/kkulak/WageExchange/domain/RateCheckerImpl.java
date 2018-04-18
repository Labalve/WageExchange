package com.kkulak.WageExchange.domain;

import com.kkulak.WageExchange.infrastructure.ApiNotRespondingException;
import com.kkulak.WageExchange.infrastructure.RateApiCaller;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;

public class RateCheckerImpl implements RateChecker {

    @Autowired
    RateApiCaller rateApiCaller;

    @Override
    public BigDecimal getRate(Currency from, Currency to) throws ApiNotRespondingException {
        return rateApiCaller.getRate(String.valueOf(from), String.valueOf(to));
    }

}

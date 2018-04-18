package com.kkulak.WageExchange.domain;

import com.kkulak.WageExchange.infrastructure.ApiNotRespondingException;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;

public class CurrencyExchangerImpl implements CurrencyExchanger {

    @Autowired
    RateChecker rateChecker;

    @Override
    public BigDecimal exchange(BigDecimal value, Currency from, Currency to) throws ApiNotRespondingException {
        return value.multiply(rateChecker.getRate(from, to));
    }

}

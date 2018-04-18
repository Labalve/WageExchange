package com.kkulak.WageExchange.domain;

import com.kkulak.WageExchange.infrastructure.ApiNotRespondingException;
import java.math.BigDecimal;

public interface CurrencyExchanger {

    public BigDecimal exchange(BigDecimal value, Currency from, Currency to) throws ApiNotRespondingException;

}

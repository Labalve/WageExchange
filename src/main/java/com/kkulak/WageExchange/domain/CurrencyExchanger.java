package com.kkulak.WageExchange.domain;

import java.math.BigDecimal;

public interface CurrencyExchanger {

    public BigDecimal exchange(BigDecimal value, Currency from, Currency to);
    
}

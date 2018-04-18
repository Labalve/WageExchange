package com.kkulak.WageExchange.domain;

import java.math.BigDecimal;

public interface MonthlyNetCalculator {

    BigDecimal calculate(BigDecimal value, Country country);
    
}

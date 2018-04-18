package com.kkulak.WageExchange.domain;

import java.math.BigDecimal;
import com.google.common.base.Preconditions;

public class MonthlyNetCalculatorImpl implements MonthlyNetCalculator {

    final static int DAYS_IN_MONTH = 22;

    @Override
    public BigDecimal calculate(BigDecimal value, Country country) {
        Preconditions.checkArgument(value.compareTo(BigDecimal.ZERO) > 0, "Calculated value must be bigger than 0.");
        Preconditions.checkArgument(country != null, "Country cannot be null.");
        value = value.multiply(new BigDecimal(DAYS_IN_MONTH)).setScale(2, BigDecimal.ROUND_HALF_UP);
        if (value.compareTo(country.getCostOfIncome()) != 1) {
            return value;
        }
        BigDecimal taxPercentage = new BigDecimal(country.getTaxRate() / 100).setScale(2, BigDecimal.ROUND_HALF_UP);
        return value.subtract(value.subtract(country.getCostOfIncome()).multiply(taxPercentage)).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

}

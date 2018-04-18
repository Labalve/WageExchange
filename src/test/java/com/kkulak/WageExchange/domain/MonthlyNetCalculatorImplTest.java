package com.kkulak.WageExchange.domain;

import java.math.BigDecimal;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class MonthlyNetCalculatorImplTest {

    int plnDaily = 200;
    int daysInMonth = 22;
    int costOfIncomePL = 1200;
    double taxPercentage = 0.19;

    @Test
    public void calculate() {
        BigDecimal value = new BigDecimal(plnDaily);
        Country country = Country.of("Poland", Currency.PLN, 19, new BigDecimal(1200));
        MonthlyNetCalculatorImpl instance = new MonthlyNetCalculatorImpl();
        BigDecimal expResult = new BigDecimal(plnDaily * daysInMonth - (plnDaily * daysInMonth - costOfIncomePL) * taxPercentage).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal result = instance.calculate(value, country);
        assertThat(result).isEqualTo(expResult);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void calculateWithNullCountry() {
        BigDecimal value = new BigDecimal(plnDaily);
        Country country = null;
        MonthlyNetCalculatorImpl instance = new MonthlyNetCalculatorImpl();
        BigDecimal result = instance.calculate(value, country);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void calculateWithZeroValue() {
        BigDecimal value = new BigDecimal(0);
        Country country = mock(Country.class);
        MonthlyNetCalculatorImpl instance = new MonthlyNetCalculatorImpl();
        BigDecimal result = instance.calculate(value, country);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void calculateWithNegativeValue() {
        BigDecimal value = new BigDecimal(-123);
        Country country = mock(Country.class);
        MonthlyNetCalculatorImpl instance = new MonthlyNetCalculatorImpl();
        BigDecimal result = instance.calculate(value, country);
    }

}

package com.kkulak.WageExchange.domain;

import java.math.BigDecimal;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class MonthlyNetCalculatorImplTest {

    int daily = 200;
    int daysInMonth = 22;
    int costOfIncomePl = 1200;
    int costOfIncomeDe = 800;
    double taxPercentagePl = 0.19;
    double taxPercentageDe = 0.20;

    @Test
    public void calculateForPL() {
        BigDecimal value = new BigDecimal(daily);
        Country country = Country.of("Poland", Currency.PLN, 19, new BigDecimal(1200));
        MonthlyNetCalculatorImpl instance = new MonthlyNetCalculatorImpl();
        BigDecimal expResult = monthlyNet(taxPercentagePl, costOfIncomePl, 1);
        BigDecimal result = instance.calculate(value, country);
        assertThat(result).isEqualTo(expResult);
    }
    
    @Test
    public void calculateForDe() {
        double eurRate = 4;
        BigDecimal value = new BigDecimal(daily);
        Country country = Country.of("Germany", Currency.EUR, 20, new BigDecimal(800));
        MonthlyNetCalculatorImpl instance = new MonthlyNetCalculatorImpl();
        BigDecimal expResult = monthlyNet(taxPercentageDe, costOfIncomeDe, eurRate);
        BigDecimal result = instance.calculate(value.multiply(new BigDecimal(eurRate)), country);
        assertThat(result).isEqualTo(expResult);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void calculateWithNullCountry() {
        BigDecimal value = new BigDecimal(daily);
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

    private BigDecimal monthlyNet(double taxPercentage, int costOfIncome, double rate){
        return new BigDecimal(daily * rate * daysInMonth - (daily * rate * daysInMonth - costOfIncome) * taxPercentage).setScale(2, BigDecimal.ROUND_HALF_UP);
    }
    
}

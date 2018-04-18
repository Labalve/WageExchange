package com.kkulak.WageExchange.domain;

import java.math.BigDecimal;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;

public class MonthlyNetServiceImplTest {

    int daysInMonth;
    BigDecimal value;
    MonthlyNetServiceImpl instance;
    Country poland;
    Country germany;
    Country unitedKingdom;

    @Before
    public void before() throws WrongCountryCodeException {
        daysInMonth = 22;
        value = new BigDecimal(200);
        poland = Country.of("Poland", Currency.PLN, 19, new BigDecimal(1200));
        unitedKingdom = Country.of("United Kingdom", Currency.GBP, 25, new BigDecimal(600));
        germany = Country.of("Germany", Currency.EUR, 20, new BigDecimal(800));

        final CurrencyExchanger currencyExchanger = mock(CurrencyExchanger.class);
        when(currencyExchanger.exchange(value, Currency.EUR, Currency.PLN)).thenReturn(value.multiply(new BigDecimal(4)));
        when(currencyExchanger.exchange(value, Currency.GBP, Currency.PLN)).thenReturn(value.multiply(new BigDecimal(4.5)));

        final CountryProvider countryProvider = mock(CountryProvider.class);
        when(countryProvider.getCountry("PL")).thenReturn(poland);
        when(countryProvider.getCountry("DE")).thenReturn(germany);
        when(countryProvider.getCountry("UK")).thenReturn(unitedKingdom);

        final MonthlyNetCalculator monthlyNetCalculator = mock(MonthlyNetCalculator.class);
        when(monthlyNetCalculator.calculate(value, poland)).thenReturn(calculateNet(value, new BigDecimal(1200), 19, 1));
        when(monthlyNetCalculator.calculate(value.multiply(new BigDecimal(4)), germany)).thenReturn(calculateNet(value, new BigDecimal(800), 20, 4));
        when(monthlyNetCalculator.calculate(value.multiply(new BigDecimal(4.5)), unitedKingdom)).thenReturn(calculateNet(value, new BigDecimal(600), 25, 4.5));

        instance = MonthlyNetServiceImpl.with(countryProvider, monthlyNetCalculator, currencyExchanger);
    }

    @Test
    public void getMonthlyNet() throws WrongCountryCodeException {
        Wage expected = Wage.of(new BigDecimal(14240), Currency.PLN);
        Wage result = instance.getMonthlyNet(new BigDecimal(200), "DE");
        assertThat(result.getValue()).isEqualTo(expected.getValue());
        assertThat(result.getCurrency()).isEqualTo(expected.getCurrency());
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void getMonthlyNetWithNullValue() throws WrongCountryCodeException {
        instance.getMonthlyNet(null, "DE");
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void getMonthlyNetWithNullCurrency() throws WrongCountryCodeException {
        instance.getMonthlyNet(new BigDecimal(14240), null);
    }
    
    private BigDecimal calculateNet(BigDecimal value, BigDecimal costOfIncome, double taxRate, double exchangeRate) {
        BigDecimal grossMonth = value.multiply(new BigDecimal(exchangeRate)).multiply(new BigDecimal(daysInMonth));
        BigDecimal tax = (grossMonth.subtract(costOfIncome)).multiply(new BigDecimal(taxRate / 100));
        BigDecimal netMonth = (grossMonth.subtract(tax)).setScale(2, BigDecimal.ROUND_HALF_UP);
        return netMonth;
    }
}

package com.kkulak.WageExchange.domain;

import com.google.common.base.Preconditions;
import com.kkulak.WageExchange.infrastructure.ApiNotRespondingException;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;

public class MonthlyNetServiceImpl implements MonthlyNetService {

    static final Currency TARGET_CURRENCY = Currency.PLN;

    @Autowired
    private CountryProvider countryProvider;

    @Autowired
    private MonthlyNetCalculator monthlyNetCalculator;

    @Autowired
    private CurrencyExchanger currencyExchanger;

    public static MonthlyNetServiceImpl with(CountryProvider countryProvider, MonthlyNetCalculator monthlyNetCalculator, CurrencyExchanger currencyExchanger) {
        return new MonthlyNetServiceImpl(countryProvider, monthlyNetCalculator, currencyExchanger);
    }

    @Override
    public Wage getMonthlyNet(BigDecimal value, String countryCode) throws WrongCountryCodeException, ApiNotRespondingException  {
        Preconditions.checkArgument(value != null, "value cannot be null");
        Preconditions.checkArgument(countryCode != null, "countryCode cannot be null");
        Country country = countryProvider.getCountry(countryCode);
        BigDecimal exchangedValue = currencyExchanger.exchange(value, country.getCurrency(), TARGET_CURRENCY);
        BigDecimal finalValue = monthlyNetCalculator.calculate(exchangedValue, country);
        return Wage.of(finalValue, Currency.PLN);
    }

    private MonthlyNetServiceImpl(CountryProvider countryProvider, MonthlyNetCalculator monthlyNetCalculator, CurrencyExchanger currencyExchanger) {
        this.countryProvider = countryProvider;
        this.monthlyNetCalculator = monthlyNetCalculator;
        this.currencyExchanger = currencyExchanger;
    }

    // needed for autowiring
    public MonthlyNetServiceImpl() {
        ;
    }

}

package com.kkulak.WageExchange.domain;

import com.kkulak.WageExchange.infrastructure.CountryProvider;
import com.google.common.base.Preconditions;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;

public class MonthlyNetServiceImpl implements MonthlyNetService {

    static final Currency TARGET_CURRENCY = Currency.PLN;

    @Autowired
    CountryProvider countryProvider;
    
    @Autowired
    MonthlyNetCalculator monthlyNetCalculator;
    
    @Autowired
    CurrencyExchanger currencyExchanger;
    
    public static MonthlyNetService with(CurrencyExchanger currencyExchanger) {
        MonthlyNetServiceImpl instance = new MonthlyNetServiceImpl();
        instance.currencyExchanger = currencyExchanger;
        return instance;
    }
    
    @Override
    public Wage getMonthlyNet(BigDecimal value, String countryCode) throws WrongCountryCodeException {
        Preconditions.checkArgument(value != null, "value cannot be null");
        Preconditions.checkArgument(countryCode != null, "countryCode cannot be null");
        Country country = countryProvider.getCountry(countryCode);
        BigDecimal exchangedValue = currencyExchanger.exchange(value, country.getCurrency(), TARGET_CURRENCY);
        BigDecimal finalValue = monthlyNetCalculator.calculate(exchangedValue, country);
        return Wage.of(finalValue, Currency.PLN);
    }

}

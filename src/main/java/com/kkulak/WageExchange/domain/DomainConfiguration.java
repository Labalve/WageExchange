package com.kkulak.WageExchange.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfiguration {

    @Bean
    public RateChecker RateCheckerImpl() {
        return new RateCheckerImpl();
    }

    @Bean
    MonthlyNetCalculator MonthlyNetCalculatorImpl() {
        return new MonthlyNetCalculatorImpl();
    }

    @Bean
    CurrencyExchanger CurrencyExchangerImpl() {
        return new CurrencyExchangerImpl();
    }

    @Bean
    public CountryProvider CountryProviderImpl() {
        return new CountryProviderImpl();
    }

    @Bean
    public HashMap<String, Country> Countries() {
        HashMap<String, Country> countries = new HashMap<>();
        Country poland = Country.of("Poland", Currency.PLN, 19, new BigDecimal(1200));
        countries.put("PL", poland);
        Country unitedKingdom = Country.of("United Kingdom", Currency.GBP, 25, new BigDecimal(600));
        countries.put("UK", unitedKingdom);
        Country germany = Country.of("Germany", Currency.EUR, 20, new BigDecimal(800));
        countries.put("DE", germany);
        return countries;
    }

}

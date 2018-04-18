package com.kkulak.WageExchange.domain;

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

}

package com.kkulak.WageExchange.infrastructure;

import com.kkulak.WageExchange.domain.Country;
import com.kkulak.WageExchange.domain.Currency;
import java.math.BigDecimal;
import java.util.HashMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InfrastructureConfiguration {

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
        countries.put("DE", unitedKingdom);
        return countries;
    }

}

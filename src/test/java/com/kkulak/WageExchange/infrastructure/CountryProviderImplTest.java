package com.kkulak.WageExchange.infrastructure;

import com.kkulak.WageExchange.domain.Country;
import com.kkulak.WageExchange.domain.Currency;
import com.kkulak.WageExchange.domain.WrongCountryCodeException;
import java.math.BigDecimal;
import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CountryProviderImplTest {

    CountryProviderImpl countryProvider;

    Country poland;
    Country germany;
    Country unitedKingdom;

    @Before
    public void before() {
        HashMap<String, Country> countries = new HashMap<>();
        poland = Country.of("Poland", Currency.PLN, 19, new BigDecimal(1200));
        countries.put("PL", poland);
        unitedKingdom = Country.of("United Kingdom", Currency.GBP, 25, new BigDecimal(600));
        countries.put("UK", unitedKingdom);
        germany = Country.of("Germany", Currency.EUR, 20, new BigDecimal(800));
        countries.put("DE", unitedKingdom);
        countryProvider = CountryProviderImpl.with(countries);
    }

    @Test
    public void getCountry() throws WrongCountryCodeException {
        assertThat(countryProvider.getCountry("PL")).isEqualTo(poland);
    }
    

}

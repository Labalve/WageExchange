package com.kkulak.WageExchange.domain;

import com.google.common.base.Preconditions;
import com.kkulak.WageExchange.domain.Country;
import com.kkulak.WageExchange.domain.WrongCountryCodeException;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;

public class CountryProviderImpl implements CountryProvider {

    @Autowired
    private HashMap<String, Country> countries;

    public static CountryProviderImpl with(HashMap<String, Country> countries) {
        return new CountryProviderImpl(countries);
    }

    public Country getCountry(String code) throws WrongCountryCodeException {
        Preconditions.checkArgument(code != null, "code cannot be null");
        Country country = countries.get(code);
        if (country == null) {
            throw new WrongCountryCodeException();
        }
        return country;
    }

    private CountryProviderImpl(HashMap<String, Country> countries) {
        this.countries = countries;
    }

    // needed for autowiring
    public CountryProviderImpl() {
        ;
    }

}

package com.kkulak.WageExchange.infrastructure;

import com.kkulak.WageExchange.domain.Country;
import com.kkulak.WageExchange.domain.WrongCountryCodeException;

public interface CountryProvider {

    public Country getCountry(String code) throws WrongCountryCodeException;
    
}

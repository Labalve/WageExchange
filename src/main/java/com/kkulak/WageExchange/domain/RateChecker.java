package com.kkulak.WageExchange.domain;

public interface RateChecker {

    Double getRate(Country from, Country to);
    
}

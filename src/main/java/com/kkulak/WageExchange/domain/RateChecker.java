package com.kkulak.WageExchange.domain;

public interface RateChecker {

    double getRate(Currency from, Currency to);
    
}

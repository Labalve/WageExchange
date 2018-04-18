package com.kkulak.WageExchange.domain;

public class RateCheckerImpl implements RateChecker {
    
    @Override
    public double getRate(Currency from, Currency to) {
        return 1.0;
    }

}

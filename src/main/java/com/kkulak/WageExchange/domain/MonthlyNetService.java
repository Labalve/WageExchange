package com.kkulak.WageExchange.domain;

import java.math.BigDecimal;

public interface MonthlyNetService {

    Wage getMonthlyNet(BigDecimal value, String countryCode) throws WrongCountryCodeException;
}

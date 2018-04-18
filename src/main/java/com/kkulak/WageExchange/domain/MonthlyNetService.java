package com.kkulak.WageExchange.domain;

import com.kkulak.WageExchange.infrastructure.ApiNotRespondingException;
import java.math.BigDecimal;

public interface MonthlyNetService {

    Wage getMonthlyNet(BigDecimal value, String countryCode) throws WrongCountryCodeException, ApiNotRespondingException;
}

package com.kkulak.WageExchange.domain;

import com.google.common.base.Preconditions;
import java.math.BigDecimal;

public class Country {

    private final String name;
    private final Currency currency;
    private final double taxRate;
    private final BigDecimal costOfIncome;

    public static Country of(String name, Currency currency, double taxRate, BigDecimal costOfIncome) {
        Preconditions.checkArgument(name != null, "name cannot be null");
        Preconditions.checkArgument(!name.equals(""), "name cannot be empty");
        Preconditions.checkArgument(currency != null, "currency cannot be empty");
        Preconditions.checkArgument(taxRate >= 0, "taxRate must be higher than 0");
        Preconditions.checkArgument(costOfIncome.compareTo(new BigDecimal(0)) != -1, "taxRate must be higher than 0");
        return new Country(name, currency, taxRate, costOfIncome);
    }

    public String getName() {
        return name;
    }

    public Currency getCurrency() {
        return currency;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public BigDecimal getCostOfIncome() {
        return costOfIncome;
    }

    private Country(String name, Currency currency, double taxRate, BigDecimal costOfIncome) {
        this.name = name;
        this.currency = currency;
        this.taxRate = taxRate;
        this.costOfIncome = costOfIncome.setScale(2);
    }

}

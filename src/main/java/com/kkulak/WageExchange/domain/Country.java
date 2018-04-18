package com.kkulak.WageExchange.domain;

import com.google.common.base.Preconditions;
import java.math.BigDecimal;
import java.util.Objects;

public class Country {

    private final String name;
    private final Currency currency;
    private final double taxRate;
    private final BigDecimal costOfIncome;

    public static Country of(String name, Currency currency, double taxRate, BigDecimal costOfIncome) {
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
        Preconditions.checkArgument(name != null, "name cannot be null");
        Preconditions.checkArgument(!name.equals(""), "name cannot be empty");
        Preconditions.checkArgument(currency != null, "currency cannot be empty");
        Preconditions.checkArgument(taxRate >= 0, "taxRate must be higher than 0");
        Preconditions.checkArgument(taxRate < 100, "taxRate must be lower than 100");
        Preconditions.checkArgument(costOfIncome != null, "cost of income cannot be null");
        Preconditions.checkArgument(costOfIncome.compareTo(BigDecimal.ZERO) >= 0, "cost of income cannot be lower than zero");
        this.name = name;
        this.currency = currency;
        this.taxRate = taxRate;
        this.costOfIncome = costOfIncome.setScale(2);
    }

    @Override
    public final boolean equals(Object rightSide) {
        if (rightSide == null) {
            return false;
        }
        if (!(rightSide instanceof Country)) {
            return false;
        }
        return (((Country) rightSide).getCurrency() == this.currency
                && ((Country) rightSide).getName().equals(this.name)
                && Double.compare(((Country) rightSide).getTaxRate(), this.taxRate) == 0
                && ((Country) rightSide).getCostOfIncome().equals(this.costOfIncome)
                );
    }

    @Override
    public final int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + Objects.hashCode(this.currency);
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.taxRate) ^ (Double.doubleToLongBits(this.taxRate) >>> 32));
        hash = 29 * hash + Objects.hashCode(this.costOfIncome);
        return hash;
    }

}

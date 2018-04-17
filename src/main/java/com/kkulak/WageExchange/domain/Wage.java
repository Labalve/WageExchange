package com.kkulak.WageExchange.domain;

import com.google.common.base.Preconditions;

import java.math.BigDecimal;
import java.util.Objects;

public class Wage {

    private final Currency currency;
    private final BigDecimal value;

    public static Wage of(BigDecimal value, Currency currency) {
        Preconditions.checkArgument(currency != null, "currency cannot be null");
        Preconditions.checkArgument(value != null, "value cannot be null");
        return new Wage(currency, value);
    }

    public Currency getCurrency() {
        return this.currency;
    }

    public BigDecimal getValue() {
        return this.value;
    }

    private Wage(Currency currency, BigDecimal value) {
        this.currency = currency;
        this.value = value.setScale(2);
    }

    @Override
    public final boolean equals(Object rightSide) {
        if(rightSide == null) return false;
        if (!(rightSide instanceof Wage)) {
            return false;
        } else {
            return (((Wage) rightSide).getCurrency() == this.currency
                    && this.value.equals(((Wage) rightSide).getValue()));
        }
    }

    @Override
    public final int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.currency);
        hash = 41 * hash + Objects.hashCode(this.value);
        return hash;
    }

}

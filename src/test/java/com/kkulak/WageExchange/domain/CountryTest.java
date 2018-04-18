package com.kkulak.WageExchange.domain;

import java.math.BigDecimal;
import org.junit.Test;
import nl.jqno.equalsverifier.EqualsVerifier;
import static org.assertj.core.api.Assertions.assertThat;

public class CountryTest {

    String name = "Greece";
    Currency currency = Currency.EUR;
    double taxRate = 5;
    BigDecimal costOfIncome = new BigDecimal(1000).setScale(2);

    @Test
    public void creating() {
        Country result = Country.of(name, currency, taxRate, costOfIncome);
        assertThat(result.getName()).isEqualTo("Greece");
        assertThat(result.getTaxRate()).isEqualTo(5);
        assertThat(result.getCostOfIncome()).isEqualTo(new BigDecimal(1000).setScale(2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void creatingWithNullName() {
        name = null;
        Country result = Country.of(name, currency, taxRate, costOfIncome);
    }

    @Test(expected = IllegalArgumentException.class)
    public void creatingWithEmptyName() {
        name = "";
        Country result = Country.of(name, currency, taxRate, costOfIncome);
    }

    @Test(expected = IllegalArgumentException.class)
    public void creatingWithNullCurrency() {
        currency = null;
        Country result = Country.of(name, currency, taxRate, costOfIncome);
    }

    @Test(expected = IllegalArgumentException.class)
    public void creatingWithNullCostOfIncome() {
        costOfIncome = null;
        Country result = Country.of(name, currency, taxRate, costOfIncome);
    }

    @Test(expected = IllegalArgumentException.class)
    public void creatingWithNegativeCostOfIncome() {
        costOfIncome = new BigDecimal(-100);
        Country result = Country.of(name, currency, taxRate, costOfIncome);
    }

    @Test(expected = IllegalArgumentException.class)
    public void creatingWithNegativeTaxRate() {
        taxRate = -100;
        Country result = Country.of(name, currency, taxRate, costOfIncome);
    }

    @Test(expected = IllegalArgumentException.class)
    public void creatingWithTaxRateHundred() {
        taxRate = 100;
        Country result = Country.of(name, currency, taxRate, costOfIncome);
    }

    @Test(expected = IllegalArgumentException.class)
    public void creatingWithTaxRateBiggerThanHundred() {
        taxRate = 150;
        Country result = Country.of(name, currency, taxRate, costOfIncome);
    }

    @Test
    public void equalsAndHashCode() {
        EqualsVerifier.forClass(Country.class).withNonnullFields("name", "currency", "taxRate", "costOfIncome").verify();
    }

}

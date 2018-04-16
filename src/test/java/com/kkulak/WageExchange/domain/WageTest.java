package com.kkulak.WageExchange.domain;

import java.math.BigDecimal;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class WageTest {

    @Test
    public void create() {
        String currency = "EUR";
        BigDecimal value = new BigDecimal(100);
        Wage result = Wage.Of(currency, value);
        assertThat(result.getValue()).isEqualTo(new BigDecimal(100).setScale(2));
        assertThat(result.getCurrency()).isEqualTo(Currency.EUR);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void createWithNullCurrency() {
        String currency = null;
        BigDecimal value = new BigDecimal(100);
        Wage.Of(currency, value);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void createWithNullValue() {
        String currency = "EUR";
        BigDecimal value = null;
        Wage.Of(currency, value);
    }

    @Test
    public void equalsAndHashCode() {
        EqualsVerifier.forClass(Wage.class).withNonnullFields("value", "currency").verify();
    }
    
}

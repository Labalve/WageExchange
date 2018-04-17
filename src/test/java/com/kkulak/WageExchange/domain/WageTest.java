package com.kkulak.WageExchange.domain;

import java.math.BigDecimal;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class WageTest {

    @Test
    public void create() {
        Currency currency = Currency.EUR;
        BigDecimal value = new BigDecimal(100);
        Wage result = Wage.of(value, currency);
        assertThat(result.getValue()).isEqualTo(new BigDecimal(100).setScale(2));
        assertThat(result.getCurrency()).isEqualTo(Currency.EUR);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void createWithNullCurrency() {
        Currency currency = null;
        BigDecimal value = new BigDecimal(100);
        Wage.of(value, currency);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void createWithNullValue() {
        Currency currency = Currency.EUR;
        BigDecimal value = null;
        Wage.of(value, currency);
    }

    @Test
    public void equalsAndHashCode() {
        EqualsVerifier.forClass(Wage.class).withNonnullFields("value", "currency").verify();
    }
    
}

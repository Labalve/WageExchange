package com.kkulak.WageExchange;

import com.kkulak.WageExchange.domain.MonthlyNetService;
import com.kkulak.WageExchange.domain.MonthlyNetServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WageExchangeConfiguration {

    @Bean
    public MonthlyNetService MonthlyNetServiceImpl() {
        return new MonthlyNetServiceImpl();
    }
    
}

package com.kkulak.WageExchange;

import com.kkulak.WageExchange.domain.MonthlyNetService;
import com.kkulak.WageExchange.domain.MonthlyNetServiceImpl;
import com.kkulak.WageExchange.presentation.WagePrinter;
import com.kkulak.WageExchange.presentation.WagePrinterImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WageExchangeConfiguration {

    @Bean
    public MonthlyNetService MonthlyNetServiceImpl() {
        return new MonthlyNetServiceImpl();
    }
    
    @Bean
    public WagePrinter WagePrinterImpl() {
        return new WagePrinterImpl();
    }
    
}

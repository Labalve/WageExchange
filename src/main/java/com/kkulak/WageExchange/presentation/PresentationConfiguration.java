package com.kkulak.WageExchange.presentation;

import com.kkulak.WageExchange.domain.MonthlyNetService;
import com.kkulak.WageExchange.domain.MonthlyNetServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PresentationConfiguration {

    @Bean
    public MonthlyNetService MonthlyNetServiceImpl() {
        return new MonthlyNetServiceImpl();
    }
    
    @Bean
    public WagePrinter WagePrinterImpl() {
        return new WagePrinterImpl();
    }
    
}

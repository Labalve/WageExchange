package com.kkulak.WageExchange.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InfrastructureConfiguration {
   
    @Bean RateApiCaller RateApiCallerNBP() {
        return new RateApiCallerNBP();
    }

}

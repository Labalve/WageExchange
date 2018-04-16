package com.kkulak.WageExchange.presentation;

import com.kkulak.WageExchange.domain.Wage;

public class WagePrinterImpl implements WagePrinter {

    @Override
    public String print(Wage wage){
        return new StringBuilder().append(wage.getValue()).append(' ').append(wage.getCurrency()).toString();
    }
    
}

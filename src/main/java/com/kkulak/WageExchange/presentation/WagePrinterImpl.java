package com.kkulak.WageExchange.presentation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kkulak.WageExchange.domain.Wage;

public class WagePrinterImpl implements WagePrinter {

    @Override
    public String print(Wage wage){
        try {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(wage);
        return json;
        } catch (JsonProcessingException ex) {
            return "Printing error occured.";
        }
    }

}

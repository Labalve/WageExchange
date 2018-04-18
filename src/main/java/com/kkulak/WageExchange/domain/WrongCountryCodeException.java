package com.kkulak.WageExchange.domain;

public class WrongCountryCodeException extends Exception {

    private final String message = "Provided country code is not configured.";

    @Override
    public String getMessage() {
        return message;
    }

}

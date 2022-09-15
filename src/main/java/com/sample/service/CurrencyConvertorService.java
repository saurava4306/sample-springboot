package com.sample.service;

import com.sample.factory.CurrencyConverterFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CurrencyConvertorService {

    private final CurrencyConverterFactory factory;
    public CurrencyConvertorService(CurrencyConverterFactory factory) {
        this.factory = factory;
    }

    public BigDecimal getConvertedAmount(String currencyCode, BigDecimal amount) {
        return factory.getMultiplicationFactor(currencyCode).convert(amount);
    }
}

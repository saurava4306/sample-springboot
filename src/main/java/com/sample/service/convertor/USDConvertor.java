package com.sample.service.convertor;

import com.sample.service.CurrencyConvertor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class USDConvertor implements CurrencyConvertor {
    @Override
    public BigDecimal convert(BigDecimal amountToConvert) {
        return amountToConvert.multiply(new BigDecimal("1.0"));
    }
}

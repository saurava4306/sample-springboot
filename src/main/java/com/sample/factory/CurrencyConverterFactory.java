package com.sample.factory;

import com.sample.service.CurrencyConvertor;
import org.springframework.stereotype.Component;
import com.sample.service.convertor.CanadaConvertor;
import com.sample.service.convertor.IndianConvertor;
import com.sample.service.convertor.USDConvertor;

@Component
public class CurrencyConverterFactory {
    public CurrencyConvertor getMultiplicationFactor(String currencyCode) {
        switch (currencyCode) {
            case "USD": {
                return new USDConvertor();
            }
            case "CAN": {
                return new CanadaConvertor();
            }
            case "IND":{
                return new IndianConvertor();
            }
            default:
                throw new IllegalArgumentException("currencyCode not supported");
        }
    }

}

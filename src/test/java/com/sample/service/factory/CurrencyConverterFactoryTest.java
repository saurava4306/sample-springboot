package com.sample.service.factory;

import com.sample.factory.CurrencyConverterFactory;
import com.sample.service.CurrencyConvertor;
import com.sample.service.convertor.CanadaConvertor;
import com.sample.service.convertor.IndianConvertor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CurrencyConverterFactoryTest {

    private CurrencyConverterFactory factory;

    @Before
    public void setUp(){
        factory = new CurrencyConverterFactory();

    }
    @Test
    public void getMultiplicationFactor_returnsIndiaConverter_whenCurrencyCodeIsIND() {
        CurrencyConvertor convertor = factory.getMultiplicationFactor("IND");
        Assert.assertTrue(convertor instanceof IndianConvertor);
    }
    @Test
    public void getMultiplicationFactor_returnsCanadaConverter_whenCurrencyCodeIsCAN() {
        CurrencyConvertor convertor = factory.getMultiplicationFactor("CAN");
        Assert.assertTrue(convertor instanceof CanadaConvertor);
    }
    @Test
    public void getMultiplicationFactor_throwsIllegalArgumentException_whenCurrencyCodeIsNotSupported() {
        try{
            factory.getMultiplicationFactor("ZZZ");
            Assert.fail("Should not reach here");
        }catch (Exception ex){
            Assert.assertTrue(ex instanceof IllegalArgumentException);
        }

    }
}
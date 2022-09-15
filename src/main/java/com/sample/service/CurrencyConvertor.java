package com.sample.service;

import java.math.BigDecimal;

public interface CurrencyConvertor {
    BigDecimal convert(BigDecimal amountToConvert);
}

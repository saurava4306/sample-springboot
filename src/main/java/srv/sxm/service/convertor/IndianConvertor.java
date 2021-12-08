package srv.sxm.service.convertor;

import srv.sxm.service.CurrencyConvertor;

import java.math.BigDecimal;

public class IndianConvertor implements CurrencyConvertor {
    @Override
    public BigDecimal convert(BigDecimal amountToConvert) {
        return amountToConvert.multiply(new BigDecimal("0.014"));
    }
}

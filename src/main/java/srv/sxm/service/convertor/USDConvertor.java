package srv.sxm.service.convertor;

import org.springframework.stereotype.Component;
import srv.sxm.service.CurrencyConvertor;

import java.math.BigDecimal;

@Component
public class USDConvertor implements CurrencyConvertor {
    @Override
    public BigDecimal convert(BigDecimal amountToConvert) {
        return amountToConvert.multiply(new BigDecimal("1.0"));
    }
}

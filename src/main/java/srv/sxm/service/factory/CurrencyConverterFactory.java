package srv.sxm.service.factory;

import org.springframework.stereotype.Component;
import srv.sxm.service.CurrencyConvertor;
import srv.sxm.service.convertor.CanadaConvertor;
import srv.sxm.service.convertor.IndianConvertor;
import srv.sxm.service.convertor.USDConvertor;

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

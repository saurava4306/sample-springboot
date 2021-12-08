package srv.sxm.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import srv.sxm.model.Customer;
import srv.sxm.service.CurrencyConvertorService;
import srv.sxm.service.CustomerService;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api")
public class CurrencyConvertorController {

    private final CurrencyConvertorService currencyConvertorService;
    private final CustomerService customerService;

    public CurrencyConvertorController(CurrencyConvertorService currencyConvertorService, CustomerService customerService) {
        this.currencyConvertorService = currencyConvertorService;
        this.customerService = customerService;
    }

    @GetMapping("convertToUSD")
    public ResponseEntity<BigDecimal> convertToUSD(@RequestParam String currencyCode, @RequestParam BigDecimal amount){
        BigDecimal convertedAmount = currencyConvertorService.getConvertedAmount(currencyCode, amount);
        return new ResponseEntity<>(convertedAmount, HttpStatus.OK);
    }

    @PostMapping("createCustomer")
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer){
        String status = customerService.create(customer);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}

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

    @PostMapping("customer")
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer){
        Long status = customerService.create(customer);
        return new ResponseEntity<>(String.valueOf(status), HttpStatus.OK);
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity<String> updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
        Long status = customerService.update(customer, id);
        return new ResponseEntity<>(String.valueOf(status), HttpStatus.OK);
    }
}

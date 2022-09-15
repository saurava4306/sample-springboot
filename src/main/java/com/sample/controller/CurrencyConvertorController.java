package com.sample.controller;

import com.sample.service.CurrencyConvertorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/convertor")
public class CurrencyConvertorController {

    private final CurrencyConvertorService currencyConvertorService;

    public CurrencyConvertorController(CurrencyConvertorService currencyConvertorService) {
        this.currencyConvertorService = currencyConvertorService;
    }

    @GetMapping("toUSD")
    public ResponseEntity<BigDecimal> convertToUSD(@RequestParam String currencyCode, @RequestParam BigDecimal amount){
        BigDecimal convertedAmount = currencyConvertorService.getConvertedAmount(currencyCode, amount);
        return new ResponseEntity<>(convertedAmount, HttpStatus.OK);
    }

}

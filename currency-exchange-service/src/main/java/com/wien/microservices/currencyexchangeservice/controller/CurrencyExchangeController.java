package com.wien.microservices.currencyexchangeservice.controller;


import com.wien.microservices.currencyexchangeservice.beans.CurrencyExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.MathContext;

@RestController
public class CurrencyExchangeController {

    private Environment env;

    @Autowired
    public CurrencyExchangeController(Environment env) {
        this.env = env;
    }

    @GetMapping("/currency-exchange/from/{fromCcy}/to/{toCcy}")
    public ResponseEntity<CurrencyExchange> getExchangeValue(@PathVariable String fromCcy, @PathVariable String toCcy) {
        CurrencyExchange ccyExchg = new CurrencyExchange(1000L, fromCcy, toCcy, new BigDecimal(88.11, MathContext.DECIMAL32), env.getProperty("local.server.port"));
        return ResponseEntity.ok(ccyExchg);
    }
}

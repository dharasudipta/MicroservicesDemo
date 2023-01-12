package com.wien.microservices.currencyconversionservice.controller;

import com.wien.microservices.currencyconversionservice.beans.CurrencyConversionResponse;
import com.wien.microservices.currencyconversionservice.proxy.CurrencyExchangeProxy;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {

    private static final Logger log = LoggerFactory.getLogger(CurrencyConversionController.class);

    //    private Environment env;
    private CurrencyExchangeProxy proxy;

    @Autowired
    public CurrencyConversionController(CurrencyExchangeProxy proxy) {//Environment env,
//        this.env = env;
        this.proxy = proxy;
    }

    @GetMapping("/currency-conversion/from/{fromCcy}/to/{toCcy}/quantity/{qty}")
//    @Retry(name = "currency-conversion", fallbackMethod = "currencyConversionFallback")
    @CircuitBreaker(name = "currency-conversion", fallbackMethod = "currencyConversionFallback") //ToDo Explore Ratelimiter and Bulkhead
    public ResponseEntity<CurrencyConversionResponse> calculateCurrencyConversion(@PathVariable String fromCcy,
                                                                                  @PathVariable String toCcy, @PathVariable Integer qty) {
        log.info("API call received");
        ResponseEntity<CurrencyConversionResponse> exchangeValue = proxy.getExchangeValue(fromCcy, toCcy);
        CurrencyConversionResponse ccyConversionResponse = new CurrencyConversionResponse(5003L, fromCcy, toCcy,
                qty);
        BigDecimal conversionMultiple = exchangeValue.getBody().getConversionMultiple();
        ccyConversionResponse.setConversionMultiple(conversionMultiple);
        ccyConversionResponse.setTotalCalculatedAmount(conversionMultiple.multiply(new BigDecimal(qty)));
        ccyConversionResponse.setEnvironment(exchangeValue.getBody().getEnvironment());
        return ResponseEntity.ok(ccyConversionResponse);
    }

    public ResponseEntity<String> currencyConversionFallback(Exception ex) {
        return ResponseEntity.status(HttpStatus.SC_SERVICE_UNAVAILABLE).body(ex.getMessage());
    }
}

package com.wien.microservices.currencyconversionservice.proxy;

import com.wien.microservices.currencyconversionservice.beans.CurrencyConversionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//@FeignClient(name = "currency-exchange-service", url = "localhost:8084")
@FeignClient(name = "currency-exchange-service")
public interface CurrencyExchangeProxy {

    @GetMapping("/currency-exchange/from/{fromCcy}/to/{toCcy}")
    ResponseEntity<CurrencyConversionResponse> getExchangeValue(@PathVariable String fromCcy, @PathVariable String toCcy);

}

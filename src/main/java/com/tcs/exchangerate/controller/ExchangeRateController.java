package com.tcs.exchangerate.controller;

import com.tcs.exchangerate.dto.request.CurrencyExchangeRateRequest;
import com.tcs.exchangerate.dto.request.ExchangeRateRequest;
import com.tcs.exchangerate.dto.response.CurrencyExchangeRateResponse;
import com.tcs.exchangerate.dto.response.ExchangeRateResponse;
import com.tcs.exchangerate.service.ExchangeRateService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("exchange-rates")
@Slf4j
@AllArgsConstructor
public class ExchangeRateController {

    private ExchangeRateService exchangeRateService;

    @GetMapping("/convert")
    public ResponseEntity<CurrencyExchangeRateResponse> getCurrencyExchangeRate(@RequestParam BigDecimal amount,
                                                                                @RequestParam String fromCurrency,
                                                                                @RequestParam String toCurrency) {
        log.info("[GET] ExchangeRateController::getCurrencyExchangeRate - amount: {}, from: {}, to: {}", amount, fromCurrency, toCurrency);
        CurrencyExchangeRateRequest request = new CurrencyExchangeRateRequest(amount, fromCurrency, toCurrency);
        return ResponseEntity.ok(exchangeRateService.getCurrencyExchangeRate(request));
    }

    @PostMapping
    public ResponseEntity<ExchangeRateResponse> createCurrencyExchangeRate(@RequestBody ExchangeRateRequest request) {
        log.info("[GET] ExchangeRateController::createCurrencyExchangeRate - request: {}", request);
        return new ResponseEntity<>(exchangeRateService.createExchangeRate(request), HttpStatus.CREATED);
    }

}

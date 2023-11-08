package com.tcs.exchangerate.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class CurrencyExchangeRateRequest {
    private BigDecimal amount;
    private String fromCurrency;
    private String toCurrency;
}

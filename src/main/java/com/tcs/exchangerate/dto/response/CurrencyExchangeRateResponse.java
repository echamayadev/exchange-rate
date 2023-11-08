package com.tcs.exchangerate.dto.response;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class CurrencyExchangeRateResponse {
    private BigDecimal amount;
    private BigDecimal exchangeRateAmount;
    private String fromCurrency;
    private String toCurrency;
    private Double rate;
}

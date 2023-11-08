package com.tcs.exchangerate.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ExchangeRateRequest {
    private String fromCurrency;
    private String toCurrency;
    private Date date;
    private Double rate;
}

package com.tcs.exchangerate.dto.response;

import lombok.Data;

import java.util.Date;

@Data
public class ExchangeRateResponse {
    private int id;
    private String fromCurrency;
    private String toCurrency;
    private Date date;
    private Double rate;
}

package com.tcs.exchangerate.service;

import com.tcs.exchangerate.dto.request.CurrencyExchangeRateRequest;
import com.tcs.exchangerate.dto.request.ExchangeRateRequest;
import com.tcs.exchangerate.dto.response.CurrencyExchangeRateResponse;
import com.tcs.exchangerate.dto.response.ExchangeRateResponse;

public interface ExchangeRateService {

    CurrencyExchangeRateResponse getCurrencyExchangeRate(CurrencyExchangeRateRequest request);

    ExchangeRateResponse createExchangeRate(ExchangeRateRequest request);

}

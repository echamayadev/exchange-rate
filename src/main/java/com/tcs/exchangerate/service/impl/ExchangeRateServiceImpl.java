package com.tcs.exchangerate.service.impl;

import com.tcs.exchangerate.dto.request.CurrencyExchangeRateRequest;
import com.tcs.exchangerate.dto.request.ExchangeRateRequest;
import com.tcs.exchangerate.dto.response.CurrencyExchangeRateResponse;
import com.tcs.exchangerate.dto.response.ExchangeRateResponse;
import com.tcs.exchangerate.entity.ExchangeRate;
import com.tcs.exchangerate.repository.ExchangeRateRepository;
import com.tcs.exchangerate.service.ExchangeRateService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

@Service
@AllArgsConstructor
public class ExchangeRateServiceImpl implements ExchangeRateService {

    private ExchangeRateRepository exchangeRateRepository;
    private ModelMapper modelMapper;

    @Override
    public CurrencyExchangeRateResponse getCurrencyExchangeRate(CurrencyExchangeRateRequest request) {
        ExchangeRate exchangeRate = exchangeRateRepository.getExchangeRateByFromCurrencyAndToCurrency(
                request.getFromCurrency(),
                request.getToCurrency());

        if (exchangeRate != null) {
            BigDecimal exchangeRateAmount = BigDecimal.valueOf(request.getAmount().doubleValue() * exchangeRate.getRate())
                    .setScale(2, RoundingMode.HALF_EVEN);
            return new CurrencyExchangeRateResponse(
                    request.getAmount(),
                    exchangeRateAmount,
                    exchangeRate.getFromCurrency(),
                    exchangeRate.getToCurrency(),
                    exchangeRate.getRate()
            );
        }

        return null;
    }

    @Override
    public ExchangeRateResponse createExchangeRate(ExchangeRateRequest request) {
        request.setDate(new Date());
        ExchangeRate exchangeRateResponseEntity = exchangeRateRepository.save(modelMapper.map(request, ExchangeRate.class));
        return modelMapper.map(exchangeRateResponseEntity, ExchangeRateResponse.class);
    }
}

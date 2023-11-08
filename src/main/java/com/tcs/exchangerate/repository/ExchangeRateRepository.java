package com.tcs.exchangerate.repository;

import com.tcs.exchangerate.entity.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Integer> {

    ExchangeRate getExchangeRateByFromCurrencyAndToCurrency(String fromCurrency, String toCurrency);

}

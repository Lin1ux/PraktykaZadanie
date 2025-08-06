package com.example.exercise.Services;

import com.example.exercise.Model.CurrencyRequest;
import com.example.exercise.Reposytory.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyDBService
{
    @Autowired
    private CurrencyRepository currencyRepository;

    public CurrencyRequest saveCurrencyRequest(CurrencyRequest currencyRequest)
    {
        return currencyRepository.save(currencyRequest);
    }
}

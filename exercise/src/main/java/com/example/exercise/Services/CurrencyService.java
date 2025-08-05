package com.example.exercise.Services;

import com.example.exercise.Model.NBP.NBPResponse;
import com.example.exercise.Model.NBP.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;


@Service
public class CurrencyService
{
    private final String NBPCurrencyAPI = "http://api.nbp.pl/api/exchangerates/tables/A?format=json";

    @Autowired
    private RestTemplate restTemplate;

    //Return list of currencies
    public List<Rate> currencyList()
    {
        NBPResponse[] response = restTemplate.getForObject(NBPCurrencyAPI, NBPResponse[].class);
        return response[0].GetRates();
    }
    //Return value of currency
    public Float getCurrencyValue(String currency) throws ResponseStatusException
    {
        NBPResponse[] response = restTemplate.getForObject(NBPCurrencyAPI, NBPResponse[].class);
        List<Rate> RatesList = response[0].GetRates();
        Float value = -1.0f;
        for(Rate rate: RatesList)
        {
            if(rate.GetCode().equals(currency))
            {
                return rate.GetMid();
            }
        }
        if("PLN".equals(currency))
        {
            return 1.0000f;
        }
        throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Nie istnieje taka waluta");
    }

}

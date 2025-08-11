package com.example.exercise.Services;

import com.example.exercise.Model.CurrencyRequest;
import com.example.exercise.Model.NBP.NBPResponse;
import com.example.exercise.Model.NBP.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;


@Service
public class CurrencyService
{
    @Value("${spring.NBPCurrencyAPI}")
    private String NBPCurrencyAPI;

    private RestTemplate restTemplate;
    private CurrencyDBService currencyDBService;

    @Autowired
    CurrencyService(RestTemplate restTemplate,CurrencyDBService currencyDBService)
    {
        this.restTemplate = restTemplate;
        this.currencyDBService = currencyDBService;
    }

    //Return value of currency
    public Float getCurrencyValue(String currency) throws ResponseStatusException
    {
        NBPResponse[] response;
        try
        {
            response = restTemplate.getForObject(NBPCurrencyAPI, NBPResponse[].class);
        }
        catch (Exception e)
        {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE,
                    "Service Unavailable");
        }
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
        throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "This currency don't exists");
    }

    public Float getCurrencyValueAndSave(String currency,String nickname) throws ResponseStatusException
    {
        Float value = this.getCurrencyValue(currency);
        currencyDBService.saveCurrencyRequest(new CurrencyRequest(currency,nickname,value));
        return value;
    }

}

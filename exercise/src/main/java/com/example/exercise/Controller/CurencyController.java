package com.example.exercise.Controller;

import com.example.exercise.Model.CurrencyRequest;
import com.example.exercise.Model.NBP.NBPResponse;
import com.example.exercise.Model.NBP.Rate;
import com.example.exercise.Model.Request;
import com.example.exercise.Services.CurrencyDBService;
import com.example.exercise.Services.CurrencyService;
import com.example.exercise.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.time.LocalDateTime;
import java.util.*;

@SpringBootApplication
@RestController
public class CurencyController
{
    private CurrencyService currencyService;
    private CurrencyDBService currencyDBService;

    @Autowired
    public CurencyController(CurrencyService currencyService,CurrencyDBService currencyDBService)
    {
        this.currencyService = currencyService;
        this.currencyDBService = currencyDBService;
    }

    //Gives currency based from NBP API
    @PostMapping("/currencies/get-current-currency-value-command")
    public Map<String,Float> getCurrentCurrency(@RequestBody Request request) throws ResponseStatusException
    {
        //Get Data
        String currency = request.getCurrency();
        String nickname = request.getNickname();

        //Validation
        Validation.currencyValidation(currency);    //Validate currency
        Validation.nicknameValidation(nickname);    //Validate nickname

        currency = currency.toUpperCase();          //Uppercase currency

        //Response
        Map<String,Float> response = new HashMap<>();

        //Send Request to NBP API and save data
        Float value = currencyService.getCurrencyValueAndSave(currency,nickname);
        response.put("value",value);

        System.out.println("Response to: "+nickname+" Currency: "+currency+" Value: "+value);

        return response;
    }

    @GetMapping("/currencies/requests")
    public List<CurrencyRequest> getAllRequests()
    {
        //Get Request History from Data base
        List<CurrencyRequest> response = currencyDBService.getAllRequests();

        System.out.println("Send all requests");

        return response;
    }

    //Gives all data related to given nickname
    @PostMapping("/currencies/request")
    public List<CurrencyRequest> requestCurrency(@RequestBody Request request) throws ResponseStatusException
    {
        //Get Data
        String nickname = request.getNickname();

        Validation.nicknameValidation(nickname);

        //Get Request History of user from Data base
        List<CurrencyRequest> response = currencyDBService.getRequestsByNickname(nickname);

        System.out.println("Send requests of "+nickname+"\n"+response);

        return response;
    }

    //Endpoint made for testing. Sends empty Requests list
    @GetMapping("/test")
    public List<CurrencyRequest> requestCurrency()
    {
        System.out.println("Testing");
        //Response
        List<CurrencyRequest> response = new ArrayList<CurrencyRequest>();

        return response;
    }
}

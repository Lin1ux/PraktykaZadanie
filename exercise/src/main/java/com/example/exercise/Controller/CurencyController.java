package com.example.exercise.Controller;

import com.example.exercise.Model.CurrencyRequest;
import com.example.exercise.Model.NBP.NBPResponse;
import com.example.exercise.Model.NBP.Rate;
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
    public Map<String,Float> GetCurrentCurrency(@RequestBody Map<String,String> request) throws ResponseStatusException
    {
        //Get Data
        String currency = request.get("currency");
        String nickname = request.get("nickname");

        //Validation
        Validation.currencyValidation(currency);    //Validate currency
        Validation.nicknameValidation(nickname);    //Validate nickname

        currency = currency.toUpperCase();          //Uppercase currency

        //Response
        Map<String,Float> response = new HashMap<>();

        //Send Request to NBP API
        Float value = currencyService.getCurrencyValue(currency);
        response.put("value",value);

        //Save data in database
        CurrencyRequest RequestData = new CurrencyRequest(currency,nickname,value);
        currencyDBService.saveCurrencyRequest(RequestData);

        System.out.println("Response to: "+nickname+" Currency: "+currency+" Value: "+value);

        return response;
    }

    @GetMapping("/currencies/requests")
    public List<CurrencyRequest> GetAllRequests()
    {
        //Get Request History from Data base
        List<CurrencyRequest> response = currencyDBService.getAllRequests();

        System.out.println("Send all requests");

        return response;
    }

    //Gives all data related to given nickname
    @PostMapping("/currencies/request")
    public List<CurrencyRequest> RequestCurrency(@RequestBody Map<String,String> request) throws ResponseStatusException
    {
        //Get Data
        String nickname = request.get("nickname");

        Validation.nicknameValidation(nickname);

        //Get Request History of user from Data base
        List<CurrencyRequest> response = currencyDBService.getRequestsByNickname(nickname);

        System.out.println("Send requests of "+nickname+"\n"+response);

        return response;
    }

    //Endpoint made for testing. Sends empty Requests list
    @GetMapping("/test")
    public List<CurrencyRequest> RequestCurrency()
    {
        System.out.println("Testing");
        //Response
        List<CurrencyRequest> response = new ArrayList<CurrencyRequest>();

        return response;
    }
}

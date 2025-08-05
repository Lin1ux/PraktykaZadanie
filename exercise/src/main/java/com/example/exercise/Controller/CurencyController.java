package com.example.exercise.Controller;

import com.example.exercise.Model.CurrencyRequest;
import com.example.exercise.Model.NBP.NBPResponse;
import com.example.exercise.Model.NBP.Rate;
import com.example.exercise.Services.CurrencyService;
import com.example.exercise.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.example.exercise.Model.NBP.Currency;
import java.util.*;

@SpringBootApplication
@RestController
public class CurencyController
{
    private CurrencyService currencyService;

    @Autowired
    public CurencyController(CurrencyService currencyService)
    {
        this.currencyService = currencyService;
    }


    //Gives currency based on API
    @PostMapping("/currencies/get-current-currency-value-command")
    public Map<String,Float> GetCurrentCurrency(@RequestBody Map<String,String> request) throws ResponseStatusException
    {
        //Get Data
        String currency = request.get("currency");
        String nickname = request.get("nickname");

        Validation.currencyValidation(currency);    //Validate currency
        Validation.nicknameValidation(currency);    //Validate nickname

        currency = currency.toUpperCase();          //Uppercase currency

        //Response
        Map<String,Float> response = new HashMap<>();

        //Send Request to NBP API
        Float value = currencyService.getCurrencyValue(currency);
        response.put("value",value);
        //response.put("value","0.000f");
        System.out.println(nickname+" "+currency+" "+value);

        return response;
    }

    //Gives all data related to given nickname
    @PostMapping("/currencies/requests")
    public List<CurrencyRequest> RequestCurrency(@RequestBody Map<String,String> request) throws ResponseStatusException
    {
        //Get Data
        String nickname = request.get("nickname");

        Validation.nicknameValidation(nickname);

        //Response
        List<CurrencyRequest> response = new ArrayList<CurrencyRequest>();
        CurrencyRequest testReq = new CurrencyRequest("PLN","Kowalski","5.08.2025",1.0f);
        CurrencyRequest testReq2 = new CurrencyRequest("EUR","Nowak","4.08.2025",1.828231f);

        response.add(testReq);
        response.add(testReq2);

        System.out.println(nickname);

        return response;
    }

    //Function made to test ing
    @GetMapping("/test")
    public List<CurrencyRequest> RequestCurrency()
    {
        //Get Data
        System.out.println("TEST1");

        //Response
        List<CurrencyRequest> response = new ArrayList<CurrencyRequest>();
        CurrencyRequest testReq = new CurrencyRequest("PLN","Kowalski","5.08.2025",1.0f);
        CurrencyRequest testReq2 = new CurrencyRequest("EUR","Nowak","4.08.2025",1.828231f);

        response.add(testReq);
        response.add(testReq2);

        System.out.println("TEST2");

        return response;
    }
}

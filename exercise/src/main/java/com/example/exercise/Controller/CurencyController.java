package com.example.exercise.Controller;

import com.example.exercise.Validation;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

//import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@RestController
public class CurencyController
{
    @PostMapping("/currencies/get-current-currency-value-command")
    public Map<String,String> GetCurrentCurrency(@RequestBody Map<String,String> request) throws ResponseStatusException
    {
        //Get Data
        String currency = request.get("currency");
        String nickname = request.get("nickname");

        Validation.currencyValidation(currency);    //Validate currency
        Validation.nicknameValidation(currency);    //Validate nickname

        currency = currency.toUpperCase();          //Uppercase currency

        //Response
        Map<String,String> response = new HashMap<>();

        response.put("value","0.0000");

        System.out.println(currency+" "+nickname);
        return response;
    }

    @PostMapping("/currencies/requests")
    public String RequestCurrency(@RequestBody Map<String,String> request) throws ResponseStatusException
    {
        //Get Data
        String nickname = request.get("nickname");

        Validation.nicknameValidation(nickname);

        System.out.println(nickname);

        return "";
    }
}

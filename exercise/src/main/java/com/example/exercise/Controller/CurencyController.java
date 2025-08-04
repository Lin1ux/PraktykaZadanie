package com.example.exercise.Controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

//import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@RestController
public class CurencyController
{
    @GetMapping("/currencies/get-current-currency-value-command")
    @CrossOrigin(origins = "http://localhost:4200")
    public String GetCurrentCurrency(@RequestParam Map<String,String> request)
    {
        String currency = request.get("currency");
        String nickname = request.get("nickname");

        System.out.println(currency+" "+nickname);
        return "";
    }

    @GetMapping("/currencies/requests")
    public String RequestCurrency()
    {
        return "";
    }
}

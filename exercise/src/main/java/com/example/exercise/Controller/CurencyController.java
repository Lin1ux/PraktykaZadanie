package com.example.exercise.Controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CurencyController
{
    @RequestMapping("/currencies/get-current-currency-value-command")
    @CrossOrigin(origins = "http://localhost:4200")
    public String CurrentCurrency()
    {
        return "";
    }

    @RequestMapping("/currencies/requests")
    public String RequestCurrency()
    {
        return "";
    }
}

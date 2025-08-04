package com.example.exercise.Model;

public class CurrencyRequest
{
    private String currency;
    private String name;
    private String date;
    private Float value;

    public CurrencyRequest(String currency, String name, String date, Float value)
    {
        this.currency = currency;
        this.name = name;
        this.date = date;
        this.value = value;
    }
}

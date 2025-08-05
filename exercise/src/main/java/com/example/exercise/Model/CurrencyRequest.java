package com.example.exercise.Model;

public class CurrencyRequest
{
    private String currency;
    private String name;
    private String date;
    private Float value;

    public CurrencyRequest() {}

    public CurrencyRequest(String currency, String name, String date, Float value)
    {
        this.currency = currency;
        this.name = name;
        this.date = date;
        this.value = value;
    }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public Float getValue() { return value; }
    public void setValue(Float value) { this.value = value; }
}

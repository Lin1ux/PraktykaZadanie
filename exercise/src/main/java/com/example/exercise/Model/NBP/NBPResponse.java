package com.example.exercise.Model.NBP;

import lombok.Data;

import java.util.List;

@Data
public class NBPResponse
{
    private String table;
    private String no;
    private String effectiveDate;
    private List<Rate> rates;

    public List<Rate> GetRates()
    {
        return rates;
    }
}

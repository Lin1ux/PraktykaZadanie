package com.example.exercise.Model.NBP;

import lombok.Data;

@Data
public class Rate
{
    private String currency;
    private String code;
    private Float mid;

    public String GetCode()
    {
        return this.code;
    }

    public Float GetMid()
    {
        return this.mid;
    }
}

package com.example.exercise.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Request
{
    private String currency;
    private String nickname;

    /*public String getCurrency()
    {
        return this.currency;
    }

    public String getNickname()
    {
        return this.nickname;
    }*/
}

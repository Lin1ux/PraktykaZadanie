package com.example.exercise;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class Validation
{
    public static void currencyValidation(String currency) throws ResponseStatusException
    {
        //No Currency Exception
        if(currency == null)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Currency can't be null");
        }
        //Wrong Length of Currency Exception
        if (currency.length() != 3)
        {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                    "Currency must have 3 letters");
        }
        //Check is Letters only
        if(!Utility.LettersOnly(currency))
        {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                    "Currency must have only letters");
        }
    }
    public static void nicknameValidation(String nickname) throws ResponseStatusException
    {
        //No nickname Exception
        if (nickname == null)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Name can't be null");
        }
        //Wrong Length of nickname
        if (nickname.length() < 2)
        {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                    "Name should have at least 2 characters");
        }
        //Wrong Length of nickname
        if (nickname.length() > 50)
        {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                    "Too many characters");
        }
        //Check Letters
        if (!Utility.CorrectNickname(nickname))
        {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                    "Name can only use english letters, numbers, spaces and _");
        }
    }
}

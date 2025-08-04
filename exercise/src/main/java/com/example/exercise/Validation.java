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
                    "Waluta nie może być pusta");
        }
        //Wrong Length of Currency Exception
        if (currency.length() != 3)
        {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                    "Waluta powinna mieć zapis 3 literowy");
        }
        //Check is Letters only
        if(!Utility.LettersOnly(currency))
        {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                    "Waluta powinna składać się tylko liter");
        }
    }
    public static void nicknameValidation(String nickname) throws ResponseStatusException
    {
        //No nickname Exception
        if (nickname == null)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Nazwa Użytkownika nie może być pusta");
        }
        //Wrong Length of nickname
        if (nickname.length() < 2)
        {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                    "Nazwa Użytkownika powinna zawierać ponad 2 znaki");
        }
        //Wrong Length of nickname
        if (nickname.length() > 50)
        {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                    "Przekroczono limit długości nazwy użytkownika");
        }
        //Check Letters
        if (!Utility.CorrectNickname(nickname))
        {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                    "Nazwa użytkownika może składać się z liter, cyfr, spacji i _");
        }
    }
}

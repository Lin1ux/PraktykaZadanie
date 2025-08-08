package com.example.exercise;

import java.util.List;
import java.util.Locale;

public class Utility
{
    //Check if text have only letters space or _
    public static Boolean correctNickname(String text)
    {
        if (text == null)
        {
            return false;
        }
        return text.matches("^[0-9a-zA-Z _]+$");
    }

    //Check if text have only letters space or _
    public static Boolean lettersOnly(String text)
    {
        if (text == null)
        {
            return false;
        }
        return text.toUpperCase().matches("^[A-Z]+$");
    }
}

package com.example.exercise;

import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ValidationTest
{
    //currencyValidation tests
    @Test
    public void testCurrencyIsNull()
    {
        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            Validation.currencyValidation(null);
        });
        assertEquals("400 BAD_REQUEST \"Currency can't be null\"", exception.getMessage());
    }

    @Test
    public void testCurrencyWrongLength()
    {
        //PL
        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            Validation.currencyValidation("PL");
        });
        assertEquals("422 UNPROCESSABLE_ENTITY \"Currency must have 3 letters\"", exception.getMessage());

        //EURO
        exception = assertThrows(ResponseStatusException.class, () -> {
            Validation.currencyValidation("EURO");
        });
        assertEquals("422 UNPROCESSABLE_ENTITY \"Currency must have 3 letters\"", exception.getMessage());

        exception = assertThrows(ResponseStatusException.class, () -> {
            Validation.currencyValidation("");
        });
        assertEquals("422 UNPROCESSABLE_ENTITY \"Currency must have 3 letters\"", exception.getMessage());
    }

    @Test
    public void testCurrencyWrongSemantic()
    {
        //PL_
        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            Validation.currencyValidation("PL_");
        });
        assertEquals("422 UNPROCESSABLE_ENTITY \"Currency must have only letters\"", exception.getMessage());

        //ZŁO
        exception = assertThrows(ResponseStatusException.class, () -> {
            Validation.currencyValidation("ZŁO");
        });
        assertEquals("422 UNPROCESSABLE_ENTITY \"Currency must have only letters\"", exception.getMessage());

        //P N
        exception = assertThrows(ResponseStatusException.class, () -> {
            Validation.currencyValidation("P N");
        });
        assertEquals("422 UNPROCESSABLE_ENTITY \"Currency must have only letters\"", exception.getMessage());

        //5ZL
        exception = assertThrows(ResponseStatusException.class, () -> {
            Validation.currencyValidation("5ZL");
        });
        assertEquals("422 UNPROCESSABLE_ENTITY \"Currency must have only letters\"", exception.getMessage());

        //$$$
        exception = assertThrows(ResponseStatusException.class, () -> {
            Validation.currencyValidation("$$$");
        });
        assertEquals("422 UNPROCESSABLE_ENTITY \"Currency must have only letters\"", exception.getMessage());

        //P_N
        exception = assertThrows(ResponseStatusException.class, () -> {
            Validation.currencyValidation("P_N");
        });
        assertEquals("422 UNPROCESSABLE_ENTITY \"Currency must have only letters\"", exception.getMessage());
    }

    @Test
    public void testCurrencyValid() {
        assertDoesNotThrow(() -> {
            Validation.currencyValidation("PLN");
        });

        assertDoesNotThrow(() -> {
            Validation.currencyValidation("EUR");
        });

        assertDoesNotThrow(() -> {
            Validation.currencyValidation("USD");
        });
    }

    //nicknameValidation tests
    @Test
    public void testNicknameIsNull()
    {
        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            Validation.nicknameValidation(null);
        });
        assertEquals("400 BAD_REQUEST \"Name can't be null\"", exception.getMessage());
    }

    @Test
    public void testNicknameWrongLength()
    {
        //P
        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            Validation.nicknameValidation("P");
        });
        assertEquals("422 UNPROCESSABLE_ENTITY \"Name should have at least 2 characters\"", exception.getMessage());

        //empty string
        exception = assertThrows(ResponseStatusException.class, () -> {
            Validation.nicknameValidation("");
        });
        assertEquals("422 UNPROCESSABLE_ENTITY \"Name should have at least 2 characters\"", exception.getMessage());

        //long string
        exception = assertThrows(ResponseStatusException.class, () -> {
            Validation.nicknameValidation("AqwertyuiopasdfghjklzxcvbnmAqwertyuiopasdfghjklzxcvbnmAqwertyuiopasdfghjklzxcvbnmAqwertyuiopasdfghjklzxcvbnmAqwertyuiopasdfghjklzxcvbnm");
        });
        assertEquals("422 UNPROCESSABLE_ENTITY \"Too many characters\"", exception.getMessage());
    }

    @Test
    public void testNicknameWrongSemantic()
    {
        //Bogdan;
        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            Validation.nicknameValidation("Bogdan;");
        });
        assertEquals("422 UNPROCESSABLE_ENTITY \"Name can only use english letters, numbers, spaces and _\"", exception.getMessage());

        //Łukasz
        exception = assertThrows(ResponseStatusException.class, () -> {
            Validation.nicknameValidation("Łukasz");
        });
        assertEquals("422 UNPROCESSABLE_ENTITY \"Name can only use english letters, numbers, spaces and _\"", exception.getMessage());

        //***
        exception = assertThrows(ResponseStatusException.class, () -> {
            Validation.nicknameValidation("***");
        });
        assertEquals("422 UNPROCESSABLE_ENTITY \"Name can only use english letters, numbers, spaces and _\"", exception.getMessage());

        exception = assertThrows(ResponseStatusException.class, () -> {
            Validation.nicknameValidation("\"Norbert\"");
        });
        assertEquals("422 UNPROCESSABLE_ENTITY \"Name can only use english letters, numbers, spaces and _\"", exception.getMessage());

        exception = assertThrows(ResponseStatusException.class, () -> {
            Validation.nicknameValidation("Zbigniew\nKowalski");
        });
        assertEquals("422 UNPROCESSABLE_ENTITY \"Name can only use english letters, numbers, spaces and _\"", exception.getMessage());
    }

    @Test
    public void testNicknameValid() {
        assertDoesNotThrow(() -> {
            Validation.nicknameValidation("Geralt z Rivii");
        });

        assertDoesNotThrow(() -> {
            Validation.nicknameValidation("L1nux");
        });

        assertDoesNotThrow(() -> {
            Validation.nicknameValidation("Tank1234");
        });

        assertDoesNotThrow(() -> {
            Validation.nicknameValidation("BIG_LETTERS");
        });

        assertDoesNotThrow(() -> {
            Validation.nicknameValidation("ul");
        });
    }
}
package com.example.exercise;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UtilityTest
{
    @Test
    public void CorrectNickname()
    {
        assertThat(Utility.CorrectNickname("Edward")).isTrue();
        assertThat(Utility.CorrectNickname("Anna")).isTrue();
        assertThat(Utility.CorrectNickname("Ala;")).isFalse();
        assertThat(Utility.CorrectNickname("Al")).isTrue();
        assertThat(Utility.CorrectNickname("B")).isTrue();
        assertThat(Utility.CorrectNickname("AqwertyuiopasdfghjklzxcvbnmAqwertyuiopasdfghjklzxcvbnmAqwertyuiopasdfghjklzxcvbnmAqwertyuiopasdfghjklzxcvbnmAqwertyuiopasdfghjklzxcvbnm")).isTrue();
        assertThat(Utility.CorrectNickname("Geralt z Rivii")).isTrue();
        assertThat(Utility.CorrectNickname("123344567")).isTrue();
        assertThat(Utility.CorrectNickname("JSON123")).isTrue();
    }

    @Test
    //Check if text have only letters space or _
    public void LettersOnly()
    {
        assertThat(Utility.LettersOnly("Edward")).isTrue();
        assertThat(Utility.LettersOnly("Anna")).isTrue();
        assertThat(Utility.LettersOnly("Ala;")).isFalse();
        assertThat(Utility.LettersOnly("Al")).isTrue();
        assertThat(Utility.LettersOnly("B")).isTrue();
        assertThat(Utility.LettersOnly("AqwertyuiopasdfghjklzxcvbnmAqwertyuiopasdfghjklzxcvbnmAqwertyuiopasdfghjklzxcvbnmAqwertyuiopasdfghjklzxcvbnmAqwertyuiopasdfghjklzxcvbnm")).isTrue();
        assertThat(Utility.LettersOnly("Geralt z Rivii")).isFalse();
        assertThat(Utility.LettersOnly("123344567")).isFalse();
        assertThat(Utility.LettersOnly("JSON123")).isFalse();
    }
}

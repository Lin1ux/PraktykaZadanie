package com.example.exercise;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UtilityTest
{
    @Test
    public void correctNickname()
    {
        assertThat(Utility.correctNickname("Edward")).isTrue();
        assertThat(Utility.correctNickname("Anna")).isTrue();
        assertThat(Utility.correctNickname("Ala;")).isFalse();
        assertThat(Utility.correctNickname("Al")).isTrue();
        assertThat(Utility.correctNickname("B")).isTrue();
        assertThat(Utility.correctNickname("AqwertyuiopasdfghjklzxcvbnmAqwertyuiopasdfghjklzxcvbnmAqwertyuiopasdfghjklzxcvbnmAqwertyuiopasdfghjklzxcvbnmAqwertyuiopasdfghjklzxcvbnm")).isTrue();
        assertThat(Utility.correctNickname("Geralt z Rivii")).isTrue();
        assertThat(Utility.correctNickname("123344567")).isTrue();
        assertThat(Utility.correctNickname("JSON123")).isTrue();
    }

    @Test
    //Check if text have only letters space or _
    public void lettersOnly()
    {
        assertThat(Utility.lettersOnly("Edward")).isTrue();
        assertThat(Utility.lettersOnly("Anna")).isTrue();
        assertThat(Utility.lettersOnly("Ala;")).isFalse();
        assertThat(Utility.lettersOnly("Al")).isTrue();
        assertThat(Utility.lettersOnly("B")).isTrue();
        assertThat(Utility.lettersOnly("AqwertyuiopasdfghjklzxcvbnmAqwertyuiopasdfghjklzxcvbnmAqwertyuiopasdfghjklzxcvbnmAqwertyuiopasdfghjklzxcvbnmAqwertyuiopasdfghjklzxcvbnm")).isTrue();
        assertThat(Utility.lettersOnly("Geralt z Rivii")).isFalse();
        assertThat(Utility.lettersOnly("123344567")).isFalse();
        assertThat(Utility.lettersOnly("JSON123")).isFalse();
    }
}

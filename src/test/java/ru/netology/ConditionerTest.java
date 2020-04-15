package ru.netology;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ConditionerTest {

    @ParameterizedTest
    @CsvSource(
            value = {
                    "Increase current temperature correct, 21, 21",
                    "Increase current temperature uncorrect, 22, 20",
                    "Over max temperature, 31, 20"
            }
    )
    public void shouldIncreaseCurrentTemperature(String name, int amount, int expected) {
        Conditioner conditioner = new Conditioner();
        assertEquals(expected, conditioner.increaseCurrentTemperature(amount));
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "Decrease current temperature correct, 19, 19 ",
                    "Decrease current temperature uncorrect, 15, 20",
                    "Under min temperature, 5, 20"
            }
    )
    public void shouldDecreaseCurrentTemperature(String name, int amount, int expected) {
        Conditioner conditioner = new Conditioner();
        assertEquals(expected, conditioner.decreaseCurrentTemperature(amount));
    }

    @Test
    public void shouldGetName() {
        Conditioner conditioner = new Conditioner();
        String expected = "Кондей";
        assertEquals(expected, conditioner.getName());
    }
}
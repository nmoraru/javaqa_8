package ru.netology;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConditionerTest {

    @ParameterizedTest
    @CsvSource(
            value = {
                    "Increase normal current temperature, 10, 30, 20, 21",
                    "Increase max temperature, 10, 30, 30, 30"
            }
    )
    public void shouldIncreaseCurrentTemperature(String name, int minTemperature, int maxTemperature,
                                                 int currentTemperature, int expected) {
        Conditioner conditioner = new Conditioner();
        conditioner.setMinTemperature(minTemperature);
        conditioner.setMaxTemperature(maxTemperature);
        conditioner.setCurrentTemperature(currentTemperature);
        conditioner.increaseCurrentTemperature();
        assertEquals(expected, conditioner.getCurrentTemperature(), "Values should be equal");
    }


    @ParameterizedTest
    @CsvSource(
            value = {
                    "Decrease normal current temperature, 10, 30, 20, 19 ",
                    "Decrease min temperature, 10, 30, 10, 10"
            }
    )
    public void shouldDecreaseCurrentTemperature(String name, int minTemperature, int maxTemperature,
                                                 int currentTemperature, int expected) {
        Conditioner conditioner = new Conditioner();
        conditioner.setMinTemperature(minTemperature);
        conditioner.setMaxTemperature(maxTemperature);
        conditioner.setCurrentTemperature(currentTemperature);
        conditioner.decreaseCurrentTemperature();
        assertEquals(expected, conditioner.getCurrentTemperature(), "Values should be equal");
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "Current temperature normal, 10, 30, 20, 20 ",
                    "Current temperature upper max temperature, 10, 30, 31, 0 ",
                    "Current temperature under min temperature, 10, 30, 9, 0 ",
            }
    )
    public void shouldSetCurrentTemperature(String name, int minTemperature, int maxTemperature,
                                                 int currentTemperature, int expected) {
        Conditioner conditioner = new Conditioner();
        conditioner.setMinTemperature(minTemperature);
        conditioner.setMaxTemperature(maxTemperature);
        conditioner.setCurrentTemperature(currentTemperature);
        assertEquals(expected, conditioner.getCurrentTemperature(), "Values should be equal");
    }

    @Test
    public void shouldGetName() {
        Conditioner conditioner = new Conditioner();
        String expected = "Кондей";
        assertEquals(expected, conditioner.getName(), "Values should be equal");
    }
}
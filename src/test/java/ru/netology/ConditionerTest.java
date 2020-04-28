package ru.netology;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConditionerTest {

    @ParameterizedTest
    @CsvSource(
            value = {
                    "Increase normal current temperature, true, 10, 30, 20, 21",
                    "Increase max temperature, true, 10, 30, 30, 30",
                    "Increase normal current temperature, false, 10, 30, 20, 0"
            }
    )
    public void shouldIncreaseCurrentTemperature(String name, boolean on, int minTemperature, int maxTemperature,
                                                 int currentTemperature, int expected) {
        Conditioner conditioner = new Conditioner();
        conditioner.setOn(on);
        conditioner.setMinTemperature(minTemperature);
        conditioner.setMaxTemperature(maxTemperature);
        conditioner.setCurrentTemperature(currentTemperature);
        conditioner.increaseCurrentTemperature();
        assertEquals(expected, conditioner.getCurrentTemperature(), name);
    }


    @ParameterizedTest
    @CsvSource(
            value = {
                    "Decrease normal current temperature, true, 10, 30, 20, 19 ",
                    "Decrease min temperature, true, 10, 30, 10, 10",
                    "Decrease min temperature, false, 10, 30, 10, 0"
            }
    )
    public void shouldDecreaseCurrentTemperature(String name, boolean on, int minTemperature, int maxTemperature,
                                                 int currentTemperature, int expected) {
        Conditioner conditioner = new Conditioner();
        conditioner.setOn(on);
        conditioner.setMinTemperature(minTemperature);
        conditioner.setMaxTemperature(maxTemperature);
        conditioner.setCurrentTemperature(currentTemperature);
        conditioner.decreaseCurrentTemperature();
        assertEquals(expected, conditioner.getCurrentTemperature(), name);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "Current temperature normal, true, 10, 30, 20, 20 ",
                    "Current temperature upper max temperature, true, 10, 30, 31, 0 ",
                    "Current temperature under min temperature, true, 10, 30, 9, 0 ",
                    "Current temperature under min temperature, false, 10, 30, 15, 0 "
            }
    )
    public void shouldSetCurrentTemperature(String name, boolean on, int minTemperature, int maxTemperature,
                                            int currentTemperature, int expected) {
        Conditioner conditioner = new Conditioner();
        conditioner.setOn(on);
        conditioner.setMinTemperature(minTemperature);
        conditioner.setMaxTemperature(maxTemperature);
        conditioner.setCurrentTemperature(currentTemperature);
        assertEquals(expected, conditioner.getCurrentTemperature(), name);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "max temperature < min temperature, true, 10, 9, 10, 30",
                    "min temperature > max temperature, true, 31, 30, 10, 30",
                    "max temperature = min temperature, true, 3, 3, 3, 30",
                    "max station > min station, true, 7, 19, 7, 19"
            }
    )
    public void shouldisMinTemperatureNotOverMaxTemperature(String name, boolean on, int minTemperature,
                                                            int maxTemperature, int expectedMinTemperature,
                                                            int expectedMaxTemperature) {
        Conditioner conditioner = new Conditioner();
        conditioner.setOn(on);
        conditioner.setMinTemperature(minTemperature);
        conditioner.setMaxTemperature(maxTemperature);

        assertEquals(expectedMinTemperature, conditioner.getMinTemperature(), name);
        assertEquals(expectedMaxTemperature, conditioner.getMaxTemperature(), name);
    }

    @Test
    public void shouldGetName() {
        Conditioner conditioner = new Conditioner();
        String expected = "Кондей";
        assertEquals(expected, conditioner.getName(), "Values should be equal");
    }
}
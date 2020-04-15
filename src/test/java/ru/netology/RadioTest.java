package ru.netology;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @ParameterizedTest
    @CsvSource(
            value = {
                    "Next station upper max, 9, 0",
                    "Next station other, 0, 1"
            }
    )
    public void shouldButtonNextStation(String name, int amount, int expected) {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(amount);
        assertEquals(expected, radio.buttonNextStation());
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "Next station under min, 0, 9",
                    "Next station other, 1, 0"
            }
    )
    public void shouldButtonPrevStation(String name, int amount, int expected) {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(amount);
        assertEquals(expected, radio.buttonPrevStation());
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "Upper max radio station, 10, 5",
                    "Under min radio station, -1, 5",
                    "Other radio station, 6, 6"
            }
    )
    public void shouldController(String name, int amount, int expected) {
        Radio radio = new Radio();
        assertEquals(expected, radio.controller(amount));
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "Volume max up, 10, 10",
                    "other volume up, 4, 5"
            }
    )
    public void shouldButtonVolumeUp(String name, int amount, int expected) {
        Radio radio = new Radio();
        radio.setCurrentVolume(amount);
        assertEquals(expected, radio.buttonVolumeUp());
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "Volume min down, 0, 0",
                    "other volume down, 4, 3"
            }
    )
    public void shouldButtonVolumeDown(String name, int amount, int expected) {
        Radio radio = new Radio();
        radio.setCurrentVolume(amount);
        assertEquals(expected, radio.buttonVolumeDown());
    }

    @Test
    public void shouldGetCurrentRadioStation() {
        Radio radio = new Radio();
        int expected = 5;
        assertEquals(expected, radio.getCurrentRadioStation());
    }

    @Test
    public void shouldGetCurrentVolume() {
        Radio radio = new Radio();
        int expected = 5;
        assertEquals(expected, radio.getCurrentVolume());
    }

}
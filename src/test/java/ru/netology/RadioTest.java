package ru.netology;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @ParameterizedTest
    @CsvSource(
            value = {
                    "Next station other, true, 100, 10, 5, 6",
                    "Next station after max, true, 100, 10, 10, 0",
                    "Next station other, false, 100, 10, 5, 0"
            }
    )
    public void shouldSelectNextStation(String name, boolean on, int maxVolume, int maxStation, int currentRadioStation,
                                        int expected) {
        Radio radio = new Radio(
                maxVolume,
                maxStation,
                on
        );
        radio.setCurrentRadioStation(currentRadioStation, on);
        radio.selectNextStation(on);
        assertEquals(expected, radio.getCurrentRadioStation(), name);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "Prev station before min, true, 100, 10, 0, 10",
                    "Prev station other, true, 100, 10, 2, 1",
                    "Prev station before min, false, 100, 10, 5, 0"
            }
    )
    public void shouldSelectPrevStation(String name, boolean on, int maxVolume, int maxStation, int currentStation,
                                        int expected) {
        Radio radio = new Radio(
                maxVolume,
                maxStation,
                on
        );
        radio.setCurrentRadioStation(currentStation, on);
        radio.selectPrevStation(on);
        assertEquals(expected, radio.getCurrentRadioStation(), name);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "Volume max up, true, 100, 10, 100, 100",
                    "other volume up, true, 100, 10, 4, 5",
                    "Volume max up, false, 100, 10, 5, 0"
            }
    )
    public void shouldSelectVolumeUp(String name, boolean on, int maxVolume, int maxStation, int currentVolume,
                                     int expected) {
        Radio radio = new Radio(
                maxVolume,
                maxStation,
                on
        );
        radio.setCurrentVolume(currentVolume, on);
        radio.selectVolumeUp(on);
        assertEquals(expected, radio.getCurrentVolume(), name);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "Volume min down, true, 100, 10, 0, 0",
                    "other volume down, true, 100, 10, 4, 3",
                    "Volume min down, false, 100, 10, 5, 0"
            }
    )
    public void shouldSelectVolumeDown(String name, boolean on, int maxVolume, int maxStation, int currentVolume,
                                       int expected) {
        Radio radio = new Radio(
                maxVolume,
                maxStation,
                on
        );
        radio.setCurrentVolume(currentVolume, on);
        radio.selectVolumeDown(on);
        assertEquals(expected, radio.getCurrentVolume(), name);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "Current volume normal, true, 100, 10, 5, 5",
                    "Current volume under min volume, true, 100, 10, -1, 0",
                    "Current volume upper max volume, true, 100, 10, 101, 0",
                    "Current volume normal, false, 100, 10, 5, 0"
            }
    )
    public void shouldSetCurrentVolume(String name, boolean on, int maxVolume, int maxStation,  int currentVolume,
                                       int expected) {
        Radio radio = new Radio(
                maxVolume,
                maxStation,
                on
        );

        radio.setCurrentVolume(currentVolume, on);
        assertEquals(expected, radio.getCurrentVolume(), name);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "Upper max radio station, true, 100, 10, 11, 0",
                    "Under min radio station, true, 100, 10, -1, 0",
                    "Other radio station, true, 100, 10, 7, 7",
                    "Upper max radio station, false, 100, 10, 10, 0"

            }
    )
    public void shouldSetCurrentRadioStation(String name, boolean on, int maxVolume, int maxStation,
                                             int currentStation, int expected) {
        Radio radio = new Radio(
                maxVolume,
                maxStation,
                on
        );

        radio.setCurrentRadioStation(currentStation, on);
        assertEquals(expected, radio.getCurrentRadioStation(), name);
    }

    @Test
    public void shouldGetCurrentRadioStation() {
        Radio radio = new Radio();
        int expected = 0;
        assertEquals(expected, radio.getCurrentRadioStation());
    }

    @Test
    public void shouldGetCurrentVolume() {
        Radio radio = new Radio();
        int expected = 0;
        assertEquals(expected, radio.getCurrentVolume());
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "max volume < min volume, true, -3, 10, 100",
                    "max volume = min volume, true, 0, 10, 100",
                    "max volume > min volume, true, 7, 10, 7"
            }
    )
    public void shouldMinVolumeNotOverMaxVolume(String name, boolean on, int maxVolume, int maxStation,
                                                int expectedMaxVolume) {
        Radio radio = new Radio(
                maxVolume,
                maxStation,
                on
        );

        assertEquals(expectedMaxVolume, radio.getMaxVolume(), name);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "max station < min station, true, 100, -3, 10",
                    "max station = min station, true, 100, 0, 10",
                    "max station > min station, true, 100, 7, 7"
            }
    )
    public void shouldMinStationNotOverMaxStation(String name, boolean on, int maxVolume, int maxStation,
                                                  int expectedMaxStation) {
        Radio radio = new Radio(
                maxVolume,
                maxStation,
                on
        );

        assertEquals(expectedMaxStation, radio.getMaxRadioStation(), name);
    }

}
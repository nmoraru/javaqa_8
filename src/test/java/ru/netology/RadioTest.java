package ru.netology;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @ParameterizedTest
    @CsvSource(
            value = {
                    "Next station other, true, 0, 10, 5, 6",
                    "Next station after max, true, 0, 10, 10, 0",
                    "Next station other, false, 0, 10, 5, 0"
            }
    )
    public void shouldButtonNextStation(String name, boolean on, int minStation, int maxStation, int currentRadioStation,
                                        int expected) {
        Radio radio = new Radio(
                minStation,
                maxStation,
                on
        );
        radio.setCurrentRadioStation(currentRadioStation, on);
        radio.buttonNextStation(on);
        assertEquals(expected, radio.getCurrentRadioStation(), name);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "Prev station before min, true, 0, 10, 0, 10",
                    "Prev station other, true, 0, 10, 2, 1",
                    "Prev station before min, false, 0, 10, 5, 0"
            }
    )
    public void shouldButtonPrevStation(String name, boolean on, int minStation, int maxStation, int currentStation,
                                        int expected) {
        Radio radio = new Radio(
                minStation,
                maxStation,
                on
        );
        radio.setCurrentRadioStation(currentStation, on);
        radio.buttonPrevStation(on);
        assertEquals(expected, radio.getCurrentRadioStation(), name);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "Upper max radio station, true, 0, 10, 5, 11, 5",
                    "Under min radio station, true, 3, 10, 5, 1, 5",
                    "Other radio station, true, 0, 10, 5, 7, 7",
                    "Upper max radio station, false, 0, 9, 5, 6, 0"
            }
    )
    public void shouldStationFromController(String name, boolean on, int minStation, int maxStation, int currentStation,
                                            int stationFromController, int expected) {
        Radio radio = new Radio(
                minStation,
                maxStation,
                on
        );
        radio.setCurrentRadioStation(currentStation, on);
        radio.stationFromController(stationFromController, on);
        assertEquals(expected, radio.getCurrentRadioStation(), name);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "Volume max up, true, 0, 100, 100, 100",
                    "other volume up, true, 0, 100, 4, 5",
                    "Volume max up, false, 0, 100, 5, 0"
            }
    )
    public void shouldButtonVolumeUp(String name, boolean on, int minVolume, int maxVolume, int currentVolume,
                                     int expected) {
        Radio radio = new Radio(
                minVolume,
                on,
                maxVolume
        );
        radio.setCurrentVolume(currentVolume, on);
        radio.buttonVolumeUp(on);
        assertEquals(expected, radio.getCurrentVolume(), name);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "Volume min down, true, 0, 10, 0, 0",
                    "other volume down, true, 0, 10, 4, 3",
                    "Volume min down, false, 0, 10, 5, 0"
            }
    )
    public void shouldButtonVolumeDown(String name, boolean on, int minVolume, int maxVolume, int currentVolume,
                                       int expected) {
        Radio radio = new Radio(
                minVolume,
                on,
                maxVolume
        );
        radio.setCurrentVolume(currentVolume, on);
        radio.buttonVolumeDown(on);
        assertEquals(expected, radio.getCurrentVolume(), name);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "Current volume normal, true, 0, 10, 5, 5",
                    "Current volume under min volume, true, 0, 10, -1, 0",
                    "Current volume upper max volume, true, 0, 10, 11, 0",
                    "Current volume normal, false, 0, 10, 5, 0",
                    "Current volume under min volume, false, 0, 10, -1, 0",
                    "Current volume upper max volume, false, 0, 10, 11, 0",
            }
    )
    public void shouldSetCurrentVolume(String name, boolean on, int minVolume, int maxVolume, int currentVolume,
                                       int expected) {
        Radio radio = new Radio(
                minVolume,
                on,
                maxVolume
        );

        radio.setCurrentVolume(currentVolume, on);
        assertEquals(expected, radio.getCurrentVolume(), name);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "Upper max radio station, true, 0, 10, 11, 0",
                    "Under min radio station, true, 0, 10, -1, 0",
                    "Other radio station, true, 0, 10, 7, 7",
                    "Upper max radio station, false, 0, 10, 10, 0"
            }
    )
    public void shouldSetCurrentRadioStation(String name, boolean on, int minStation, int maxStation,
                                             int currentStation, int expected) {
        Radio radio = new Radio(
                minStation,
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
                    "max volume < min volume, true, 3, 1, 0, 100",
                    "min volume > max volume, true, 11, 0, 0, 100",
                    "max volume = min volume, true, 3, 3, 0, 100",
                    "max volume > min volume, true, 7, 19, 7, 19"
            }
    )
    public void shouldMinVolumeNotOverMaxVolume(String name, boolean on, int minVolume, int maxVolume,
                                                int expectedMinVolume, int expectedMaxVolume) {
        Radio radio = new Radio(
                minVolume,
                on,
                maxVolume
        );

        assertEquals(expectedMinVolume, radio.getMinVolume(), name);
        assertEquals(expectedMaxVolume, radio.getMaxVolume(), name);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "max station < min station, true, 3, 1, 0, 10",
                    "min station > max station, true, 11, 0, 0, 10",
                    "max station = min station, true, 3, 3, 0, 10",
                    "max station > min station, true, 7, 19, 7, 19"
            }
    )
    public void shouldMinStationNotOverMaxStation(String name, boolean on, int minStation, int maxStation,
                                                int expectedMinStation, int expectedMaxStation) {
        Radio radio = new Radio(
                minStation,
                maxStation,
                on
        );

        assertEquals(expectedMinStation, radio.getMinRadioStation(), name);
        assertEquals(expectedMaxStation, radio.getMaxRadioStation(), name);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'Create conditioner with customer min/max temperature and volume, on', " +
                            "true, 1, 11, 1, 101, 1, 11, 1, 101",
                    "'Create conditioner with customer min/max temperature and volume, off', " +
                            "false, 1, 11, 1, 101, 0, 10, 0, 100",
                    "max station < min station, true, 3, 1, 1, 101, 0, 10, 1, 101",
                    "max volume < min volume, true, 1, 11, 3, 1, 0, 10, 0, 100"
            }
    )
    public void shouldCreateCustomConditioner(String name, boolean on, int minStation, int maxStation,
                                            int minVolume, int maxVolume,
                                            int expectedMinStation, int expectedMaxStation,
                                            int expectedMinVolume, int expectedMaxVolume
                                            ) {
        Radio radio = new Radio(
                minVolume,
                maxVolume,
                minStation,
                maxStation,
                on
        );

        assertEquals(expectedMinStation, radio.getMinRadioStation(), name);
        assertEquals(expectedMaxStation, radio.getMaxRadioStation(), name);
        assertEquals(expectedMinVolume, radio.getMinVolume(), name);
        assertEquals(expectedMaxVolume, radio.getMaxVolume(), name);
    }

}
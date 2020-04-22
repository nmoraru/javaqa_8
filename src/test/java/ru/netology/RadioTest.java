package ru.netology;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @ParameterizedTest
    @CsvSource(
            value = {
                    "Next station other, 0, 9, 5, 6",
                    "Next station after max, 0, 9, 9, 0"
            }
    )
    public void shouldButtonNextStation(String name, int minStation, int maxStation, int currentStation,
                                        int expected) {
        Radio radio = new Radio();
        radio.setMinRadioStation(minStation);
        radio.setMaxRadioStation(maxStation);
        radio.setCurrentRadioStation(currentStation);
        radio.buttonNextStation();
        assertEquals(expected, radio.getCurrentRadioStation(), "Values should be equal");
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "Prev station before min, 0, 9, 0, 9",
                    "Prev station other, 0, 9, 1, 0"
            }
    )
    public void shouldButtonPrevStation(String name, int minStation, int maxStation, int currentStation,
                                        int expected) {
        Radio radio = new Radio();
        radio.setMinRadioStation(minStation);
        radio.setMaxRadioStation(maxStation);
        radio.setCurrentRadioStation(currentStation);
        radio.buttonPrevStation();
        assertEquals(expected, radio.getCurrentRadioStation(), "Values should be equal");
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "Upper max radio station, 0, 9, 5, 10, 5",
                    "Under min radio station, 0, 9, 5, -1, 5",
                    "Other radio station, 0, 9, 5, 7, 7"
            }
    )
    public void shouldStationFromController(String name, int minStation, int maxStation, int currentStation,
                                            int stationFromController, int expected) {
        Radio radio = new Radio();
        radio.setMinRadioStation(minStation);
        radio.setMaxRadioStation(maxStation);
        radio.setCurrentRadioStation(currentStation);
        radio.stationFromController(stationFromController);
        assertEquals(expected, radio.getCurrentRadioStation(), "Values should be equal");
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "Volume max up, 0, 10, 10, 10",
                    "other volume up, 0, 10, 4, 5"
            }
    )
    public void shouldButtonVolumeUp(String name, int minVolume, int maxVolume, int currentVolume, int expected) {
        Radio radio = new Radio();
        radio.setMinVolume(minVolume);
        radio.setMaxVolume(maxVolume);
        radio.setCurrentVolume(currentVolume);
        radio.buttonVolumeUp();
        assertEquals(expected, radio.getCurrentVolume(), "Values should be equal");
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "Volume min down, 0, 10, 0, 0",
                    "other volume down, 0, 10, 4, 3"
            }
    )
    public void shouldButtonVolumeDown(String name, int minVolume, int maxVolume, int currentVolume, int expected) {
        Radio radio = new Radio();
        radio.setMinVolume(minVolume);
        radio.setMaxVolume(maxVolume);
        radio.setCurrentVolume(currentVolume);
        radio.buttonVolumeDown();
        assertEquals(expected, radio.getCurrentVolume(), "Values should be equal");
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "Current volume normal, 0, 10, 5, 5",
                    "Current volume under min volume, 0, 10, -1, 0",
                    "Current volume upper max volume, 0, 10, 11, 0"
            }
    )
    public void shouldSetCurrentVolume(String name, int minVolume, int maxVolume, int currentVolume, int expected) {
        Radio radio = new Radio();
        radio.setMinVolume(minVolume);
        radio.setMaxVolume(maxVolume);
        radio.setCurrentVolume(currentVolume);
        assertEquals(expected, radio.getCurrentVolume(), "Values should be equal");
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "Upper max radio station, 0, 9, 10, 0",
                    "Under min radio station, 0, 9, -1, 0",
                    "Other radio station, 0, 9, 7, 7"
            }
    )
    public void shouldSetCurrentRadioStation(String name, int minStation, int maxStation, int currentStation,
                                             int expected) {
        Radio radio = new Radio();
        radio.setMinRadioStation(minStation);
        radio.setMaxRadioStation(maxStation);
        radio.setCurrentRadioStation(currentStation);
        assertEquals(expected, radio.getCurrentRadioStation(), "Values should be equal");
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

}
package ru.netology;

public class Radio {
    private String name = "Атмосфера";

    private int minVolume = 0;
    private int maxVolume = 10;
    private int currentVolume = 5;

    private int minRadioStation = 0;
    private int maxRadioStation = 9;
    private int currentRadioStation = 5;

    public int buttonNextStation() {
        if (currentRadioStation == maxRadioStation) {
            currentRadioStation = minRadioStation;
            return currentRadioStation;
        }
        currentRadioStation++;
        return currentRadioStation;
    }

    public int buttonPrevStation() {
        if (currentRadioStation == minRadioStation) {
            currentRadioStation = maxRadioStation;
            return currentRadioStation;
        }
        currentRadioStation--;
        return currentRadioStation;
    }

    public int controller(int currentRadioStation) {
        if (currentRadioStation > maxRadioStation) {
            return this.currentRadioStation;
        }
        if (currentRadioStation < minRadioStation) {
            return this.currentRadioStation;
        }
        this.currentRadioStation = currentRadioStation;
        return this.currentRadioStation;
    }

    public int buttonVolumeUp() {
        if (currentVolume == maxVolume) {
            return currentVolume;
        }
        currentVolume++;
        return currentVolume;
    }

    public int buttonVolumeDown() {
        if (currentVolume == minVolume) {
            return currentVolume;
        }
        currentVolume--;
        return currentVolume;
    }

    public int getCurrentRadioStation() {
        return currentRadioStation;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentRadioStation(int currentRadioStation) {
        this.currentRadioStation = currentRadioStation;
    }

    public void setCurrentVolume(int currentVolume) {
        this.currentVolume = currentVolume;
    }

}

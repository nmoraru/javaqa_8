package ru.netology;

public class Radio {
    private String name = "Атмосфера";

    private int minVolume;
    private int maxVolume;
    private int currentVolume;

    private int minRadioStation;
    private int maxRadioStation;
    private int currentRadioStation;

    public void setMinVolume(int minVolume) {
        this.minVolume = minVolume;
    }
    public int getMinVolume() {
        return minVolume;
    }

    public void setMaxVolume(int maxVolume) {
        this.maxVolume = maxVolume;
    }
    public int getMaxVolume() {
        return maxVolume;
    }

    public void setCurrentVolume(int currentVolume) {
        if (currentVolume < minVolume || currentVolume > maxVolume) {
            return;
        }
        this.currentVolume = currentVolume;
    }
    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setMinRadioStation(int minRadioStation) {
        this.minRadioStation = minRadioStation;
    }
    public int getMinRadioStation() {
        return minRadioStation;
    }

    public void setMaxRadioStation(int maxRadioStation) {
        this.maxRadioStation = maxRadioStation;
    }
    public int getMaxRadioStation() {
        return maxRadioStation;
    }

    public void setCurrentRadioStation(int currentRadioStation) {
        if (currentRadioStation < minRadioStation || currentRadioStation > maxRadioStation) {
            return;
        }
        this.currentRadioStation = currentRadioStation;
    }
    public int getCurrentRadioStation() {
        return currentRadioStation;
    }

    public void buttonNextStation() {
        if (currentRadioStation == maxRadioStation) {
            currentRadioStation = minRadioStation;
        }
        else currentRadioStation++;
    }

    public void buttonPrevStation() {
        if (currentRadioStation == minRadioStation) {
            currentRadioStation = maxRadioStation;
        }
        else currentRadioStation--;
    }

    public void stationFromController(int stationFromController) {
        if (stationFromController < minRadioStation || stationFromController > maxRadioStation) {
            return;
        }
        currentRadioStation = stationFromController;
    }

    public void buttonVolumeUp() {
        if (currentVolume == maxVolume) {
            return;
        }
        currentVolume++;
    }

    public void buttonVolumeDown() {
        if (currentVolume == minVolume) {
            return;
        }
        currentVolume--;
    }

}

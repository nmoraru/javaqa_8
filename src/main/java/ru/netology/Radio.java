package ru.netology;

public class Radio {
    private String name = "Атмосфера";
    private int minVolume = 0;
    private int maxVolume = 100;
    private int currentVolume;
    private int minRadioStation = 0;
    private int maxRadioStation = 10;
    private int currentRadioStation;
    private boolean on;

    public Radio() {
    }

    public Radio(int minVolume, int maxVolume, int minRadioStation, int maxRadioStation, boolean on) {
        if (isOn(on)) {
            return;
        }
        if (isMinVolumeNotOverMaxVolume(minVolume, maxVolume)) {
            return;
        }
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;

        if (isMinStationNotOverMaxStation(minRadioStation, maxRadioStation)) {
            return;
        }
        this.minRadioStation = minRadioStation;
        this.maxRadioStation = maxRadioStation;
    }

    public Radio(int minRadioStation, int maxRadioStation, boolean on) {
        if (isOn(on)) {
            return;
        }
        if (isMinStationNotOverMaxStation(minRadioStation, maxRadioStation)) {
            return;
        }
        this.minRadioStation = minRadioStation;
        this.maxRadioStation = maxRadioStation;
    }

    public Radio( int minVolume, boolean on, int maxVolume) {
        if (isOn(on)) {
            return;
        }
        if (isMinVolumeNotOverMaxVolume(minVolume, maxVolume)) {
            return;
        }
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
    }

    private boolean isMinVolumeNotOverMaxVolume(int minVolume, int maxVolume) {
        return (maxVolume <= minVolume);
    }

    public int getMinVolume() {
        return minVolume;
    }

    public int getMaxVolume() {
        return maxVolume;
    }

    public void setCurrentVolume(int currentVolume, boolean on) {
        if (isOn(on)) {
            return;
        }
        if (isCurrentVolumeBetweenMinAndMax(currentVolume)) {
            return;
        }
        this.currentVolume = currentVolume;
    }

    private boolean isCurrentVolumeBetweenMinAndMax(int currentVolume) {
        return (currentVolume < minVolume || currentVolume > maxVolume);
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public int getMinRadioStation() {
        return minRadioStation;
    }

    public int getMaxRadioStation() {
        return maxRadioStation;
    }

    private boolean isMinStationNotOverMaxStation(int minRadioStation, int maxRadioStation) {
        return (maxRadioStation <= minRadioStation);
    }

    public void setCurrentRadioStation(int currentRadioStation, boolean on) {
        if (isOn(on)) {
            return;
        }
        if (isCurrentRadioStationBetweenMinAndMax(currentRadioStation)) {
            return;
        }
        else this.currentRadioStation = currentRadioStation;
    }

    private boolean isCurrentRadioStationBetweenMinAndMax(int currentRadioStation) {
        return (currentRadioStation < minRadioStation || currentRadioStation > maxRadioStation);
    }

    public int getCurrentRadioStation() {
        return currentRadioStation;
    }

    public void buttonNextStation(boolean on) {
        if (isOn(on)) {
            return;
        }
        if (currentRadioStation == maxRadioStation) {
            currentRadioStation = minRadioStation;
        } else currentRadioStation++;
    }

    public void buttonPrevStation(boolean on) {
        if (isOn(on)) {
            return;
        }
        if (currentRadioStation == minRadioStation) {
            currentRadioStation = maxRadioStation;
        }
        else currentRadioStation--;
    }

    public void stationFromController(int stationFromController, boolean on) {
        if (isOn(on)) {
            return;
        }
        if (isStationFromControllerBetweenMinAndMax(stationFromController)) {
            return;
        }
        currentRadioStation = stationFromController;
    }

    private boolean isStationFromControllerBetweenMinAndMax(int stationFromController) {
        return (stationFromController < minRadioStation || stationFromController > maxRadioStation);
    }

    public void buttonVolumeUp(boolean on) {
        if (isOn(on)) {
            return;
        }
        if (currentVolume == maxVolume) {
            return;
        }
        currentVolume++;
    }

    public void buttonVolumeDown(boolean on) {
        if (isOn(on)) {
            return;
        }
        if (currentVolume == minVolume) {
            return;
        }
        currentVolume--;
    }

    public boolean getOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    private boolean isOn(boolean on) {
        return (on == false);
    }
}

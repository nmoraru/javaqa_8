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

    public Radio(int maxVolume, int maxRadioStation, boolean on) {
        if (isOff(on)) {
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
        if (isOff(on)) {
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
        if (isOff(on)) {
            return;
        }
        if (isCurrentRadioStationBetweenMinAndMax(currentRadioStation)) {
            return;
        }
        this.currentRadioStation = currentRadioStation;
    }

    private boolean isCurrentRadioStationBetweenMinAndMax(int currentRadioStation) {
        return (currentRadioStation < minRadioStation || currentRadioStation > maxRadioStation);
    }

    public int getCurrentRadioStation() {
        return currentRadioStation;
    }

    public void selectNextStation(boolean on) {
        if (isOff(on)) {
            return;
        }
        if (currentRadioStation == maxRadioStation) {
            currentRadioStation = minRadioStation;
        } else {
            currentRadioStation++;
        }
    }

    public void selectPrevStation(boolean on) {
        if (isOff(on)) {
            return;
        }
        if (currentRadioStation == minRadioStation) {
            currentRadioStation = maxRadioStation;
        } else {
            currentRadioStation--;
        }
    }

    public void selectVolumeUp(boolean on) {
        if (isOff(on)) {
            return;
        }
        if (currentVolume == maxVolume) {
            return;
        }
        currentVolume++;
    }

    public void selectVolumeDown(boolean on) {
        if (isOff(on)) {
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

    private boolean isOff(boolean on) {
        return (on == false);
    }
}

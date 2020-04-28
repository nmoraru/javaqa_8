package ru.netology;

public class Radio {
    private String name = "Атмосфера";

    private int minVolume = 1;
    private int maxVolume = 10;
    private int currentVolume;

    private int minRadioStation = 1;
    private int maxRadioStation = 9;
    private int currentRadioStation;

    private boolean on;

    public void setMinVolume(int minVolume) {
        if (isOn(on)) {
            return;
        }
        if (isMinVolumeNotOverMaxVolume(minVolume, maxVolume)) {
            return;
        }
        else this.minVolume = minVolume;
    }

    private boolean isMinVolumeNotOverMaxVolume(int minVolume, int maxVolume) {
        return (maxVolume <= minVolume);
    }

    public int getMinVolume() {
        return minVolume;
    }

    public void setMaxVolume(int maxVolume) {
        if (isOn(on)) {
            return;
        }
        if (isMinVolumeNotOverMaxVolume(minVolume, maxVolume)) {
            return;
        }
        else this.maxVolume = maxVolume;
    }

    public int getMaxVolume() {
        return maxVolume;
    }

    public void setCurrentVolume(int currentVolume) {
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

    public void setMinRadioStation(int minRadioStation) {
        if (isOn(on)) {
            return;
        }
        if (isMinStationNotOverMaxStation(minRadioStation, maxRadioStation)) {
            return;
        } else this.minRadioStation = minRadioStation;
    }

    public int getMinRadioStation() {
        return minRadioStation;
    }

    public void setMaxRadioStation(int maxRadioStation) {
        if (isOn(on)) {
            return;
        }
        if (isMinStationNotOverMaxStation(minRadioStation, maxRadioStation)) {
            return;
        }
        else this.maxRadioStation = maxRadioStation;
    }

    public int getMaxRadioStation() {
        return maxRadioStation;
    }

    private boolean isMinStationNotOverMaxStation(int minRadioStation, int maxRadioStation) {
        return (maxRadioStation <= minRadioStation);
    }

    public void setCurrentRadioStation(int currentRadioStation) {
        if (isOn(on)) {
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

    public void buttonNextStation() {
        if (isOn(on)) {
            return;
        }
        if (currentRadioStation == maxRadioStation) {
            currentRadioStation = minRadioStation;
        } else currentRadioStation++;
    }

    public void buttonPrevStation() {
        if (isOn(on)) {
            return;
        }
        if (currentRadioStation == minRadioStation) {
            currentRadioStation = maxRadioStation;
        } else currentRadioStation--;
    }

    public void stationFromController(int stationFromController) {
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

    public void buttonVolumeUp() {
        if (isOn(on)) {
            return;
        }
        if (currentVolume == maxVolume) {
            return;
        }
        currentVolume++;
    }

    public void buttonVolumeDown() {
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

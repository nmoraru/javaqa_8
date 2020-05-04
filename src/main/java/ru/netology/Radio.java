package ru.netology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Radio {
    private String name = "Атмосфера";
    private int minVolume = 0;
    private int maxVolume = 100;
    private int currentVolume;
    private int minRadioStation = 0;
    private int maxRadioStation = 10;
    private int currentRadioStation;
    private boolean on;

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

    private boolean isOn(boolean on) {
        return (on == false);
    }
}

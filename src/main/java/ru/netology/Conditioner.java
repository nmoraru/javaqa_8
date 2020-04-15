package ru.netology;

public class Conditioner {
    private String name = "Кондей";
    private int maxTemperature = 30;
    private int minTemperature = 10;
    private int currentTemperature = 20;
    private boolean on;

    public int increaseCurrentTemperature(int currentTemperature) {
        if (currentTemperature > maxTemperature) {
            return this.currentTemperature;
        }
        if (currentTemperature != this.currentTemperature + 1) {
            return this.currentTemperature;
        }
        this.currentTemperature = currentTemperature;
        return this.currentTemperature;
    }

    public int decreaseCurrentTemperature(int currentTemperature) {
        if (currentTemperature < minTemperature) {
            return this.currentTemperature;
        }
        if (currentTemperature != this.currentTemperature - 1) {
            return this.currentTemperature;
        }
        this.currentTemperature = currentTemperature;
        return this.currentTemperature;
    }

    public int getCurrentTemperature() {
        return currentTemperature;
    }

    public String getName() {
        return name;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }
}
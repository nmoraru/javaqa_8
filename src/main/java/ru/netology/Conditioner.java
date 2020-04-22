package ru.netology;

public class Conditioner {
    private String name = "Кондей";
    private int maxTemperature;
    private int minTemperature;
    private int currentTemperature;
    private boolean on;

    public void setCurrentTemperature(int currentTemperature) {
        if (currentTemperature < minTemperature || currentTemperature > maxTemperature) {
            return;
        }
        this.currentTemperature = currentTemperature;
    }

    public int getCurrentTemperature() {
        return currentTemperature;
    }

    public void increaseCurrentTemperature() {
        if (currentTemperature >= maxTemperature) {
            return;
        }
        currentTemperature++;
    }

    public void decreaseCurrentTemperature() {
        if (currentTemperature <= minTemperature) {
            return;
        }
        currentTemperature--;
    }

    public void setMaxTemperature(int maxTemperature) {
        this.maxTemperature = maxTemperature;
    }
    public int getMaxTemperature() {
        return maxTemperature;
    }

    public void setMinTemperature(int minTemperature) {
        this.minTemperature = minTemperature;
    }
    public int getMinTemperature() {
        return minTemperature;
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
package ru.netology;

public class Conditioner {
    private String name = "Кондей";
    private int maxTemperature = 30;
    private int minTemperature = 10;
    private int currentTemperature;
    private boolean on;

    public void setCurrentTemperature(int currentTemperature) {
        if (isOn(on)) {
            return;
        }
        if (isCurrentTemperatureBetweenMaxAndMin(currentTemperature)) {
            return;
        }
        this.currentTemperature = currentTemperature;
    }

    private boolean isCurrentTemperatureBetweenMaxAndMin(int currentTemperature) {
        return (currentTemperature < minTemperature || currentTemperature > maxTemperature);
    }

    public int getCurrentTemperature() {
        return currentTemperature;
    }

    public void increaseCurrentTemperature() {
        if (isOn(on)) {
            return;
        }
        if (currentTemperature >= maxTemperature) {
            return;
        }
        currentTemperature++;
    }

    public void decreaseCurrentTemperature() {
        if (isOn(on)) {
            return;
        }
        if (currentTemperature <= minTemperature) {
            return;
        }
        currentTemperature--;
    }

    public void setMaxTemperature(int maxTemperature) {
        if (isOn(on)) {
            return;
        }
        if (isMinTemperatureNotOverMaxTemperature(minTemperature, maxTemperature)) {
            return;
        }
        this.maxTemperature = maxTemperature;
    }

    private boolean isMinTemperatureNotOverMaxTemperature(int minTemperature, int maxTemperature) {
        return (minTemperature >= maxTemperature);
    }

    public int getMaxTemperature() {
        return maxTemperature;
    }

    public void setMinTemperature(int minTemperature) {
        if (isOn(on)) {
            return;
        }
        if (isMinTemperatureNotOverMaxTemperature(minTemperature, maxTemperature)) {
            return;
        }
        this.minTemperature = minTemperature;
    }

    public int getMinTemperature() {
        return minTemperature;
    }

    public String getName() {
        return name;
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
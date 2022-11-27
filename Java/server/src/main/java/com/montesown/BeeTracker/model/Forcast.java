package com.montesown.BeeTracker.model;

public class Forcast {
    private int temp;
    private String condition;
    private int icon;

    public Forcast(int temp, String condition, int icon) {
        this.temp = temp;
        this.condition = condition;
        this.icon = icon;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}

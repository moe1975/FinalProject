package com.mohibhero.finalproject;

/**
 * Created by MohibHero on 4/4/17.
 */

public class TemperatureData {
    private String temperature;
    private long _id;

    public TemperatureData() {
        temperature = "";
        _id = 0;
    }

    public TemperatureData(String temperature, long _id) {
        this.temperature = temperature;
        this._id = _id;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }
}

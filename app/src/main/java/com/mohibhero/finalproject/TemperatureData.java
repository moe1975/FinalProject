/**
 * package is com.mohibhero.finalproject.
 */
package com.mohibhero.finalproject;

/**
 * A class used to store the information passed in two variables, mainly the id & temperature.
 * some parts referenced from author https://github.com/yass0016. All credits.
 */
public class TemperatureData {
    private String temperature; //a private variable for temperature.
    private long _id; //a private variable for id.

    /**
     * A constructor for the class where we set all the variables to zero, null etc. i.e. initialization.
     */
    public TemperatureData() {
        temperature = ""; //setting the temperature to blank.
        _id = 0; //setting the id to zero
    }

    /**
     * A parameterized constructor for the class where we set all the variables with the things passed in the parameters.
     * @param temperature
     * @param _id
     */
    public TemperatureData(String temperature, long _id) {
        this.temperature = temperature; //setting the temperature
        this._id = _id; //setting the id.
    }

    /**
     * A getter to return the Temperature.
     * @return temperature
     */
    public String getTemperature() {

        return temperature; //return the temperature

    }

    /**
     * A setter to set the Temperature.
     * @param temperature
     */
    public void setTemperature(String temperature) {

        this.temperature = temperature; //setting the temperature

    }

    /**
     * A getter to return the id.
     * @return id
     */
    public long get_id() {

        return _id; //return the id

    }

    /**
     * A setter to set the id.
     * @param _id
     */
    public void set_id(long _id) {

        this._id = _id; //setting the id.

    }
}

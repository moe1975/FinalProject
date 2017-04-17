/**
 * package is com.mohibhero.finalproject.
 */
package com.mohibhero.finalproject;

/**
 * A class used to store the information passed in three variables, mainly the id, title and image.
 * some parts referenced from author https://github.com/yass0016. All credits.
 */
public class HouseData {
    private int _id; //a private variable for id.
    private String title; //a private variable for title.
    private String imageUri; //a private variable for image.

    /**
     * A constructor for the class where we set all the variables to zero, null etc. i.e. initialization.
     */
    public HouseData() {
        this._id = 0; //setting the id to zero
        this.title = ""; //setting the title to blank.
        this.imageUri = ""; //setting the image to blank.

    }

    /**
     * A parameterized constructor for the class where we set all the variables with the things passed in the parameters.
     * @param _id
     * @param title
     * @param imageUri
     */
    public HouseData(int _id, String title, String imageUri) {
        this._id = _id; //setting the id
        this.title = title; //setting the title
        this.imageUri = imageUri; //setting the image.
    }

    /**
     * A getter to return the id.
     * @return
     */
    public int get_id() {

        return _id; //return the id.

    }

    /**
     * A setter to set the id.
     * @param _id
     */
    public void set_id(int _id) {

        this._id = _id; //set the id

    }

    /**
     * A getter to return the title.
     * @return
     */
    public String getTitle() {

        return title; //return the title

    }

    /**
     * A setter to set the title.
     * @param title
     */
    public void setTitle(String title) {

        this.title = title; //set the title

    }

    /**
     * A getter to return the image
     * @return
     */
    public String getImageUri() {

        return imageUri; //return the image.

    }

    /**
     * A setter to set the image
     * @param imageUri
     */
    public void setImageUri(String imageUri) {

        this.imageUri = imageUri; //set the image.

    }


}

package com.moe.finalproject;

/**
 * Created by Moe on 2017-03-27.
 */


public class RoomDataBase {
    private long _id;
    private String title;
    private String image;


    public static final int item_TV = 0;
    public static final int item_Light1 = 1;
    public static final int item_Light2 = 2;
    public static final int item_Light3 = 3;
    public static final int item_Blinding = 4;
    private int deviceType;


    public RoomDataBase() {
        this._id = 0;
        this.title = "";
        this.image = "";
    }

    public RoomDataBase(long _id, String title, String image, int deviceType) {
        this._id = _id;
        this.title = title;
        this.image = image;
        this.deviceType = deviceType;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUri() {

        return image;
    }

    public void setImageUri(String imageUri) {
        this.image = imageUri;
    }

    public int getDeviceType() {
        return deviceType;
    }
}
package com.emad.finalproject;

/**
 * Created by Algo on 3/29/2017.
 */


public class KitchenDataModel {


    private long _id;
    private String text;
    private String uri;

    public KitchenDataModel() {
        _id = 0;
        text = "";
        uri = "";
    }

    public KitchenDataModel(long _id, String text, String uri) {
        this._id = _id;
        this.text = text;
        this.uri = uri;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
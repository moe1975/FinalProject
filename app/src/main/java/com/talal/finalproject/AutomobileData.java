package com.talal.finalproject;

/**
 * Created by Talal on 2017-03-22.
 */

public class AutomobileData {

    private long _id;
    private String text;
    private String uri;

    public AutomobileData() {
        _id = 0;
        text = "";
        uri = "";
    }

    public AutomobileData(long _id, String text, String uri) {
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

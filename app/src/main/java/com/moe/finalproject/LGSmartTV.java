package com.moe.finalproject;

/**
 * Created by Moe on 2017-03-22.
 */

public class LGSmartTV {

    private long id;
    private String Tv_Model;
    private int Tv_Volume;
    private long NextChannel;
    private long PrevChannel;
    private String Status;


    public LGSmartTV(long id, String tv_Model, int tv_Volume, long nextChannel, long prevChannel, String Status) {
        this.id = id;
        this.Tv_Model = tv_Model;
        this.Tv_Volume = tv_Volume;
        this.NextChannel = nextChannel;
        this.PrevChannel = prevChannel;
        this.Status = Status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTv_Model() {
        return Tv_Model;
    }

    public void setTv_Model(String tv_Model) {
        Tv_Model = tv_Model;
    }

    public int getTv_Volume() {
        return Tv_Volume;
    }

    public void setTv_Volume(int tv_Volume) {
        Tv_Volume = tv_Volume;
    }

    public long getNextChannel() {
        return NextChannel;
    }

    public void setNextChannel(long nextChannel) {
        NextChannel = nextChannel;
    }

    public long getPrevChannel() {
        return PrevChannel;
    }

    public void setPrevChannel(long prevChannel) {
        PrevChannel = prevChannel;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public LGSmartTV(){

        this.id = 0;
        this.Tv_Model = "";
        this.Tv_Volume = 0;
        this.NextChannel = 0;
        this.PrevChannel = 0;
        this.Status = "";



    }

}

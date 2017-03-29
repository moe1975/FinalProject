package com.moe.finalproject;

/**
 * Created by Moe on 2017-03-22.
 */

public class Channel {
    private long   id;
    private long   channelId;
    private long   Tv_id;
    private String FavChannel;
    private String ChannelName;
    private String SavedChannel;
    private String Channel_Category;

    public Channel(){

        id = 0;
        channelId = 0;
        FavChannel = "";
        ChannelName = "";
        SavedChannel = "";
        Channel_Category = "";
    }

    public Channel(long id, long channelId, long tv_id, String favChannel, String channelName, String savedChannel, String channel_Category) {
        this.id = id;
        this.channelId = channelId;
        this.Tv_id = tv_id;
        this.FavChannel = favChannel;
        this.ChannelName = channelName;
        this.SavedChannel = savedChannel;
        this.Channel_Category = channel_Category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getChannelId() {
        return channelId;
    }

    public void setChannelId(long channelId) {
        this.channelId = channelId;
    }

    public String getFavChannel() {
        return FavChannel;
    }

    public void setFavChannel(String favChannel) {
        FavChannel = favChannel;
    }

    public String getChannelName() {
        return ChannelName;
    }

    public void setChannelName(String channelName) {
        ChannelName = channelName;
    }

    public String getSavedChannel() {
        return SavedChannel;
    }

    public void setSavedChannel(String savedChannel) {
        SavedChannel = savedChannel;
    }

    public String getChannel_Category() {
        return Channel_Category;
    }

    public long getTv_id() {
        return Tv_id;
    }

    public void setTv_id(long tv_id) {
        Tv_id = tv_id;
    }

    public void setChannel_Category(String channel_Category) {
        Channel_Category = channel_Category;

    }
}

package com.example.po;

import java.sql.Timestamp;

public class likesPo {
    private long likeId;
    private long userId;
    private long weiboId;
    private Timestamp likeTime;

    public likesPo() {
    }

    public likesPo(long likeId, long userId, long weiboId, Timestamp likeTime) {
        this.likeId = likeId;
        this.userId = userId;
        this.weiboId = weiboId;
        this.likeTime = likeTime;
    }

    public long getLikeId() {
        return likeId;
    }

    public void setLikeId(long likeId) {
        this.likeId = likeId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getWeiboId() {
        return weiboId;
    }

    public void setWeiboId(long weiboId) {
        this.weiboId = weiboId;
    }

    public Timestamp getLikeTime() {
        return likeTime;
    }

    public void setLikeTime(Timestamp likeTime) {
        this.likeTime = likeTime;
    }
}

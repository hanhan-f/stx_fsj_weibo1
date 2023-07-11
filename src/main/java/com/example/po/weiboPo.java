package com.example.po;

import java.io.File;
import java.sql.Timestamp;
import java.util.List;

public class weiboPo {
    private long weiboId;
    private long userId;
    private String username;
    private String content;
    private Timestamp releaseTime;
    private List<String> images;
    private String userImage;

    public weiboPo() {
    }

    public weiboPo(long weiboId, long userId, String content, Timestamp releaseTime) {
        this.weiboId = weiboId;
        this.userId = userId;
        this.content = content;
        this.releaseTime = releaseTime;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public long getWeiboId() {
        return weiboId;
    }

    public void setWeiboId(long weiboId) {
        this.weiboId = weiboId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Timestamp releaseTime) {
        this.releaseTime = releaseTime;
    }
}

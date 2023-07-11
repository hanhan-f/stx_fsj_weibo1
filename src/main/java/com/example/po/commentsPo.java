package com.example.po;

import java.sql.Timestamp;

public class commentsPo {
    private long commentsId;
    private long UserId;
    private long weiboId;
    private String content;
    private Timestamp releaseTime;

    public commentsPo() {
    }

    public commentsPo(long commentsId, long userId, long weiboId, String content, Timestamp releaseTime) {
        this.commentsId = commentsId;
        UserId = userId;
        this.weiboId = weiboId;
        this.content = content;
        this.releaseTime = releaseTime;
    }

    public long getCommentsId() {
        return commentsId;
    }

    public void setCommentsId(long commentsId) {
        this.commentsId = commentsId;
    }

    public long getUserId() {
        return UserId;
    }

    public void setUserId(long userId) {
        UserId = userId;
    }

    public long getWeiboId() {
        return weiboId;
    }

    public void setWeiboId(long weiboId) {
        this.weiboId = weiboId;
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

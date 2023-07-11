package com.example.po;

public class concernPo {
    private long concernId;
    private long userId;
    private long followerUserId;

    public concernPo() {
    }

    public concernPo(long concernId, long userId, long followerUserId) {
        this.concernId = concernId;
        this.userId = userId;
        this.followerUserId = followerUserId;
    }

    public long getConcernId() {
        return concernId;
    }

    public void setConcernId(long concernId) {
        this.concernId = concernId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getFollowerUserId() {
        return followerUserId;
    }

    public void setFollowerUserId(long followerUserId) {
        this.followerUserId = followerUserId;
    }
}

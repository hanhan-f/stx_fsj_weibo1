package com.example.po;

import java.sql.Timestamp;

public class browsingHistoryPo {
    private long HistoryId;
    private long UserId;
    private long weiboId;
    private Timestamp visitTime;

    public browsingHistoryPo() {
    }

    public browsingHistoryPo(long historyId, long userId, long weiboId, Timestamp visitTime) {
        HistoryId = historyId;
        UserId = userId;
        this.weiboId = weiboId;
        this.visitTime = visitTime;
    }

    public long getHistoryId() {
        return HistoryId;
    }

    public void setHistoryId(long historyId) {
        HistoryId = historyId;
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

    public Timestamp getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Timestamp visitTime) {
        this.visitTime = visitTime;
    }
}

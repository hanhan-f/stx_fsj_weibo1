package com.example.po;

import java.sql.Timestamp;

public class UserPo {
    private long UserId;
    private String UserName;
    private String pwd;
    private long phone;
    private String emile;
    private Timestamp registrationTime;
    private String head_img;
    public UserPo() {
    }

    public UserPo(String userName, String pwd, long phone, String emile, Timestamp registrationTime) {
        UserName = userName;
        this.pwd = pwd;
        this.phone = phone;
        this.emile = emile;
        this.registrationTime = registrationTime;
    }

    public UserPo(long userId, String userName, String pwd, long phone, String emile, Timestamp registrationTime) {
        UserId = userId;
        UserName = userName;
        this.pwd = pwd;
        this.phone = phone;
        this.emile = emile;
        this.registrationTime = registrationTime;
    }

    public long getUserId() {
        return UserId;
    }

    public void setUserId(long userId) {
        UserId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getEmile() {
        return emile;
    }

    public void setEmile(String emile) {
        this.emile = emile;
    }

    public Timestamp getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(Timestamp registrationTime) {
        this.registrationTime = registrationTime;
    }

    public String getHead_img() {
        return head_img;
    }

    public void setHead_img(String head_img) {
        this.head_img = head_img;
    }
}

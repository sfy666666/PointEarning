package com.example.pointearning.bean;

import java.io.Serializable;

/**
 * created by shengfeiyu
 * on 2019/9/20
 */
public class AttentionEntity implements Serializable {
    private int userID;
    private int icon;
    private String name;
    private String content;
    private boolean status;
    private int bigImg;
    private String time;

    public AttentionEntity(int userID, int icon, String name, String content, boolean status, int bigImg, String time) {
        this.userID = userID;
        this.icon = icon;
        this.name = name;
        this.content = content;
        this.status = status;
        this.bigImg = bigImg;
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getBigImg() {
        return bigImg;
    }

    public void setBigImg(int bigImg) {
        this.bigImg = bigImg;
    }

    public AttentionEntity(int userID, int icon, String name, String content, boolean status, int bigImg) {
        this.userID = userID;
        this.icon = icon;
        this.name = name;
        this.content = content;
        this.status = status;
        this.bigImg = bigImg;
    }

    public AttentionEntity(int userID, int icon, String name, String content, boolean status) {
        this.userID = userID;
        this.icon = icon;
        this.name = name;
        this.content = content;
        this.status = status;
    }

    public AttentionEntity(int icon, String name, String content, boolean status) {
        this.icon = icon;
        this.name = name;
        this.content = content;
        this.status = status;
    }

    public AttentionEntity() {
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

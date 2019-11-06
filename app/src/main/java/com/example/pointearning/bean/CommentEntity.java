package com.example.pointearning.bean;

/**
 * created by shengfeiyu
 * on 2019/9/6
 */
public class CommentEntity {
    private int icon;
    private String userName;
    private String comment;
    private String time;

    public CommentEntity(int icon, String userName, String comment, String time) {
        this.icon = icon;
        this.userName = userName;
        this.comment = comment;
        this.time = time;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

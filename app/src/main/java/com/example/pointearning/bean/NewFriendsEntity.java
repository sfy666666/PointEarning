package com.example.pointearning.bean;

/**
 * 新的好友实体类     在新的好友、创建群聊页面使用
 *
 * created by shengfeiyu
 * on 2019/9/11
 */
public class NewFriendsEntity {
    private int userId;

    public NewFriendsEntity(int userId, int icon, String name, String yanzhengxiaoxi, boolean agree) {
        this.userId = userId;
        this.icon = icon;
        this.name = name;
        this.yanzhengxiaoxi = yanzhengxiaoxi;
        this.agree = agree;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    private int icon;
    private String name;
    private String yanzhengxiaoxi;
    private boolean agree;

    public NewFriendsEntity(int icon, String name, String yanzhengxiaoxi, boolean agree) {
        this.icon = icon;
        this.name = name;
        this.yanzhengxiaoxi = yanzhengxiaoxi;
        this.agree = agree;
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

    public String getYanzhengxiaoxi() {
        return yanzhengxiaoxi;
    }

    public void setYanzhengxiaoxi(String yanzhengxiaoxi) {
        this.yanzhengxiaoxi = yanzhengxiaoxi;
    }

    public boolean isAgree() {
        return agree;
    }

    public void setAgree(boolean agree) {
        this.agree = agree;
    }
}

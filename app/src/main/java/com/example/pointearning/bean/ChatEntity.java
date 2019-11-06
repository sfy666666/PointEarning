package com.example.pointearning.bean;

import com.github.library.entity.MultiItemEntity;

/**
 * created by shengfeiyu
 * on 2019/9/12
 */
public class ChatEntity implements com.chad.library.adapter.base.entity.MultiItemEntity {
    private int userID;
    private int icon;
    private String  chat;
    private  int viewType;

    private static final int VIEWTYPETIME = 10001;
    private static final int VIEWTYPERIGHT = 10002;
    private static final int VIEWTYPELEFT = 10003;


    public ChatEntity(int userID, int icon, String chat, int viewType) {
        this.userID = userID;
        this.icon = icon;
        this.chat = chat;
        this.viewType = viewType;
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

    public String getChat() {
        return chat;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    @Override
    public int getItemType() {
        return viewType;
    }
}

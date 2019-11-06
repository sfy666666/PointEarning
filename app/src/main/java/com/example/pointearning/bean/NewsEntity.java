package com.example.pointearning.bean;

/**
 * created by shengfeiyu
 * on 2019/9/4
 */
public class NewsEntity {
    private String title;
    private String content;
    int count;
    int icon;
    String imageUrl;

    private int tIcon;//导师照片
    private String tName;//导师名称
    private String tLevel;//导师级别
    private String tutorType;//导师类型
    private String tIntroduction;//导师简介
    private int tHeat;//热度
    private int tAttention;//关注人数
    private int type;

    private int contactIcon;
    private String contactName;

    public NewsEntity(int contactIcon, String contactName) {
        this.contactIcon = contactIcon;
        this.contactName = contactName;
    }

    public int getContactIcon() {
        return contactIcon;
    }

    public void setContactIcon(int contactIcon) {
        this.contactIcon = contactIcon;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public int gettIcon() {
        return tIcon;
    }

    public void settIcon(int tIcon) {
        this.tIcon = tIcon;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String gettLevel() {
        return tLevel;
    }

    public void settLevel(String tLevel) {
        this.tLevel = tLevel;
    }

    public String getTutorType() {
        return tutorType;
    }

    public void setTutorType(String tutorType) {
        this.tutorType = tutorType;
    }

    public String gettIntroduction() {
        return tIntroduction;
    }

    public void settIntroduction(String tIntroduction) {
        this.tIntroduction = tIntroduction;
    }

    public int gettHeat() {
        return tHeat;
    }

    public void settHeat(int tHeat) {
        this.tHeat = tHeat;
    }

    public int gettAttention() {
        return tAttention;
    }

    public void settAttention(int tAttention) {
        this.tAttention = tAttention;
    }

    /**
     * 创建 优秀导师  的构造器
     *
     * @param tIcon
     * @param tName
     * @param tLevel
     * @param tutorType
     * @param tIntroduction
     * @param tHeat
     * @param tAttention
     * @param type
     */
    public NewsEntity(int tIcon, String tName, String tLevel, String tutorType, String tIntroduction, int tHeat, int tAttention, int type) {
        this.tIcon = tIcon;
        this.tName = tName;
        this.tLevel = tLevel;
        this.tutorType = tutorType;
        this.tIntroduction = tIntroduction;
        this.tHeat = tHeat;
        this.tAttention = tAttention;
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    public NewsEntity(String title, String content, int count, int icon) {
        this.title = title;
        this.content = content;
        this.count = count;
        this.icon = icon;
    }

    /**
     * 创建  优秀项目的  构造器
     *
     * @param title
     * @param content
     * @param count
     * @param icon
     * @param type
     */
    public NewsEntity(String title, String content, int count, int icon, int type) {
        this.title = title;
        this.content = content;
        this.count = count;
        this.icon = icon;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

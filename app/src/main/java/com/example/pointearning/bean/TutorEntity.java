package com.example.pointearning.bean;

import java.io.Serializable;

/**
 * created by shengfeiyu
 * on 2019/9/7
 * 导师实体类
 */
public class TutorEntity implements Serializable {
    private int icon;//导师照片
    private String name;//导师名称
    private String level;//导师级别
    private String tutorType;//导师类型
    private String introduction;//导师简介
    private int heat;//热度
    private int attention;//关注人数
    private int type;

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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getTutorType() {
        return tutorType;
    }

    public void setTutorType(String tutorType) {
        this.tutorType = tutorType;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public int getHeat() {
        return heat;
    }

    public void setHeat(int heat) {
        this.heat = heat;
    }

    public int getAttention() {
        return attention;
    }

    public void setAttention(int attention) {
        this.attention = attention;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public TutorEntity(int icon, String name, String level, String tutorType, String introduction, int heat, int attention, int type) {
        this.icon = icon;
        this.name = name;
        this.level = level;
        this.tutorType = tutorType;
        this.introduction = introduction;
        this.heat = heat;
        this.attention = attention;
        this.type = type;
    }
}

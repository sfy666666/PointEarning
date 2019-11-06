package com.example.pointearning.bean;

import java.io.Serializable;

/**
 * created by shengfeiyu
 * on 2019/9/5
 *
 * 动态的实体类
 */
public class CommunityEntity implements Serializable {
    private int  icon;//头像
    private String name;//用户名
    private String time;//时间
    private String content;//内容
    private int image1;//
    private int image2;//
    private int image3;//
    private int image4;//
    private int image5;//
    private int image6;//

    private int  type;//类型

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public CommunityEntity(int icon, String name, String time, String content, int image1, int image2, int image3, int image4, int image5, int image6, int type) {
        this.icon = icon;
        this.name = name;
        this.time = time;
        this.content = content;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
        this.image5 = image5;
        this.image6 = image6;
        this.type = type;
    }

    public CommunityEntity(int icon, String name, String time, String content, int image1) {
        this.icon = icon;
        this.name = name;
        this.time = time;
        this.content = content;
        this.image1 = image1;
    }

    public CommunityEntity(int icon, String name, String time, String content, int image1, int image2, int image3, int image4, int image5, int image6) {
        this.icon = icon;
        this.name = name;
        this.time = time;
        this.content = content;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
        this.image5 = image5;
        this.image6 = image6;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getImage1() {
        return image1;
    }

    public void setImage1(int image1) {
        this.image1 = image1;
    }

    public int getImage2() {
        return image2;
    }

    public void setImage2(int image2) {
        this.image2 = image2;
    }

    public int getImage3() {
        return image3;
    }

    public void setImage3(int image3) {
        this.image3 = image3;
    }

    public int getImage4() {
        return image4;
    }

    public void setImage4(int image4) {
        this.image4 = image4;
    }

    public int getImage5() {
        return image5;
    }

    public void setImage5(int image5) {
        this.image5 = image5;
    }

    public int getImage6() {
        return image6;
    }

    public void setImage6(int image6) {
        this.image6 = image6;
    }




}

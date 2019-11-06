package com.example.pointearning.bean;

import com.github.library.entity.MultiItemEntity;

/**
 * 通讯录实体类
 * created by shengfeiyu
 * on 2019/9/11
 */
public class SortModel extends MultiItemEntity {

    public static  final  int TYPEONE=100;
    public  static  final  int TYPETWO=200;
    public SortModel(int icon,String name, String letter) {
        this.name = name;
        this.letter = letter;
        this.icon = icon;
    }


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    private String name;

    public SortModel(int icon,String name, String letter,  int type) {
        this.name = name;
        this.letter = letter;
        this.icon = icon;
        this.type = type;
    }

    private String letter;
    private int  icon;
    private int type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }
}

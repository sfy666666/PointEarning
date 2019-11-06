package com.example.pointearning.contact;


public class SortModel {

    private int icon;
    private String name;
    private String letter;
    private int userID;
    private int type;

    public SortModel() {
    }

    public SortModel(int icon, String name) {
        this.icon = icon;
        this.name = name;
    }

    public SortModel(int icon, String name, String letter, int type) {
        this.icon = icon;
        this.name = name;
        this.letter = letter;
        this.type = type;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

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

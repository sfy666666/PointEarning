package com.example.pointearning.bean;

public class HomeProjectBean {
    private String name;
    private String content;
    private int person;
    private int pic;

    public HomeProjectBean(String name, String content, int person, int pic) {
        this.name = name;
        this.content = content;
        this.person = person;
        this.pic = pic;
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

    public int getPerson() {
        return person;
    }

    public void setPerson(int person) {
        this.person = person;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }
}

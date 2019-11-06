package com.example.pointearning.bean;

public class HomeTutorBean {
    private String name;
    private String tags;
    private String content;
    private int hot;
    private int person;
    private int pic;

    public HomeTutorBean(String name, String tags, String content, int hot, int person, int pic) {
        this.name = name;
        this.tags = tags;
        this.content = content;
        this.hot = hot;
        this.person = person;
        this.pic = pic;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    public int getPerson() {
        return person;
    }

    public void setPerson(int person) {
        this.person = person;
    }
}

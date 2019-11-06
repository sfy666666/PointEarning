package com.example.pointearning.bean;

public class HomeTypeBean {
    private String name;
    private int pic;

    public HomeTypeBean(String name, int pic) {
        this.name = name;
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }
}

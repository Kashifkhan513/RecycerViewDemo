package com.polaris.recycerviewdemo.Model;

public class Model {
    private String img;
    private String id;
    private String name;

    public Model(String img, String id, String name) {
        this.img = img;
        this.id = id;
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

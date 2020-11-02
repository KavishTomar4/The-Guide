package com.notes.theguide;

public class Drama {

    private int id;
    private String name;
    private String shortDes;
    private String imgUrl;
    private boolean Extended;



    public Drama(int id , String name , String shortDes , String imgUrl)
    {
        this.id = id;
        this.name = name;
        this.shortDes = shortDes;
        this.imgUrl = imgUrl;

        Extended = false;


    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDes() {
        return shortDes;
    }

    public void setShortDes(String shortDes) {
        this.shortDes = shortDes;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public boolean isExtended() {
        return Extended;
    }

    public void setExtended(boolean extended) {
        Extended = extended;
    }
}

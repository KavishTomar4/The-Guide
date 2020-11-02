package com.notes.theguide;

public class Scene
{

    private String scene;
    private String actNumber;
    private String dramaName;

    public Scene( String scene , String actNumber , String dramaName)
    {
        this.scene = scene;
        this.actNumber = actNumber;
        this.dramaName = dramaName;
    }



    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

    public String getActNumber() {
        return actNumber;
    }

    public void setActNumber(String actNumber) {
        this.actNumber = actNumber;
    }

    public String getDramaName() {
        return dramaName;
    }

    public void setDramaName(String dramaName) {
        this.dramaName = dramaName;
    }
}

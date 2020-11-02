package com.notes.theguide;

public class Act
{
    private int id;
    private String Act;
    private String dramaName;


    public Act(int id, String Act , String dramaName) {

        this.id = id;
        this.Act = Act;
        this.dramaName = dramaName;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAct() {
        return Act;
    }

    public void setAct(String act) {
        Act = act;
    }
    public String getDramaName() {
        return dramaName;
    }

    public void setDramaName(String dramaName) {
        this.dramaName = dramaName;
    }



}

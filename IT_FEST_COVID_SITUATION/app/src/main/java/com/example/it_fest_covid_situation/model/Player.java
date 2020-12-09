package com.example.it_fest_covid_situation.model;

import android.content.Intent;

import java.io.Serializable;

public class Player implements Serializable {
    private boolean sex;
    private Integer point;
    private String name;
    private boolean isMask;

    public boolean isMask() {
        return isMask;
    }

    public void setMask(boolean mask) {
        isMask = mask;
    }

    public Player(boolean sex, Integer point, String name) {
        this.sex = sex;
        this.point = point;
        this.name = name;
    }

    public Integer addPoint(Integer point){
        return this.point += point;
    }

    public boolean isSex() {
        return sex;
    }

    public Integer getPoint() {
        return point;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "sex=" + sex +
                ", point=" + point +
                ", name='" + name + '\'' +
                '}';
    }
}

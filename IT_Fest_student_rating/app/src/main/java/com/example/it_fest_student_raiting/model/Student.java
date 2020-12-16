package com.example.it_fest_student_raiting.model;

import android.content.Intent;

import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String name;
    private String gr;
    private Integer score;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGr() {
        return gr;
    }

    public Integer getScore() {
        return score;
    }

    public Student(int id, String name, String gr, Integer score) {
        this.id = id;
        this.name = name;
        this.gr = gr;
        this.score = score;
    }
}

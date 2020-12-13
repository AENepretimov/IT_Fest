package com.example.mkmediaplayer.model;

import java.io.Serializable;

public class Video implements Serializable {

    private Integer number;
    private String
            nameModule,
            nameVideo,
            urlVideo;

    public Video(Integer number, String nameModule, String nameVideo, String urlVideo) {
        this.number = number;
        this.nameModule = nameModule;
        this.nameVideo = nameVideo;
        this.urlVideo = urlVideo;
    }

    public Integer getNumber() {
        return number;
    }

    public String getNameModule() {
        return nameModule;
    }

    public String getNameVideo() {
        return nameVideo;
    }

    public String getUrlVideo() {
        return urlVideo;
    }
}

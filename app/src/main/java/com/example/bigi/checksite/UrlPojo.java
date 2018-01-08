package com.example.bigi.checksite;

import android.graphics.Color;

/**
 * Created by bigi on 04.01.2018.
 */

public class UrlPojo {

    String url;
    int status;
    int color;

    public UrlPojo(String url, int status, int color) {
        this.url = url;
        this.status = status;
        this.color = color;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}

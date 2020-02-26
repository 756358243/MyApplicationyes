package com.example.vkeline.myapplication.data;

/**
 * Created by vkeline on 2018/3/2.
 */
public class PaiPanItem {
    private int img;
    private String text;

    public PaiPanItem(int img, String text) {
        this.img = img;
        this.text = text;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

package com.example.mohitkumar.customviewapp;

/**
 * Created by mohitkumar on 20/03/17.
 */

public class CardData {

    private String Title;
    int n;
    private String info;
    String NameMark;

    public CardData(String Title,int n,String info,String NameMark) {
        this.setInfo(info);
        this.setN(n);
        this.setNameMark(NameMark);
        this.setTitle(Title);
    }

    public String getNameMark() {
        return NameMark;
    }

    public void setNameMark(String nameMark) {
        NameMark = nameMark;
    }

    public String getInfo() {
        return info;
    }

    public int getN() {
        return n;
    }

    public String getTitle() {
        return Title;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setTitle(String title) {
        Title = title;
    }
}

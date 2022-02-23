package com.example.truyencuoi;

import java.util.ArrayList;

public class Topic {
    private String ten;
    private int icon;
    private ArrayList<TruyenCuoi> listTruyen;

    public Topic(String ten, int icon, ArrayList<TruyenCuoi> listTruyen) {
        this.ten = ten;
        this.icon = icon;
        this.listTruyen = listTruyen;
    }

    public ArrayList<TruyenCuoi> getListTruyen() {
        return listTruyen;
    }

    public void setListTruyen(ArrayList<TruyenCuoi> listTruyen) {
        this.listTruyen = listTruyen;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}

package com.example.truyencuoi;

import java.io.Serializable;

public class TruyenCuoi implements Serializable {
    private String tenTruyen;
    private String noiDung;

    public TruyenCuoi(String tenTruyen, String noiDung) {
        this.tenTruyen = tenTruyen;
        this.noiDung = noiDung;
    }

    public String getTenTruyen() {
        return tenTruyen;
    }

    public void setTenTruyen(String tenTruyen) {
        this.tenTruyen = tenTruyen;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
}

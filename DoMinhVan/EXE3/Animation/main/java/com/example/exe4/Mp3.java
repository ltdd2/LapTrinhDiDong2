package com.example.exe4;

public class Mp3 {
    private String txtTenBaiHat;
    private int imgHinh;
    private String id;

    public Mp3(String txtTenBaiHat, int imgHinh, String
            id) {
        this.txtTenBaiHat = txtTenBaiHat;
        this.imgHinh = imgHinh;
        this.id = id;
    }

    public String getTxtTenBaiHat() {
        return txtTenBaiHat;
    }

    public void setTxtTenBaiHat(String txtTenBaiHat) {
        this.txtTenBaiHat = txtTenBaiHat;
    }

    public int getImgHinh() {
        return imgHinh;
    }

    public void setImgHinh(int imgHinh) {
        this.imgHinh = imgHinh;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

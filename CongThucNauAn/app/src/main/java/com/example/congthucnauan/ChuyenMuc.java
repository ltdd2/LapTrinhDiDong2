package com.example.congthucnauan;

public class ChuyenMuc {
    private int imgHinh;
    private String txtTen;

    public ChuyenMuc(int imgHinh, String txtTen) {
        this.imgHinh = imgHinh;
        this.txtTen = txtTen;
    }
    public int getImgHinh() {
        return imgHinh;
    }

    public void setImgHinh(int imgHinh) {
        this.imgHinh = imgHinh;
    }

    public String getTxtTen() {
        return txtTen;
    }

    public void setTxtTen(String txtTen) {
        this.txtTen = txtTen;
    }
}

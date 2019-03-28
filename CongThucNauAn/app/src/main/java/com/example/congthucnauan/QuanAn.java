package com.example.congthucnauan;

public class QuanAn {
    private int imgHinhQuanAn;
    private String txtTenQuanAn;

    public QuanAn(int imgHinhQuanAn, String txtTenQuanAn) {

        this.imgHinhQuanAn = imgHinhQuanAn;
        this.txtTenQuanAn = txtTenQuanAn;
    }

    public int getImgHinhQuanAn() {
        return imgHinhQuanAn;
    }

    public void setImgHinhQuanAn(int imgHinhQuanAn) {
        this.imgHinhQuanAn = imgHinhQuanAn;
    }

    public String getTxtTenQuanAn() {
        return txtTenQuanAn;
    }

    public void setTxtTenQuanAn(String txtTenQuanAn) {
        this.txtTenQuanAn = txtTenQuanAn;
    }
}

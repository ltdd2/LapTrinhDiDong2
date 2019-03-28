package com.example.congthucnauan;

public class MonAn {
    private int imgHinhMonAn;
    private String txtTenMonAn;
    private String txtMoTaMonAn;

    public MonAn(int imgHinhMonAn, String txtTenMonAn, String txtMoTaMonAn) {
        this.imgHinhMonAn = imgHinhMonAn;
        this.txtTenMonAn = txtTenMonAn;
        this.txtMoTaMonAn = txtMoTaMonAn;
    }

    public int getImgHinhMonAn() {
        return imgHinhMonAn;
    }

    public void setImgHinhMonAn(int imgHinhMonAn) {
        this.imgHinhMonAn = imgHinhMonAn;
    }

    public String getTxtTenMonAn() {
        return txtTenMonAn;
    }

    public void setTxtTenMonAn(String txtTenMonAn) {
        this.txtTenMonAn = txtTenMonAn;
    }

    public String getTxtMoTaMonAn() {
        return txtMoTaMonAn;
    }

    public void setTxtMoTaMonAn(String txtMoTaMonAn) {
        this.txtMoTaMonAn = txtMoTaMonAn;
    }
}

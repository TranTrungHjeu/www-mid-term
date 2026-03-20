package com.example.wwwmidterm.model;

public class ToaNha {
    private String maToa;
    private String tenToa;
    private String viTri;
    private String  chuToa;

    public String getMaToa() {
        return maToa;
    }

    public String getTenToa() {
        return tenToa;
    }

    public String getViTri() {
        return viTri;
    }

    public String getChuToa() {
        return chuToa;
    }

    public void setMaToa(String maToa) {
        this.maToa = maToa;
    }

    public void setTenToa(String tenToa) {
        this.tenToa = tenToa;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public void setChuToa(String chuToa) {
        this.chuToa = chuToa;
    }

    public ToaNha(String maToa, String tenToa, String viTri, String chuToa) {
        this.maToa = maToa;
        this.tenToa = tenToa;
        this.viTri = viTri;
        this.chuToa = chuToa;
    }

    public ToaNha() {
    }

    @Override
    public String toString() {
        return "ToaNha{" +
                "maToa='" + maToa + '\'' +
                ", tenToa='" + tenToa + '\'' +
                ", viTri='" + viTri + '\'' +
                ", chuToa='" + chuToa + '\'' +
                '}';
    }
}


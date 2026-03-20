package com.example.wwwmidterm.model;

import java.math.BigDecimal;

public class CanHo {
    private String maCanHo;
        private String tenCanHo;
        private BigDecimal giaThue;
        private float dienTich;
        private String hinhAnh;
        private ToaNha toaNha;


    public CanHo() {
    }

    public CanHo(String maCanHo, String tenCanHo, BigDecimal giaThue, float dienTich, String hinhAnh, ToaNha toaNha) {
        this.maCanHo = maCanHo;
        this.tenCanHo = tenCanHo;
        this.giaThue = giaThue;
        this.dienTich = dienTich;
        this.hinhAnh = hinhAnh;
        this.toaNha = toaNha;
    }

    public String getMaCanHo() {
        return maCanHo;
    }

    public void setMaCanHo(String maCanHo) {
        this.maCanHo = maCanHo;
    }

    public String getTenCanHo() {
        return tenCanHo;
    }

    public void setTenCanHo(String tenCanHo) {
        this.tenCanHo = tenCanHo;
    }

    public BigDecimal getGiaThue() {
        return giaThue;
    }

    public void setGiaThue(BigDecimal giaThue) {
        this.giaThue = giaThue;
    }

    public float getDienTich() {
        return dienTich;
    }

    public void setDienTich(float dienTich) {
        this.dienTich = dienTich;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public ToaNha getToaNha() {
        return toaNha;
    }

    public void setToaNha(ToaNha toaNha) {
        this.toaNha = toaNha;
    }
}

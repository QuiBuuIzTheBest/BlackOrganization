/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.entity;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class KhoaHoc {
    String MaKH;
    String MaCD;
    float HocPhi;
    String ThoiLuong;
    Date NgayKhaiGiang;
    String GhiChu;
    String MaNV;
    String NgayTao;

    public KhoaHoc() {
    }

    public KhoaHoc(String MaKH, String MaCD, float HocPhi, String ThoiLuong, Date NgayKhaiGiang, String GhiChu, String MaNV, String NgayTao) {
        this.MaKH = MaKH;
        this.MaCD = MaCD;
        this.HocPhi = HocPhi;
        this.ThoiLuong = ThoiLuong;
        this.NgayKhaiGiang = NgayKhaiGiang;
        this.GhiChu = GhiChu;
        this.MaNV = MaNV;
        this.NgayTao = NgayTao;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getMaCD() {
        return MaCD;
    }

    public void setMaCD(String MaCD) {
        this.MaCD = MaCD;
    }

    public float getHocPhi() {
        return HocPhi;
    }

    public void setHocPhi(float HocPhi) {
        this.HocPhi = HocPhi;
    }

    public String getThoiLuong() {
        return ThoiLuong;
    }

    public void setThoiLuong(String ThoiLuong) {
        this.ThoiLuong = ThoiLuong;
    }

    public Date getNgayKhaiGiang() {
        return NgayKhaiGiang;
    }

    public void setNgayKhaiGiang(Date NgayKhaiGiang) {
        this.NgayKhaiGiang = NgayKhaiGiang;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(String NgayTao) {
        this.NgayTao = NgayTao;
    }
    
    
    
    
    
}

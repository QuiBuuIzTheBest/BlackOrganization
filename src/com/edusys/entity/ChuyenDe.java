/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.entity;

/**
 *
 * @author Admin
 */
public class ChuyenDe {
    String MaCD;
    String TenCD;
    String ThoiLuong;
    float HocPhi;
    String MoTa;
    String HinhLogo;

    public ChuyenDe() {
    }
    
    

    public ChuyenDe(String MaCD, String TenCD, String ThoiLuong, float HocPhi, String MoTa, String HinhLogo) {
        this.MaCD = MaCD;
        this.TenCD = TenCD;
        this.ThoiLuong = ThoiLuong;
        this.HocPhi = HocPhi;
        this.MoTa = MoTa;
        this.HinhLogo = HinhLogo;
    }
    
    

    public String getMaCD() {
        return MaCD;
    }

    public void setMaCD(String MaCD) {
        this.MaCD = MaCD;
    }

    public String getTenCD() {
        return TenCD;
    }

    public void setTenCD(String TenCD) {
        this.TenCD = TenCD;
    }

    public String getThoiLuong() {
        return ThoiLuong;
    }

    public void setThoiLuong(String ThoiLuong) {
        this.ThoiLuong = ThoiLuong;
    }

    public float getHocPhi() {
        return HocPhi;
    }

    public void setHocPhi(float HocPhi) {
        this.HocPhi = HocPhi;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public String getHinhLogo() {
        return HinhLogo;
    }

    public void setHinhLogo(String HinhLogo) {
        this.HinhLogo = HinhLogo;
    }
    
    
    
}


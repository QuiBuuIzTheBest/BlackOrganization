/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.utils;

import com.edusys.entity.NhanVien;

/**
 *
 * @author ASUS ZENBOOK
 */
public class Auth {
    
    public static NhanVien user = null;
    
    public static void clear(){
        user = null;
    }
    
    public static boolean isLogin(){
        return isLogin() && user.isVaiTro();
    }
}

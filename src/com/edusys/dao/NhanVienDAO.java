/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.dao;

import com.edusys.entity.*;
import com.edusys.utils.*;
import java.util.*;
import java.sql.*;

/**
 *
 * @author ASUS ZENBOOK
 */
public class NhanVienDAO extends EdusysDAO<NhanVien, String> {

    String INSERT_SQL = "INSERT INTO nhan_vien(MaNv, MatKhau, HoTen, VaiTro) VALUES(?,?,?,?)";
    String UPDATE_SQL = "UPDATE nhan_vien SET MatKhau=?, HoTen=?, VaiTro=? WHERE MaNV=?";
    String DELETE_SQL = "DELETE FROM nhan_vien WHERE MaNV=?";
    String SELECT_ALL_SQL = "SELECT * FROM nhan_vien";
    String SELECT_BY_ID_SQL = "SELECT * FROM nhan_vien WHERE MaNV=?";

    @Override
    public void insert(NhanVien entity) {
        JdbcHelper.executeUpdate(INSERT_SQL,
                entity.getMaNV(),
                entity.getMatKhau(),
                entity.getHoTen(),
                entity.isVaiTro());
    }

    @Override
    public void update(NhanVien entity) {
        JdbcHelper.executeUpdate(UPDATE_SQL,
                entity.getMaNV(),
                entity.getMatKhau(),
                entity.getHoTen(),
                entity.isVaiTro())  ;
    }

    @Override
    public void delete(String id) {
        JdbcHelper.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public NhanVien selectById(String id) {
        List<NhanVien> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<NhanVien> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                NhanVien entity = new NhanVien();
                entity.setMaNV(rs.getString("MaNv"));
                entity.setMatKhau(rs.getString("MatKhau"));
                entity.setHoTen(rs.getString("HoTen"));
                entity.setVaiTro(rs.getBoolean("VaiTro"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

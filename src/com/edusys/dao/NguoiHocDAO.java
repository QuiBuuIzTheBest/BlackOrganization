/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.dao;

import com.edusys.entity.NguoiHoc;
import com.edusys.utils.JdbcHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
/**
 *
 * @author ASUS ZENBOOK
 */
public class NguoiHocDAO extends EdusysDAO<NguoiHoc, String>{
    String INSERT_SQL = "INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    String UPDATE_SQL = "UPDATE NguoiHoc SET HoTen=?, NgaySinh=?, GioiTinh=?, DienThoai=?, Email=?, GhiChu=?,MaNV=? WHERE MaNH=?";
    String DELETE_SQL = "DELETE FROM NguoiHoc WHERE MaNH=?";
    String SELECT_ALL_SQL = "SELECT * FROM NguoiHoc";
    String SELECT_BY_ID_SQL = "SELECT * FROM NguoiHoc WHERE MaNH=?";

    @Override
    public void insert(NguoiHoc entity) {
        JdbcHelper.executeUpdate(INSERT_SQL,
                entity.getMaNH(),
                entity.getHoVaTen(),
                entity.getNgaySinh(),
                entity.getGioiTinh(),
                entity.getEmail(),
                entity.getGhiChu());
    }

    @Override
    public void update(NguoiHoc entity) {
        JdbcHelper.executeUpdate(UPDATE_SQL,
                entity.getMaNH(),
                entity.getHoVaTen(),
                entity.getNgaySinh(),
                entity.getGioiTinh(),
                entity.getEmail(),
                entity.getGhiChu());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public NguoiHoc selectById(String id) {
        List<NguoiHoc> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<NguoiHoc> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<NguoiHoc> selectBySql(String sql, Object... args) {
        List<NguoiHoc> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                NguoiHoc entity = new NguoiHoc();
                entity.setMaNH(rs.getString("MaNH"));
                entity.setHoVaTen(rs.getString("HoTen"));
                entity.setNgaySinh(rs.getDate("NgaySinh"));
                entity.setGioiTinh(rs.getString("GioiTinh"));
                entity.setEmail(rs.getString("Email"));
                entity.setGhiChu(rs.getString("GhiChu"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<NguoiHoc> selectByKeyword(String keyword) {
        String SQL = "SELECT * FROM NguoiHoc WHERE HoTen LIKE ?";
        return this.selectBySql(SQL, "%" + keyword + "%");
    }

    public List<NguoiHoc> selectNotInCourse(int makh, String keyword) {
        String SQL = "SELECT * FROM NguoiHoc WHERE HoTen LIKE ? AND "
                + "MaNH NOT IN(SELECT MaNH FROM HocVien WHERE MaKH = ?)";
        return this.selectBySql(SQL, "%" + keyword + "%", makh);
    }
}

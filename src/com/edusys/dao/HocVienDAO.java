/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.dao;

import com.edusys.entity.HocVien;
import com.edusys.utils.JdbcHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author ASUS ZENBOOK
 */
public class HocVienDAO extends EdusysDAO<HocVien, String> {

    String INSERT_SQL = "INSERT INTO HocVien(MaKH, MaNH, Diem) VALUES(?, ?, ?)";
    String UPDATE_SQL = "UPDATE HocVien SET MaKH=?, MaNH=?, Diem=? WHERE MaHV=?";
    String DELETE_SQL = "DELETE FROM HocVien WHERE MaHV=?";
    String SELECT_ALL_SQL = "select a.MAHV, b.HOVATEN, b.GIOITINH, b.NGAYSINH, b.SDT, b.EMAIL\n"
            + "from HOC_VIEN a inner join NGUOI_HOC b on a.MANH = b.MANH";
    String SELECT_BY_ID_SQL = "select a.MAHV, b.HOVATEN, b.GIOITINH, b.NGAYSINH, b.SDT, b.EMAIL\n"
            + "from HOC_VIEN a inner join NGUOI_HOC b on a.MANH = b.MANH WHERE MaHV=?";

    @Override
    public void insert(HocVien entity) {
        JdbcHelper.executeUpdate(INSERT_SQL,
                entity.getMaHV(),
                entity.getHoTen(),
                entity.getGioiTinh(),
                entity.getNgaySinh(),
                entity.getSDT(),
                entity.getEmail());
    }

    @Override
    public void update(HocVien entity) {
        JdbcHelper.executeUpdate(UPDATE_SQL,
                entity.getMaHV(),
                entity.getHoTen(),
                entity.getGioiTinh(),
                entity.getNgaySinh(),
                entity.getSDT(),
                entity.getEmail());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public HocVien selectById(String id) {
        List<HocVien> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<HocVien> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public List<HocVien> selectBySql(String sql, Object... args) {
        List<HocVien> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                HocVien entity = new HocVien();
                entity.setMaHV(rs.getString("MAHV"));
                entity.setHoTen(rs.getString("HOVATEN"));
                entity.setGioiTinh(rs.getString("GIOITINH"));
                entity.setNgaySinh(rs.getString("NGAYSINH"));
                entity.setSDT(rs.getString("SDT"));
                entity.setEmail(rs.getString("EMAIL"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<HocVien> selectByKhoaHoc(String maKH) {
        String SQL = "SELECT * FROM HocVien WHERE MaKH = ?";
        return this.selectBySql(SQL, maKH);
    }
}

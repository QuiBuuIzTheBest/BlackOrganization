/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.dao;

import com.edusys.entity.*;
import com.edusys.utils.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ChuyenDeDAO extends EdusysDAO<ChuyenDe, String>{
    
    String INSERT_SQL = "INSERT INTO chuyen_de (MaCD, TenCD, ThoiLuong, HocPhi, MoTa, Hinh) VALUES (?, ?, ?, ?, ?, ?)";
    String UPDATE_SQL = "UPDATE ChuyenDe SET TenCD=?, ThoiLuong=?, HocPhi=?, MoTa=?, Hinh=? WHERE MaCD=?";
    String DELETE_SQL = "DELETE FROM chuyen_de WHERE MaCD=?";
    String SELECT_ALL_SQL = "SELECT * FROM chuyen_de";
    String SELECT_BY_ID_SQL = "SELECT * FROM chuyen_de WHERE MaCD=?";

    @Override
    public void insert(ChuyenDe entity) {
        JdbcHelper.executeUpdate(INSERT_SQL,
                entity.getMaCD(),
                entity.getTenCD(),
                entity.getHocPhi(),
                entity.getThoiLuong(),
                entity.getHinhLogo(),
                entity.getMoTa());
    }

    @Override
    public void update(ChuyenDe entity) {
        JdbcHelper.executeUpdate(UPDATE_SQL,
                entity.getTenCD(),
                entity.getHocPhi(),
                entity.getThoiLuong(),
                entity.getHinhLogo(),
                entity.getMoTa(),
                entity.getMaCD());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public ChuyenDe selectById(String id) {
        List<ChuyenDe> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<ChuyenDe> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public List<ChuyenDe> selectBySql(String sql, Object... args) {
        List<ChuyenDe> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                ChuyenDe entity = new ChuyenDe();
                entity.setMaCD(rs.getString("MaCD"));
                entity.setTenCD(rs.getString("TenCD"));
                entity.setThoiLuong(rs.getString("ThoiLuong"));
                entity.setHocPhi(rs.getFloat("HocPhi"));
                entity.setMoTa(rs.getString("MoTa"));
                entity.setHinhLogo(rs.getBytes("Hinh"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    
}

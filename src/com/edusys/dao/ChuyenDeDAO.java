/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.dao;

import com.edusys.entity.ChuyenDe;
import com.edusys.utils.JdbcHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ChuyenDeDAO extends EdusysDAO<ChuyenDe, String>{
    String insert_sql = "INSERT INTO chuyen_de(MaCD,TenCD,ThoiLuong,HocPhi,Mota,HinhLogo) values (?,?,?,?,?,?)";
    String upadate_sql ="update chuyen_de set TenCD = ?, ThoiLuong = ?, HocPhi = ?, Mota =? where MaCD = ?";
    String delete_sql = "delete from chuyen_de where MaCD = ?";
    String select_all_sql ="select * from chuyen_de";
    String select_by_id_sql ="select * from chuyen_de where MaCD";
    @Override
    public void insert(ChuyenDe entity) {
        
        }

    @Override
    public void update(ChuyenDe entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ChuyenDe> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ChuyenDe selectById(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void selectBySql(String sql, Object... args) {
        List<ChuyenDe> list = new ArrayList<ChuyenDe>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql,args);
            while(rs.next()){
                ChuyenDe entity = new ChuyenDe();
            
            }
        } catch (Exception e) {
        }
    }
    
}

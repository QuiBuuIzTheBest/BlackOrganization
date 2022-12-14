/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.utils;

import java.sql.*;

/**
 *
 * @author Admin
 */
public class JdbcHelper {

    static String dburl = "jdbc:sqlserver://localhost:1433;databaseName=edusysdao;encrypt=true;trustServerCertificate=true";
    static String user = "edusys";
    static String pass = "123";

//    static {
//        try {
//            Class.forName("com.microsoft.sqlsever.SQLSeverDriver");
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    } thêm cái này nó lỗi quá nên Trọng bỏ nó luôn

    public static PreparedStatement preparedStatement(String sql, Object... args) throws SQLException {
        Connection conn = DriverManager.getConnection(dburl, user, pass);
        PreparedStatement pstmt = null;
        if (sql.trim().startsWith("{")) {
            pstmt = conn.prepareCall(sql); //proc
        } else {
            pstmt = conn.prepareStatement(sql); //SQL
        }
        for (int i = 0; i < args.length; i++) {
            pstmt.setObject(i + 1, args[i]);
        }
        return pstmt;
    }

    public static ResultSet executeQuery(String sql, Object... args) {
        try {
            PreparedStatement pstmt = preparedStatement(sql, args);
            return pstmt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void executeUpdate(String sql, Object... args) {
        try {
            PreparedStatement pstmt = preparedStatement(sql, args);
            try {
                pstmt.executeUpdate();
            } finally {
                pstmt.getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

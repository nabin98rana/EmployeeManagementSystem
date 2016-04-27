/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ems.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Navin
 */
public class DBConnection {
    private Connection conn=null;
    
    public DBConnection() throws SQLException,ClassNotFoundException{
            Class.forName("com.mysql.jdbc.Driver");
           conn=DriverManager.getConnection("jdbc:mysql://localhost/ems", "root", "");
    }
    public int executeUpdate(String sql) throws SQLException{
        Statement stmt=conn.createStatement();
        return stmt.executeUpdate(sql);
    }
    public ResultSet executeQuery(String sql) throws SQLException{
    Statement stmt=conn.createStatement();
    ResultSet rs=stmt.executeQuery(sql);
    return rs;
    }
    
    public void close() throws SQLException{
     if(conn!=null && !conn.isClosed()){
      conn.close();
      conn=null;
     }
    }
}

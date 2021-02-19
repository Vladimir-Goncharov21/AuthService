/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.labwork1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class DataBaseUtil {
    // метод для получения объекта типа Connection 
    public static Connection getConnection() throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", 
                                                      "postgres", 
                                                      "123");
        return conn;
    }         
    //
    public static void printMeta(Connection c) throws SQLException{
        DatabaseMetaData meta = c.getMetaData(); 
        System.out.println("getDatabaseProductName="    + meta.getDatabaseProductName());
        System.out.println("getDatabaseProductVersion=" + meta.getDatabaseProductVersion());
        System.out.println("getDriverName()="           + meta.getDriverName());
        System.out.println("getDriverVersion="          + meta.getDriverVersion());        
    }
}

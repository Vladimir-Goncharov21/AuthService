/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.labwork1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author foxyl
 */
public class SecurityService {

    private static SecurityService SecurityService;

    public SecurityService() {
    }

    public static SecurityService getSecurityService() {
        if (SecurityService == null) {
            SecurityService = new SecurityService();
        }
        return SecurityService;
    }

    public void authenticate(String username, String password) throws AuthException, SQLException {
        final String sql = "select username, password from accounts where username = ?"; //находим значение пароля для введенного логина
        final String successLoginSql = "update accounts set last_login  = now() where username = ?"; //обновляем время последнего логина в случае успеха
        Connection c = DataBaseUtil.getConnection();
        PreparedStatement s = c.prepareStatement(sql);
        s.setString(1, username);
        ResultSet rs = s.executeQuery();
        if (rs.next()) {
            if (rs.getString("username").equals(username) && rs.getString("password").equals(password)) { //проверям совпадает ли введенные логин и пароль со значениями в базе данных
                PreparedStatement ss = c.prepareStatement(successLoginSql);
                ss.setString(1, username);
                ss.executeUpdate();
                System.out.println("Вход выполнен успешно");
            }
        } else {
            throw new AuthException(); //выброс исключения что логин и пароль неверные
        }
    }
}

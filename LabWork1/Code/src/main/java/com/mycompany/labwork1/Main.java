
package com.mycompany.labwork1;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        final String username = "user1"; //здесь программа получает логин
        final String password = "123"; //здесь программа получает пароль
        try {
            SecurityService.getSecurityService().authenticate(username, password);
        } catch (AuthException | SQLException ex) {
            ex.printStackTrace();
        }
    }
}

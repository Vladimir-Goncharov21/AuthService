/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.labwork1;

/**
 *
 * @author foxyl
 */
public class AuthException extends Exception {

    public AuthException() {
    }

    @Override
    public void printStackTrace() {
        System.out.println("Пользователя с данным логином и паролем не существует");
    }

}

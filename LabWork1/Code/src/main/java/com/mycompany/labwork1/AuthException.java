package com.mycompany.labwork1;

public class AuthException extends Exception {

    public AuthException() {
    }

    @Override
    public void printStackTrace() {
        System.out.println("Пользователя с данным логином и паролем не существует");
    }

}

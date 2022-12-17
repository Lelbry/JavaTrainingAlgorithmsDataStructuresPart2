package com.company;

import java.util.Scanner;

class WrongLoginException extends Exception {
    public WrongLoginException() {
        super();
    }

    public WrongLoginException(String message) {
        super(message);
    }
}

class WrongPasswordException extends Exception {
    public WrongPasswordException() {
        super();
    }

    public WrongPasswordException(String message) {
        super(message);
    }
}

public class Main {
    // Static method with three parameters: login, password, and confirmPassword
    public static void verifyCredentials(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        // Check login: should contain only Latin letters, numbers, and underscore
        if (!login.matches("^[a-zA-Z0-9_]*$")) {
            throw new WrongLoginException("Логин должен содержать только латинские буквы, цифры и знак подчеркивания");
        }
        // Check login length
        if (login.length() > 20) {
            throw new WrongLoginException("Длина логина не должна превышать 20 символов");
        }

        // Check password: should contain only Latin letters, numbers, and underscore
        if (!password.matches("^[a-zA-Z0-9_]*$")) {
            throw new WrongPasswordException("Пароль должен содержать только латинские буквы, цифры и знак подчеркивания");
        }
        // Check password length
        if (password.length() > 20) {
            throw new WrongPasswordException("Длина пароля не должна превышать 20 символов");
        }
        // Check that password and confirmPassword match
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароль и подтверждающий пароль не совпадают");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите логин: ");
        String login = scanner.nextLine();
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();
        System.out.print("Потвердите пароль: ");
        String confirmPassword = scanner.nextLine();

        try {
            verifyCredentials(login, password, confirmPassword);
            System.out.println("Логин и пароль корректны");
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        }
    }
}


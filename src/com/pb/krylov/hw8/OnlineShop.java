package com.pb.krylov.hw8;

import java.util.Scanner;

public class OnlineShop {
    public static void main(String[] args) {
        Auth auth = new Auth();
        String passwd = "aaZZ0_";
        String login = "1h4545";
        Scanner in = new Scanner(System.in);
        while (auth.getLogin()==null) {
            System.out.println("Введите логин:");
            login = in.nextLine();
            System.out.println("Введите пароль:");
            passwd = in.nextLine();
            System.out.println("Попытка регистрации Логин: " + login + " Пароль: " + passwd);
            try {
                auth.signUp(login, passwd, passwd);
            } catch (WrongLoginException e) {
                System.out.println("Логин " + e.getLogin() + " не соответсвует требованиям.");
                e.printStackTrace();
            } catch (WrongPasswordException e) {
                System.out.println("Ошибка " + e.getMessage());
                e.printStackTrace();
            }
        }
        System.out.println("Присвоено Логин: "+auth.getLogin()+" Пароль: "+auth.getPassword());
        try {
            auth.signIn(login,passwd);
        } catch (WrongLoginException e) {
            System.out.println("Логин " + e.getLogin()+ " не вошел!!!");
            e.printStackTrace();
        }

    }
}

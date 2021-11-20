package com.pb.krylov.hw8;

public class WrongLoginException extends Exception{
    private String login;

    public WrongLoginException(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }
}

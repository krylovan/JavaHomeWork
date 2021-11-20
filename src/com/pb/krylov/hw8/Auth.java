package com.pb.krylov.hw8;

public class Auth  {
    private String  login, password;
    public boolean isEmpty;
    void signUp (String logn, String passwd, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {
        isEmpty=true;
        String patternP = "[A-Za-z0-9_]{5,}";
        String patternL = "[A-Za-z0-9]{5,20}";
        if (!logn.matches(patternL)) throw new WrongLoginException(logn);
        if (!passwd.matches(patternP)) throw new WrongPasswordException("Пароль не соответствует требованиям");
        if (!passwd.equals(confirmPassword)) throw new WrongPasswordException("Пароли не совпадают");

        login=logn;
        password=passwd;
        isEmpty=false;
    }
    void signIn (String logn, String passwd) throws WrongLoginException{
        if (logn.equals(login)&passwd.equals(password)) {
            System.out.println("Вошёл "+logn);
        }else throw new WrongLoginException(logn);
    }
   public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}

package com.pb.krylov.hw5;

public class Reader {
    public Reader(String fio, String number, String fakultet, String dateB, String mobile) {
        Fio = fio;
        Number = number;
        Fakultet = fakultet;
        DateB = dateB;
        Mobile = mobile;
           }

    final String Fio, Number, Fakultet, DateB, Mobile;
public void takeBook (int CountBook){
    System.out.println(Fio + " взял "+CountBook+" книги");
}

    public void takeBook (String ... Books ){
        System.out.print(Fio + " взял книги:");
        for (String mBook : Books) {
            System.out.println(mBook);
        }    }
    public void takeBook (Book ... Books ){
        System.out.print(Fio + " взял книги:");
        for (Book mBook : Books) {
            mBook.info();
        }    }
    public void returnBook (int CountBook){
        System.out.println(Fio + " отдал "+CountBook+" книги");
    }

    public void returnBook (String ... Books ){
        System.out.print(Fio + " отдал книги:");
        for (String mBook : Books) {
            System.out.println(mBook);
        }    }
    public void returnBook (Book ... Books ){
        System.out.print(Fio + " отдал книги:");
        for (Book mBook : Books) {
            mBook.info();
        }    }

    public void info() {
        System.out.print(Fio + ", факультет-"+Fakultet+", номер "+Number+" ");

    }
}

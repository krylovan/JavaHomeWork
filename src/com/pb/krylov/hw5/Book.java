package com.pb.krylov.hw5;

public class Book {
    private final String title, Author;
    private final Integer Year;
    public Book(String title, String author, Integer year) {
        this.title = title;
        Author = author;
        Year = year;
    }
    public void info (){
        System.out.print(title + "("+Author+", "+Year+") ");
    }

}

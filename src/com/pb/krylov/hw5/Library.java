package com.pb.krylov.hw5;

public class Library {
    public static void main(String[] args) {
        Book [] books = {new Book("Математика","Иванов И.И.",1990),
                new Book("География","Ким И.И.",1997),
                new Book("Словарь","Абрамова О.И.",1988)};
        Reader [] readers = {new Reader("Жук","1","2", "2000","068907645"),
                new Reader("Копил Анна","2","2", "2001","068907645"),
                new Reader("Виноградов Петр","3","2002", "2000","068907645")};

        System.out.println("Есть книги:");
        for (Book mBook : books) {
            mBook.info();
        }
        System.out.println();

        System.out.println(" Есть читатели:");

        for (Reader mReader : readers) {
            mReader.info();
        }
        // takebook
        System.out.println();
        readers[0].takeBook(1);
        System.out.println();
        readers[1].takeBook("Приключения"," Словарь", "Энциклопедия");
        System.out.println();
        readers[2].takeBook(books[1],books[2]);
        //returnbook
        System.out.println();
        readers[0].returnBook(5);
        System.out.println();
        readers[1].takeBook("Приключения I"," Словарь", "Энциклопедия");
        System.out.println();
        readers[2].takeBook(books[0]);



    }
}

package it.tsp.boundary;

import it.tsp.control.Store;
import it.tsp.entity.Book;

public class Bookshop {

    

    public static Book addBook(String nameBook, int edition, int price) {

        Store.beginTran();
        Book book = new Book(nameBook, edition, price);
        Store.saveBook(book);
        Store.commitTran();
        Store.rollTran();
        return book;

    }

    public static void removeBookbyID(int bookID) {

        Store.beginTran();
        Store.removeBookbyID(bookID);
        Store.commitTran();
        Store.rollTran();

    }

    public static Book removeBook(String nameBook, int edition, int price) {

        Store.beginTran();
        Book book = new Book(nameBook, edition, price);
        Store.removeBook(book);
        Store.commitTran();
        Store.rollTran();

        return book;
    }

}
package com.zguiz.service;

import com.zguiz.bean.Book;

import java.util.List;

public interface IBookService {
    List<Book> findBook(Book book);
    boolean addBook(Book book);
    boolean deleteBook(Book book);
    boolean deleteBook(String isbn);
    boolean updateBook(Book book);
}

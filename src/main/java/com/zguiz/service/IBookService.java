package com.zguiz.service;

import com.zguiz.bean.Book;
import com.zguiz.bean.Pager;

import java.util.List;

public interface IBookService {
    List<Book> findBook(Book book);
    List<Book> findBookByPager(Pager pager);
    boolean addBook(Book book);
    boolean deleteBook(Book book);
    boolean deleteBook(String isbn);
    boolean updateBook(Book book);
    int countForPager(Pager pager);
}

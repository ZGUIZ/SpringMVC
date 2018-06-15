package com.zguiz.service;

import com.zguiz.bean.Book;

import java.util.List;

public interface IBookService {
    List<Book> findBook(Book book);
}

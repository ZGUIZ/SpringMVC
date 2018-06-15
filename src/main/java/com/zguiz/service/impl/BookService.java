package com.zguiz.service.impl;

import com.zguiz.bean.Book;
import com.zguiz.mapper.BookMapper;
import com.zguiz.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class BookService implements IBookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> findBook(Book book){
        List<Book> books=bookMapper.findBook(book);
        return books;
    }

}

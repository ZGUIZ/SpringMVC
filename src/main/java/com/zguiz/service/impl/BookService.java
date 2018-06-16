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

    @Override
    public boolean addBook(Book book) {
        try {
            if (bookMapper.addBook(book) > 0) {
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteBook(Book book) {
        return deleteBook(book.getIsbn());
    }

    @Override
    public boolean deleteBook(String isbn) {
        try {
            return bookMapper.deleteByIsbn(isbn);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateBook(Book book){
        int res=bookMapper.updateBook(book);
        if(res>0){
            return true;
        }
        return false;
    }

}

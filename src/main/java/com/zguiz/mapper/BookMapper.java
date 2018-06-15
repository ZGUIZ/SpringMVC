package com.zguiz.mapper;

import com.zguiz.bean.Book;
import com.zguiz.bean.Category;
import com.zguiz.bean.Pager;

import java.util.List;

public interface BookMapper {
    List<Book> findBookByCategoryName(Category category);
    List<Book> findAll();
    int addBook(Book book);
    List<Book> findAllBookAndCategory();
    List<Book> findBook(Book book);
    int updateBook(Book book);

    /**
     * 分页查询
     * @param pager
     * @return
     */
    List<Book> findByPager(Pager pager);

    /**
     * 统计页数
     * 与分页查询sql条件一致的统计查询
     * @param pager
     * @return
     */
    int countForPager(Pager pager);

    /**
     * 批量查询
     * @param isbnList
     * @return
     */
    List<Book> findByIsbnList(List<String> isbnList);

    /**
     * 批量删除
     * @param isbnArray
     */
    void deleteByIsbnList(List<String> isbnArray);

    /**
     * 批量修改
     * @param books
     */
    void editBooks(List<Book> books);

    /**
     * 批量新增
     * @param books
     */
    void addBooks(List<Book> books);
}

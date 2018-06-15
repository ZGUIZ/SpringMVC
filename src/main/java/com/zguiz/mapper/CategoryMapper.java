package com.zguiz.mapper;

import com.zguiz.bean.Book;
import com.zguiz.bean.Category;

import java.util.List;

public interface CategoryMapper {
    List<Category> getCategoryByBookName(Book book);

    int addCategory(Category category);
    List<Category> findAll();
    List<Category> findByName(Category category);
    List<Category> findByNameOrId(Category category);
}

package com.zguiz.service;

import com.zguiz.bean.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAllCategory();
    boolean addCategory(List<Category> categories);
    boolean delCategoryById(List<Integer> id);
    boolean updateCategory(List<Category> categories);
    List<Category> findCategory(Category category);
}

package com.zguiz.service.impl;

import com.zguiz.bean.Category;
import com.zguiz.mapper.CategoryMapper;
import com.zguiz.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryService implements ICategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> findAllCategory() {
        return categoryMapper.findAll();
    }

    @Override
    public boolean addCategory(List<Category> categories) {
        try {
            int res = categoryMapper.addCategoryByList(categories);
            if(res>0) {
                return true;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delCategoryById(List<Integer> id) {
        try {
            int res = categoryMapper.deleteCategory(id);
            if(res>0){
                return true;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateCategory(List<Category> categories) {
        try {
            int res = categoryMapper.updateCategory(categories);
            if(res>0){
                return true;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Category> findCategory(Category category) {
        if(category.getId()<=0&&(category.getName()==null||(category.getName().trim().equals("")))){
            return categoryMapper.findAll();
        }
        return categoryMapper.findByNameOrId(category);
    }
}

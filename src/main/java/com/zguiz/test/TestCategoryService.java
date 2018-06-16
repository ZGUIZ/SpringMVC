package com.zguiz.test;

import com.zguiz.bean.Category;
import com.zguiz.service.ICategoryService;
import com.zguiz.service.impl.CategoryService;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TestCategoryService {
    private ApplicationContext context;
    private ICategoryService categoryService;
    private Logger logger;
    @Before
    public void init(){
        logger=Logger.getRootLogger();
        String configLoaction="applicationContext.xml";
        context=new ClassPathXmlApplicationContext(configLoaction);
        categoryService= context.getBean(CategoryService.class);
    }

    @Test
    public void findCategory(){
        List<Category> categoryList=categoryService.findAllCategory();
        for(Category category:categoryList){
            System.out.println(category.toString());
        }
    }

    @Test
    public void addCategory(){
        Category category=new Category();
        category.setName("轻小说");
        Category category1=new Category();
        category1.setName("漫画");
        List<Category> categories=new ArrayList<>();
        categories.add(category);
        categories.add(category1);
        boolean res=categoryService.addCategory(categories);
        System.out.println(res);
        logger.debug("res="+res);
    }

    @Test
    public void updateCategory(){
        Category category=new Category();
        category.setId(5);
        category.setName("小说");
        Category category1=new Category();
        category1.setId(6);
        //category1.setName("漫画");
        Category category2=new Category(7,"传记");
        Category category3=new Category(8,"感情");
        List<Category> categories=new ArrayList<>();
        categories.add(category);
        categories.add(category1);
        categories.add(category2);
        categories.add(category3);
        boolean res=categoryService.updateCategory(categories);
        logger.debug("res="+res);
    }

    @Test
    public void delCategory(){
        List<Integer> id=new ArrayList<>();
        id.add(7);
        id.add(8);
        boolean res=categoryService.delCategoryById(id);
        logger.debug("res="+res);
    }
}

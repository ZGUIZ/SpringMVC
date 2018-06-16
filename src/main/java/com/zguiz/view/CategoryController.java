package com.zguiz.view;

import com.zguiz.bean.Category;
import com.zguiz.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    /**
     * 多条件查询
     * @param category
     * @return
     */
    @RequestMapping("/find")
    public ModelAndView findCategory(Category category){
        ModelAndView modelAndView=new ModelAndView("categorylist");
        List<Category> categories;
        categories=categoryService.findCategory(category);
        modelAndView.getModel().put("categories",categories);
        return modelAndView;
    }

    /**
     * 查询所有
     * @return
     */
    @RequestMapping("/list")
    public ModelAndView listCategory(){
        ModelAndView modelAndView=new ModelAndView("categorylist");
        List<Category> categories;
        categories=categoryService.findAllCategory();
        modelAndView.getModel().put("categories",categories);
        return modelAndView;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/del")
    public String deleteCategory(int id){
        List<Integer> list=new ArrayList<>();
        list.add(id);
        boolean res=categoryService.delCategoryById(list);
        return "forward:/category/list.action";
    }

    @RequestMapping("/doadd")
    public String addCategory(Category category){
        List<Category> categories=new ArrayList<>();
        categories.add(category);
        if(categoryService.addCategory(categories)){
            return "forward:/category/list.action";
        }
        return "addcategory";
    }

    @RequestMapping("/update")
    public ModelAndView updateFindMessage(Category category){
        System.out.println("id="+category.getId());
        List<Category> categories=categoryService.findCategory(category);
        ModelAndView view=new ModelAndView("updatecategory");
        view.getModel().put("category",categories.get(0));
        return view;
    }

    @RequestMapping("/doupdate")
    public String update(Category category){
        List<Category> categories=new ArrayList<>();
        categories.add(category);
        boolean res=categoryService.updateCategory(categories);
        if(res) {
            return "forward:/category/list.action";
        }
        return "forward:/category/update.action?id="+category.getId();
    }

}

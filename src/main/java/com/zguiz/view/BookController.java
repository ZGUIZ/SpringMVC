package com.zguiz.view;

import com.zguiz.bean.Book;
import com.zguiz.bean.Category;
import com.zguiz.service.IBookService;
import com.zguiz.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private IBookService bookService;
    @Autowired
    private ICategoryService categoryService;

    /**
     * 查找所有书籍
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String listBook(Model model){
        //Model是Spring MVC封装的数据模型，用于在mvc各组件中传递数据，类似于HttpServlet对象
        List<Book> list=bookService.findBook(new Book());
        model.addAttribute("books",list);
        return "booklist";
    }

    /**
     * 跳转到添加书籍页面
     * @return
     */
    @RequestMapping("/add")
    public ModelAndView toAddBook(){
        List<Category> categories=categoryService.findAllCategory();
        ModelAndView view=new ModelAndView("addbook");
        view.getModel().put("categories",categories);
        return view;
    }

    @RequestMapping("/doadd")
    public String doAddBook(Book book){
        if(bookService.addBook(book)){
            return "forward:/book/list.action";
        }
        else{
            return "forward:/book/add.action";
        }
    }

    @RequestMapping("/del")
    public String delBook(String isbn){
        bookService.deleteBook(isbn);
        return "forward:/book/list.action";
    }

    @RequestMapping("/update")
    public ModelAndView toUpdateBook(String isbn){
        Book book=new Book();
        book.setIsbn(isbn);
        List<Book> books=bookService.findBook(book);
        List<Category> categories=categoryService.findAllCategory();
        ModelAndView view=new ModelAndView("updatebook");
        view.getModel().put("book",books.get(0));
        view.getModel().put("categories",categories);
        return view;
    }

    @RequestMapping("doupdate")
    public String doUpdate(Book book){
        if(bookService.updateBook(book)){
            return "forward:/book/list.action";
        }
        return "forward:/book/update.action?isbn="+book.getIsbn();
    }
}

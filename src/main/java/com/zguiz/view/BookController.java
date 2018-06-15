package com.zguiz.view;

import com.zguiz.bean.Book;
import com.zguiz.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private IBookService bookService;

    @RequestMapping("/list")
    public String listBook(Model model){
        //Model是Spring MVC封装的数据模型，用于在mvc各组件中传递数据，类似于HttpServlet对象
        List<Book> list=bookService.findBook(new Book());
        model.addAttribute("books",list);
        return "booklist";
    }
}

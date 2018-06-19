package com.zguiz.view;

import com.zguiz.bean.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
    @RequestMapping("hello")
    public String hello(Book book){
        boolean flag=true;
        if(flag){
            throw new NullPointerException();
        }
        //System.out.println(book.getCategory().getId());
        return "forward:/book/list";
    }

    @RequestMapping("index")
    public ModelAndView show(){
        ModelAndView mv=new ModelAndView();
        mv.addObject("msg","world");
        mv.setViewName("index");
        return mv;
    }
}

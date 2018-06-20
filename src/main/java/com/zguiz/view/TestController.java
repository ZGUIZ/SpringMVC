package com.zguiz.view;

import com.zguiz.bean.Book;
import com.zguiz.bean.BookVo;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    public ModelAndView show(@RequestParam(defaultValue = "test",value = "n") String name){
        ModelAndView mv=new ModelAndView();
        mv.addObject("msg",name);
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("/index1")
    public ModelAndView show1(String[] name){
        ModelAndView mv=new ModelAndView("index");
        mv.addObject("names",name);
        return mv;
    }

    @RequestMapping("/index2")
    public ModelAndView show2(BookVo books){
        ModelAndView mv=new ModelAndView("index");
        mv.addObject("books",books.getBooks());
        return mv;
    }

    @RequestMapping("index3")
    public void show3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String isbn=request.getParameter("isbn");
        request.setAttribute("msg",isbn);
        request.getRequestDispatcher("/pages/index.jsp").forward(request,response);
    }

    @RequestMapping(value="/index4/{isbn}",method= RequestMethod.GET)
    public void show4(@PathVariable(value="isbn") String isbn,HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("msg",isbn);
        request.getRequestDispatcher("/pages/index.jsp").forward(request,response);
    }
}

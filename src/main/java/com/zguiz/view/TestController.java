package com.zguiz.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
    @RequestMapping("hello")
    public String hello(){
        return "index";
    }

    @RequestMapping("index")
    public ModelAndView show(){
        ModelAndView mv=new ModelAndView();
        mv.addObject("msg","world");
        mv.setViewName("index");
        return mv;
    }
}

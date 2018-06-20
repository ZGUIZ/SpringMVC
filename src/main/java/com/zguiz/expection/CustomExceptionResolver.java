package com.zguiz.expection;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object param, Exception e) {
        //根据不同的异常返回不同的视图或返回统一的视图
        ModelAndView view=null;
        if(e instanceof NullPointerException){
            view=new ModelAndView("index");
            return view;
        }
        else{
            view=new ModelAndView("index");
            return view;
        }
    }
}

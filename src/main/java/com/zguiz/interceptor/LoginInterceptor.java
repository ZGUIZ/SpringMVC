package com.zguiz.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    //在拦截点前拦截
    //所返回true，则不拦截拦截点后的操作（拦截成功）;
    //返回false执行拦截
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession session=httpServletRequest.getSession();
        String uri=httpServletRequest.getRequestURI();
        if(session.getAttribute("LOGIN_USER")!=null /*|| uri.indexOf("system/login")!=-1*/) {
            return true;
        } else{
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/pages/login.jsp");
            return false;
        }
    }

    //处理中，执行拦截
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    //执行完毕，返回前拦截
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}

package com.zguiz.filter;

import com.sun.deploy.net.HttpResponse;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpSession session=request.getSession();
        Object object=session.getAttribute("LOGIN_USER");
        if(object==null&&request.getRequestURI().indexOf("pages/login.jsp")!=-1){
            HttpServletResponse response=(HttpServletResponse) servletResponse;
            response.sendRedirect("pages/login.jsp");
        } else {
            //已经登录，继续请求下一级资源
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}

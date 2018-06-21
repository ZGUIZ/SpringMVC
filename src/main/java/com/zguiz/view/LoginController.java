package com.zguiz.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/system")
public class LoginController {

    @RequestMapping("/login")
    public String login(String account, String password, HttpServletRequest request){
        if(account.equals("admin")&&password.equals("admin")) {
            //当参数值为true时，与无参数的功能一致，
            // 表示系统中有会话则返回该会话，没有会话则创建新的会话并返回
            // 当参数为false时，表示系统中有会话则返回该会话，没有会话则返回空
            //会话默认有效时间长是30分钟，在特定场景可以调整会话的失效时长
            //会话失效有3种情况：1).会话超时失效；2）客户端关闭；3）在服务端调用session.invalidate方法（退出系统）
            HttpSession session=request.getSession(true);
            session.setAttribute("LOGIN_USER",account);
            return "redirect:/book/listbypager.action";
        } else {
            request.setAttribute("error", "账号或密码错误");
            return "login";
        }
    }

}

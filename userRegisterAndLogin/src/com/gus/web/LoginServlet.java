package com.gus.web;

import com.gus.domain.User;
import com.gus.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "LoginServlet", urlPatterns = "/servlet/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        UserServiceImpl service = new UserServiceImpl();
//        1.获取浏览器中提交的数据，在这里为什么不检验是否为空呢?,因为只要检验能否根据用户和密码查出user就可以判断了，这一步没有必要
        String username = req.getParameter("username");
        String password = req.getParameter("password");
//        2.获取用户
        User user = service.isuser(username, password);
        if (null == user) {
            req.setAttribute("msg", "用户名密码不正确");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        } else {
//            设置session
            req.getSession().setAttribute("user", user);
//        3.如果用户勾选了记住用户名，则发送cookie，为防止用户名为中文
            if ("OK".equals(req.getParameter("remname"))) {
                Cookie remNameC = new Cookie("remname", URLEncoder.encode(user.getUsername(), "utf-8"));
                remNameC.setPath(req.getContextPath());
                remNameC.setMaxAge(3600*34*30);
                resp.addCookie(remNameC);
            } else {
//                没有勾选则覆盖cookie
                Cookie remNameC = new Cookie("remname",  "");
                remNameC.setPath(req.getContextPath());
                remNameC.setMaxAge(0);
                resp.addCookie(remNameC);
            }
            resp.sendRedirect(req.getContextPath()+"/index.jsp");
        }


    }
}

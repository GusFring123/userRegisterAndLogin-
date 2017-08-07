package com.gus.web;

import com.gus.domain.User;
import com.gus.exception.MsgException;
import com.gus.service.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", urlPatterns = "/servlet/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
//        1.校验验证码是否正确，在这之前，需要做一些字符编码处理
            req.setCharacterEncoding("utf-8");
            resp.setContentType("text/html;charset=utf-8");
            UserServiceImpl service = new UserServiceImpl();

//        获取验证码；
            String valistr1 = req.getParameter("valistr");
            String valistr2 = (String) req.getSession().getAttribute("valistr");
//            判断验证码是否为空，或者验证码是不不正确，如果不正确则提示，正确则继续
            if (null == valistr1 || null == valistr2 || !valistr1.equals(valistr2)) {
                throw new MsgException("验证码不正确！");
            }
//         2.封装数据，校验数据
            User user = new User();
            BeanUtils.populate(user, req.getParameterMap());
//            检验用户名密码是否为空以及格式是否正确，如果出错，则抛出异常，进行提示。
            user.checkValue();
//          3.调用service方法添加用户
            service.registerUser(user);
//          如果执行到这一步，说明都没有问题了，和数据库打交道的用户名校验放在service里面了；
//          4，使用户返回主页直接能够登录了；
            req.getSession().setAttribute("user", user);
//          5.跳转到主页
            resp.getWriter().write("恭喜你注册成功，3秒后返回主页");
            resp.setHeader("refresh", "3;url=" + req.getContextPath() + "/index.jsp");
        } catch (MsgException e) {
            req.setAttribute("msg", e.getMessage());
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

}

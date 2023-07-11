package com.example.Servlet;

import com.example.Dao.UserDao;
import com.example.po.UserPo;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/logById")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("userid");
        String pwd = req.getParameter("pwd");
        String k=req.getParameter("kind");
        System.out.println(k);
        UserPo user=UserDao.queryUserForLog(id, pwd);
        if (user!=null) {
            HttpSession session=req.getSession();
            session.setAttribute("user", user);
//            Cookie c=new Cookie("userName",String.valueOf(user.getUserId()));
//            c.setPath("/");
//        发送(响应)Cookie数据
//            resp.addCookie(c);
            resp.sendRedirect("index.jsp");
        }else {
            req.setAttribute("message","登录失败");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}


package com.example.Servlet;

import com.example.Dao.UserDao;
import com.example.Dao.weiboDao;
import com.example.po.UserPo;
import com.example.po.weiboPo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/otherUserPage")
public class otherUsersServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       long userId= Long.parseLong(req.getParameter("concern"));
        System.out.println(userId);
        List<weiboPo> list = weiboDao.queryMyWeibo(userId);
        UserPo concern= UserDao.queryUserById(userId);
        HttpSession session= req.getSession();
        session.setAttribute("concern",concern);
        session.setAttribute("weiboList",list);
        resp.sendRedirect("otherUserPage.jsp");
    }
}

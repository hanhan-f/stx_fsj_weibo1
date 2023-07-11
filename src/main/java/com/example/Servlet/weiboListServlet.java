package com.example.Servlet;

import com.example.Dao.weiboDao;
import com.example.po.weiboPo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/weiboList")
public class weiboListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<weiboPo> weiboList= weiboDao.query();
        HttpSession session= req.getSession();
        session.setAttribute("weiboList",weiboList);
        resp.sendRedirect("weiboList.jsp");
    }
}

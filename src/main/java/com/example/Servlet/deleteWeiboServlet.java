package com.example.Servlet;

import com.example.Dao.weiboDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteWeibo")
public class deleteWeiboServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long weiboId= Long.parseLong(req.getParameter("weiboId"));
        weiboDao.deleteWeibo(weiboId);
        req.getRequestDispatcher("myWeibo").forward(req,resp);

    }
}

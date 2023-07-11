package com.example.Servlet;

import com.example.Dao.concernDao;
import com.example.po.UserPo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteConcern")
public class deleteConcernServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long userId= Long.parseLong(req.getParameter("user"));
        long concernId=Long.parseLong(req.getParameter("concern"));
        concernDao.deleteConcern(userId,concernId);
        req.getRequestDispatcher("MyConcerns").forward(req,resp);
    }
}

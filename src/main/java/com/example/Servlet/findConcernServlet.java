package com.example.Servlet;

import com.example.Dao.concernDao;
import com.example.po.UserPo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/findConcern")
public class findConcernServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserPo user=(UserPo) session.getAttribute("user");
        List<UserPo> findConcernList= concernDao.queryConcerns(user.getUserId());
        session.setAttribute("findConcernList",findConcernList);
        resp.sendRedirect("findConcern.jsp");
    }
}

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

@WebServlet("/MyConcerns")
public class MyConcernsServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserPo userPo = (UserPo) session.getAttribute("user");
        Long id = userPo.getUserId();
        List<UserPo> list = concernDao.queryMyConcerns(id);
        session.setAttribute("userList", list);
        req.getRequestDispatcher("concernList.jsp").forward(req, resp);
    }
}

package com.example.Servlet;

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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/myWeibo")
public class myWeiboServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session= req.getSession();
        UserPo user=(UserPo) session.getAttribute("user");
        Long userId=user.getUserId();
        List<weiboPo> mine= weiboDao.queryMyWeibo(userId);
        session.setAttribute("myWeibo",mine);
        resp.sendRedirect("myWeibo.jsp");
    }
}

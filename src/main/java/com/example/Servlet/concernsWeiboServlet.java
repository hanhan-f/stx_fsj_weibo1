package com.example.Servlet;

import com.example.Dao.concernDao;
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

@WebServlet("/concernsWeibo")
public class concernsWeiboServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session= req.getSession();
        UserPo user=(UserPo) session.getAttribute("user");
        List<UserPo> findConcernList= concernDao.queryMyConcerns(user.getUserId());
        List<weiboPo> weiboList = new ArrayList<>();
        for (UserPo concern:findConcernList){
            List<weiboPo> list = weiboDao.queryMyWeibo(concern.getUserId());
            if(list!=null)
            weiboList.addAll(list);
        }
        session.setAttribute("weiboList",weiboList);
        resp.sendRedirect("weiboList.jsp");
    }
}

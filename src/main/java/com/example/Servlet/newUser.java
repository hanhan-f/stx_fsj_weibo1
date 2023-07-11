package com.example.Servlet;

import com.example.Dao.UserDao;
import com.example.po.UserPo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

@WebServlet("/newUser")
public class newUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("userName");
        String pwd = req.getParameter("password");
        long phone = Long.valueOf(req.getParameter("phone"));
        String emile = req.getParameter("emile");
        Timestamp time = new Timestamp(System.currentTimeMillis());
        UserPo user = new UserPo(username, pwd, phone, emile, time);
        if (UserDao.isExistUsrName(user)) {
            req.setAttribute("name_error", "用户名已存在");
        }
        if (UserDao.isExistPhone(user)) {
            req.setAttribute("phone_error", "电话号码被占用");
        }
        if (UserDao.isExistEmile(user)) {
            req.setAttribute("emile_error", "邮箱已被占用");
        }
        if (UserDao.isExistPhone(user) || UserDao.isExistEmile(user) || UserDao.isExistUsrName(user)) {
            req.getRequestDispatcher("CreatNewUser.jsp").forward(req, resp);
        } else {
            UserDao.addUser(user);
            resp.sendRedirect("index.jsp");
        }
    }
}

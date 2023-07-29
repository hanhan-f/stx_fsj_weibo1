package com.example.Filter;

import com.example.po.UserPo;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(value = "/*")
public class SecurityFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        /**
         * 1. 登录相关的请求不需要过滤
         * a) 登录页面
         * b）登录请求
         * 2) 静态页面是不要验证登录的
         * 2. 除此外的页面都要判断是否已登录，如果为登录进行登录
         */

            // 将target属性设置为空
            String targetAttribute = req.getParameter("target");
            if (targetAttribute != null) {
                req.setAttribute("target", "");
                System.out.println("tar");
            }
        chain.doFilter(req, res);
//        System.out.println("request:"+req.getRequestURI());
//        System.out.println("contentPath:"+req.getContextPath());
//        if(isUserRequest(req,res)){
//            UserPo user = (UserPo) req.getSession().getAttribute("user");
//            if(user==null){
//                req.getRequestDispatcher("login.jsp").forward(req,res);
//            }
//        }else{
//            chain.doFilter(req, res);
//
//        }
//        if (isIndexRequest(req, res) || isLoginRequest(req, res)||isNewUser(req, res)) {
//            chain.doFilter(req, res);
//        } else {
//            UserPo user = (UserPo) req.getSession().getAttribute("user");
//            if (user == null) {
//                res.sendRedirect("login.jsp");
//                return;
//            } else {
//                chain.doFilter(req, res);
//            }
//        }

    }

    private boolean isLoginRequest(HttpServletRequest req, HttpServletResponse res) {
        String uri = req.getRequestURI();
        return uri.equals(req.getContextPath() + "/login");
    }
    private boolean isIndexRequest(HttpServletRequest req,HttpServletResponse res){
        String uri=req.getRequestURI();
        return uri.equals(req.getContextPath()+"/index")||uri.equals(req.getContextPath()+"/index.jsp");
    }
    private boolean isNewUser(HttpServletRequest req,HttpServletResponse res){
        String uri=req.getRequestURI();
        return uri.equals(req.getContextPath()+"/CreatNewUser.jsp")||uri.equals(req.getContextPath()+"/newUser");
    }
    private boolean isUserRequest(HttpServletRequest req,HttpServletResponse res){
        String uri=req.getRequestURI();
        return uri.equals(req.getContextPath()+"/concernsWeibo");
    }
}

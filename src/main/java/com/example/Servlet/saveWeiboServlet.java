package com.example.Servlet;

import com.example.Dao.UserDao;
import com.example.Dao.weiboDao;
import com.example.po.UserPo;
import com.example.po.weiboPo;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@WebServlet("/save")
@MultipartConfig
public class saveWeiboServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session= req.getSession();
        UserPo user=(UserPo)session.getAttribute("user");
        weiboPo weibo=new weiboPo();

        Collection<Part> parts = req.getParts();
        List<String> pathList=new ArrayList<>();
        for(Part part:parts){
            String fileName=GetName(part);
            if(fileName!=null){
                String filePath=req.getServletContext().getRealPath("/");
                pathList.add("weiboImages/"+fileName);
                part.write(filePath+"/"+"weiboImages/"+fileName);
            }else {

            }
        }
        weibo.setUserId(user.getUserId());
        weibo.setContent(req.getParameter("content"));
        int weiboId = weiboDao.addWeibo(weibo);
        System.out.println(pathList.size());
        if(pathList.size()!=0){
            weiboDao.addImages(pathList,weiboId,user.getUserId());
        }
        resp.sendRedirect("MyPage.jsp");
    }
    public String GetName(Part part){
        String partHeader=part.getHeader("content-disposition");
        for(String content:partHeader.split(";")){
            //trim()去除字符串前后的空格
            if(content.trim().startsWith("filename")){
                String name=content.substring(content.indexOf("=")+1).trim().replace("\"","");
                if(name.equals("")){
                    return null;
                }else {
                    return System.currentTimeMillis()+name;
                }
            }
        }
        return null;
    }
}

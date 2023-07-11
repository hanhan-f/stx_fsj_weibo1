package com.example.Servlet;

import com.example.Dao.UserDao;
import com.example.po.UserPo;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet("/changeUser")
@MultipartConfig
public class changeUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //获取普通表单项(获取参数)
        UserPo user=new UserPo();
        user.setUserId(Long.parseLong(request.getParameter("userId")));
        user.setUserName(request.getParameter("userName"));//表单中表单元素name属性值
        user.setEmile(request.getParameter("emile"));
        user.setPhone(Long.parseLong(request.getParameter("phone")));
        user.setPwd(request.getParameter("pwd"));
        //获取Part对象(Servlet将multipart/form-data 的post请求封装成Part对象)
        Part part=request.getPart("img");//表单中file文件域的name属性值
        //获取上传的文件名
        String fileName=GetName(part);
        //得到文件存放的路径
        //修改数据库
        if(fileName!=null){
            String filePath=request.getServletContext().getRealPath("/");
            String path="userImages/"+fileName;
            part.write(filePath+"/"+"userImages/"+fileName);
            UserDao.ChangeUser(user,path);
        }else {
            UserDao.ChangeUser(user,null);
        }
        resp.sendRedirect("myWeibo");
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

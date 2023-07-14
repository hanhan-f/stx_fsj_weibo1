package com.example.Dao;

import com.example.po.UserPo;
import com.example.utile.DBUtil;

import java.sql.*;

public class UserDao {
    public static UserPo queryUserById(long userId) {
        Connection con = null;
        PreparedStatement pr = null;
        ResultSet res = null;
        try {
            con = DBUtil.getConnection();
            pr = con.prepareStatement("select * from user where user_id=?");
            pr.setString(1, String.valueOf(userId));
            res = pr.executeQuery();
            UserPo user = new UserPo();
            if (res.next()) {
                user.setUserId(res.getLong("user_id"));
                user.setUserName(res.getString("username"));
                return user;
            }
        } catch (SQLException e) {

        }
        return null;
    }

    public static UserPo queryUserForLog(String userId, String pwd) {
        Connection con = null;
        PreparedStatement pr = null;
        ResultSet res = null;
        try {
            con = DBUtil.getConnection();
            pr = con.prepareStatement("SELECT * FROM user where user_id=? and pwd=?");
            pr.setLong(1, Long.valueOf(userId));
            pr.setString(2, pwd);
            res = pr.executeQuery();
            if (res.next()) {
                UserPo user=new UserPo();
                user.setUserId(res.getLong(1));
                user.setUserName(res.getString(2));
                user.setPwd(res.getString(3));
                user.setPhone(res.getLong(4));
                user.setEmile(res.getString(5));
                user.setHead_img(queryUserImg(Long.valueOf(userId)));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(res, pr, con);
        }
        return null;
    }
    public static UserPo queryUserForLog_emile(String emile, String pwd) {
        Connection con = null;
        PreparedStatement pr = null;
        ResultSet res = null;
        try {
            con = DBUtil.getConnection();
            pr = con.prepareStatement("SELECT * FROM user where emile=? and pwd=?");
            pr.setString(1,emile);
            pr.setString(2, pwd);
            res = pr.executeQuery();
            if (res.next()) {
                UserPo user=new UserPo();
                user.setUserId(res.getLong(1));
                user.setUserName(res.getString(2));
                user.setPwd(res.getString(3));
                user.setPhone(res.getLong(4));
                user.setEmile(res.getString(5));
                user.setHead_img(queryUserImg(user.getUserId()));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(res, pr, con);
        }
        return null;
    }


    public static void addUser(UserPo user) {
        Connection con = null;
        PreparedStatement pr = null;
        ResultSet res = null;
        try {
            con = DBUtil.getConnection();
            pr = con.prepareStatement("insert into user(username,pwd,phone,emile,registration_time) values " +
                    "(?,?,?,?,?);");
            pr.setString(1, user.getUserName());
            pr.setString(2, user.getPwd());
            pr.setLong(3, user.getPhone());
            pr.setString(4, user.getEmile());
            pr.setTimestamp(5, user.getRegistrationTime());
            pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(res, pr, con);
        }
    }

    public static void ChangeUser(UserPo user,String path) {
        Connection con = null;
        PreparedStatement pr = null;
        ResultSet res = null;
        try {
            con = DBUtil.getConnection();
            pr = con.prepareStatement("UPDATE `user` SET  username = ?, pwd=?, phone=?, emile=?WHERE user_id=?;");
            pr.setString(1, user.getUserName());
            pr.setString(2, user.getPwd());
            pr.setLong(3, user.getPhone());
            pr.setString(4, user.getEmile());
            pr.setLong(5,user.getUserId());
            pr.executeUpdate();
            if(check(user)){
                pr = con.prepareStatement("UPDATE user_head_image SET Path=? WHERE user_id=?;");
                pr.setString(1,path);
                pr.setLong(2,user.getUserId());
                pr.executeUpdate();
            }else {
                pr = con.prepareStatement("INSERT into user_head_image(user_id,Path,insert_time) VALUES (?,?,NOW());");
                pr.setLong(1,user.getUserId());
                pr.setString(2,path);
                pr.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(res, pr, con);
        }
    }
    public static String queryUserImg(Long userId) {
        Connection con = null;
        PreparedStatement pr = null;
        ResultSet res = null;
        try {
            con = DBUtil.getConnection();
            pr = con.prepareStatement("SELECT Path FROM user_head_image WHERE user_id=?");
            pr.setLong(1, Long.valueOf(userId));
            res = pr.executeQuery();
            if (res.next()) {
                return res.getString("path");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(res, pr, con);
        }
        return null;
    }

    public static Boolean check(UserPo user) {
        Connection con = null;
        PreparedStatement pr = null;
        ResultSet res = null;
        try {
            con = DBUtil.getConnection();
            pr = con.prepareStatement("SELECT * FROM user_head_image WHERE user_id=?");
            pr.setLong(1,user.getUserId());
            res = pr.executeQuery();
            if(res.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(res, pr, con);
        }
        return false;
    }

    public static Boolean isExistUsrName(UserPo user) {
        Connection con = null;
        PreparedStatement pr = null;
        ResultSet res = null;
        try {
            con = DBUtil.getConnection();
            pr = con.prepareStatement("SELECT * FROM user WHERE username=?");
            pr.setString(1,user.getUserName());
            res = pr.executeQuery();
            if(res.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(res, pr, con);
        }
        return false;
    }
    public static Boolean isExistPhone(UserPo user) {
        Connection con = null;
        PreparedStatement pr = null;
        ResultSet res = null;
        try {
            con = DBUtil.getConnection();
            pr = con.prepareStatement("SELECT * FROM user WHERE phone=?");
            pr.setLong(1,user.getPhone());
            res = pr.executeQuery();
            if(res.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(res, pr, con);
        }
        return false;
    }
    public static Boolean isExistEmile(UserPo user) {
        Connection con = null;
        PreparedStatement pr = null;
        ResultSet res = null;
        try {
            con = DBUtil.getConnection();
            pr = con.prepareStatement("SELECT * FROM user WHERE emile=?");
            pr.setString(1,user.getEmile());
            res = pr.executeQuery();
            if(res.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(res, pr, con);
        }
        return false;
    }
}

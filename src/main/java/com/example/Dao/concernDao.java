package com.example.Dao;

import com.example.po.UserPo;
import com.example.utile.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class concernDao {
    public static void addConcern(Long userId,long concernId) {
        Connection con = null;
        PreparedStatement pr = null;
        ResultSet res = null;
        try {
            con = DBUtil.getConnection();
            pr = con.prepareStatement("INSERT INTO concern(user_id, cuser_id) VALUES (?, ?);");
            pr.setLong(1, userId);
            pr.setLong(2,concernId);
            pr.executeUpdate();
        } catch (SQLException e) {

        } finally {
            try {
                DBUtil.close(res, pr, con);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void deleteConcern(Long userId,long concernId) {
        Connection con = null;
        PreparedStatement pr = null;
        ResultSet res = null;
        try {
            con = DBUtil.getConnection();
            pr = con.prepareStatement("DELETE FROM concern where user_id=? and cuser_id=?");
            pr.setLong(1, userId);
            pr.setLong(2,concernId);
            pr.executeUpdate();


        } catch (SQLException e) {

        } finally {
            try {
                DBUtil.close(res, pr, con);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static List<UserPo> queryMyConcerns(Long userId) {
        Connection con = null;
        PreparedStatement pr = null;
        ResultSet res = null;
        try {
            con = DBUtil.getConnection();
            pr = con.prepareStatement("SELECT user.* FROM user INNER JOIN concern ON concern.cuser_id=`user`.user_id WHERE concern.user_id=?");
            pr.setLong(1, userId);
            res = pr.executeQuery();

            List<UserPo> list = new ArrayList<>();
            while (res.next()) {
                UserPo concern = new UserPo();
                concern.setUserId(res.getLong("user_id"));
                concern.setUserName(res.getString("username"));
                concern.setPwd(res.getString("pwd"));
                concern.setPhone(res.getLong("phone"));
                concern.setEmile(res.getString("emile"));
                concern.setRegistrationTime(res.getTimestamp("registration_time"));
                list.add(concern);
            }
            if (list.size() > 0) {
                return list;
            }


        } catch (SQLException e) {

        } finally {
            try {
                DBUtil.close(res, pr, con);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static List<UserPo> queryConcerns(Long userId) {
        Connection con = null;
        PreparedStatement pr = null;
        ResultSet res = null;
        try {
            con = DBUtil.getConnection();
            pr = con.prepareStatement("SELECT user.user_id,user.username,user.phone,user.emile FROM user WHERE not EXISTS(SELECT 1 FROM concern WHERE concern.user_id=? and concern.cuser_id=user.user_id) and user.user_id!=?");
            pr.setLong(1, userId);
            pr.setLong(2, userId);
            res = pr.executeQuery();

            List<UserPo> list = new ArrayList<>();
            while (res.next()) {
                UserPo concern = new UserPo();
                concern.setUserId(res.getLong("user.user_id"));
                concern.setUserName(res.getString("user.username"));
                concern.setPhone(res.getLong("user.phone"));
                concern.setEmile(res.getString("user.emile"));
                list.add(concern);
            }
            if (list.size() > 0) {
                return list;
            }


        } catch (SQLException e) {

        } finally {
            try {
                DBUtil.close(res, pr, con);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

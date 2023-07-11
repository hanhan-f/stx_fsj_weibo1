package com.example.Dao;

import com.example.po.UserPo;
import com.example.po.weiboPo;
import com.example.utile.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class weiboDao {

    public static int addWeibo(weiboPo weibo) {
        Connection con = null;
        PreparedStatement pr = null;
        ResultSet res = null;
        try {
            con = DBUtil.getConnection();
            pr = con.prepareStatement("INSERT into weibo(user_id,content,release_time) VALUES (?,?,NOW());", Statement.RETURN_GENERATED_KEYS);
            pr.setLong(1, weibo.getUserId());
            pr.setString(2, weibo.getContent());
            int affectedRows=pr.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet resultSet = pr.getGeneratedKeys()) {
                    if (resultSet.next()) {
                        return resultSet.getInt(1);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(res, pr, con);
        }
        return 0;
    }
    public static void deleteWeibo(Long weiboId) {
        Connection con = null;
        PreparedStatement pr = null;
        ResultSet res = null;
        try {
            con = DBUtil.getConnection();
            pr = con.prepareStatement("DELETE FROM weibo where weibo_id=?");
            pr.setLong(1, weiboId);
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
    public static void addImages(List<String> pathList,long weiboId,long userId) {
        Connection con = null;
        PreparedStatement pr = null;
        ResultSet res = null;
        try {
            con = DBUtil.getConnection();
            for(String path:pathList){
                pr = con.prepareStatement("INSERT INTO imagepath(user_id,weibo_id,Path,insert_time) VALUES (?,?,?,NOW())");
                pr.setLong(1,userId);
                pr.setLong(2,weiboId);
                pr.setString(3,path);
                pr.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(res, pr, con);
        }
    }
    public static List<weiboPo> queryMyWeibo(Long userId) {
        Connection con = null;
        PreparedStatement pr = null;
        ResultSet res = null;
        try {
            con = DBUtil.getConnection();
            pr = con.prepareStatement("SELECT weibo.weibo_id,user.user_id, `user`.username,weibo.content,weibo.release_time  FROM weibo INNER JOIN `user` ON weibo.user_id=`user`.user_id where weibo.user_id=?");
            pr.setLong(1,userId);
            res = pr.executeQuery();
            List<weiboPo> weiboList=new ArrayList<>();
            while (res.next()) {
                weiboPo weibo=new weiboPo();
                weibo.setWeiboId(res.getLong("weibo.weibo_id"));
                weibo.setUserId(res.getLong("user.user_id"));
                weibo.setUsername(res.getString("user.username"));
                weibo.setContent(res.getString("weibo.content"));
                weibo.setReleaseTime(res.getTimestamp("weibo.release_time"));
                List<String> img=weiboDao.queryImages(weibo);
                weibo.setImages(img);
                String userImg=UserDao.queryUserImg(res.getLong("user.user_id"));
                weibo.setUserImage(userImg);
                weiboList.add(weibo);
            }
            if(weiboList.size()!=0){
                return weiboList;
            }
        } catch (SQLException e) {

        }finally {
            try {
                DBUtil.close(res,pr,con);
            }catch (Exception e){

            }
        }
        return null;
    }
    public static List<weiboPo> query() {
        Connection con = null;
        PreparedStatement pr = null;
        ResultSet res = null;
        try {
            con = DBUtil.getConnection();
            pr = con.prepareStatement("SELECT weibo.weibo_id,user.user_id, `user`.username,weibo.content,weibo.release_time  FROM weibo INNER JOIN `user` ON weibo.user_id=`user`.user_id");

            res = pr.executeQuery();
            List<weiboPo> weiboList=new ArrayList<>();
            while (res.next()) {
                weiboPo weibo=new weiboPo();
                weibo.setWeiboId(res.getLong("weibo.weibo_id"));
                weibo.setUserId(res.getLong("user.user_id"));
                weibo.setUsername(res.getString("user.username"));
                weibo.setContent(res.getString("weibo.content"));
                weibo.setReleaseTime(res.getTimestamp("weibo.release_time"));
                List<String> img=weiboDao.queryImages(weibo);
                weibo.setImages(img);
                String userImg=UserDao.queryUserImg(res.getLong("user.user_id"));
                weibo.setUserImage(userImg);
                weiboList.add(weibo);
            }
            if(weiboList.size()!=0){
                return weiboList;
            }
        } catch (SQLException e) {

        }finally {
            try {
                DBUtil.close(res,pr,con);
            }catch (Exception e){

            }
        }
        return null;
    }
    public static List<String> queryImages(weiboPo weibo){
        Connection con = null;
        PreparedStatement pr = null;
        ResultSet res = null;
        try {
            con = DBUtil.getConnection();
            pr=con.prepareStatement("SELECT Path FROM imagepath WHERE weibo_id=?");
            pr.setLong(1,weibo.getWeiboId());
            res = pr.executeQuery();
            List<String> imgs = new ArrayList<>();
            while (res.next()) {
                imgs.add(res.getString("path"));
            }
            return imgs;
        }catch (Exception e){

        }finally {
            try {
                DBUtil.close(res,pr,con);
            }catch (Exception e){

            }
        }
        return null;
    }
}

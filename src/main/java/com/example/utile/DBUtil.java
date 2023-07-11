package com.example.utile;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;


public class DBUtil {
    private static String CONN_URI= null;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Properties p = new Properties();
            InputStream configStream= DBUtil.class.getResourceAsStream("/jdbc.properties");
            p.load(configStream);
            String jdbcUrl = (String)p.get("jdbcUrl");
            String userName = (String)p.get("userName");
            String password = (String)p.get("password");
            CONN_URI = String.format("%s?user=%s&password=%s", jdbcUrl, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(CONN_URI);
    }

    public static void close(ResultSet res,Statement pr,Connection con){
        try{
            if(res!=null){
                res.close();
            }
            if(pr!=null){
                pr.close();
            }
            if(con!=null){
                con.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

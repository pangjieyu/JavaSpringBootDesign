package com.exercise.mysys.service;
import com.exercise.mysys.domain.goodandstore;
import com.exercise.mysys.domain.orderUserCustomGood;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class findServices {
    public static ArrayList<goodandstore> findGood(String name) {
        ArrayList<goodandstore> list = new ArrayList<>();

        Connection con = null ;

        Statement stmt = null ;
        try {
            System.out.println("enter");
            Class.forName("com.mysql.jdbc.Driver");   //mysql为例 不一样的数据库所需的驱动包不一样 连接语句略有不同
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sqlDesign?useUnicode=true&characterEncoding=utf-8", "root", "pangjieyu");
            stmt = con.createStatement();
            String sql2="select x.id,x.in_id,x.in_time,x.number,x.position,y.name from\n" +
                    "store as x,good as y\n" +
                    "where x.id=y.id and y.name like '%"+name+"%'";
            ResultSet rs = stmt.executeQuery(sql2);
            while(rs.next())
            {
                goodandstore tem = new goodandstore();
                tem.id = rs.getString(1);
                tem.in_id = rs.getString(2);
                tem.in_time = rs.getString(3);
                tem.number = rs.getString(4);
                tem.position = rs.getString(5);
                tem.good_name = rs.getString(6);
                list.add(tem);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
            return null;
        }
        return list;
    }
    public static ArrayList<goodandstore> findGood()
    {
        ArrayList<goodandstore> list = new ArrayList<>();
        Connection con = null ;

        Statement stmt = null ;
        try {
            System.out.println("enter");
            Class.forName("com.mysql.jdbc.Driver");   //mysql为例 不一样的数据库所需的驱动包不一样 连接语句略有不同
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sqlDesign", "root", "pangjieyu");
            stmt = con.createStatement();
            String sql2="select x.id,x.in_id,x.in_time,x.number,x.position,y.name from\n" +
                    "store as x,good as y\n" +
                    "where x.id=y.id";
            ResultSet rs = stmt.executeQuery(sql2);
            while(rs.next())
            {
                goodandstore tem = new goodandstore();
                tem.id = rs.getString(1);
                tem.in_id = rs.getString(2);
                tem.in_time = rs.getString(3);
                tem.number = rs.getString(4);
                tem.position = rs.getString(5);
                tem.good_name = rs.getString(6);
                list.add(tem);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
            return null;
        }
        return list;
    }

    public static ArrayList<orderUserCustomGood> findOrder(String customName, String sysUserName) {
        ArrayList<orderUserCustomGood> list = new ArrayList<>();

        return list;
    }
}

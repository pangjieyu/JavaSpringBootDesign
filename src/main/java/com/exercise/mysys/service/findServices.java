package com.exercise.mysys.service;
import com.exercise.mysys.domain.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class findServices {
    private static String password = "123456789";

    public static ArrayList<goodandstore> findGood(String name, String inId) {

        ArrayList<goodandstore> list = new ArrayList<>();

        Connection con = null ;

        Statement stmt = null ;
        try {
            System.out.println("enter");
            Class.forName("com.mysql.jdbc.Driver");   //mysql为例 不一样的数据库所需的驱动包不一样 连接语句略有不同
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sqlDesign?useUnicode=true&characterEncoding=utf-8", "root", password);
            stmt = con.createStatement();
            //查询结果显示编号
            String sql2="select x.good_id,x.in_id,x.in_time,x.number,x.position,y.name,x.id from\n" +
                    "store as x,good as y\n" +
                    "where x.good_id=y.id ";
            if (!name.equals(""))
            {
                sql2 += "and y.name like '%" + name + "%'";
            }
            if (!inId.equals(""))
            {
                sql2 += "and x.in_id like '%" + inId + "%'";
            }
            ResultSet rs = stmt.executeQuery(sql2);
            while(rs.next())
            {
                goodandstore tem = new goodandstore();
                tem.id = rs.getString(1);
                tem.in_id = rs.getString(2);
                tem.in_time = rs.getString(3);
                tem.formatdate = tem.in_time.substring(0,10);
                tem.number = rs.getString(4);
                tem.position = rs.getString(5);
                tem.good_name = rs.getString(6);
                tem.id = rs.getString(7);
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

    public static ArrayList<goodandstore> findGood(String name) {

        ArrayList<goodandstore> list = new ArrayList<>();

        Connection con = null ;

        Statement stmt = null ;
        try {
            System.out.println("enter");
            Class.forName("com.mysql.jdbc.Driver");   //mysql为例 不一样的数据库所需的驱动包不一样 连接语句略有不同
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sqlDesign?useUnicode=true&characterEncoding=utf-8", "root", password);
            stmt = con.createStatement();
            //查询结果显示编号
            String sql2="select x.good_id,x.in_id,x.in_time,x.number,x.position,y.name,x.id from\n" +
                    "store as x,good as y\n" +
                    "where x.good_id=y.id and y.name like '%"+name+"%'";
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
                tem.id = rs.getString(7);
                tem.formatdate = tem.in_time.substring(0,10);
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
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sqlDesign?useUnicode=true&characterEncoding=utf-8", "root", password);
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
                tem.formatdate = tem.in_time.substring(0,10);
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
    //查询订货单
    //格式化日期
    public static ArrayList<orderUserCustomGood> findOrder(String customName, String sysUserName) {
        ArrayList<orderUserCustomGood> list = new ArrayList<>();

        Connection con = null ;

        Statement stmt = null ;
        try {
            Class.forName("com.mysql.jdbc.Driver");   //mysql为例 不一样的数据库所需的驱动包不一样 连接语句略有不同
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sqlDesign?useUnicode=true&characterEncoding=utf-8", "root", password);
            stmt = con.createStatement();
            //查询结果显示编号
            String sql2="select x.name, y.name, z.name, hh.deposit, hh.money, hh.number," +
                    "hh.effective, hh.create_date, hh.payment, hh.id from\n" +
                    "order_good as hh, good as x, customer as y, sys_user as z\n" +
                    "where hh.good_id=x.id and hh.customer_id = y.id and hh.employee_id = z.id ";
            if (!customName.equals(""))
            {
                sql2 += "and y.name like '%" + customName + "%'";
            }
            if (!sysUserName.equals(""))
            {
                sql2 += "and z.name like '%" + sysUserName + "%'";
            }
            ResultSet rs = stmt.executeQuery(sql2);
            while(rs.next())
            {
                orderUserCustomGood tem = new orderUserCustomGood();
                tem.good_name = rs.getString(1);
                tem.customer_name = rs.getString(2);
                tem.employee_name = rs.getString(3);
                tem.deposit = rs.getString(4);
                tem.money = rs.getString(5);
                tem.number = rs.getString(6);
                tem.effective = rs.getString(7);
                tem.create_date = rs.getString(8);
                tem.payment = rs.getString(9);
                tem.id = rs.getString(10);
                tem.formatdate = tem.create_date.substring(0,10);
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
    //查询退货单
    //格式化日期
    public static ArrayList<returnGoodResult> findReturn(String customName, String sysUserName) {
        ArrayList<returnGoodResult> list = new ArrayList<>();

        Connection con = null ;

        Statement stmt = null ;
        try {
            Class.forName("com.mysql.jdbc.Driver");   //mysql为例 不一样的数据库所需的驱动包不一样 连接语句略有不同
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sqlDesign?useUnicode=true&characterEncoding=utf-8", "root", password);
            stmt = con.createStatement();
            //查询结果显示编号
            String sql2="select x.name, y.name, z.name, hh.money, hh.number," +
                    "hh.effective, hh.createdate, hh.id from\n" +
                    "return_good as hh, good as x, customer as y, sys_user as z\n" +
                    "where hh.good_id=x.id and hh.customer_id = y.id and hh.employee_id = z.id ";
            if (!customName.equals(""))
            {
                sql2 += "and y.name like '%" + customName + "%'";
            }
            if (!sysUserName.equals(""))
            {
                sql2 += "and z.name like '%" + sysUserName + "%'";
            }
            ResultSet rs = stmt.executeQuery(sql2);
            while(rs.next())
            {
                returnGoodResult tem = new returnGoodResult();
                tem.good_name = rs.getString(1);
                tem.customer_name = rs.getString(2);
                tem.employee_name = rs.getString(3);
                tem.money = rs.getString(4);
                tem.number = rs.getString(5);
                tem.effective = rs.getString(6);
                tem.create_date = rs.getString(7);
                tem.id = rs.getString(8);
                tem.formatdate = tem.create_date.substring(0,10);
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
    //插叙提货单
    //格式化日期
    public static ArrayList<pickGoodResult> findPick(String customName, String sysUserName) {
        ArrayList<pickGoodResult> list = new ArrayList<>();

        Connection con = null ;

        Statement stmt = null ;
        try {
            Class.forName("com.mysql.jdbc.Driver");   //mysql为例 不一样的数据库所需的驱动包不一样 连接语句略有不同
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sqlDesign?useUnicode=true&characterEncoding=utf-8", "root", password);
            stmt = con.createStatement();
            //结果显示编号
            String sql2="select x.name, y.name, z.name, hh.section, hh.number," +
                    "hh.effective, hh.create_date, hh.id from\n" +
                    "pick as hh, good as x, customer as y, sys_user as z\n" +
                    "where hh.good_id=x.id and hh.customer_id = y.id and hh.employee_id = z.id ";
            if (!customName.equals(""))
            {
                sql2 += "and y.name like '%" + customName + "%'";
            }
            if (!sysUserName.equals(""))
            {
                sql2 += "and z.name like '%" + sysUserName + "%'";
            }
            ResultSet rs = stmt.executeQuery(sql2);
            while(rs.next())
            {
                pickGoodResult tem = new pickGoodResult();
                tem.good_name = rs.getString(1);
                tem.customer_name = rs.getString(2);
                tem.employee_name = rs.getString(3);
                tem.section = rs.getString(4);
                tem.number = rs.getString(5);
                tem.effective = rs.getString(6);
                tem.create_date = rs.getString(7);
                tem.id = rs.getString(8);
                //2018-07-23 00:00:00.0
                tem.formatdate = tem.create_date.substring(0,10);
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
    //查询生产计划
    //格式化日期
    public static ArrayList<manufacturePlanResult> findManufacturePlan(String goodName, String manufactureDate) {
        ArrayList<manufacturePlanResult> list = new ArrayList<>();

        Connection con = null ;

        Statement stmt = null ;
        try {
            Class.forName("com.mysql.jdbc.Driver");   //mysql为例 不一样的数据库所需的驱动包不一样 连接语句略有不同
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sqlDesign?useUnicode=true&characterEncoding=utf-8", "root", password);
            stmt = con.createStatement();
            //查询结果显示编号
            String sql2="select x.name, y.name, hh.number, hh.money," +
                    "hh.effective, hh.manufacture_date, hh.id from\n" +
                    "manufacture_plan as hh, good as x, sys_user as y\n" +
                    "where hh.good_id=x.id and hh.employee_id = y.id ";
            if (!goodName.equals(""))
            {
                sql2 += "and x.name like '%" + goodName + "%'";
            }
            if (!manufactureDate.equals(""))
            {
                sql2 += "and hh.manufacture_date like '%" + manufactureDate + "%'";
            }
            ResultSet rs = stmt.executeQuery(sql2);
            while(rs.next())
            {
                manufacturePlanResult tem = new manufacturePlanResult();
                tem.good_name = rs.getString(1);
                tem.employee_name = rs.getString(2);
                tem.number = rs.getString(3);
                tem.money = rs.getString(4);
                tem.effective = rs.getString(5);
                tem.manufacture_date = rs.getString(6);
                tem.id = rs.getString(7);
                tem.formatdate = tem.manufacture_date.substring(0,10);
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
    //查询凭证
    public static ArrayList<voucherResult> findVoucher(String customerName, String type) {
        ArrayList<voucherResult> list = new ArrayList<>();

        Connection con = null ;

        Statement stmt = null ;
        try {
            Class.forName("com.mysql.jdbc.Driver");   //mysql为例 不一样的数据库所需的驱动包不一样 连接语句略有不同
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sqlDesign?useUnicode=true&characterEncoding=utf-8", "root", password);
            stmt = con.createStatement();
            //查询结果显示编号
            String sql2="select x.name, hh.money," +
                    "hh.effective, hh.receivable, hh.type, hh.id from\n" +
                    "voucher as hh, customer as x\n" +
                    "where hh.customer_id=x.id ";
            if (!customerName.equals(""))
            {
                sql2 += "and x.name like '%" + customerName + "%'";
            }
            if (!type.equals(""))
            {
                sql2 += "and hh.type like '%" + type + "%'";
            }
            ResultSet rs = stmt.executeQuery(sql2);
            while(rs.next())
            {
                voucherResult tem = new voucherResult();
                tem.customer_name = rs.getString(1);
                tem.money = rs.getString(2);
                tem.effective = rs.getString(3);
                tem.receivable = rs.getString(4);
                tem.type = rs.getString(5);
                tem.id = rs.getString(6);
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
    //查询入库单
    //格式化日期
    public static ArrayList<ruKuResult> findRuKu(String employeeName, String goodName, String inDate) {
        ArrayList<ruKuResult> list = new ArrayList<>();

        Connection con = null ;

        Statement stmt = null ;
        try {
            Class.forName("com.mysql.jdbc.Driver");   //mysql为例 不一样的数据库所需的驱动包不一样 连接语句略有不同
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sqlDesign?useUnicode=true&characterEncoding=utf-8", "root", password);
            stmt = con.createStatement();
            //查询结果显示编号
            String sql2="select x.name, y.name, hh.in_date," +
                    "hh.number, hh.id from\n" +
                    "in_ku as hh, sys_user as x, good as y\n" +
                    "where hh.employee_id=x.id and hh.good_id=y.id ";
            if (!employeeName.equals(""))
            {
                sql2 += "and x.name like '%" + employeeName + "%'";
            }
            if (!goodName.equals(""))
            {
                sql2 += "and y.name like '%" + goodName + "%'";
            }
            if (!inDate.equals(""))
            {
                sql2 += "and hh.in_date like '%" + inDate + "%'";
            }
            ResultSet rs = stmt.executeQuery(sql2);
            while(rs.next())
            {
                ruKuResult tem = new ruKuResult();
                tem.employee_name = rs.getString(1);
                tem.good_name = rs.getString(2);
                tem.in_date = rs.getString(3);
                tem.number = rs.getString(4);
                tem.id = rs.getString(5);
                tem.formatdate = tem.in_date.substring(0,10);
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
    //查询出库单
    //格式化日期
    public static ArrayList<chuKuResult> findChuKu(String employeeName, String goodName, String outDate) {
        ArrayList<chuKuResult> list = new ArrayList<>();

        Connection con = null ;

        Statement stmt = null ;
        try {
            Class.forName("com.mysql.jdbc.Driver");   //mysql为例 不一样的数据库所需的驱动包不一样 连接语句略有不同
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sqlDesign?useUnicode=true&characterEncoding=utf-8", "root", password);
            stmt = con.createStatement();
            //查询结果显示编号
            String sql2="select x.name, y.name, hh.out_date," +
                    "hh.number, hh.id from\n" +
                    "out_ku as hh, sys_user as x, good as y\n" +
                    "where hh.employee_id=x.id and hh.good_id=y.id ";
            if (!employeeName.equals(""))
            {
                sql2 += "and x.name like '%" + employeeName + "%'";
            }
            if (!goodName.equals(""))
            {
                sql2 += "and y.name like '%" + goodName + "%'";
            }
            if (!outDate.equals(""))
            {
                sql2 += "and hh.out_date like '%" + outDate + "%'";
            }
            ResultSet rs = stmt.executeQuery(sql2);
            while(rs.next())
            {
                chuKuResult tem = new chuKuResult();
                tem.employee_name = rs.getString(1);
                tem.good_name = rs.getString(2);
                tem.out_date = rs.getString(3);
                tem.number = rs.getString(4);
                tem.id = rs.getString(5);
                tem.formatdate = tem.out_date.substring(0,10);
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
}
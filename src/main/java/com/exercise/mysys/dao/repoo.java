package com.exercise.mysys.dao;
import com.exercise.mysys.domain.Customer;
import com.exercise.mysys.domain.ReturnGood;

import javax.persistence.Query;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class repoo {
    public static List<temp> fi()
    {
//        List<temp> list=new List<>();
        ArrayList<temp> list = new ArrayList<temp>();
        Connection con = null ;

        Statement stmt = null ;
        try {
            System.out.println("enter");
            Class.forName("com.mysql.jdbc.Driver");   //mysql为例 不一样的数据库所需的驱动包不一样 连接语句略有不同
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/usr", "root", "123456");
            stmt = con.createStatement();
            String sql2="select x.id,x.in_id,x.in_time,x.number,x.position,y.name from\n" +
                    "store as x,good as y\n" +
                    "where x.id=y.id";
            ResultSet rs = stmt.executeQuery(sql2);
            while(rs.next())
            {
                temp tem = new temp();
                tem.id = rs.getString(1);
                tem.in_id = rs.getString(2);
                tem.in_time = rs.getString(3);
                tem.number = rs.getString(4);
                tem.position = rs.getString(5);
                tem.name = rs.getString(6);
                System.out.println(tem.name);
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

package oop.b;

import jdk.nashorn.internal.runtime.regexp.joni.Config;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * TBDIPDI  数据解析 已MR001为例。
 * 1、查询TBDIPDI的第一条数据
 * 2、判断data内容中的前五位字符串内容
 * 3、对不同的表执行对应的insert into操作
 * 4、将 description数据插入MESSAGE_UUID
 * 疑问：
 * 1、没有加入插入时间
 */
public  class InsertTimeIntoDbTable {
       public   void conDb() {
            String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=SIPM;user=sa;password=Sipm@123";//sa身份连接
            Connection con = null; //数据库连接对象

        try {
            Config.log.println("日志输出");
                System.out.println("开始连接数据库");
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection(url);
                System.out.println("数据库连接成功，接下来执行SQL语句");
                long  num1=Runtime.getRuntime().freeMemory();
                Long  time1=System.currentTimeMillis();
                for (int i=1;i<10;i++) {
                    String SQL = "insert into mmf.test1_RECEIVE_FROM_L3_MR201(CREATED_TIME,UPDATED_TIME,timestamp)values (?,?,?)"; //查询语句
                    PreparedStatement preStst = con.prepareStatement(SQL);
                    preStst.setDate(1, Date.valueOf(LocalDate.now()));//插入当前日期{数据库列类型 date}
                    preStst.setTime(2, Time.valueOf(LocalTime.now()));//插入当前时间{数据库列类型time}
                    preStst.setString(3, String.valueOf(System.currentTimeMillis()));//插入字符串格式的时间戳{数据库列类型varchar}
                    preStst.executeUpdate();
                }
  //              rs.close();
    //            preStst.close();
                   con.close();
            long  num2=Runtime.getRuntime().freeMemory();
            Long  time2=System.currentTimeMillis();
            System.out.println("内存消耗：" +(num1-num2)/1000000+"MB");
            System.out.println("时间消耗："+(time2-time1)+"毫秒");
            }
            // Handle any errors that may have occurred.
            catch (Exception e) {
                e.printStackTrace();
       } finally {
//                if (rs != null)
//                    try {
//                        rs.close();
//                        System.out.println(" ");
//                    } catch (Exception e) {
//                    }
//                if (stmt != null)
//                    try {
//                        stmt.close();
//                    } catch (Exception e) {
//                    }
                if (con != null)
                    try {
                        con.close();
                    } catch (Exception e) {
                    }

            }
        }

    public static void main(String[] args) {
        InsertTimeIntoDbTable Db= new InsertTimeIntoDbTable();
        Db.conDb();
    }
    }



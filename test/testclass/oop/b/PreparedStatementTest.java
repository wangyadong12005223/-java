package oop.b;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * TBDIPDI  数据解析 已MR001为例。
 * 1、查询TBDIPDI的第一条数据
 * 2、判断data内容中的前五位字符串内容
 * 3、对不同的表执行对应的insert into操作
 * 4、将 description数据插入MESSAGE_UUID
 * 5、data为可变长度，MR001接口可以直接截取，MR201不可直接数字截取
 * 6、
 *
 *
 *
 */
public class PreparedStatementTest {
    public static void main(String[] args) {
        Timer t = new Timer(); // 建立Timer对象
        MyTask task = new MyTask(); //定义任务
        t.schedule(task, 1000,10000);//设置任务的执行，1秒后开始，每2秒执行一次

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MINUTE, 30);

        t.schedule(task, cal.getTime() , 10000);
//        String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=SIPM;user=sa;password=Sipm@123";//sa身份连接
//        String user = "sa";
//        String password = "Sipm@123";
//        Connection connection =null;
//        try {
//            System.out.println("开始连接数据库");
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            connection = DriverManager.getConnection(url,user,password);
//            System.out.println("数据库连接成功，接下来执行SQL语句");
//            String SQL = "select  * from mmf.TBDIPDI where STATUS='N'"; //查询语句
//            PreparedStatement preStst = connection.prepareStatement(SQL);
//            ResultSet rs= preStst.executeQuery();
//            java.util.Date date = new java.util.Date();   // 获取当前时间
//            java.sql.Date sql_date = new java.sql.Date(date.getTime()); //转换成java.sql.Date
//            while (rs.next()) {
//                String data = rs.getNString(5);
////                String status=rs.getString(6);
////                String proessTime=rs.getString(7);
//                String description = rs.getString(8);
//                if ("MR001".equals(data.substring(0, 5))) {
//                    System.out.println(data);
//                    System.out.println(data.length());
//                    System.out.println(data.substring(0, 5));  //FORMID	传送代号	    5
//                    System.out.println(data.substring(5, 6)); //INPUTCODE	输入代码	1
//                    System.out.println(data.substring(6, 15).trim()); //MTRLNO		  物料编码  40
//                    System.out.println(data.substring(46, 86).trim()); //CNMDESC	物料名称	    40
//                String d1=data.substring(0,5); //FORMID	传送代号	    5
//                String d2=data.substring(5,6); //INPUTCODE	输入代码
//                String d3=data.substring(6,15).trim(); //MTRLNO		  物料编码  40
//                String d4=data.substring(46,86).trim(); //CNMDESC	物料名称	    40
//              String SQL1="insert into mmf.test_FROM_L3_MR001(MESSAGE_UUID,CREATED_TIME,FORMID, INPUTCODE ,MTRLNO,CNMDESC) values (?,?,?,?,?,?)";
////                stmt1.executeUpdate(SQL1);
//                    PreparedStatement preStst1 = connection.prepareStatement(SQL1);
//                    preStst1.setString(1,description);
//                    preStst1.setDate(2,sql_date);
//                    preStst1.setString(3,d1);
//                    preStst1.setString(4,d2);
//                    preStst1.setString(5,d3);
//                    preStst1.setString(6,d4);
//                    preStst1.executeUpdate();
//                }
//                if (("MR201".equals(data.substring(0, 5)))) {
//                    System.out.println(data);
//                    System.out.println(data.length());
//                    System.out.println(data.substring(0, 5));  //FORMID	传送代号	    5 √
//                    System.out.println(data.substring(5, 6)); //INPUTCODE	输入代码	1 √
//                    System.out.println(data.substring(6, 36)); //UNLOADPLANNO   卸船计划40√
//                    System.out.println(data.substring(36, 76)); //PONO	订单号	    40
//                    System.out.println(data.substring(76, 116));  //物料编码	MTRLNO	VC(40)
//                    System.out.println(data.substring(116, 124)); //计划开始日期	PLANBEGINDATE	VC(8)
//                    System.out.println(data.substring(124, 130)); //计划开始时间	PLANBEGINTIME	VC(6)
//                    System.out.println(data.substring(130, 138)); //计划结束日期	PLANENDDATE	VC(8)
//                    System.out.println(data.substring(138, 144));  //计划结束时间	PLANENDTIME	VC(6)
//                    System.out.println(data.substring(144, 146));   //物流类型	LOGISTYPE	VC(2)
//                    System.out.println(data.substring(146, 196));   //供应商/客户	CUSTOM	VC(50)	50	SAP供应商/客户编号(采购/销售必须)
//                    System.out.println(data.substring(196, 216));    //装货地点	FROMID	VC(20)	20	必须为库存地点代码
//                    System.out.println(data.substring(216, 236)); //卸货地点	TOID	VC(20)	20	必须为库存地点代码
//                    System.out.println(data.substring(236, 238));   //运输方式	TRANSTYPE	VC(2)	2	B：汽运
//                    System.out.println(data.substring(238, 258));  //计划重量	PLANWEIGHTNUM	BD(19,4)	20
//                    System.out.println(data.substring(258, 259));  //类型	TYPE	VC(1)	1
//                    System.out.println(data.substring(259, 279)); //新增人员	CREEMPNO	VC(20)
//                    System.out.println(data.substring(279, 287)); //新增日期	CREDATE	VC(8)
//                    System.out.println(data.substring(287, 293)); //新增时间	CRETIME	VC(6)
//                    String sql ="insert into mmf.test_RECEIVE_FROM_L3_MR201 (MESSAGE_UUID,FOMRID,INPUTCODE,UNLOADPLANNO,PONO,MTRLNO,PLANBEGINDATE,PLANBEGINTIME,PLANENDDATE,PLANENDTIME,LOGISTYPE,CUSTOM,FROMID,TOID,TRANSTYPE,PLANWEIGHTNUM,STYPE,CREEMPNO,CREDATE,CRETIME) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//                    PreparedStatement preStst1 = connection.prepareStatement(sql);
//                     String d0=data.substring(0, 5);
//                    String	d1	=	data.substring(5, 6);
//                    String	d2	=	data.substring(6, 36);
//                    String	d3	=	data.substring(36, 76);
//                    String	d4	=	data.substring(76, 116);
//                    String	d5	=	data.substring(116, 124)	;
//                    String	d6	=	data.substring(124, 130)	;
//                    String	d7	=	data.substring(130, 138)	;
//                    String	d8	=	data.substring(138, 144)	;
//                    String	d9	=	data.substring(144, 146)	;
//                    String	d10	=	data.substring(146, 196)	;
//                    String	d11	=	data.substring(196, 216)	;
//                    String	d12	=	data.substring(216, 236)	;
//                    String	d13	=	data.substring(236, 238)	;
//                    String	d14	=	data.substring(238, 258)	;
//                    String	d15	=	data.substring(258, 259)	;
//                    String	d16	=	data.substring(259, 279)	;
//                    String	d17	=	data.substring(279, 287)	;
//                    String	d18	=	data.substring(287, 293)	;
//                    preStst1.setString	(1,description);
//                    preStst1.setString	(2,d0	);
//                    preStst1.setString	(3,d1	);
//                    preStst1.setString	(4,d2	);
//                    preStst1.setString	(5,d3	);
//                    preStst1.setString	(6,d4	);
//                    preStst1.setString	(7,d5	);
//                    preStst1.setString	(8,d6	);
//                    preStst1.setString	(9,d7	);
//                    preStst1.setString	(10,d8)	;
//                    preStst1.setString	(11,d9);
//                    preStst1.setString	(12,d10);
//                    preStst1.setString	(13,d11);
//                    preStst1.setString	(14,d12);
//                    preStst1.setString	(15,d13);
//                    preStst1.setString	(16,d14);
//                    preStst1.setString	(17,d15);
//                    preStst1.setString	(18,d16);
//                    preStst1.setString	(19,d17);
//                    preStst1.setString	(20,d18);
//                    preStst1.executeUpdate();
//                }
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


    }
    public static class MyTask extends TimerTask
    {

        @Override
        public void run()
        {
            SimpleDateFormat sdf = null;
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            System.out.println("当前时间：" + sdf.format(new Date()));
            String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=SIPM;user=sa;password=Sipm@123";//sa身份连接
            String user = "sa";
            String password = "Sipm@123";
            Connection connection =null;
            try {
                System.out.println("开始连接数据库");
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                connection = DriverManager.getConnection(url,user,password);
                System.out.println("数据库连接成功，接下来执行SQL语句");
                String SQL = "select  * from mmf.TBDIPDI where STATUS='N'"; //查询语句
                PreparedStatement preStst = connection.prepareStatement(SQL);
                ResultSet rs= preStst.executeQuery();
                java.util.Date date = new java.util.Date();   // 获取当前时间
                java.sql.Date sql_date = new java.sql.Date(date.getTime()); //转换成java.sql.Date
                while (rs.next()) {
                    String data = rs.getNString(5);
//                String status=rs.getString(6);
//                String proessTime=rs.getString(7);
                    String description = rs.getString(8);
                    int i=rs.getString(8).length();
                    if ("MR001".equals(data.substring(0, 5))) {
                        System.out.println(data);
                        System.out.println(data.length());
                        System.out.println(data.substring(0, 5));  //FORMID	传送代号	    5
                        System.out.println(data.substring(5, 6)); //INPUTCODE	输入代码	1
                        System.out.println(data.substring(6, 15).trim()); //MTRLNO		  物料编码  40
                        System.out.println(data.substring(46, 86).trim()); //CNMDESC	物料名称	    40
                        String d1=data.substring(0,5); //FORMID	传送代号	    5
                        String d2=data.substring(5,6); //INPUTCODE	输入代码
                        String d3=data.substring(6,15).trim(); //MTRLNO		  物料编码  40
                        String d4=data.substring(46,86).trim(); //CNMDESC	物料名称	    40
                        String SQL1="insert into mmf.test_FROM_L3_MR001(MESSAGE_UUID,CREATED_TIME,FORMID, INPUTCODE ,MTRLNO,CNMDESC) values (?,?,?,?,?,?)";
//                stmt1.executeUpdate(SQL1);
                        PreparedStatement preStst1 = connection.prepareStatement(SQL1);
                        preStst1.setString(1,description);
                        preStst1.setDate(2,sql_date);
                        preStst1.setString(3,d1);
                        preStst1.setString(4,d2);
                        preStst1.setString(5,d3);
                        preStst1.setString(6,d4);
                        preStst1.executeUpdate();
                    }
                    if (("MR201".equals(data.substring(0, 5)))) {
                        System.out.println(data);
                        System.out.println(data.length());
                        System.out.println(data.substring(0, 5));  //FORMID	传送代号	    5 √
                        System.out.println(data.substring(5, 6)); //INPUTCODE	输入代码	1 √
                        System.out.println(data.substring(6, 36)); //UNLOADPLANNO   卸船计划40√
                        System.out.println(data.substring(36, 76)); //PONO	订单号	    40
                        System.out.println(data.substring(76, 116));  //物料编码	MTRLNO	VC(40)
                        System.out.println(data.substring(116, 124)); //计划开始日期	PLANBEGINDATE	VC(8)
                        System.out.println(data.substring(124, 130)); //计划开始时间	PLANBEGINTIME	VC(6)
                        System.out.println(data.substring(130, 138)); //计划结束日期	PLANENDDATE	VC(8)
                        System.out.println(data.substring(138, 144));  //计划结束时间	PLANENDTIME	VC(6)
                        System.out.println(data.substring(144, 146));   //物流类型	LOGISTYPE	VC(2)
                        System.out.println(data.substring(146, 196));   //供应商/客户	CUSTOM	VC(50)	50	SAP供应商/客户编号(采购/销售必须)
                        System.out.println(data.substring(196, 216));    //装货地点	FROMID	VC(20)	20	必须为库存地点代码
                        System.out.println(data.substring(216, 236)); //卸货地点	TOID	VC(20)	20	必须为库存地点代码
                        System.out.println(data.substring(236, 238));   //运输方式	TRANSTYPE	VC(2)	2	B：汽运
                        System.out.println(data.substring(238, 258));  //计划重量	PLANWEIGHTNUM	BD(19,4)	20
                        System.out.println(data.substring(258, 259));  //类型	TYPE	VC(1)	1
                        System.out.println(data.substring(259, 279)); //新增人员	CREEMPNO	VC(20)
                        System.out.println(data.substring(279, 287)); //新增日期	CREDATE	VC(8)
                        System.out.println(data.substring(287, 293)); //新增时间	CRETIME	VC(6)
                        String sql ="insert into mmf.test_RECEIVE_FROM_L3_MR201 (MESSAGE_UUID,FOMRID,INPUTCODE,UNLOADPLANNO,PONO,MTRLNO,PLANBEGINDATE,PLANBEGINTIME,PLANENDDATE,PLANENDTIME,LOGISTYPE,CUSTOM,FROMID,TOID,TRANSTYPE,PLANWEIGHTNUM,STYPE,CREEMPNO,CREDATE,CRETIME) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                        PreparedStatement preStst1 = connection.prepareStatement(sql);
                        String d0=data.substring(0, 5);
                        String	d1	=	data.substring(5, 6);
                        String	d2	=	data.substring(6, 36);
                        String	d3	=	data.substring(36, 76);
                        String	d4	=	data.substring(76, 116);
                        String	d5	=	data.substring(116, 124)	;
                        String	d6	=	data.substring(124, 130)	;
                        String	d7	=	data.substring(130, 138)	;
                        String	d8	=	data.substring(138, 144)	;
                        String	d9	=	data.substring(144, 146)	;
                        String	d10	=	data.substring(146, 196)	;
                        String	d11	=	data.substring(196, 216)	;
                        String	d12	=	data.substring(216, 236)	;
                        String	d13	=	data.substring(236, 238)	;
                        String	d14	=	data.substring(238, 258)	;
                        String	d15	=	data.substring(258, 259)	;
                        String	d16	=	data.substring(259, 279)	;
                        String	d17	=	data.substring(279, 287)	;
                        String	d18	=	data.substring(287, 293)	;
                        preStst1.setString	(1,description);
                        preStst1.setString	(2,d0	);
                        preStst1.setString	(3,d1	);
                        preStst1.setString	(4,d2	);
                        preStst1.setString	(5,d3	);
                        preStst1.setString	(6,d4	);
                        preStst1.setString	(7,d5	);
                        preStst1.setString	(8,d6	);
                        preStst1.setString	(9,d7	);
                        preStst1.setString	(10,d8)	;
                        preStst1.setString	(11,d9);
                        preStst1.setString	(12,d10);
                        preStst1.setString	(13,d11);
                        preStst1.setString	(14,d12);
                        preStst1.setString	(15,d13);
                        preStst1.setString	(16,d14);
                        preStst1.setString	(17,d15);
                        preStst1.setString	(18,d16);
                        preStst1.setString	(19,d17);
                        preStst1.setString	(20,d18);
                        preStst1.executeUpdate();
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
       } catch (SQLException e) {
             e.printStackTrace();
            }
        }
    }
}


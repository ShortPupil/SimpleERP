package databaseutil;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DatabaseConnection {
	private static String mysqlDriver;
	private static String url;
	private static String user;
	private static String password;

	//获取数据库连接
	public static Connection getConn(){
		Connection conn=null;
		try {
			InputStream is=DatabaseConnection.class.getResourceAsStream("/db.properties");
			Properties ps=new Properties();
			ps.load(is);
			url=ps.getProperty("url");
			user=ps.getProperty("user");
			password=ps.getProperty("password");
			mysqlDriver=ps.getProperty("driverClass");
			Class.forName(mysqlDriver);
			conn= DriverManager.getConnection(url, user, password);
			//if(conn != null) System.out.println("成功连接");
		}  catch(ClassNotFoundException e) {   
            //数据库驱动类异常处理
            System.out.println("数据库连接失败1");   
            e.printStackTrace();   
            } catch(SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();  
            System.out.println("数据库连接失败2");
            }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            System.out.println("数据库连接失败3");
        }
		return conn;
	}
	
	//关闭资源
	public static void close(Object...objs){
		if(objs!=null&&objs.length>0){
			for(int i=0;i<objs.length;i++){
				try {
					if(objs[i] instanceof DatabaseConnection){
						((Connection)objs[i]).close();
					}else if(objs[i] instanceof PreparedStatement){
						((PreparedStatement)objs[i]).close();
					}else if(objs[i] instanceof ResultSet){
						((ResultSet)objs[i]).close();
					}
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("关闭资源 异常");
				}
			}
		}
	}

}

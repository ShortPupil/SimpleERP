package databaseutil;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DatabaseConnection {
	private static String mysqlDriver;
	private static String url;
	private static String user;
	private static String password;

	//��ȡ���ݿ�����
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
			//if(conn != null) System.out.println("�ɹ�����");
		}  catch(ClassNotFoundException e) {   
            //���ݿ��������쳣����
            System.out.println("���ݿ�����ʧ��1");   
            e.printStackTrace();   
            } catch(SQLException e) {
            //���ݿ�����ʧ���쳣����
            e.printStackTrace();  
            System.out.println("���ݿ�����ʧ��2");
            }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            System.out.println("���ݿ�����ʧ��3");
        }
		return conn;
	}
	
	//�ر���Դ
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
					System.out.println("�ر���Դ �쳣");
				}
			}
		}
	}

}

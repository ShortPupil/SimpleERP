package databaseutil;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import po.UserPO;


//���ڷ�����
public class BaseDao<T>{
	Class<T> clazz;
	
	public BaseDao(){
		Type superclass = getClass().getGenericSuperclass();  
        ParameterizedType parameterizedType = null;  
        if (superclass instanceof ParameterizedType) {  
            parameterizedType = (ParameterizedType) superclass;  
            Type[] typeArray = parameterizedType.getActualTypeArguments();  
           if (typeArray != null && typeArray.length > 0) {  
                  clazz=(Class)typeArray[0];      
            }  
       }
	}
	
	
	/**获得全部表数据
	 * 
	 * @return List<T>
	 */
	public List<T> queryList(){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		T t=null;
		String sql="select * from "+clazz.getSimpleName();
		List<T> list = new ArrayList<T>();
		//System.out.println(sql);
		try {	
			conn=DatabaseConnection.getConn();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			ResultSetMetaData metaData =rs.getMetaData();
			int count=metaData.getColumnCount();
			while(rs.next()){
				t=(T)clazz.newInstance();
				for(int i=0;i<count;i++){
					String fieldName=metaData.getColumnName(i+1);
					Field filed =clazz.getDeclaredField(fieldName);
					//System.out.println(filed);
					Method method=clazz.getMethod(getSetter(fieldName), filed.getType());
					//System.out.println(rs.getObject(i+1));
					method.invoke(t, rs.getObject(i+1));
				}
				list.add(t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DatabaseConnection.close(rs,ps,conn);
		}
		return list;
	}
	
	/**
	 * 模糊查找po
	 * */
	public List<T> queryListByInfo(String field){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		T t=null;
		String sql="select * from "+clazz.getSimpleName();
		List<T> list = new ArrayList<T>();
		List<T> res = new ArrayList<T>();
		//System.out.println(sql);
		try {	
			conn=DatabaseConnection.getConn();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			ResultSetMetaData metaData =rs.getMetaData();
			int count=metaData.getColumnCount();
			while(rs.next()){
				t=(T)clazz.newInstance();
				for(int i=0;i<count;i++){
					String fieldName=metaData.getColumnName(i+1);
					Field filed =clazz.getDeclaredField(fieldName);
					//System.out.println(filed);
					Method method=clazz.getMethod(getSetter(fieldName), filed.getType());
					//System.out.println(rs.getObject(i+1));
					method.invoke(t, rs.getObject(i+1));
				}
				list.add(t);
			}
			for(int i=0 ; i<list.size() ; i++) {
				t = list.get(i);
				//System.out.println(user.toString());
				if(t.toString().contains(field)) {
					res.add(t);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DatabaseConnection.close(rs,ps,conn);
		}
		return res;
	}
	
	/**根据id查找po
	 * @param id
	 * @return T
	 */
	public T queryPo(String id){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		T t=null;
		String sql="select * from "+clazz.getSimpleName()+" where  id=?";
		//System.out.println(sql);
		try {
			t=(T)clazz.newInstance();
			conn=DatabaseConnection.getConn();
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			ResultSetMetaData metaData =rs.getMetaData();
			int count=metaData.getColumnCount();
			while(rs.next()){
				for(int i=0;i<count;i++){
					String fieldName=metaData.getColumnName(i+1);
					Field filed =clazz.getDeclaredField(fieldName);
					//System.out.println(filed);
					Method method=clazz.getMethod(getSetter(fieldName), filed.getType());
					//System.out.println(rs.getObject(i+1));
					method.invoke(t, rs.getObject(i+1));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DatabaseConnection.close(rs,ps,conn);
		}
		return t;
	}
	
	//���po
	public void addPo(T t){
		Connection conn=null;
		PreparedStatement ps=null;
		String sql=getInsertSql(t);
		//System.out.println(sql);
		try {
			conn=DatabaseConnection.getConn();
			ps=conn.prepareStatement(sql);
			Field[] fields=clazz.getDeclaredFields();
			int c=1;
			//���
			for(int i=0;i<fields.length;i++){
				fields[i].setAccessible(true);
				//���
				if(fields[i].get(t)!=null){
					String fieldName=fields[i].getName();
					Method method=clazz.getMethod(getGetter(fieldName));
					Object obj=method.invoke(t);
					ps.setObject(c, obj);
					fields[i].setAccessible(false);
					c++;
				}
			}
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DatabaseConnection.close(ps,conn);
		}
	}
	
	//�޸�po
	public void updatePo(T t,String id){
		Connection conn=null;
		PreparedStatement ps=null;
		String sql=getUpdateSql(t, id);
		try {
			conn=DatabaseConnection.getConn();
			ps=conn.prepareStatement(sql);
			Field[] fields=clazz.getDeclaredFields();
			int c=1;
			//���
			for(int i=0;i<fields.length;i++){
				fields[i].setAccessible(true);
				//���
				if(fields[i].get(t)!=null){
					String fieldName=fields[i].getName();
					Method method=clazz.getMethod(getGetter(fieldName));
					Object obj=method.invoke(t);
					ps.setObject(c, obj);
					fields[i].setAccessible(false);
					c++;
				}
			}
			ps.setString(c, id);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DatabaseConnection.close(ps,conn);
		}
	}
	
	//ɾ��
	public void deletePo(String id){
			Connection conn=null;
			PreparedStatement ps=null;
			String sql="delete from "+clazz.getSimpleName()+"  where id=?";
			System.out.println(sql);
			try {
				conn=DatabaseConnection.getConn();
				ps=conn.prepareStatement(sql);
				ps.setString(1, id);
				ps.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				DatabaseConnection.close(ps,conn);
			}
	}
	
	//��ȡ��ѯ��sql���
	@SuppressWarnings("unused")
	private  String getQuerySql(T t){
		String sql="select * from "+clazz.getSimpleName()+"  where 1=1 ";
		try {
			Field[] fields=clazz.getDeclaredFields();
			for(int i=0;i<fields.length;i++){
				fields[i].setAccessible(true);
				if(fields[i].get(t)!=null){
					sql+= " and " +fields[i].getName()+"=?";
				}
			}
			sql=sql.substring(0,sql.length());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sql;
	}
	
	//��ȡ��ӵ�sql���
	private String getInsertSql(T t){
		String sql="insert into "+clazz.getSimpleName()+"(";
		String param="";
		Field[] fields=clazz.getDeclaredFields();
		try {
			for(int i=0;i<fields.length;i++){
				fields[i].setAccessible(true);
				if(fields[i].get(t)!=null){
					sql+=fields[i].getName()+",";
					param+="?,";
				}
			}
			sql=sql.substring(0,sql.length()-1)+") values("+param;
			sql=sql.substring(0,sql.length()-1)+")";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sql;
	}
	
	//��ȡ�޸ĵ�sql���
	private String getUpdateSql(T t,String id){
		String sql="update "+clazz.getSimpleName()+" set ";
		Field[] fields=clazz.getDeclaredFields();
		try {
			for(int i=0;i<fields.length;i++){
				fields[i].setAccessible(true);
				if(fields[i].get(t)!=null){
					sql+=fields[i].getName()+"=?,";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		sql=sql.substring(0,sql.length()-1)+"  where id =?";
		return sql;
	}
	
	//��ȡset�����ķ�����
	private static String getSetter(String fieldName){
		//���������� ƴ��set����  
		return "set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);	
		
	}
	
	//��ȡget�����ķ�����
	private static String getGetter(String fieldName){
		//���������� ƴ��get����  
		System.out.println("get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1));
		return "get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);	
		
	}
}


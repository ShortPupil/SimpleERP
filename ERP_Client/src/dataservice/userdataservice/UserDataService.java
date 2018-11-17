package dataservice.userdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.UserPO;
import po.UserRole;

public interface UserDataService extends Remote{
	
	/**
	 * 得到用户新id
	 * @author 钟镇鸿
	 * @return id字符串
	 * */
	public String getUserNewID(UserRole role) throws RemoteException;
	
	/**
	 * 根据id查找用户
	 * @author 钟镇鸿
	 * @param id
	 * @return 用户po
	 * */
	public UserPO searchUserByID(String id) throws RemoteException;
	
	/**
	 * 模糊查找用户
	 * @author 钟镇鸿
	 * @param field
	 * @return 用户po组成的动态数组
	 * */
	public ArrayList<UserPO> searchUserByInfo(String field) throws RemoteException;
	
	/**新增用户*/
	public boolean addUser(UserPO user) throws RemoteException;  
	
	/**删除用户*/
	public boolean deleteUser(String id) throws RemoteException;
	
	/**修改用户信息*/
	public boolean updateUser(UserPO user,String id) throws RemoteException;
}

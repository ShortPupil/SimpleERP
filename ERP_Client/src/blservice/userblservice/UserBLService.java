package blservice.userblservice;

import java.rmi.RemoteException;

import po.UserPO;

public interface UserBLService {

	/**
	 * 登陆
	 * @throws RemoteException 
	 * */
	public boolean login(boolean isUser, boolean isAdministeror, String id, String passsword) throws RemoteException;
	
	/**
	 * 新增用户
	 * @throws RemoteException 
	 * */
	public UserPO addUser(String name, String password, int role) throws RemoteException;
	
	/**
	 * 删除用户
	 * @throws RemoteException 
	 * */
	public boolean deleteUser(String id) throws RemoteException;
}

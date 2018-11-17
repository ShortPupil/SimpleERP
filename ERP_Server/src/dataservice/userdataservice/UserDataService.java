package dataservice.userdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.UserPO;
import po.UserRole;

public interface UserDataService extends Remote{
	
	/**
	 * �õ��û���id
	 * @author �����
	 * @return id�ַ���
	 * */
	public String getUserNewID(UserRole role) throws RemoteException;
	
	/**
	 * ����id�����û�
	 * @author �����
	 * @param id
	 * @return �û�po
	 * */
	public UserPO searchUserByID(String id) throws RemoteException;
	
	/**
	 * ģ�������û�
	 * @author �����
	 * @param field
	 * @return �û�po��ɵĶ�̬����
	 * */
	public List<UserPO> searchUserByInfo(String field) throws RemoteException;
	
	/**�����û�*/
	public boolean addUser(UserPO user) throws RemoteException;  
	
	/**ɾ���û�*/
	public boolean deleteUser(String id) throws RemoteException;
	
	/**�޸��û���Ϣ*/
	public boolean updateUser(UserPO user,String id) throws RemoteException;
}

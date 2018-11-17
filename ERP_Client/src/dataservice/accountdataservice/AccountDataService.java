package dataservice.accountdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.AccountPO;

public interface AccountDataService extends Remote{
	
	/**
	 * �õ������˵�
	 * @author �����
	 * @param 
	 * @return AccountPO��ɵĶ�̬����
	 * */
	public ArrayList<AccountPO> getAllAccount() throws RemoteException;

	/**
	 * �����˵����õ��˵�
	 * @author �����
	 * @param name
	 * @return AccountPO
	 * */
	public AccountPO getAccountByName(String name) throws RemoteException;
	/**
	 * ģ���˵�
	 * @author �����
	 * @param AccountPO
	 * @return AccountPO��ɵĶ�̬����
	 * */
	public ArrayList<AccountPO> searchAccountByInfo(String field) throws RemoteException;
	/**
	 * �����˵�
	 * @author �����
	 * @param AccountPO
	 * @return boolean
	 * */
	public boolean addAccount(AccountPO account) throws RemoteException;
	
	/**
	 * ɾ���˵�
	 * @author �����
	 * @param �˵�����
	 * @return boolean
	 * */
	public boolean deleteAccount(String name) throws RemoteException;
	
	/**
	 * �޸��˵�
	 * @author �����
	 * @param Ҫ�޸ĵ��˵�
	 * �޸ĵ�����(0ΪName 1ΪMoney)��
	 * �޸ĵĽ��
	 * */
	public boolean updateAccount(AccountPO account, int updateLoc, String message) throws RemoteException;
}

package dataservice.accountdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.AccountPO;
import po.StartAccountPO;

public interface AccountDataService extends Remote{
	
	/**
	 * �õ������˵�
	 * @author �����
	 * @param 
	 * @return AccountPO��ɵĶ�̬����
	 * */
	public List<StartAccountPO> getAllAccount() throws RemoteException;

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
	public List<AccountPO> searchAccountByInfo(String field) throws RemoteException;
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
}

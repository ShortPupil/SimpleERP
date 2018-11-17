package dataservice.accountdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.AccountPO;

public interface AccountDataService extends Remote{
	
	/**
	 * 得到所有账单
	 * @author 钟镇鸿
	 * @param 
	 * @return AccountPO组成的动态数组
	 * */
	public ArrayList<AccountPO> getAllAccount() throws RemoteException;

	/**
	 * 根据账单名得到账单
	 * @author 钟镇鸿
	 * @param name
	 * @return AccountPO
	 * */
	public AccountPO getAccountByName(String name) throws RemoteException;
	/**
	 * 模糊账单
	 * @author 钟镇鸿
	 * @param AccountPO
	 * @return AccountPO组成的动态数组
	 * */
	public ArrayList<AccountPO> searchAccountByInfo(String field) throws RemoteException;
	/**
	 * 新增账单
	 * @author 钟镇鸿
	 * @param AccountPO
	 * @return boolean
	 * */
	public boolean addAccount(AccountPO account) throws RemoteException;
	
	/**
	 * 删除账单
	 * @author 钟镇鸿
	 * @param 账单名称
	 * @return boolean
	 * */
	public boolean deleteAccount(String name) throws RemoteException;
	
	/**
	 * 修改账单
	 * @author 钟镇鸿
	 * @param 要修改的账单
	 * 修改的内容(0为Name 1为Money)，
	 * 修改的结果
	 * */
	public boolean updateAccount(AccountPO account, int updateLoc, String message) throws RemoteException;
}

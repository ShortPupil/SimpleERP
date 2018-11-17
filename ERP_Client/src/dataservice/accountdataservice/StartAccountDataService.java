package dataservice.accountdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.StartAccountPO;

public interface StartAccountDataService extends Remote{

	/**
	 * 得到所有期初账
	 * @author 钟镇鸿
	 * @param 
	 * @return StartAccountPO组成的动态数组
	 * */
	public ArrayList<StartAccountPO> getAllStartAccount() throws RemoteException;
	
	/**
	 * 新增一套账
	 * @author 钟镇鸿
	 * @param 账的全部信息
	 * @return boolean
	 * */
	public boolean addStartAccount(StartAccountPO startAccount) throws RemoteException;
}

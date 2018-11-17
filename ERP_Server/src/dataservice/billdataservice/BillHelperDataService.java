package dataservice.billdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

import po.BillCategory;

public interface BillHelperDataService extends Remote{

	/**
	 * 根据账单名得到账单
	 * @author 钟镇鸿
	 * @param name
	 * @return 字符串
	 * */
	public String getNewID(BillCategory category, Date date) throws RemoteException;
}

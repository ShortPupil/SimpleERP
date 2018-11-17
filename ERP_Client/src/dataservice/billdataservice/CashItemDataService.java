package dataservice.billdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po_accountbill.CashItem;
import po_accountbill.PayAndReceiveItem;

public interface CashItemDataService extends Remote{

	/**
	 * 新增现金费用单的清单某项
	 * @author 钟镇鸿
	 * @param 单据id， 新增的某项
	 * @return boolean
	 * */
	public boolean addCashItem(String billID, CashItem item) throws RemoteException;
	
	/**
	 * 删除现金费用单的清单某项
	 * @author 钟镇鸿
	 * @param 单据id， 删除的某项名称
	 * @return boolean
	 * */
	public boolean deleteCashItem(String billID, String id) throws RemoteException;
}

package dataservice.billdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po_accountbill.PayAndReceiveItem;

public interface PayAndReceiveItemDataService extends Remote{

	/**
	 * 新增收款付款单的清单某项
	 * @author 钟镇鸿
	 * @param 单据id， 新增的某项
	 * @return boolean
	 * */
	public boolean addPayAndReceiveItem(String billID, PayAndReceiveItem item) throws RemoteException;
	
	/**
	 * 删除收款付款单的清单某项
	 * @author 钟镇鸿
	 * @param 单据id， 删除的某项名称
	 * @return boolean
	 * */
	public boolean deletePayAndReceiveItem(String billID, String id) throws RemoteException;
	
	/**
	 * 更新item
	 * @param updateLoc 用数字表示修改内容
	 * 修改名称为0，修改金额为1，修改备注为2
	 * @author 钟镇鸿
	 * @return boolean
	 * */
	public boolean updatePayAndReceiveItem(String billID, String id , int updateLoc, String message) throws RemoteException;
}

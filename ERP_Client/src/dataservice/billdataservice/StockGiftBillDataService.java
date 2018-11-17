package dataservice.billdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import po.BillState;
import po_stockbill.StockAlarmBillPO;
import po_stockbill.StockGiftBillPO;

public interface StockGiftBillDataService extends Remote{

	/**
	 * 得到所有库存赠送单
	 * */
	public ArrayList<StockGiftBillPO> getAllStockGiftBill() throws RemoteException;
	
	/**
	 * 根据id查找库存赠送单
	 * */
	public StockGiftBillPO searchStockGiftBillByID(String id) throws RemoteException;
	
	/**
	 * 模糊查找库存赠送单
	 * */
	public ArrayList<String> searchStockGiftBillByInfo(Date start, Date end, String OperatorId, String WareId) throws RemoteException;
	
	/**
	 * 新增库存赠送单
	 * */
	public boolean addStockGiftBill(StockGiftBillPO bill) throws RemoteException;
	
	/**
	 * 删除库存赠送单
	 * */
	public boolean deleteStockGiftBill(String id) throws RemoteException;
	
	/**
	 * 修改库存赠送单审批状态
	 * */
	public boolean updateStockGiftBillState(BillState newState, String id) throws RemoteException;

	/**
	 * 修改库存赠送单的内容（用于红冲修改）
	 * */
	public boolean updateStockGiftBill(StockGiftBillPO bill, String update, String message) throws RemoteException;
}

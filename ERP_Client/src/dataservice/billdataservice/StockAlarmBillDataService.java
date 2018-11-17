package dataservice.billdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import po.BillState;
import po_stockbill.StockAlarmBillPO;

public interface StockAlarmBillDataService extends Remote{
 		
	/**
	 * 得到所有库存报警单
	 * */
	public ArrayList<StockAlarmBillPO> getAllStockAlarmBill() throws RemoteException;
	
	/**
	 * 根据id查找库存报警单
	 * */
	public StockAlarmBillPO searchStockAlarmBillByID(String id) throws RemoteException;
	
	/**
	 * 模糊查找库存报警单
	 * */
	public ArrayList<String> searchStockAlarmBillByInfo(Date start, Date end, String OperatorId, String WareId) throws RemoteException;
	
	/**
	 * 新增库存报警单
	 * */
	public boolean addStockAlarmBill(StockAlarmBillPO bill) throws RemoteException;
	
	/**
	 * 删除库存报警单
	 * */
	public boolean deleteStockAlarmBill(String id) throws RemoteException;
	
	/**
	 * 修改库存报警单的审批状态
	 * */
	public boolean updateStockAlarmBillState(BillState newState, String id) throws RemoteException;
}

package dataservice.billdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import po.BillState;
import po_stockbill.StockLossBillPO;

public interface StockLossBillDataService extends Remote{

	/**
	 * 得到所有库存报损单
	 * */
	public ArrayList<StockLossBillPO> getAllStockLossBill() throws RemoteException;
	
	/**
	 * 根据id查找库存报损单
	 * */
	public StockLossBillPO searchStockLossBillByID(String id) throws RemoteException;
	
	/**
	 * 模糊查找库存报损单
	 * */
	public ArrayList<String> searchStockLossBillByInfo(Date start, Date end, String OperatorId, String WareId) throws RemoteException;
	
	/**
	 * 新增库存报损单
	 * */
	public boolean addStockLossBill(StockLossBillPO bill) throws RemoteException;
	
	/**
	 * 删除库存报损单
	 * */
	public boolean deleteStockLossBill(String id) throws RemoteException;
	
	/**
	 * 修改库存报损单审批状态
	 * */
	public boolean updateStockLossBillState(BillState newState, String id) throws RemoteException;

	/**
	 * 修改库存报损单的内容（用于红冲修改）
	 * */
	public boolean updateStockLossBill(StockLossBillPO bill, String update, String message) throws RemoteException;
}

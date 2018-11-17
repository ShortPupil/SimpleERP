package dataservice.billdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import po.BillState;
import po_stockbill.StockOverflowBillPO;

public interface StockOverflowBillDataService extends Remote{

	/**
	 * 得到所有库存报溢单
	 * */
	public ArrayList<StockOverflowBillPO> getAllStockOverflowBill() throws RemoteException;
	
	/**
	 * 根据id查找库存报溢单
	 * */
	public StockOverflowBillPO searchStockOverflowBillByID(String id) throws RemoteException;
	
	/**
	 * 模糊查找库存报溢单
	 * */
	public ArrayList<String> searchStockOverflowBillByInfo(Date start, Date end, String OperatorId, String WareId) throws RemoteException;
	
	/**
	 * 新增库存报溢单
	 * */
	public boolean addStockOverflowBill(StockOverflowBillPO bill) throws RemoteException;
	
	/**
	 * 删除库存报溢单
	 * */
	public boolean deleteStockOverflowBill(String id) throws RemoteException;
	
	/**
	 * 修改库存报溢单审批状态
	 * */
	public boolean updateStockOverflowBillState(BillState newState, String id) throws RemoteException;

	/**
	 * 修改库存报溢单的内容（用于红冲修改）
	 * */
	public boolean updateStockOverflowBill(StockOverflowBillPO bill, String update, String message) throws RemoteException;
}

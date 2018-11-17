package dataservice.billdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import po.BillState;
import po_stockbill.StockOverflowBillPO;

public interface StockOverflowBillDataService extends Remote{

	/**
	 * �õ����п�汨�絥
	 * */
	public ArrayList<StockOverflowBillPO> getAllStockOverflowBill() throws RemoteException;
	
	/**
	 * ����id���ҿ�汨�絥
	 * */
	public StockOverflowBillPO searchStockOverflowBillByID(String id) throws RemoteException;
	
	/**
	 * ģ�����ҿ�汨�絥
	 * */
	public ArrayList<String> searchStockOverflowBillByInfo(Date start, Date end, String OperatorId, String WareId) throws RemoteException;
	
	/**
	 * ������汨�絥
	 * */
	public boolean addStockOverflowBill(StockOverflowBillPO bill) throws RemoteException;
	
	/**
	 * ɾ����汨�絥
	 * */
	public boolean deleteStockOverflowBill(String id) throws RemoteException;
	
	/**
	 * �޸Ŀ�汨�絥����״̬
	 * */
	public boolean updateStockOverflowBillState(BillState newState, String id) throws RemoteException;

	/**
	 * �޸Ŀ�汨�絥�����ݣ����ں���޸ģ�
	 * */
	public boolean updateStockOverflowBill(StockOverflowBillPO bill, String update, String message) throws RemoteException;
}

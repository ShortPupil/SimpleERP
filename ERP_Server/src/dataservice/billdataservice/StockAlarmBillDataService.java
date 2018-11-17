package dataservice.billdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import po.BillState;
import po_stockbill.StockAlarmBillPO;

public interface StockAlarmBillDataService extends Remote{
 		
	/**
	 * �õ����п�汨����
	 * */
	public ArrayList<StockAlarmBillPO> getAllStockAlarmBill() throws RemoteException;
	
	/**
	 * ����id���ҿ�汨����
	 * */
	public StockAlarmBillPO searchStockAlarmBillByID(String id) throws RemoteException;
	
	/**
	 * ģ�����ҿ�汨����
	 * */
	public ArrayList<String> searchStockAlarmBillByInfo(Date start, Date end, String OperatorId, String WareId) throws RemoteException;
	
	/**
	 * ������汨����
	 * */
	public boolean addStockAlarmBill(StockAlarmBillPO bill) throws RemoteException;
	
	/**
	 * ɾ����汨����
	 * */
	public boolean deleteStockAlarmBill(String id) throws RemoteException;
	
	/**
	 * �޸Ŀ�汨����������״̬
	 * */
	public boolean updateStockAlarmBillState(BillState newState, String id) throws RemoteException;
}

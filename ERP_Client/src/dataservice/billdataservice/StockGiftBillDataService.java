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
	 * �õ����п�����͵�
	 * */
	public ArrayList<StockGiftBillPO> getAllStockGiftBill() throws RemoteException;
	
	/**
	 * ����id���ҿ�����͵�
	 * */
	public StockGiftBillPO searchStockGiftBillByID(String id) throws RemoteException;
	
	/**
	 * ģ�����ҿ�����͵�
	 * */
	public ArrayList<String> searchStockGiftBillByInfo(Date start, Date end, String OperatorId, String WareId) throws RemoteException;
	
	/**
	 * ����������͵�
	 * */
	public boolean addStockGiftBill(StockGiftBillPO bill) throws RemoteException;
	
	/**
	 * ɾ��������͵�
	 * */
	public boolean deleteStockGiftBill(String id) throws RemoteException;
	
	/**
	 * �޸Ŀ�����͵�����״̬
	 * */
	public boolean updateStockGiftBillState(BillState newState, String id) throws RemoteException;

	/**
	 * �޸Ŀ�����͵������ݣ����ں���޸ģ�
	 * */
	public boolean updateStockGiftBill(StockGiftBillPO bill, String update, String message) throws RemoteException;
}

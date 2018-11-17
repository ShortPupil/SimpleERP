package dataservice.billdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import po.BillState;
import po_stockbill.StockLossBillPO;

public interface StockLossBillDataService extends Remote{

	/**
	 * �õ����п�汨��
	 * */
	public ArrayList<StockLossBillPO> getAllStockLossBill() throws RemoteException;
	
	/**
	 * ����id���ҿ�汨��
	 * */
	public StockLossBillPO searchStockLossBillByID(String id) throws RemoteException;
	
	/**
	 * ģ�����ҿ�汨��
	 * */
	public ArrayList<String> searchStockLossBillByInfo(Date start, Date end, String OperatorId, String WareId) throws RemoteException;
	
	/**
	 * ������汨��
	 * */
	public boolean addStockLossBill(StockLossBillPO bill) throws RemoteException;
	
	/**
	 * ɾ����汨��
	 * */
	public boolean deleteStockLossBill(String id) throws RemoteException;
	
	/**
	 * �޸Ŀ�汨������״̬
	 * */
	public boolean updateStockLossBillState(BillState newState, String id) throws RemoteException;

	/**
	 * �޸Ŀ�汨�𵥵����ݣ����ں���޸ģ�
	 * */
	public boolean updateStockLossBill(StockLossBillPO bill, String update, String message) throws RemoteException;
}

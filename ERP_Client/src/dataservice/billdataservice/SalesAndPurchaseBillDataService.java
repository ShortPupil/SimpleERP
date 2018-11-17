package dataservice.billdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import po.BillCategory;
import po.BillState;
import po_salesandpurchasebill.SalesAndPurchaseBillPO;

public interface SalesAndPurchaseBillDataService extends Remote{

	/**
	 * ����id�õ�����
	 * @author �����
	 * @param ��� id
	 * @return  SalesAndPurchaseBillPO
	 * */
	public SalesAndPurchaseBillPO searchSalesAndPurchaseBillByID(BillCategory categoy, String id) throws RemoteException;
	
	/**
	 * ����ģ����Ϣ�õ�����
	 * @author �����
	 * @param  ��ʼʱ�䣬����ʱ�䣬�˿�id������Աid���ֿ�id
	 * @return SalesAndPurchaseBillPO��ɵĶ�̬����
	 * */
	public ArrayList<String> searchSalesAndPurchaseBillByInfo(Date start, Date end, BillCategory category,String CustomerID ,String OperatorId, String WareId) throws RemoteException;
	
	/**
	 * �õ����е���
	 * @author �����
	 * @param 
	 * @return ArrayList<SalesAndPurchaseBillPO>
	 * */
	public ArrayList<SalesAndPurchaseBillPO> getAllSalesAndPurchaseBill() throws RemoteException;
	
	/**
	 * ��������
	 * @author �����
	 * @param SalesAndPurchaseBillPO
	 * @return boolean
	 * */
	public boolean addSalesAndPurchaseBill(SalesAndPurchaseBillPO bill) throws RemoteException;
	
	/**
	 * ɾ������
	 * @author �����
	 * @param ����id
	 * @return boolean
	 * */
	public boolean deleteSalesAndPurchaseBill(String id) throws RemoteException;
	
	/**
	 * �޸ĵ�������
	 * @author �����
	 * @param ����id���޸�λ�ã��ĺ�����
	 * @return boolean
	 * */
	public boolean updateSalesAndPurchaseBill(SalesAndPurchaseBillPO bill, String updateLoc, String message) throws RemoteException;
	
	/**
	 * �޸ĵ�������״̬
	 * @author �����
	 * @param ����״̬�� ����id
	 * @return boolean
	 * */
	public boolean updateSalesAndPurchaseBillState(BillState newState, String id) throws RemoteException;
}

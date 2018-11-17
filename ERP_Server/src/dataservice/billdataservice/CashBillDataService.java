package dataservice.billdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import po.BillState;
import po_accountbill.CashBillPO;

public interface CashBillDataService extends Remote{

	/**
	 * �õ�ĳ����Ա�������е���
	 * @author �����
	 * @param
	 * @return CashBillPO��ɵĶ�̬����
	 * */
	public ArrayList<CashBillPO> searchCashBillByUserID(String userid) throws RemoteException;
	
	/**
	 * ����id�õ�����
	 * @author �����
	 * @param ��� id
	 * @return CashBillPO
	 * */
	public CashBillPO searchCashBillByID(String id) throws RemoteException;
	
	/**
	 * ����ģ����Ϣ�õ�����
	 * @author �����
	 * @param  ��ʼʱ�䣬����ʱ�䣬�˿�id������Աid
	 * @return id��ɵĶ�̬����
	 * */
	public ArrayList<String> searchCashBillByInfo(Date start, Date end ,String OperatorId) throws RemoteException;
	
	/**
	 * ��������
	 * @author �����
	 * @param CashBill
	 * @return boolean
	 * */
	public boolean addCashBill(CashBillPO bill) throws RemoteException;
	
	/**
	 * ɾ������
	 * @author �����
	 * @param ����id
	 * @return boolean
	 * */
	public boolean deleteCashBill(String id) throws RemoteException;
	
}

package dataservice.billdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import po.BillCategory;
import po.BillState;
import po_accountbill.PayAndReceiveBillPO;

public interface PayAndReceiveBillDataService extends Remote{

	/**
	 * �õ�ĳ����Ա�������е���
	 * @author �����
	 * @param
	 * @return PayAndReceivePO��ɵĶ�̬����
	 * */
	public ArrayList<PayAndReceiveBillPO> searchPayAndReceiveBillByUserID(String userid) throws RemoteException;
	
	/**
	 * ����id�õ�����
	 * @author �����
	 * @param ��� id
	 * @return PayAndReceiveBillPO
	 * */
	public PayAndReceiveBillPO searchPayAndReceiveBillByID(BillCategory category, String id) throws RemoteException;
	
	/**
	 * ����ģ����Ϣ�õ�����
	 * @author �����
	 * @param  ��ʼʱ�䣬����ʱ�䣬�˿�id������Աid
	 * @return id��ɵĶ�̬����
	 * */
	public ArrayList<String> searchPayAndReceiveBillByInfo(Date start, Date end, BillCategory category,String CustomerID ,String OperatorId) throws RemoteException;
	
	/**
	 * ��������
	 * @author �����
	 * @param PayAndReceivePOBill
	 * @return boolean
	 * */
	public boolean addPayAndReceiveBill(PayAndReceiveBillPO bill) throws RemoteException;
	
	/**
	 * ɾ������
	 * @author �����
	 * @param ����id
	 * @return boolean
	 * */
	public boolean deletePayAndReceiveBill(String id) throws RemoteException;
	
	/**
	 * �޸ĵ�������״̬
	 * @author �����
	 * @param ����״̬�� ����id
	 * @return boolean
	 * */
	public boolean updatePayAndReceiveBillState(BillState newState, String id) throws RemoteException;
}

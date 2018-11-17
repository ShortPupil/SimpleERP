package dataservice.billdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po_accountbill.CashItem;
import po_accountbill.PayAndReceiveItem;

public interface CashItemDataService extends Remote{

	/**
	 * �����ֽ���õ����嵥ĳ��
	 * @author �����
	 * @param ����id�� ������ĳ��
	 * @return boolean
	 * */
	public boolean addCashItem(String billID, CashItem item) throws RemoteException;
	
	/**
	 * ɾ���ֽ���õ����嵥ĳ��
	 * @author �����
	 * @param ����id�� ɾ����ĳ������
	 * @return boolean
	 * */
	public boolean deleteCashItem(String billID, String id) throws RemoteException;
}

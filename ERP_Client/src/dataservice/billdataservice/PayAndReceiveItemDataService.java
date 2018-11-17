package dataservice.billdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po_accountbill.PayAndReceiveItem;

public interface PayAndReceiveItemDataService extends Remote{

	/**
	 * �����տ����嵥ĳ��
	 * @author �����
	 * @param ����id�� ������ĳ��
	 * @return boolean
	 * */
	public boolean addPayAndReceiveItem(String billID, PayAndReceiveItem item) throws RemoteException;
	
	/**
	 * ɾ���տ����嵥ĳ��
	 * @author �����
	 * @param ����id�� ɾ����ĳ������
	 * @return boolean
	 * */
	public boolean deletePayAndReceiveItem(String billID, String id) throws RemoteException;
	
	/**
	 * ����item
	 * @param updateLoc �����ֱ�ʾ�޸�����
	 * �޸�����Ϊ0���޸Ľ��Ϊ1���޸ı�עΪ2
	 * @author �����
	 * @return boolean
	 * */
	public boolean updatePayAndReceiveItem(String billID, String id , int updateLoc, String message) throws RemoteException;
}

package dataservice.billdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

import po.BillCategory;

public interface BillHelperDataService extends Remote{

	/**
	 * �����˵����õ��˵�
	 * @author �����
	 * @param name
	 * @return �ַ���
	 * */
	public String getNewID(BillCategory category, Date date) throws RemoteException;
}

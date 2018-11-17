package dataservice.accountdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.StartAccountPO;

public interface StartAccountDataService extends Remote{

	/**
	 * �õ������ڳ���
	 * @author �����
	 * @param 
	 * @return StartAccountPO��ɵĶ�̬����
	 * */
	public List<StartAccountPO> getAllStartAccount() throws RemoteException;
	
	/**
	 * ����һ����
	 * @author �����
	 * @param �˵�ȫ����Ϣ
	 * @return boolean
	 * */
	public boolean addStartAccount(StartAccountPO startAccount) throws RemoteException;
}

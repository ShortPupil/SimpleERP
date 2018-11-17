package dataservice.customerdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.CustomerPO;

public interface CustomerDataService extends Remote{

	/**
	 * ���ɹ˿���id
	 * @author �����
	 * @return id�ַ���
	 * */
	public String getCustomerNewID() throws RemoteException;
	
	/**
	 * ����id���ҹ˿�
	 * @author �����
	 * @param id
	 * @return �ͻ�po
	 * */
	public CustomerPO searchCustomerByID(String id) throws RemoteException;
	
	/**
	 * ģ�����ҹ˿�
	 * @author �����
	 * @param field�� value
	 * @return �ͻ�po��ɵĶ�̬����
	 * */
	public List<CustomerPO> searchCustomerByInfo(String field) throws RemoteException;

	/**
	 * �����˿�
	 * */
	public boolean addCustomer(CustomerPO customer) throws RemoteException;  
	
	/**
	 * ɾ���˿�
	 * */
	public boolean deleteCustomer(String id) throws RemoteException;
	
	/**
	 * �޸Ĺ˿���Ϣ
	 * */
	public boolean updateCustomer(CustomerPO customer, String id) throws RemoteException;
	//getCustomerDataBase
}

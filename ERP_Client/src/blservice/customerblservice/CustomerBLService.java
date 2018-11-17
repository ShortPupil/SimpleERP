package blservice.customerblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CustomerPO;
import vo.CustomerVO;

public interface CustomerBLService {

	/**
	 * 新增顾客
	 * @throws RemoteException 
	 * */
	public CustomerVO addCustomer(int role, int level, String name, String phonenumber,
			String address, String email, String postcode, double receivalesamount, 
			String salesman) throws RemoteException;
	
	/**
	 * 删除顾客
	 * @throws RemoteException 
	 * */
	public boolean deleteCustomer(String id) throws RemoteException;
	
	/**
	 * 修改顾客信息
	 * @throws RemoteException 
	 * */
	public CustomerVO updateCustomer(CustomerPO customer, String id) throws RemoteException;
	
	/**
	 * 根据id查找顾客
	 * @throws RemoteException 
	 * */
	public CustomerPO searchCustomerByID(String id) throws RemoteException;
	
	/**
	 * 模糊查找顾客
	 * @throws RemoteException 
	 * */
	public ArrayList<CustomerPO> searchCustomerByField(String field) throws RemoteException;
}

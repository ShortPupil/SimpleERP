package dataservice.customerdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CustomerPO;

public interface CustomerDataService extends Remote{

	/**
	 * 生成顾客新id
	 * @author 钟镇鸿
	 * @return id字符串
	 * */
	public String getCustomerNewID() throws RemoteException;
	
	/**
	 * 根据id查找顾客
	 * @author 钟镇鸿
	 * @param id
	 * @return 客户po
	 * */
	public CustomerPO searchCustomerByID(String id) throws RemoteException;
	
	/**
	 * 模糊查找顾客
	 * @author 钟镇鸿
	 * @param field， value
	 * @return 客户po组成的动态数组
	 * */
	public ArrayList<CustomerPO> searchCustomerByInfo(String field) throws RemoteException;

	/**
	 * 新增顾客
	 * */
	public boolean addCustomer(CustomerPO customer) throws RemoteException;  
	
	/**
	 * 删除顾客
	 * */
	public boolean deleteCustomer(String id) throws RemoteException;
	
	/**
	 * 修改顾客信息
	 * */
	public boolean updateCustomer(CustomerPO customer, String id) throws RemoteException;
	//getCustomerDataBase
}

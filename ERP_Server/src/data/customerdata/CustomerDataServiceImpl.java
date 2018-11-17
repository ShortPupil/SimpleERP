package data.customerdata;

import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import databaseutil.BaseDao;
import dataservice.customerdataservice.CustomerDataService;
import po.CustomerPO;

public class CustomerDataServiceImpl extends BaseDao<CustomerPO> implements CustomerDataService{

	private static final String STR_FORMAT = "000000"; 
	@Override
	public String getCustomerNewID() throws RemoteException {
		// TODO Auto-generated method stub
		String res = "";
		DecimalFormat df = new DecimalFormat(STR_FORMAT);  
		List<CustomerPO> list = queryList();
		int counter = list.size()-1;
		CustomerPO customer = list.get(counter);
		String originalNum = customer.getId();
	    String num = df.format(Integer.valueOf(originalNum)+1);
	    res = res + num;
		return res;
	}

	@Override
	public CustomerPO searchCustomerByID(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return queryPo(id);
	}

	@Override
	public List<CustomerPO> searchCustomerByInfo(String field) throws RemoteException {
		// TODO Auto-generated method stub
		return queryListByInfo(field);
	}

	@Override
	public boolean addCustomer(CustomerPO customer) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			addPo(customer);
			return true;
		}catch (Exception e) {
		e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteCustomer(String id) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			deletePo(id);
			return true;
		}catch (Exception e) {
		e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateCustomer(CustomerPO customer, String id) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			updatePo(customer, id);
			return true;
		}catch (Exception e) {
		e.printStackTrace();
		}
		return false;
	}

}

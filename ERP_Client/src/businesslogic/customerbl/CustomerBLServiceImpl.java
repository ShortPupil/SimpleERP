package businesslogic.customerbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.customerblservice.CustomerBLService;
import po.CustomerPO;
import rmi.RemoteHelper;
import vo.CustomerVO;

public class CustomerBLServiceImpl implements CustomerBLService{

	@Override
	public CustomerVO addCustomer(int role, int level, String name, String phonenumber,
			String address, String email, String postcode, double receivalesamount, 
			String salesman) throws RemoteException {
		// TODO Auto-generated method stub
		String id = RemoteHelper.getInstance().getCustomerDataService().getCustomerNewID();
		CustomerPO cus = new CustomerPO(id, role, level, name, phonenumber, address, 
				email, postcode, receivalesamount, salesman);
		RemoteHelper.getInstance().getCustomerDataService().addCustomer(cus);
		
		CustomerVO customerInTable = new CustomerVO(id, role, level, name, 
				receivalesamount, salesman);
		return customerInTable;
	}

	@Override
	public boolean deleteCustomer(String id) throws RemoteException {
		// TODO Auto-generated method stub
		CustomerPO customerFinding = RemoteHelper.getInstance().getCustomerDataService().searchCustomerByID(id);
		if(customerFinding.getPay() != 0 || customerFinding.getReceivables()!=0) {
			return false;
		}
		return RemoteHelper.getInstance().getCustomerDataService().deleteCustomer(id);
	}

	@Override
	public CustomerVO updateCustomer(CustomerPO customer, String id) throws RemoteException {
		// TODO Auto-generated method stub
		RemoteHelper.getInstance().getCustomerDataService().updateCustomer(customer, id);
		CustomerVO cus = new CustomerVO(id, customer.getRole(), customer.getLevel(), customer.getName()
				,customer.getReceivablesamount(), customer.getSalesman());
		return cus;
	}

	@Override
	public CustomerPO searchCustomerByID(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return RemoteHelper.getInstance().getCustomerDataService().searchCustomerByID(id);
	}

	@Override
	public ArrayList<CustomerPO> searchCustomerByField(String field) throws RemoteException {
		// TODO Auto-generated method stub
		return RemoteHelper.getInstance().getCustomerDataService().searchCustomerByInfo(field);
	}

}

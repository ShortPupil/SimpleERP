package data.customerdata;

import static org.junit.jupiter.api.Assertions.*;

import java.rmi.RemoteException;
import java.util.List;

import org.junit.jupiter.api.Test;

import databaseutil.DatabaseConnection;
import po.CustomerPO;

class testCustomer {
	DatabaseConnection d = new DatabaseConnection();
	CustomerDataServiceImpl c = new CustomerDataServiceImpl();
	
	//@Test
	void test() throws RemoteException {
		assertEquals(c.getCustomerNewID(),"000002");
	}

	//@Test
	void test1() throws RemoteException{
		CustomerPO cus = c.searchCustomerByID("000001");
		cus.setId("000002");
		cus.setName("zoom");
		c.addCustomer(cus);
	}
	
	@Test
	void test2() throws RemoteException{
		List<CustomerPO> list = c.searchCustomerByInfo("5");
	}
}

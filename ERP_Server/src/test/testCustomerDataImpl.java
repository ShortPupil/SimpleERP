package test;

import static org.junit.jupiter.api.Assertions.*;

import java.rmi.RemoteException;
import org.junit.jupiter.api.Test;

import data.customerdata.CustomerDataServiceImpl;
import po.CustomerPO;

class testCustomerDataImpl {
	CustomerDataServiceImpl a = new CustomerDataServiceImpl ();
	
	CustomerPO customer3 = null;
	CustomerPO customer2 = null;
	CustomerPO customer1 = null;
	
	/**
	 * ����findCustomerByID
	 * @throws RemoteException 
	 * */
	@Test
	void test1() throws RemoteException {
		a.addCustomer(customer1);
		a.addCustomer(customer2);

		a.addCustomer(customer3);
	}
	
	@Test
	void test1_1() throws RemoteException{
		CustomerPO customer1 = a.searchCustomerByID("000001");

		assertEquals(customer1.getId(), "000001");
		assertEquals(customer1.getName(), "����");
		assertEquals(customer1.getPhonenumber(), "12312341234");
	}

	@Test
	void test2() throws RemoteException{
		CustomerPO customer1 = a.searchCustomerByID("000003");
		assertEquals(customer1.getName(), "��qi");
	}
	
	@Test
	void test3() throws RemoteException{
		a.deleteCustomer("000002");
	}
	
	@Test
	void test4() throws RemoteException{
		String id = a.getCustomerNewID();
		assertEquals("000004", id);
	}
}

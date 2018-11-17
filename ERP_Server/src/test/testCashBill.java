package test;

import static org.junit.jupiter.api.Assertions.*;

import java.rmi.RemoteException;

import org.junit.jupiter.api.Test;

import data.billdata.CashItemDataServiceImpl;
import po_accountbill.CashItem;

class testCashBill {

	CashItemDataServiceImpl c = new CashItemDataServiceImpl();
	@Test
	void test() throws RemoteException {
		CashItem item = new CashItem("0001", 1, "this", 50, "ok");
		c.addCashItem("XJFYD-20171230-00001", item);
	}

	@Test
	void test2() throws RemoteException {
		CashItem item = new CashItem("0002", 1, "this", 10, "ok");
		c.addCashItem("XJFYD-20180101-00001", item);
	}
	
	@Test
	void test3() throws RemoteException{
		c.deleteCashItem("XJFYD-20180101-00001", "0001");
	}
}

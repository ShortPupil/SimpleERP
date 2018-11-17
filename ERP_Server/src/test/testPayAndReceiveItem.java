package test;

import static org.junit.jupiter.api.Assertions.*;

import java.rmi.RemoteException;

import org.junit.jupiter.api.Test;

import data.billdata.PayAndReceiveItemDataServiceImpl;
import po_accountbill.PayAndReceiveItem;

class testPayAndReceiveItem {

	PayAndReceiveItemDataServiceImpl p = new PayAndReceiveItemDataServiceImpl();
	@Test
	void test() throws RemoteException {
		PayAndReceiveItem item = new PayAndReceiveItem("0004","company0002", 20, "ok");
		p.addPayAndReceiveItem("SKD-20171228-00001", item);
	}

	@Test
	void test2() throws RemoteException {
		p.deletePayAndReceiveItem("SKD-20171228-00001", "0001");
	}
	
	@Test
	public void test3() throws RemoteException{
		p.updatePayAndReceiveItem("SKD-20171228-00001", "0002", 1, "40.5");
	}
}

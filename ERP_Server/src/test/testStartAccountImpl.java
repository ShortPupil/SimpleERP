package test;
import static org.junit.jupiter.api.Assertions.*;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import data.accountdata.StartAccountDataServiceImpl;
import po.StartAccountPO;

public class testStartAccountImpl {

	StartAccountDataServiceImpl s = new StartAccountDataServiceImpl();
	@Test
	public void test1() throws RemoteException{
		java.util.Date date = new java.util.Date();
		StartAccountPO startAccount = new StartAccountPO("x", null, null, null, date);
		StartAccountPO startAccount2 = new StartAccountPO("y", null, null, null, date);
		s.addStartAccount(startAccount);
		s.addStartAccount(startAccount2);
	}
	
	@Test
	public void test2() throws RemoteException{
		List<StartAccountPO> l = s.getAllStartAccount();
		assertEquals(l.size(), 2);
	}
}

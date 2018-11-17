package test;


import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import data.logdata.LogDataServiceImpl;
import po.LogPO;

class testLogDataImpl {

	LogDataServiceImpl a = new LogDataServiceImpl();
	@Test
	void test1() throws RemoteException {
		LogPO log = new LogPO("新增用户", "2017/11/26 11:15", "Joe");
		a.addLog(log);
	}

	@Test
	void test2() throws RemoteException {
		LogPO log = new LogPO("修改用户信息", "2017/11/26 11:15", "Mike");
		a.addLog(log);
	}
	
	@Test
	void test3() throws RemoteException{
		ArrayList<LogPO> list = a.checkLog();
		assertEquals(list.size(), 8);
	}
}

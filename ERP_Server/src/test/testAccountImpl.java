package test;

import static org.junit.jupiter.api.Assertions.*;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import data.accountdata.AccountDataServiceImpl;
import po.AccountPO;

class testAccountImpl {

	AccountDataServiceImpl a = new AccountDataServiceImpl();
	@Test
	void test1() throws RemoteException {
		List<AccountPO> account = a.getAllAccount();
		//a.updateAccount(account.get(0), 0, "0002");
	}
	
	@Test
	void test2() throws RemoteException{
		List<AccountPO> account = a.getAllAccount();
		AccountPO x = account.get(0);
		x.setAccountName("0003");
		x.setAccountMoney(20000);
		a.addAccount(x);
	}
	
	@Test
	void test3() throws RemoteException{
		String name = "0003";
		a.deleteAccount(name);
	}

	@Test
	void test4() throws RemoteException{
		String name = "0";
		List<AccountPO> list= a.searchAccountByInfo(name);
		assertEquals(list.size() , 1);
	}
}

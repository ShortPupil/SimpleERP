package data.userdata;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.rmi.RemoteException;

import org.junit.jupiter.api.Test;

import databaseutil.DatabaseConnection;
import po.UserPO;
import po.UserRole;

class testUser {
	DatabaseConnection d = new DatabaseConnection();
	UserDataServiceImpl u = new UserDataServiceImpl();
	
	//@Test
	void test() throws RemoteException {
		UserPO user = u.searchUserByID("000001");
		assertEquals(user.getRole(),0);
	}
	
	//@Test
	void test1() throws RemoteException {
		UserPO user = u.searchUserByID("600010");
		assertEquals(user, null);
	}
	
	//@Test
	void test2() throws RemoteException{
		UserPO user = u.searchUserByID("000001");
		user.setName("zip");
		u.updatePo(user, "000001");
	}
	
	//@Test
	void test3() throws RemoteException{
		u.deletePo("000002");
	}
	
	//@Test
	void test4() throws RemoteException{
		assertEquals(u.getUserNewID(UserRole.Administrator),"000003");
	}

	@Test
	void test5() throws RemoteException{
		assertEquals(u.searchUserByInfo("1").size(), 5);
	}
}

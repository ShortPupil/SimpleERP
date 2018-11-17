package test;

import static org.junit.jupiter.api.Assertions.*;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import data.billdata.PayAndReceiveBillDataServiceImpl;
import po.BillCategory;
import po.BillState;
import po_accountbill.PayAndReceiveBillPO;

class testPayAndReceiveDataImpl {

	PayAndReceiveBillDataServiceImpl p = new PayAndReceiveBillDataServiceImpl();
	@Test
	void test1() throws RemoteException {
		PayAndReceiveBillPO bill = p.searchPayAndReceiveBillByID(BillCategory.Receive, "SKD-20171228-00001");
		assertEquals(bill.getTotalMoney(), 1560.5);
	}

	@Test
	void test3() throws RemoteException{
		PayAndReceiveBillPO bill = p.searchPayAndReceiveBillByID(BillCategory.Receive, "SKD-20171228-00001");
		bill.setID("SKD-20171228-00002");
		p.addPayAndReceiveBill(bill);
	}
	
	@Test
	void test4() throws RemoteException, ParseException{
		SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date sqlDate=java.sql.Date.valueOf("2017-12-28");
		java.sql.Date sqlDate2=java.sql.Date.valueOf("2017-12-29");
		java.util.Date date1=new java.util.Date(sqlDate.getTime());
		java.util.Date date2=new java.util.Date(sqlDate2.getTime());
		ArrayList<String> billList = p.searchPayAndReceiveBillByInfo(date1, date2, BillCategory.Receive,"000001", "300001");
		assertEquals(billList.size(), 2);
		assertEquals(billList.get(0), "SKD-20171228-00001");
		//System.out.println(billList.get(0).getDate());
	}
	
	@Test
	void test5() throws RemoteException{
		String userid  = "000002";
		ArrayList<PayAndReceiveBillPO> list = p.searchPayAndReceiveBillByUserID(userid);
		assertEquals(list.size(), 5);
	}

}

package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.junit.Test;

import data.billdata.StockAlarmBillDataServiceImpl;
import po_stockbill.StockAlarmBillItem;
import po_stockbill.StockAlarmBillPO;

public class testStockAlarmBillDataImpl {

	StockAlarmBillDataServiceImpl s = new StockAlarmBillDataServiceImpl();
	@Test
	public void test1() throws RemoteException {
		ArrayList<StockAlarmBillPO> list = s.getAllStockAlarmBill();
		for(int i=0 ;i<list.size() ; i++) {
			//System.out.println(list.get(i).toString() + " " + list.size());
		}
		StockAlarmBillPO bill = list.get(0);
		ArrayList<StockAlarmBillItem> l = bill.getItemList();
		assertEquals(l.get(1).getAlarmAmount(), 20);
		assertEquals(l.get(0).getAlarmAmount(), 30);
	}
	
	@Test
	public void test2() throws RemoteException{
		StockAlarmBillPO bill = s.searchStockAlarmBillByID("alarm00001");
		assertEquals(bill.getWareID(), "0001");
		assertEquals(bill.getItemList().get(0).getNumber(), "0001");
	}
	
	@Test
	public void test3() throws RemoteException{
		StockAlarmBillPO bill_2 = s.searchStockAlarmBillByID("alarm00002");
		assertEquals(bill_2.getOperatorID(), "0001");
		assertEquals(bill_2.getItemList().get(0).getNumber(), "0003");
	}
	
	@Test
	public void test4() throws RemoteException{
		StockAlarmBillPO bill_2 = s.searchStockAlarmBillByID("alarm00002");
		bill_2.setId("stockalarm0003");
		s.addStockAlarmBill(bill_2);
	}
	
	@Test
	public void test5() throws RemoteException, ParseException{
		SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date1=format.parse("2017-10-10");
		java.util.Date date2=format.parse("2017-10-12");
		ArrayList<String> list = s.searchStockAlarmBillByInfo(date1, date2, "0001", "0001");
		assertEquals(list.size(), 4);
	}
}

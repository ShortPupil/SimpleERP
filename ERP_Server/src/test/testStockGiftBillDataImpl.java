package test;

import static org.junit.jupiter.api.Assertions.*;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import data.billdata.StockGiftBillDataServiceImpl;
import po.BillState;
import po_stockbill.StockAlarmBillPO;
import po_stockbill.StockGiftBillPO;

class testStockGiftBillDataImpl {

	StockGiftBillDataServiceImpl s = new StockGiftBillDataServiceImpl();
	@Test
	void test() throws RemoteException {
		StockGiftBillPO bill;
		bill = s.searchStockGiftBillByID("gift00001");
		assertEquals(bill.getOperatorID(), "0001");
		assertEquals(bill.getItemList().get(0).getNumber(), "0003");		
	}
	
	@Test
	void test2() throws RemoteException, ParseException {
		SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date date1=format.parse("2017-10-10 00:00:00");
		java.util.Date date2=format.parse("2017-10-12 00:00:00");
		ArrayList<String> list = s.searchStockGiftBillByInfo(date1, date2, "0001", "0001");
		assertEquals(list.size(), 1);	
	}

	@Test
	void test3() throws RemoteException{
		s.updateStockGiftBillState(BillState.PASS, "gift0001");
	}
}

package test;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import data.billdata.StockLossBillDataServiceImpl;
import po.BillState;
import po_stockbill.StockLossBillItem;
import po_stockbill.StockLossBillPO;

class testStockLossBillDataImpl {

	StockLossBillDataServiceImpl s = new StockLossBillDataServiceImpl();
	@Test
	public void test1() throws RemoteException, ParseException{

		StockLossBillItem item = new StockLossBillItem("0006", "M", 100, 80);
		ArrayList<StockLossBillItem> list = new ArrayList<StockLossBillItem>();
		list.add(item);

		String a = "2012-06-21 00:10:00";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date d1 = sdf.parse(a); //先把字符串转为util.Date对象
		
		StockLossBillPO bill_2 = new StockLossBillPO("loss00010", list, BillState.PASS, "000001", d1, "000001");
		s.addStockLossBill(bill_2);
	}
	
	@Test
	public void test2() throws RemoteException{
		StockLossBillPO bill_2 = s.searchStockLossBillByID("loss00010");
		java.util.Date d = new java.util.Date(bill_2.getDate().getTime());
		//System.out.println(d);
	}
	
	@Test
	public void test3() throws RemoteException{
		StockLossBillPO bill_2 = s.searchStockLossBillByID("loss00010");
		s.updateStockLossBill(bill_2, "OperatorID", "000002");
	}
}

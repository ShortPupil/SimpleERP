package test;

import static org.junit.jupiter.api.Assertions.*;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import data.billdata.SalesAndPurchaseBillDataServiceImpl;
import po.BillCategory;
import po.BillState;
import po_salesandpurchasebill.GoodsItem;
import po_salesandpurchasebill.SalesAndPurchaseBillPO;

class testSalesAndPurchaseBillDataImpl {

	SalesAndPurchaseBillDataServiceImpl s = new SalesAndPurchaseBillDataServiceImpl();
	
	@Test
	void test1() throws RemoteException {
		SalesAndPurchaseBillPO a = s.searchSalesAndPurchaseBillByID(BillCategory.Sales,"XSD-20121223-00001");
		assertEquals(a.getDiscountAmount(), 20.5);
		assertEquals(a.getRemark(), "好的");
	}
	
	@Test
	void test2() throws RemoteException{
		ArrayList<SalesAndPurchaseBillPO> list =s.getAllSalesAndPurchaseBill();
		assertEquals(list.size() , 1);
	}

	@Test
	void test3() throws RemoteException{
		GoodsItem item1 = new GoodsItem("AB", "0011", "X", 20, 0.6, "OK");
		GoodsItem item2 = new GoodsItem("AB", "0012", "Y", 30, 0.5, "OK");
		ArrayList<GoodsItem> itemList = new ArrayList<GoodsItem>();
		itemList.add(item1);
		itemList.add(item2);
		java.util.Date date = new java.util.Date();
		SalesAndPurchaseBillPO add = new SalesAndPurchaseBillPO( BillCategory.SalesReturn, 
				BillState.PASS,"xsd_20121223_00001", "0001", "0001", "0001","0003", itemList, 80.6, 2.4, "ok", date);
		s.addSalesAndPurchaseBill(add);
	}
	
	@Test
	void test4() throws RemoteException, ParseException{
		SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date1=format.parse("2012-12-24");
		java.util.Date date2=format.parse("2012-12-25");
		ArrayList<String> list = s.searchSalesAndPurchaseBillByInfo(date1, date2, BillCategory.Sales,"0002", "0002", "0002");
		assertEquals(list.size(), 1);
	}
}

package test;

import static org.junit.jupiter.api.Assertions.*;

import java.rmi.RemoteException;

import org.junit.jupiter.api.Test;

import data.billdata.SalesAndPurchaseBillDataServiceImpl;
import data.billdata.SalesAndPurchaseItemDataServiceImpl;
import po.BillCategory;
import po_salesandpurchasebill.GoodsItem;
import po_salesandpurchasebill.SalesAndPurchaseBillPO;

class testSalesAndPurchaseItemImpl {

	SalesAndPurchaseItemDataServiceImpl s = new SalesAndPurchaseItemDataServiceImpl();
	SalesAndPurchaseBillDataServiceImpl d = new SalesAndPurchaseBillDataServiceImpl();
	@Test
	void test1() {
		GoodsItem goods = new GoodsItem("1", "a", "0001", 25, 2.5, "ok");
		try {
			s.addGoodsItem("XSD-20121223-00001", goods);
			SalesAndPurchaseBillPO bill = d.searchSalesAndPurchaseBillByID(BillCategory.Sales, "XSD-20121223-00001");
			assertEquals(bill.getGoodsPOList().size(), 4);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void test2() {
		try {
			s.deleteGoodsItem("XSD-20121223-00001", "1");
			SalesAndPurchaseBillPO bill = d.searchSalesAndPurchaseBillByID(BillCategory.Sales, "XSD-20121223-00001");
			assertEquals(bill.getGoodsPOList().size(), 3);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void test3() {
		try {
			s.updateGoodsItem("XSD-20121223-00001", "1", 0, "25");
			s.updateGoodsItem("XSD-20121223-00001", "1", 2, "yes");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

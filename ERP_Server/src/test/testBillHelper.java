package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.Test;

import data.billdata.BillHelper;
import po.BillCategory;

class testBillHelper {

	BillHelper b = new BillHelper();
	@Test
	void test() {
		java.util.Date date = new java.util.Date();
		String res = b.getNewID(BillCategory.Pay, date);
		assertEquals("FKD-20180108-00001", res);
	}
	
	@Test
	void test2() {
		java.sql.Date d=java.sql.Date.valueOf("2017-12-29");
		java.util.Date date = new java.util.Date(d.getTime());
		String res = b.getNewID(BillCategory.Receive, date);
		assertEquals("SKD-20171229-00001", res);
	}
	
	@Test
	void test3() {
		java.sql.Date d=java.sql.Date.valueOf("2012-12-23");
		java.util.Date date = new java.util.Date(d.getTime());
		String res = b.getNewID(BillCategory.Sales, date);
		assertEquals("XSD-20121223-00002", res);
	}
	
	@Test
	void test4() {
		java.sql.Date d=java.sql.Date.valueOf("2012-12-25");
		java.util.Date date = new java.util.Date(d.getTime());
		String res = b.getNewID(BillCategory.Sales, date);
		assertEquals("XSD-20121225-00001", res);
	}
	
	@Test
	void test5() {
		java.util.Date date = new java.util.Date();
		java.sql.Date d=java.sql.Date.valueOf("2017-12-30");
		java.util.Date date2 = new java.util.Date(d.getTime());
		String res = b.getNewID(BillCategory.Cash, date);
		String res2 = b.getNewID(BillCategory.Cash, date2);
		assertEquals("XJFYD-20171231-00001", res);
		assertEquals("XJFYD-20171230-00002", res2);
	}
	
	@Test
	void test6() {
		java.util.Date date = new java.util.Date();
		String res2 = b.getNewID(BillCategory.StockOverflow, date);
		assertEquals("overflow00006", res2);
	}

}

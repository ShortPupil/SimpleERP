package data.billdata;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import databaseutil.DatabaseConnection;
import dataservice.billdataservice.BillHelperDataService;
import po.BillCategory;


public class BillHelper implements BillHelperDataService{
	
	private Connection con = DatabaseConnection.getConn();
	private static final String STR_FORMAT = "00000";  
	
	/**
	 * @param category 单据类型
	 * @param date 日期
	 * */
	public String getNewID(BillCategory category, Date date) {
		String res = null;
		if(category.equals(BillCategory.Pay) || category.equals(BillCategory.Receive) ) {
			res = getPayAndReceiveBillNewID(category, date);
		}
		else if(category.equals(BillCategory.Sales) || category.equals(BillCategory.SalesReturn)  
				|| category.equals(BillCategory.Purchase) || category.equals(BillCategory.PurchaseReturn) ) {
			res = getSalesAndPurchaseBillNewID(category, date);
		}
		else if(category.equals(BillCategory.Cash)) {
			res = getCashBillNewID(category, date);
		}
		else if(category.equals(BillCategory.StockGift) || category.equals(BillCategory.StockOverflow) 
				||category.equals(BillCategory.StockLoss) || category.equals(BillCategory.StockAlarm)) {
			res = getStockBillNewID(category, date);
		}
		return res;		
	}
	
	private String getStockBillNewID(BillCategory category, Date date) {
		// TODO Auto-generated method stub
		String res = null;
		
		String flag = null;
		if(category.equals(BillCategory.StockOverflow)) {
			flag = "overflow";
		}
		else if(category.equals(BillCategory.StockLoss)) {
			flag = "loss";
		}
		else if(category.equals(BillCategory.StockGift)) {
			flag = "gift";
		}
		else if(category.equals(BillCategory.StockAlarm)) {
			flag = "alarm";
		}
		try {
			Statement statement_1 = con.createStatement();	
			String sql_1 = "select * from stock" + flag + "bill;";		
			ResultSet rs = statement_1.executeQuery(sql_1);			
			
	    	//��ȡ�����ݱ���������idΪ������	
		    int theNum = 1;
 
	    	while(rs.next()) {	    
	    		String ID = rs.getString("ID");   
	    	    String num = ID.substring(ID.length()-5, ID.length());
 		    	theNum = Integer.valueOf(num) + 1;
	    	}    
	    	if(theNum > 99999)
	    		return null;	    	 
	    	DecimalFormat df = new DecimalFormat(STR_FORMAT);  		    	
	    	res = flag + df.format(theNum);
	    	rs.close();   
	    	return res;
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
	    return res;
	}

	private String getCashBillNewID(BillCategory category, Date date) {
		// TODO Auto-generated method stub
		String res = null;
		try {
			Statement statement_1 = con.createStatement();	
			java.sql.Date d = new java.sql.Date(date.getTime());
			String sql_1 = "select * from cashbill where date = '" + d + "';";		
			ResultSet rs = statement_1.executeQuery(sql_1);			
			
	    	//��ȡ�����ݱ���������idΪ������	
		    int theNum = 1;
		    SimpleDateFormat f=new SimpleDateFormat("yyyyMMdd"); 		 
	    	while(rs.next()) {	    
	    		String ID = rs.getString("ID");   
	    	    String num = ID.substring(ID.length()-5, ID.length());
 		    	theNum = Integer.valueOf(num) + 1;
	    	}    
	    	if(theNum > 99999)
	    		return null;	    	 
	    	DecimalFormat df = new DecimalFormat(STR_FORMAT);  		    	
	    	res = "XJFYD-" + f.format(date) + "-" + df.format(theNum);
	    	rs.close();   
	    	return res;
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
	    return res;
	}

	private String getSalesAndPurchaseBillNewID(BillCategory category, Date date) {
		// TODO Auto-generated method stub
		String res = null;
		try {
			Statement statement_1 = con.createStatement();	
			int c = BillCategory.getIntByCategory(category);
			java.sql.Date d = new java.sql.Date(date.getTime());
			String sql_1 = "select * from salesandpurchasebill where Category = " + c + " and date = '" + d + "';";		
			ResultSet rs = statement_1.executeQuery(sql_1);			    	
	    	//��ȡ�����ݱ���������idΪ������	
			SimpleDateFormat f=new SimpleDateFormat("yyyyMMdd");  		 
			int theNum = 1;
	    	while(rs.next()) {	    
	    		String ID = rs.getString("ID");   
	    	    String num = ID.substring(ID.length()-5, ID.length());
 		    	theNum = Integer.valueOf(num) + 1;
 		    }
	    	if(theNum>99999)
	    		return null;
	    	 if(category.equals(BillCategory.Sales)) {
	 		        DecimalFormat df = new DecimalFormat(STR_FORMAT);  
	 		    	res = "XSD-" + f.format(date) + "-" + df.format(theNum);
	 		    }
	    	    else if(category.equals(BillCategory.SalesReturn)) {
	    	    	 DecimalFormat df = new DecimalFormat(STR_FORMAT);  
		 		    	res = "XSTHD-" + f.format(date) + "-" + df.format(theNum);
	    	    }
	    	    else if(category.equals(BillCategory.Purchase)) {
	    	    	 DecimalFormat df = new DecimalFormat(STR_FORMAT);  
		 		    	res = "JHD-" + f.format(date) + "-" + df.format(theNum);
	    	    }
	    	    else if(category.equals(BillCategory.PurchaseReturn)) {
	    	    	 DecimalFormat df = new DecimalFormat(STR_FORMAT);  
		 		    	res = "JHTHD-" + f.format(date) + "-" + df.format(theNum);
	    	    }
	    	rs.close();   
	    	return res;
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
	    return res;
	}

	private String getPayAndReceiveBillNewID(BillCategory category, Date date) {

		String res = null;
		try {
			Statement statement_1 = con.createStatement();	
			int c = BillCategory.getIntByCategory(category);
			java.sql.Date d = new java.sql.Date(date.getTime());
			String sql_1 = "select * from payandreceivebill where Category = " + c + " and date = '" + d + "';";		
			ResultSet rs = statement_1.executeQuery(sql_1);			
			
	    	//��ȡ�����ݱ���������idΪ������	
		    int theNum = 1;
		    SimpleDateFormat f=new SimpleDateFormat("yyyyMMdd"); 		 
	    	while(rs.next()) {	    
	    		String ID = rs.getString("ID");   
	    	    String num = ID.substring(ID.length()-5, ID.length());
 		    	theNum = Integer.valueOf(num) + 1;
	    	}    
	    	if(theNum > 99999)
	    		return null;
	    	 if(category.equals(BillCategory.Pay)) {
	 		        DecimalFormat df = new DecimalFormat(STR_FORMAT);  
	 		    	res = "FKD-" + f.format(date) + "-" + df.format(theNum);
	 		    }
	    	    else if(category.equals(BillCategory.Receive)) {
	    	    	 DecimalFormat df = new DecimalFormat(STR_FORMAT);  
		 		    	res = "SKD-" + f.format(date) + "-" + df.format(theNum);
	    	    }
	    	rs.close();   
	    	return res;
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
	    return res;
	}
}

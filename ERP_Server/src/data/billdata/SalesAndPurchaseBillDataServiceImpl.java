package data.billdata;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import databaseutil.DatabaseConnection;
import dataservice.billdataservice.SalesAndPurchaseBillDataService;
import po.BillCategory;
import po.BillState;
import po_salesandpurchasebill.GoodsItem;
import po_salesandpurchasebill.SalesAndPurchaseBillPO;

public class SalesAndPurchaseBillDataServiceImpl implements SalesAndPurchaseBillDataService{
	private Connection con = DatabaseConnection.getConn();
	
	@Override
	public SalesAndPurchaseBillPO searchSalesAndPurchaseBillByID(BillCategory category, String id)
			throws RemoteException {
		// TODO Auto-generated method stub
		SalesAndPurchaseBillPO bill = null;
		ArrayList<GoodsItem> itemList = new ArrayList<GoodsItem>();

		try {
			String dataId = id.replace("-", "_");
			Statement statement_1 = con.createStatement();	
			String sql_1 = "select * from salesandpurchasebill where ID =  "+"'"+ id+"' and "
					+"category = " +"'"+ BillCategory.getIntByCategory(category)+"'";		
			ResultSet rs = statement_1.executeQuery(sql_1);			    	
			Statement statement_2 = con.createStatement();	
	    	//��ȡ�����ݱ���������idΪ������
	    	String sql_2 = "select * from " + dataId;		
		    
	    	while(rs.next()) {	    
	    		BillState state = BillState.getStateByInt(rs.getInt("State"));  	
	    		String ID = rs.getString("ID");
	    		String CustomerID = rs.getString("CustomerID");
	    		String Staff = rs.getString("Staff");
	    		String UserID = rs.getString("UserID");
	    		String WareID = rs.getString("WareID");
	    		double DiscountAmount = rs.getDouble("DiscountAmount");
	    		double Voucher = rs.getDouble("Voucher");
	    		String Remark = rs.getString("Remark");    		
	    		java.sql.Date date = rs.getDate("Date");	    		   	    		    	
	    		
	    		ResultSet rs_2 = statement_2.executeQuery(sql_2);	    
	    		String number = null;
		        String name = null;
		        String size = null;
		        long amount = 0;
		        double price = 0;
		        //double totalPrice = 0;
		        String remark = null;
		    
		        while(rs_2.next()) {    	
		        	number = rs_2.getString("GoodsID");
		    	    name = rs_2.getString("Name");
		    	    size = rs_2.getString("Size");
		    	    amount = rs_2.getLong("Amount");
		    	    price = rs_2.getDouble("Price");
		    	   // totalPrice = rs_2.getDouble("TotalPrice");		    	
		    	    remark = rs_2.getString("Remark");	
		    	    GoodsItem item = new GoodsItem(number, name, size,amount, price, remark);
		    	    itemList.add(item);
		        }		    			
		        bill = new SalesAndPurchaseBillPO(category, state, ID, CustomerID, Staff, UserID, WareID, itemList, DiscountAmount, Voucher, Remark, date);
		        rs_2.close();    	   
	    	}
		    rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
		return bill;
	}


	@Override
	public ArrayList<String> searchSalesAndPurchaseBillByInfo(Date start, Date end, 
			BillCategory category,String CustomerId ,String UserId, String WareId)
			throws RemoteException {
		// TODO Auto-generated method stub
		java.sql.Date ds = new java.sql.Date(start.getTime());
		java.sql.Date es = new java.sql.Date(end.getTime());
		int ca = BillCategory.getIntByCategory(category);
		
		ArrayList<String> list = new ArrayList<String>();
		try {	
			Statement statement_1 = con.createStatement();	
			String sql_1 ="SELECT *" + 
					"FROM salesandpurchasebill " + 
					"WHERE Date BETWEEN ' "+ds + "' AND ' " + es + "'" +
					" and Category = " + ca +
					" and CustomerID = '" + CustomerId + "'" +
					" and UserID = '" + UserId + "'" +
					"and WareId = '" + WareId + "';";
			ResultSet rs = statement_1.executeQuery(sql_1);
		    String id = null;		      


		    while(rs.next()){
		    	id = rs.getString("ID");	 		    	
		    	list.add(id);		       			   
		    }	    
		    rs.close();
		} catch(SQLException e) {            
			e.printStackTrace();  	            
		}catch (Exception e) {           
			e.printStackTrace();	       
		}
		return list;
	}

	@Override
	public ArrayList<SalesAndPurchaseBillPO> getAllSalesAndPurchaseBill() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<SalesAndPurchaseBillPO> billList = new ArrayList<SalesAndPurchaseBillPO>();
		ArrayList<GoodsItem> itemList = new ArrayList<GoodsItem>();

		try {
			Statement statement_1 = con.createStatement();	
			String sql_1 = "select * from salesandpurchasebill";		
			ResultSet rs = statement_1.executeQuery(sql_1);			    	
			Statement statement_2 = con.createStatement();	
	    	//��ȡ�����ݱ���������idΪ������
		    
	    	while(rs.next()) {	    
	    		BillCategory category = BillCategory.getCategoryByInt(rs.getInt("Category"));
	    		BillState state = BillState.getStateByInt(rs.getInt("State"));  	
	    		String ID = rs.getString("ID");
	    		String CustomerID = rs.getString("CustomerID");
	    		String Staff = rs.getString("Staff");
	    		String UserID = rs.getString("UserID");
	    		String WareID = rs.getString("WareID");
	    		double DiscountAmount = rs.getDouble("DiscountAmount");
	    		double Voucher = rs.getDouble("Voucher");
	    		String Remark = rs.getString("Remark");    		
	    		java.sql.Date date = rs.getDate("Date");	    		   	    		    	
	    		
	    		String dataId = ID.replace("-", "_");
		    	String sql_2 = "select * from " + dataId ;		
	    		ResultSet rs_2 = statement_2.executeQuery(sql_2);	    
	    		String number = null;
		        String name = null;
		        String size = null;
		        long amount = 0;
		        double price = 0;
		        String remark = null;
		    
		        while(rs_2.next()) {    	
		        	number = rs_2.getString("GoodsID");
		    	    name = rs_2.getString("Name");
		    	    size = rs_2.getString("Size");
		    	    amount = rs_2.getLong("Amount");
		    	    price = rs_2.getDouble("Price");  	
		    	    remark = rs_2.getString("Remark");	
		    	    GoodsItem item = new GoodsItem(number, name, size,amount, price, remark);
		    	    itemList.add(item);
		        }		    			
		        SalesAndPurchaseBillPO billItem = new SalesAndPurchaseBillPO(category, state, ID, CustomerID, Staff, UserID, WareID, itemList, DiscountAmount, Voucher, Remark, date);
		        billList.add(billItem);
		        rs_2.close();    	   
	    	}
		    rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
		return billList;
	}

	@Override
	public boolean addSalesAndPurchaseBill(SalesAndPurchaseBillPO bill) throws RemoteException {
		// TODO Auto-generated method stub
		try {	
			Statement statement_1 = con.createStatement();	
			Statement statement_2 = con.createStatement();	
			Statement statement_3 = con.createStatement();	
			
			int state = BillState.getIntByState(bill.getBillState());
			int category = BillCategory.getIntByCategory(bill.getCategory());
			String id = bill.getID();
			String CustomerID = bill.getCustomerID();
			String Staff = bill.getStaff();
			String UserID = bill.getUserID();
			String WareID = bill.getWareID();
			double DiscountAmount = bill.getDiscountAmount();
			double Voucher = bill.getVoucher();
			String Remark = bill.getRemark();
			java.util.Date date = bill.getDate();
			java.sql.Date da = new java.sql.Date(date.getTime());
			
			String sql_1 = "SELECT COUNT(*) FROM account WHERE ID='"
		    		+ id + "';";  
		    ResultSet rs = statement_1.executeQuery(sql_1);
		    rs.next();
		    int x = rs.getInt(1);
		    if (x == 0)  {
		    	String sql = "insert into salesandpurchasebill values(' " + state +"','"+ category  +"','"+ id +"','"+ CustomerID+"','"+
		    			Staff+"','"+ UserID +"','"+ WareID +"',"+DiscountAmount +","+Voucher+",'"+Remark+"','"+da+"')";			    			
		    	statement_1.execute(sql);	    			
		    	ArrayList<GoodsItem> itemList = bill.getGoodsPOList();	    			
		    	String dataId = id.replace("-", "_");	    			
		    	String sql_2 = "CREATE TABLE IF NOT EXISTS erp." + dataId +		             
		    					" (Size char(50), " +		               
		    					"GoodsID char(50), " +		               
		    					"Name char(50)," +
		    					"Amount bigint(20)," +
		    					"Price double," +
		    					"TotalPrice double," +
		    					"Remark char(50));";
	    			
		    	statement_2.execute(sql_2);	    			
		    	for(int i=0 ; i<itemList.size() ; i++) {
		    				GoodsItem item = itemList.get(i);
		    				String sql_3 = "insert into "
		    						+dataId+ " values(' " + item.getSize() +"','"+item.getGoodsID()+"','"+ item.getName() +"',"+ item.getAmount() + ","+ item.getPrice()
		    						+","+item.getTotalPrice() +",'"+ item.getRemark()+"')";   				
		    				statement_3.execute(sql_3);		   
		    	}  
			}
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
		return false;
	}



	@Override
	public boolean deleteSalesAndPurchaseBill(String id) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			Statement statement_1 = con.createStatement();	
			Statement statement_2 = con.createStatement();	
			
			String dataId = id.replace("-", "_");
			String sql_1 = "DELETE FROM salesandpurchasebill WHERE id = '" + dataId + "';";
			statement_1.execute(sql_1);
			
			String sql_2 = "DROP TABLE billgoods" + id;
			statement_2.execute(sql_2);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
		return false;
	}



	@Override
	public boolean updateSalesAndPurchaseBill(SalesAndPurchaseBillPO bill, String updateLoc, String message)
			throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean updateSalesAndPurchaseBillState(BillState newState, String id) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			Statement statement_1 = con.createStatement();	

			int newStateNum = BillState.getIntByState(newState);
			String sql_1 = "UPDATE SalesAndPurchasebill SET State = " + newStateNum
					+ " WHERE id = '" + id + "';";
			statement_1.execute(sql_1);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
		return false;
	}

}

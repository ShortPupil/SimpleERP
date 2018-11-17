package data.billdata;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import databaseutil.DatabaseConnection;
import dataservice.billdataservice.PayAndReceiveBillDataService;
import po.BillCategory;
import po.BillState;
import po_accountbill.PayAndReceiveBillPO;
import po_accountbill.PayAndReceiveItem;

public class PayAndReceiveBillDataServiceImpl implements PayAndReceiveBillDataService{
	
	private Connection con = DatabaseConnection.getConn();
	
	@Override
	public PayAndReceiveBillPO searchPayAndReceiveBillByID(BillCategory category, String id) throws RemoteException {
		// TODO Auto-generated method stub
		PayAndReceiveBillPO bill = null;
		ArrayList<PayAndReceiveItem> itemList = new ArrayList<PayAndReceiveItem>();

		try {
			Statement statement_1 = con.createStatement();	
			
			String sql_1 = "select * from payandreceivebill where ID =  "+"'"+ id+"' and "
					+"category = " +"'"+ BillCategory.getIntByCategory(category)+"'";		
			ResultSet rs = statement_1.executeQuery(sql_1);			    	
			Statement statement_2 = con.createStatement();	
	    	//��ȡ�����ݱ���������idΪ������
			String dataId = id.replace("-", "_").toLowerCase();
	    	String sql_2 = "select * from " + dataId;		
		    
	    	while(rs.next()) {	    
	    		BillState state = BillState.getStateByInt(rs.getInt("State"));  	
	    		String ID = rs.getString("ID");
	    		String CustomerID = rs.getString("CustomerID");
	    		String UserID = rs.getString("UserID");
	    		//double TotalMoney = rs.getDouble("TotalMoney");		
	    		java.sql.Date date = rs.getDate("Date");	    		   	    		    	
	    		
	    		ResultSet rs_2 = statement_2.executeQuery(sql_2);	    
	    		String AccountName = null;
	    		double Money = 0;
	    		String Remark = null;
	    		String itemid = null;
		        while(rs_2.next()) {    	
		        	itemid = rs_2.getString("ID");
		        	AccountName = rs_2.getString("AccountName");
		        	Money = rs_2.getDouble("Money");
		        	Remark = rs_2.getString("Remark");
		    	    PayAndReceiveItem item = new PayAndReceiveItem(itemid, AccountName, Money, Remark);
		    	    itemList.add(item);
		        }		    			
		        bill = new PayAndReceiveBillPO(category, state, ID, CustomerID, UserID, itemList, date);
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
	public ArrayList<String> searchPayAndReceiveBillByInfo(Date start, Date end, BillCategory category,String CustomerID, String UserID) throws RemoteException {
		// TODO Auto-generated method stub
		java.sql.Date ds = new java.sql.Date(start.getTime());
		java.sql.Date es = new java.sql.Date(end.getTime());
		int ca = BillCategory.getIntByCategory(category);
		
		ArrayList<String> list = new ArrayList<String>();
		try {	
			Statement statement_1 = con.createStatement();	
			String sql_1 ="SELECT *" + 
					"FROM PayAndReceivebill " + 
					"WHERE Date BETWEEN ' "+ds + "' AND ' " + es + "'" +
					" and Category = " + ca + 
					" and CustomerID = '" + CustomerID + "'" +
					" and UserID = '" + UserID + "';";
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
	public boolean addPayAndReceiveBill(PayAndReceiveBillPO bill) throws RemoteException {
		// TODO Auto-generated method stub
		try {	
			Statement statement_1 = con.createStatement();	
			Statement statement_2 = con.createStatement();	
			Statement statement_3 = con.createStatement();	
			
			int state = BillState.getIntByState(bill.getBillState());
			int category = BillCategory.getIntByCategory(bill.getCategory());
			String ID = bill.getID();
			String CustomerID = bill.getCustomerID();
			String UserID = bill.getUserID();
			double TotalMoney = bill.getTotalMoney();
			java.util.Date date = bill.getDate();
			java.sql.Date d = new java.sql.Date(date.getTime());
    		
			 String sql = "SELECT COUNT(*) FROM payandreceivebill WHERE ID='" + ID + "';";  			   
			 ResultSet rs = statement_1.executeQuery(sql);
			 rs.next();
			 int x = rs.getInt(1);
			 if (x == 0)  {			   
					String sql_1 = "insert into payandreceivebill values('" + state +"','"+ category  +"','"+ ID +"','"+ CustomerID+"','"+
					UserID +"',"+TotalMoney +",'"+d+"')";
					statement_1.execute(sql_1);
					ArrayList<PayAndReceiveItem> itemList = bill.getList();

					String dataId = ID.replace("-", "_").toLowerCase();
					String sql_2 = "CREATE TABLE IF NOT EXISTS erp." + dataId +		             
							" (ID char(50),"+
						     "AccountName char(50), " +		               
							"Money double, " +		               
							"Remark char(50));";
					statement_2.execute(sql_2);
					for(int i=0 ; i<itemList.size() ; i++) {
						PayAndReceiveItem item = itemList.get(i);
						String sql_3 = "insert into "
								+dataId+ " values('" + item.getId()+"','"+item.getAccountName() +"',"+item.getMoney()+",'"+ item.getRemark() + "')";					
						statement_3.execute(sql_3);	
					}  
					return true;		
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
		return false;
	}

	@Override
	public boolean deletePayAndReceiveBill(String id) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			Statement statement_1 = con.createStatement();	
			Statement statement_2 = con.createStatement();	
			
			String dataId = id.replace("-", "_").toLowerCase();
			String sql_1 = "DELETE FROM payandreceivebill WHERE id = '" + id + "';";
			statement_1.execute(sql_1);
			
			String sql_2 = "DROP TABLE " + dataId;
			statement_2.execute(sql_2);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
		return false;
	}

	@Override
	public boolean updatePayAndReceiveBillState(BillState newState, String id) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			Statement statement_1 = con.createStatement();	

			int newStateNum = BillState.getIntByState(newState);
			String sql_1 = "UPDATE payandreceivebill SET State = " + newStateNum
					+ " WHERE id = '" + id + "';";
			statement_1.execute(sql_1);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
		return false;
	}

	@Override
	public ArrayList<PayAndReceiveBillPO> searchPayAndReceiveBillByUserID(String userid) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<PayAndReceiveBillPO> billList = new ArrayList<PayAndReceiveBillPO>();
		ArrayList<PayAndReceiveItem> itemList = new ArrayList<PayAndReceiveItem>();

		try {
			Statement statement_1 = con.createStatement();	
			String sql_1 = "select * from payandreceivebill where UserID = '" + userid + "';";		
			ResultSet rs = statement_1.executeQuery(sql_1);			    	
			Statement statement_2 = con.createStatement();	
	    	//��ȡ�����ݱ���������idΪ������
		    
	    	while(rs.next()) {	    
	    		BillCategory category = BillCategory.getCategoryByInt(rs.getInt("Category"));
	    		BillState state = BillState.getStateByInt(rs.getInt("State"));  	
	    		String ID = rs.getString("ID");
	    		String CustomerID = rs.getString("CustomerID");
	    		String UserID = rs.getString("UserID");

	    		//double TotalMoney = rs.getDouble("TotalMoney");  		
	    		java.sql.Date date = rs.getDate("Date");	    		   	    		    	
	    		
	    		String dataId = ID.replace("-", "_");
		    	String sql_2 = "select * from " + dataId ;		
	    		ResultSet rs_2 = statement_2.executeQuery(sql_2);	    
	    		String id = null;
		        String accountName = null;
		        double money = 0;
		        String remark = null;
		    
		        while(rs_2.next()) {    	
		        	id = rs_2.getString("ID");
		    	    accountName = rs_2.getString("AccountName");
		    	    money = rs_2.getDouble("Money");  	
		    	    remark = rs_2.getString("Remark");	
		    	    PayAndReceiveItem item = new PayAndReceiveItem(id, accountName, money, remark);
		    	    itemList.add(item);
		        }		    			
		        PayAndReceiveBillPO billItem = new PayAndReceiveBillPO(category, state, ID, CustomerID, UserID,  itemList,  date);
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

}

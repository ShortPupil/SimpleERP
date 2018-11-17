package data.billdata;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import databaseutil.DatabaseConnection;
import dataservice.billdataservice.StockGiftBillDataService;
import po.BillState;
import po_stockbill.StockGiftBillItem;
import po_stockbill.StockGiftBillPO;

public class StockGiftBillDataServiceImpl implements StockGiftBillDataService{
	
	private Connection con = DatabaseConnection.getConn();
	
	@Override
	public StockGiftBillPO searchStockGiftBillByID(String id) throws RemoteException {
		// TODO Auto-generated method stub
		StockGiftBillPO bill = null;
		ArrayList<StockGiftBillItem> itemList = new ArrayList<StockGiftBillItem>();

		try {
			Statement statement_1 = con.createStatement();	
			String sql_1 = "select * from stockgiftbill where ID =  "+"'"+ id+"'";		
			ResultSet rs = statement_1.executeQuery(sql_1);			    	
			Statement statement_2 = con.createStatement();	
	    	//��ȡ�����ݱ���������idΪ������
	    	String sql_2 = "select * from stock" + id;		
		    
	    	while(rs.next()) {	    
	    		BillState state = BillState.getStateByInt(rs.getInt("State"));  	
	    		Date date = rs.getDate("Date");	    	
	    		String operatorID = rs.getString("OperatorID");
	    		String wareID = rs.getString("WareID");
	   	    		    	
	    		ResultSet rs_2 = statement_2.executeQuery(sql_2);	    
	    		String number = null;
		        String name = null;
		        long amount = 0;
		        long giftAmount = 0;
		    
		        while(rs_2.next()) {    	
		        	number = rs_2.getString("Number");
		    	    name = rs_2.getString("Name");
		    	    amount = rs_2.getLong("Amount");
		    	    giftAmount = rs_2.getLong("GiftAmount");
		    	
		    	    StockGiftBillItem item = new StockGiftBillItem(number, name, amount, giftAmount);
		    	    itemList.add(item);
		        }		    			
		        bill = new StockGiftBillPO( id, itemList, state, date, operatorID, wareID);
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
	public ArrayList<StockGiftBillPO> getAllStockGiftBill() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<StockGiftBillPO> list = new ArrayList<StockGiftBillPO>();
		ArrayList<StockGiftBillItem> itemList = new ArrayList<StockGiftBillItem>();
		try {	
			Statement statement_1 = con.createStatement();	
			String sql_1 = "select * from stockgiftbill";				
			ResultSet rs = statement_1.executeQuery(sql_1);
		    BillState state = null;
		    String id = null;		      
		    java.sql.Date date = null;		       
		    String operatorID = null;	
		    String wareID = null;

		    while(rs.next()){
		    	state = BillState.getStateByInt(rs.getInt("State"));
		    	id = rs.getString("ID");
		    	date = rs.getDate("Date");
		    	java.util.Date d = new java.util.Date(date.getTime());
		    	operatorID = rs.getString("OperatorID");
		    	wareID = rs.getString("WareID");
		    	
		    	Statement statement_2 = con.createStatement();	
		    	//��ȡ�����ݱ���������idΪ������
		    	String sql_2 = "select * from stock" + id;		
		    	ResultSet rs_2 = statement_2.executeQuery(sql_2);
			    String number = null;
			    String name = null;
			    long amount = 0;
			    long giftAmount = 0;
			    
			    while(rs_2.next()) {
			    	number = rs_2.getString("Number");
			    	name = rs_2.getString("Name");
			    	amount = rs_2.getLong("Amount");
			    	giftAmount = rs_2.getLong("GiftAmount");
			    	
			    	StockGiftBillItem item = new StockGiftBillItem(number, name, amount, giftAmount);
			    	itemList.add(item);
			    }		    			    
		    	StockGiftBillPO bill = new StockGiftBillPO( id, itemList, state, d, operatorID, wareID);
		    	list.add(bill);	    
		    	rs_2.close();
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
	public boolean addStockGiftBill(StockGiftBillPO bill) throws RemoteException {
		// TODO Auto-generated method stub
		try {	
			Statement statement_1 = con.createStatement();	
			Statement statement_2 = con.createStatement();	
			Statement statement_3 = con.createStatement();	
			int state = BillState.getIntByState(bill.getState());
			String id = bill.getID();
			java.util.Date date = bill.getDate();
			java.sql.Date d = new java.sql.Date(date.getTime());
			String operatorid = bill.getOperatorID();
			String wareid = bill.getWareID();
			String sql_1 = "insert into stockgiftbill values(' " + state +"','"+ id +"','"+ d+"','"+ operatorid+"','"+wareid+"')";		
			statement_1.execute(sql_1);

			ArrayList<StockGiftBillItem> itemList = bill.getItemList();

			String sql_2 = "CREATE TABLE IF NOT EXISTS erp.stock" + id +		             
					" (Number char(10), " +		               
					"Name char(10), " +		               
					"Amount bigint(20)," +
					"GiftAmount bigint(20));";
			statement_2.execute(sql_2);
			for(int i=0 ; i<itemList.size() ; i++) {
				StockGiftBillItem item = itemList.get(i);
				String sql_3 = "insert into stock"
						+id+ " values(' " + item.getNumber() +"','"+ item.getName() +"',"+ item.getAmount() 
						+","+ item.getGiftAmount()+")";
				statement_3.execute(sql_3);
			}
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
		return false;
	}


	@Override
	public ArrayList<String> searchStockGiftBillByInfo(java.util.Date start, java.util.Date end
			, String OperatorId, String WareId) throws RemoteException {
		// TODO Auto-generated method stub
		java.sql.Date ds = new java.sql.Date(start.getTime());
		java.sql.Date es = new java.sql.Date(end.getTime());
		
		ArrayList<String> list = new ArrayList<String>();
		try {	
			Statement statement_1 = con.createStatement();	
			String sql_1 ="SELECT *" + 
					"FROM stockgiftbill " + 
					"WHERE Date BETWEEN ' "+ds + "' AND ' " + es + "'" + 
					" and OperatorID = '" + OperatorId + "'" +
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
	public boolean deleteStockGiftBill(String id) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			Statement statement_1 = con.createStatement();	
			Statement statement_2 = con.createStatement();	
			
			String sql_1 = "DELETE FROM stockalarmbill WHERE id = '" + id + "';";
			 statement_1.execute(sql_1);
			
			String sql_2 = "DROP TABLE stock" + id;
			statement_2.execute(sql_2);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
		return false;
	}

	@Override
	public boolean updateStockGiftBillState(BillState newState, String id) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			Statement statement_1 = con.createStatement();	

			int newStateNum = BillState.getIntByState(newState);
			String sql_1 = "UPDATE stockgiftbill SET State = " + newStateNum
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
	public boolean updateStockGiftBill(StockGiftBillPO bill, String update, String message) throws RemoteException {
		// TODO Auto-generated method stub
		String flag = null;
		String id = bill.getID();
		if(update.equals("operatorID")) {
			flag = "OperatorID";
		}else if(update.equals("WareID")) {
			flag = "WareID";
		}
		try {
			Statement statement_1 = con.createStatement();	
			String sql_1 = "UPDATE stockgiftbill SET " + flag + " = '" + message
					+ "' WHERE id = '" + id + "';";
			statement_1.execute(sql_1);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
		return false;
	}

}

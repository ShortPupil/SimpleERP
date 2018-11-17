package data.billdata;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import databaseutil.DatabaseConnection;
import dataservice.billdataservice.StockAlarmBillDataService;
import po.BillState;
import po_stockbill.StockAlarmBillItem;
import po_stockbill.StockAlarmBillPO;

public class StockAlarmBillDataServiceImpl implements StockAlarmBillDataService{
	private Connection con = DatabaseConnection.getConn();

	@Override
	public ArrayList<StockAlarmBillPO> getAllStockAlarmBill() throws RemoteException {
		// TODO Auto-generated method stub	
		ArrayList<StockAlarmBillPO> list = new ArrayList<StockAlarmBillPO>();
		ArrayList<StockAlarmBillItem> itemList = new ArrayList<StockAlarmBillItem>();
		try {	
			Statement statement_1 = con.createStatement();	
			String sql_1 = "select * from stockalarmbill";				
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
			    long alarmAmount = 0;
			    
			    while(rs_2.next()) {
			    	number = rs_2.getString("Number");
			    	name = rs_2.getString("Name");
			    	amount = rs_2.getLong("Amount");
			    	alarmAmount = rs_2.getLong("AlarmAmount");
			    	
			    	StockAlarmBillItem item = new StockAlarmBillItem(number, name, amount, alarmAmount);
			    	itemList.add(item);
			    }		    			    
		    	StockAlarmBillPO bill = new StockAlarmBillPO( id, itemList, state, d, operatorID, wareID);
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
	public StockAlarmBillPO searchStockAlarmBillByID(String id) throws RemoteException {
		// TODO Auto-generated method stub
		StockAlarmBillPO bill = null;
		ArrayList<StockAlarmBillItem> itemList = new ArrayList<StockAlarmBillItem>();

		try {
			Statement statement_1 = con.createStatement();	
			String sql_1 = "select * from stockalarmbill where ID =  "+"'"+ id+"'";		
			ResultSet rs = statement_1.executeQuery(sql_1);			    	
			Statement statement_2 = con.createStatement();	
	    	//��ȡ�����ݱ���������idΪ������
	    	String sql_2 = "select * from stock" + id;		
		    
	    	while(rs.next()) {	    
	    		BillState state = BillState.getStateByInt(rs.getInt("State"));  	
	    		java.sql.Date date = rs.getDate("Date");	    	
	    		String operatorID = rs.getString("OperatorID");
	   	    	String wareID = rs.getString("wareID");
	   	    	
	    		ResultSet rs_2 = statement_2.executeQuery(sql_2);	    
	    		String number = null;
		        String name = null;
		        long amount = 0;
		        long alarmAmount = 0;
		    
		        while(rs_2.next()) {    	
		        	number = rs_2.getString("Number");
		    	    name = rs_2.getString("Name");
		    	    amount = rs_2.getLong("Amount");
		    	    alarmAmount = rs_2.getLong("AlarmAmount");
		    	
		    	    StockAlarmBillItem item = new StockAlarmBillItem(number, name, amount, alarmAmount);
		    	    itemList.add(item);
		        }		    			
		        java.util.Date d = new java.util.Date(date.getTime());
		        bill = new StockAlarmBillPO( id, itemList, state, d, operatorID, wareID);
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
	public boolean addStockAlarmBill(StockAlarmBillPO bill) throws RemoteException {
		// TODO Auto-generated method stub
		try {	
			Statement statement_1 = con.createStatement();	
			Statement statement_2 = con.createStatement();	
			Statement statement_3 = con.createStatement();	
			int state = BillState.getIntByState(bill.getState());
			String id = bill.getId();
			java.util.Date date = bill.getDate();
			java.sql.Date d = new java.sql.Date(date.getTime());
			String operatorid = bill.getOperatorID();
			String wareid = bill.getWareID();
			String sql_1 = "insert into stockalarmbill values(' " + state +"','"+ id +"','"+ d+"','"+ operatorid+"','"
					+ wareid+"')";		
			statement_1.execute(sql_1);

			ArrayList<StockAlarmBillItem> itemList = bill.getItemList();

			String sql_2 = "CREATE TABLE IF NOT EXISTS erp.stock" + id +		             
					" (Number char(10), " +		               
					"Name char(10), " +		               
					"Amount bigint(20)," +
					"AlarmAmount bigint(20));";
			 statement_2.execute(sql_2);
			for(int i=0 ; i<itemList.size() ; i++) {
				StockAlarmBillItem item = itemList.get(i);
				String sql_3 = "insert into stock"
						+id+ " values(' " + item.getNumber() +"','"+ item.getName() +"',"+ item.getAmount() 
						+","+ item.getAlarmAmount()+")";
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
	public ArrayList<String> searchStockAlarmBillByInfo(Date start, Date end, 
			String OperatorId, String WareId) throws RemoteException {
		// TODO Auto-generated method stub
		java.sql.Date ds = new java.sql.Date(start.getTime());
		java.sql.Date es = new java.sql.Date(end.getTime());
		
		ArrayList<String> list = new ArrayList<String>();
		try {	
			Statement statement_1 = con.createStatement();	
			String sql_1 ="SELECT *" + 
					"FROM stockalarmbill " + 
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
	public boolean deleteStockAlarmBill(String id) throws RemoteException {
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
	public boolean updateStockAlarmBillState(BillState newState, String id) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			Statement statement_1 = con.createStatement();	

			int newStateNum = BillState.getIntByState(newState);
			String sql_1 = "UPDATE StockAlarmbill SET State = " + newStateNum
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

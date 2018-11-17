package data.billdata;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import databaseutil.BaseDao;
import databaseutil.DatabaseConnection;
import dataservice.billdataservice.CashBillDataService;
import po_accountbill.CashBillPO;
import po_accountbill.CashItem;

public class CashBillDataServiceImpl extends BaseDao<CashBillPO> implements CashBillDataService{
	private Connection con = DatabaseConnection.getConn();
	@Override
	public ArrayList<CashBillPO> searchCashBillByUserID(String userid) throws RemoteException {
		// TODO Auto-generated method stub
		List<CashBillPO> billListByUser = queryList();
		ArrayList<CashBillPO> res = new ArrayList<CashBillPO>();
		for(int i=0 ; i<billListByUser.size() ; i++) {
			CashBillPO billInList = billListByUser.get(i);
			if(userid.equals(billInList.getUserID())) {
				res.add(billInList);
			}
		}
		return res;
	}

	@Override
	public CashBillPO searchCashBillByID(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return queryPo(id);
	}

	@Override
	public ArrayList<String> searchCashBillByInfo(Date start, Date end, String UserId)
			throws RemoteException {
		// TODO Auto-generated method stub
		java.sql.Date ds = new java.sql.Date(start.getTime());
		java.sql.Date es = new java.sql.Date(end.getTime());
		
		ArrayList<String> list = new ArrayList<String>();
		try {	
			Statement statement_1 = con.createStatement();	
			String sql_1 ="SELECT *" + 
					"FROM cashbill " + 
					"WHERE Date BETWEEN ' "+ds + "' AND ' " + es + "'" +
					" and UserID = '" + UserId + "';";
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
	public boolean addCashBill(CashBillPO bill) throws RemoteException {
		// TODO Auto-generated method stub
		try {	
			Statement statement_1 = con.createStatement();	
			Statement statement_2 = con.createStatement();	
			Statement statement_3 = con.createStatement();	

			String ID = bill.getID();
			String UserID = bill.getUserID();
			String AccountName = bill.getAccountName();
			double TotalMoney = bill.getTotalMoney();
			java.util.Date date = bill.getDate();
			java.sql.Date d = new java.sql.Date(date.getTime());
    		
			 String sql = "SELECT COUNT(*) FROM cashbill WHERE ID='" + ID + "';";  			   
			 ResultSet rs = statement_1.executeQuery(sql);
			 rs.next();
			 int x = rs.getInt(1);
			 if (x == 0)  {			   
					String sql_1 = "insert into cashbill values('" + ID +"','"+ UserID +"','"+AccountName + "'," + TotalMoney +",'"+d+"')";
					statement_1.execute(sql_1);
					ArrayList<CashItem> itemList = bill.getItemList();

					String dataId = ID.replace("-", "_").toLowerCase();
					String sql_2 = "CREATE TABLE IF NOT EXISTS erp." + dataId +		             
							" (ID char(50), "+
							"Flag int(10), "+
						     "Name char(50), " +		               
							"Money double, " +		               
							"Remark char(50));";
					statement_2.execute(sql_2);
					for(int i=0 ; i<itemList.size() ; i++) {
						CashItem item = itemList.get(i);
						String sql_3 = "insert into "
								+dataId+ " values('" + item.getID()+"',"+item.getInOut() +",'"
								+item.getItemName()+"',"+ item.getItemMoney() + ",'" + item.getRemark() + "')";
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
	public boolean deleteCashBill(String id) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			Statement statement_1 = con.createStatement();	
			Statement statement_2 = con.createStatement();	
			
			String dataId = id.replace("-", "_").toLowerCase();
			String sql_1 = "DELETE FROM cashbill WHERE id = '" + id + "';";
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

}

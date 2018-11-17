package data.billdata;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import databaseutil.DatabaseConnection;
import dataservice.billdataservice.CashItemDataService;
import po_accountbill.CashItem;

public class CashItemDataServiceImpl implements CashItemDataService{

	private Connection con = DatabaseConnection.getConn();
	@Override
	public boolean addCashItem(String billID, CashItem item) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			String formName = billID.replace("-", "_").toLowerCase();
			
			Statement statement_1 = con.createStatement();
			Statement statement_2 = con.createStatement();
			String id = item.getID();
			int flag = item.getInOut();
			String name = item.getItemName();
			double money = item.getItemMoney();
			String remark = item.getRemark();
			String sql_1 = "insert into " + formName
					+ " values('"+id + "',"+flag+",'"+ name+"',"+ money +",'" + remark + "');";		
			statement_1.execute(sql_1);
			
			//ͬʱ�޸�bill���ܽ��		
			String sql_2 = null;
			if(flag == 1)
				sql_2 =  "update cashbill SET TotalMoney = TotalMoney + " + money + " where ID = '" +billID + "';";
			else if(flag == 0) {
				sql_2 =  "update cashbill SET TotalMoney = TotalMoney - " + money + " where ID = '" +billID + "';";
			}
			statement_2.execute(sql_2);
			return true;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
		return false;
	}

	@Override
	public boolean deleteCashItem(String billID, String id) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			String formName = billID.replace("-", "_").toLowerCase();		
			
			Statement statement_1 = con.createStatement();
			Statement statement_2 = con.createStatement();
			Statement statement_3 = con.createStatement();
			String sql_1 = "DELETE FROM " + formName
					+ " WHERE ID = '" + id + "';";
			
			//ͬʱ�޸�bill���ܽ��			
			double money = 0;
			int flag = 0;
			String sql_2 = "select * from  " + formName + " where ID = " + id + ";";
			ResultSet rs = statement_2.executeQuery(sql_2);
			while(rs.next()) {
				money = rs.getDouble("Money");
				flag = rs.getInt("Flag");
			}
			String sql_3 = null;
			if(flag == 1) {  sql_3 = "update cashbill SET TotalMoney = TotalMoney-" + money + " where ID = '" +billID + "';";}
			else if(flag == 0) { sql_3 = "update cashbill SET TotalMoney = TotalMoney+" + money + " where ID = '" +billID + "';";}
			statement_3.execute(sql_3);
			
			statement_1.execute(sql_1);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
		return false;
	}

}

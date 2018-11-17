package data.billdata;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import databaseutil.DatabaseConnection;
import dataservice.billdataservice.PayAndReceiveItemDataService;
import po_accountbill.PayAndReceiveBillPO;
import po_accountbill.PayAndReceiveItem;

public class PayAndReceiveItemDataServiceImpl implements PayAndReceiveItemDataService{

	private Connection con = DatabaseConnection.getConn(); 
	@Override
	public boolean addPayAndReceiveItem(String billID, PayAndReceiveItem item) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			String formName = billID.replace("-", "_").toLowerCase();
			
			Statement statement_1 = con.createStatement();
			Statement statement_3 = con.createStatement();
			String id = item.getId();
			String accountName = item.getAccountName();
			double money = item.getMoney();
			String remark = item.getRemark();
			String sql_1 = "insert into " + formName
					+ " values('"+id + "','"+ accountName+"',"+ money +",'" + remark + "');";		
			statement_1.execute(sql_1);
			
			//ͬʱ�޸�bill���ܽ��			
			String sql_3 =  "update payandreceivebill SET TotalMoney = TotalMoney + " + money + " where ID = '" +billID + "';";
			statement_3.execute(sql_3);
			return true;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
		return false;
	}

	@Override
	public boolean deletePayAndReceiveItem(String billID, String id) throws RemoteException {
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
			String sql_2 = "select * from  " + formName + " where ID = " + id + ";";
			ResultSet rs = statement_2.executeQuery(sql_2);
			while(rs.next()) {
				money = rs.getDouble("Money");
			}
			String sql_3 =  "update payandreceivebill SET TotalMoney = TotalMoney-" + money + " where ID = '" +billID + "';";
			statement_3.execute(sql_3);
			
			statement_1.execute(sql_1);
			return true;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
		return false;
	}

	/**
	 * ����item
	 * @param updateLoc �����ֱ�ʾ�޸�����
	 * �޸�����Ϊ0���޸Ľ��Ϊ1���޸ı�עΪ2
	 * */
	@Override
	public boolean updatePayAndReceiveItem(String billID, String id, int updateLoc, String message)
			throws RemoteException {
		// TODO Auto-generated method stub
		try {
		
			String formName = billID.replace("-", "_");		
			String sql = "update " + formName+ " SET ";		
		Statement statement_3 = con.createStatement();
		Statement statement_2 = con.createStatement();
		if(updateLoc == 0) {
			sql = sql + "AccountName = '" + message + "' where ID = '" + id + "';";
		}else if(updateLoc == 1) {
			sql = sql + "Money = " + message + " where ID = '" + id + "';";
			//ͬʱ�޸�bill���ܽ��			
			double money = 0;
			String sql_2 = "select * from  " + formName + " where ID = " + id + ";";
			ResultSet rs = statement_2.executeQuery(sql_2);
			while(rs.next()) {
				money = rs.getDouble("Money");
			}
			money = Double.valueOf(message)-money;
			String sql_3 =  "update payandreceivebill SET TotalMoney = TotalMoney + " + money + " where ID = '" +billID + "';";
			statement_3.execute(sql_3);
		}else if(updateLoc == 2) {
			sql = sql + "Remark = '" + message + "' where ID = '" + id + "';";
		}
		
			Statement statement = con.createStatement();
			statement.execute(sql);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return false;
	}

}

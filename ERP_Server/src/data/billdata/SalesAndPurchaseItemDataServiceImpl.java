package data.billdata;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import databaseutil.DatabaseConnection;
import dataservice.billdataservice.SalesAndPurchaseItemDataService;
import po_salesandpurchasebill.GoodsItem;

public class SalesAndPurchaseItemDataServiceImpl implements SalesAndPurchaseItemDataService{
	private Connection con = DatabaseConnection.getConn();
	
	@Override
	public boolean addGoodsItem(String billID, GoodsItem goods) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			String formName = billID.replace("-", "_").toLowerCase();
			
			Statement statement_1 = con.createStatement();
	
			String size = goods.getSize();
			String goodsid = goods.getGoodsID();
			String name = goods.getName();
			long amount = goods.getAmount();
			double price = goods.getPrice();
			double totalprice = goods.getTotalPrice();
			String remark = goods.getRemark();
			String sql_1 = "insert into " + formName
					+ " values('"+size + "','"+ goodsid+"','"+ name +"'," +amount + "," +price + ","
					+totalprice+",'" + remark + "');";		
			statement_1.execute(sql_1);
			
			return true;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
		return false;
	}

	@Override
	public boolean deleteGoodsItem(String billID, String goodsid) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			String formName = billID.replace("-", "_").toLowerCase();		
			
			Statement statement_1 = con.createStatement();
			String sql_1 = "DELETE FROM " + formName
					+ " WHERE GoodsID = '" + goodsid + "';";
			statement_1.execute(sql_1);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
		return false;
	}

	/**�޸�����Ϊ0���޸ĵ���Ϊ1���޸ı�עΪ2*/
	@Override
	public boolean updateGoodsItem(String billID, String goodsid, int updateLoc, String message)
			throws RemoteException {
		// TODO Auto-generated method stub
		try {
			String formName = billID.replace("-", "_").toLowerCase();		
			
			Statement statement_1 = con.createStatement();

			String sql = "update " + formName+ " SET ";		

			if(updateLoc == 0) {
				sql = sql + "Amount = '" + message + "' where GoodsID = '" + goodsid + "';";
				changeTotalPrice(formName, goodsid, 0, message);
			}else if(updateLoc == 1) {
				sql = sql + "Price = " + message + " where GoodsID = '" + goodsid + "';";
				changeTotalPrice(formName, goodsid, 1, message);
			}else if(updateLoc == 2) {
				sql = sql + "Remark = '" + message + "' where GoodsID = '" + goodsid + "';";
			}
			statement_1.execute(sql);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
		return false;
	}

	private void changeTotalPrice(String formName, String goodsid, int flag, String message) {
		// TODO Auto-generated method stub
		try {
		Statement statement_2 = con.createStatement();
		Statement statement_3 = con.createStatement();
		double price = 0;
		long amount = 0;
		String sql_2 = "select * from  " + formName + " where GoodsID = " + goodsid + ";";
		ResultSet rs;

			rs = statement_2.executeQuery(sql_2);
		while(rs.next()) {
			price = rs.getDouble("Price");
			amount = rs.getLong("Amount");
		}
		double TotalPrice = 0;
		if(flag == 1) {
			TotalPrice = Double.valueOf(message)*amount;
		}
		else if(flag == 0) {
			TotalPrice = price*Long.valueOf(message);
		}
		String sql_3 =   "update " + formName+ " SET TotalPrice = " + TotalPrice +" where GoodsID = '" + goodsid + "';";
			statement_3.execute(sql_3);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}
}

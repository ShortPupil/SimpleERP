package dataservice.billdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import po.BillCategory;
import po.BillState;
import po_salesandpurchasebill.SalesAndPurchaseBillPO;

public interface SalesAndPurchaseBillDataService extends Remote{

	/**
	 * 根据id得到单据
	 * @author 钟镇鸿
	 * @param 类别， id
	 * @return  SalesAndPurchaseBillPO
	 * */
	public SalesAndPurchaseBillPO searchSalesAndPurchaseBillByID(BillCategory categoy, String id) throws RemoteException;
	
	/**
	 * 根据模糊信息得到单据
	 * @author 钟镇鸿
	 * @param  开始时间，结束时间，顾客id，操作员id，仓库id
	 * @return SalesAndPurchaseBillPO组成的动态数组
	 * */
	public ArrayList<String> searchSalesAndPurchaseBillByInfo(Date start, Date end, BillCategory category,String CustomerID ,String OperatorId, String WareId) throws RemoteException;
	
	/**
	 * 得到所有单据
	 * @author 钟镇鸿
	 * @param 
	 * @return ArrayList<SalesAndPurchaseBillPO>
	 * */
	public ArrayList<SalesAndPurchaseBillPO> getAllSalesAndPurchaseBill() throws RemoteException;
	
	/**
	 * 新增单据
	 * @author 钟镇鸿
	 * @param SalesAndPurchaseBillPO
	 * @return boolean
	 * */
	public boolean addSalesAndPurchaseBill(SalesAndPurchaseBillPO bill) throws RemoteException;
	
	/**
	 * 删除单据
	 * @author 钟镇鸿
	 * @param 单据id
	 * @return boolean
	 * */
	public boolean deleteSalesAndPurchaseBill(String id) throws RemoteException;
	
	/**
	 * 修改单据内容
	 * @author 钟镇鸿
	 * @param 单据id，修改位置，改后内容
	 * @return boolean
	 * */
	public boolean updateSalesAndPurchaseBill(SalesAndPurchaseBillPO bill, String updateLoc, String message) throws RemoteException;
	
	/**
	 * 修改单据审批状态
	 * @author 钟镇鸿
	 * @param 审批状态， 单据id
	 * @return boolean
	 * */
	public boolean updateSalesAndPurchaseBillState(BillState newState, String id) throws RemoteException;
}

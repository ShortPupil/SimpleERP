package dataservice.billdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import po.BillState;
import po_accountbill.CashBillPO;

public interface CashBillDataService extends Remote{

	/**
	 * 得到某操作员名下所有单据
	 * @author 钟镇鸿
	 * @param
	 * @return CashBillPO组成的动态数组
	 * */
	public ArrayList<CashBillPO> searchCashBillByUserID(String userid) throws RemoteException;
	
	/**
	 * 根据id得到单据
	 * @author 钟镇鸿
	 * @param 类别， id
	 * @return CashBillPO
	 * */
	public CashBillPO searchCashBillByID(String id) throws RemoteException;
	
	/**
	 * 根据模糊信息得到单据
	 * @author 钟镇鸿
	 * @param  开始时间，结束时间，顾客id，操作员id
	 * @return id组成的动态数组
	 * */
	public ArrayList<String> searchCashBillByInfo(Date start, Date end ,String OperatorId) throws RemoteException;
	
	/**
	 * 新增单据
	 * @author 钟镇鸿
	 * @param CashBill
	 * @return boolean
	 * */
	public boolean addCashBill(CashBillPO bill) throws RemoteException;
	
	/**
	 * 删除单据
	 * @author 钟镇鸿
	 * @param 单据id
	 * @return boolean
	 * */
	public boolean deleteCashBill(String id) throws RemoteException;
	
}

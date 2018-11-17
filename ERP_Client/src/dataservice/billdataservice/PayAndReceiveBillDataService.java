package dataservice.billdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import po.BillCategory;
import po.BillState;
import po_accountbill.PayAndReceiveBillPO;

public interface PayAndReceiveBillDataService extends Remote{

	/**
	 * 得到某操作员名下所有单据
	 * @author 钟镇鸿
	 * @param
	 * @return PayAndReceivePO组成的动态数组
	 * */
	public ArrayList<PayAndReceiveBillPO> searchPayAndReceiveBillByUserID(String userid) throws RemoteException;
	
	/**
	 * 根据id得到单据
	 * @author 钟镇鸿
	 * @param 类别， id
	 * @return PayAndReceiveBillPO
	 * */
	public PayAndReceiveBillPO searchPayAndReceiveBillByID(BillCategory category, String id) throws RemoteException;
	
	/**
	 * 根据模糊信息得到单据
	 * @author 钟镇鸿
	 * @param  开始时间，结束时间，顾客id，操作员id
	 * @return id组成的动态数组
	 * */
	public ArrayList<String> searchPayAndReceiveBillByInfo(Date start, Date end, BillCategory category,String CustomerID ,String OperatorId) throws RemoteException;
	
	/**
	 * 新增单据
	 * @author 钟镇鸿
	 * @param PayAndReceivePOBill
	 * @return boolean
	 * */
	public boolean addPayAndReceiveBill(PayAndReceiveBillPO bill) throws RemoteException;
	
	/**
	 * 删除单据
	 * @author 钟镇鸿
	 * @param 单据id
	 * @return boolean
	 * */
	public boolean deletePayAndReceiveBill(String id) throws RemoteException;
	
	/**
	 * 修改单据审批状态
	 * @author 钟镇鸿
	 * @param 审批状态， 单据id
	 * @return boolean
	 * */
	public boolean updatePayAndReceiveBillState(BillState newState, String id) throws RemoteException;
}

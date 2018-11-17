package dataservice.stockdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

import po_salesandpurchasebill.SalesStrategyPO;

public interface SalesStrategyDataService extends Remote {

	/**
	 * 根据id查找销售策略
	 * @author 钟镇鸿
	 * @param  id
	 * @return  SalesStrategyPO
	 * */
	public SalesStrategyPO searchSalesStrategyByID(String id) throws RemoteException;
	
	/**
	 * 得到所有销售策略
	 * @author 钟镇鸿
	 * @return SalesStrategyPO组成的map
	 * */
	public Map<String, SalesStrategyPO> getAllSalesStrategy() throws RemoteException;
	
	/**
	 * 新增销售策略
	 * @author 钟镇鸿
	 * */
	public boolean AddSalesStrategy(SalesStrategyPO strategy) throws RemoteException;
	
	/**
	 * 删除销售策略
	 * @author 钟镇鸿
	 * */
	public boolean deleteSalesStrategy(String id) throws RemoteException;

}

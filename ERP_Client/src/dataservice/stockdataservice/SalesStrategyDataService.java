package dataservice.stockdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

import po_salesandpurchasebill.SalesStrategyPO;

public interface SalesStrategyDataService extends Remote {

	/**
	 * ����id�������۲���
	 * @author �����
	 * @param  id
	 * @return  SalesStrategyPO
	 * */
	public SalesStrategyPO searchSalesStrategyByID(String id) throws RemoteException;
	
	/**
	 * �õ��������۲���
	 * @author �����
	 * @return SalesStrategyPO��ɵ�map
	 * */
	public Map<String, SalesStrategyPO> getAllSalesStrategy() throws RemoteException;
	
	/**
	 * �������۲���
	 * @author �����
	 * */
	public boolean AddSalesStrategy(SalesStrategyPO strategy) throws RemoteException;
	
	/**
	 * ɾ�����۲���
	 * @author �����
	 * */
	public boolean deleteSalesStrategy(String id) throws RemoteException;

}

package blservice.stockblservice;

import java.rmi.RemoteException;

import po.GoodsClassificationPO;

public interface GoodsClassificationBLService {

	public GoodsClassificationPO searchGoodsClassificationByID(int id) throws RemoteException;
	public GoodsClassificationPO addGoodsClassification(int type, String name) throws RemoteException;
	public boolean deleteGoodsClassification(int id) throws RemoteException;
	public boolean updateGoodsClassification(GoodsClassificationPO newClassification, int id)throws RemoteException;
}

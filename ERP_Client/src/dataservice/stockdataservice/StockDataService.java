package dataservice.stockdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.GoodsPO;

/**
 * 商品的
 * */
public interface StockDataService extends Remote{

	public GoodsPO searchGoodsByID(String id) throws RemoteException;
	public List<GoodsPO> searchGoodsByInfo(String field) throws RemoteException;
	public List<GoodsPO> getAllGoods() throws RemoteException;

	public boolean addGoods(GoodsPO goods) throws RemoteException;  
	public boolean deleteGoods(String id) throws RemoteException;
	public boolean updateGoods(GoodsPO goods, String id) throws RemoteException;
}

package blservice.stockblservice;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import po.GoodsPO;

public interface GoodsBLService {

	public GoodsPO searchGoodsByID(String number) throws RemoteException;
	public List<GoodsPO> searchGoodsByInfo(String field) throws RemoteException;
	
	public GoodsPO addGoods(String name, String size, int cla, long amount, long alarmAmount, 
			 double defaultPurchasePrice, double defaultPrice, boolean isGiveable, int batch) throws RemoteException;
	public boolean deleteGoods(String number) throws RemoteException;
	public boolean updateGoods(GoodsPO goods, String number) throws RemoteException;
	
}

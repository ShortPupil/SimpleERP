package data.stockdata;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import databaseutil.BaseDao;
import dataservice.stockdataservice.StockDataService;
import po.GoodsPO;

public class StockDataServiceImpl extends BaseDao<GoodsPO> implements StockDataService{

	@Override
	public GoodsPO searchGoodsByID(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return queryPo(id);
	}

	@Override
	public List<GoodsPO> searchGoodsByInfo(String field) throws RemoteException {
		// TODO Auto-generated method stub
		return queryListByInfo(field);
	}

	@Override
	public boolean addGoods(GoodsPO goods) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			addPo(goods);
			return true;
		}catch (Exception e) {
		e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteGoods(String id) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			deletePo(id);
			return true;
		}catch (Exception e) {
		e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateGoods(GoodsPO goods, String id) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			updatePo(goods, id);
			return true;
		}catch (Exception e) {
		e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<GoodsPO> getAllGoods() throws RemoteException {
		// TODO Auto-generated method stub
		return queryList();
	}

}

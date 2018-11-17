package data.stockdata;

import java.rmi.RemoteException;
import java.util.List;

import databaseutil.BaseDao;
import dataservice.stockdataservice.GoodsClassificationDataService;
import po.GoodsClassificationPO;

public class GoodsClassificationDataServiceImpl extends BaseDao<GoodsClassificationPO> implements GoodsClassificationDataService{

	@Override
	public List<GoodsClassificationPO> getAllClassification() throws RemoteException {
		// TODO Auto-generated method stub
		return queryList();
	}

	@Override
	public boolean addClassification(GoodsClassificationPO classification) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			addPo(classification);
			return true;
		}catch (Exception e) {
		e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteClassification(int id) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			deletePo(id + "");
			return true;
		}catch (Exception e) {
		e.printStackTrace();
		}
		return false;
	}

	@Override
	public int getNewClassificationID() throws RemoteException {
		// TODO Auto-generated method stub
		List<GoodsClassificationPO> l = queryList();
		return l.get(l.size()-1).getID()+1;
	}

	@Override
	public boolean updateClassification(GoodsClassificationPO newClassification, int id) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			updatePo(newClassification, id+"");
			return true;
		}catch (Exception e) {
		e.printStackTrace();
		}
		return false;
	}

}

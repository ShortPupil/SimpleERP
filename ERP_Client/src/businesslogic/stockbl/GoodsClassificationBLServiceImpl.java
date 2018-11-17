package businesslogic.stockbl;

import java.rmi.RemoteException;
import java.util.List;

import blservice.stockblservice.GoodsClassificationBLService;
import po.GoodsClassificationPO;
import po.GoodsPO;
import rmi.RemoteHelper;

public class GoodsClassificationBLServiceImpl implements GoodsClassificationBLService{

	@Override
	public GoodsClassificationPO searchGoodsClassificationByID(int id) throws RemoteException {
		// TODO Auto-generated method stub
		List<GoodsClassificationPO> list = RemoteHelper.getInstance().getGoodsClassificationDataService().getAllClassification();
		for(int i=0 ; i<list.size() ; i++) {
			if(id == list.get(i).getID()) {
				return list.get(i);
			}
		}
		return null;
	}

	@Override
	public GoodsClassificationPO addGoodsClassification(int type, String name) throws RemoteException{
		// TODO Auto-generated method stub
		int newID = RemoteHelper.getInstance().getGoodsClassificationDataService().getNewClassificationID();
		GoodsClassificationPO classification = new GoodsClassificationPO(newID, type, name, 0);
		RemoteHelper.getInstance().getGoodsClassificationDataService().addClassification(classification);
		return classification;
	}

	@Override
	public boolean deleteGoodsClassification(int id) throws RemoteException{
		// TODO Auto-generated method stub
		GoodsClassificationPO cla = searchGoodsClassificationByID(id);
		if(cla.getNumberOfGoods() != 0) return false;
		return RemoteHelper.getInstance().getGoodsClassificationDataService().deleteClassification(id);
	}

	@Override
	public boolean updateGoodsClassification(GoodsClassificationPO newClassification, int id) throws RemoteException {
		// TODO Auto-generated method stub
		return RemoteHelper.getInstance().getGoodsClassificationDataService().updateClassification(newClassification, id);
	}

}

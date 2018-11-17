package businesslogic.stockbl;

import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import blservice.stockblservice.GoodsBLService;
import blservice.stockblservice.GoodsClassificationBLService;
import po.GoodsClassificationPO;
import po.GoodsPO;
import rmi.RemoteHelper;

public class GoodsBLServiceImpl implements GoodsBLService{

	private static final String STR_FORMAT = "000000";  
	GoodsClassificationBLService classificationBL = new GoodsClassificationBLServiceImpl();
	@Override
	public GoodsPO searchGoodsByID(String number) throws RemoteException {
		// TODO Auto-generated method stub
		return RemoteHelper.getInstance().getStockDataService().searchGoodsByID(number);
	}

	@Override
	public List<GoodsPO> searchGoodsByInfo(String field) throws RemoteException {
		// TODO Auto-generated method stub
		return RemoteHelper.getInstance().getStockDataService().searchGoodsByInfo(field);
	}

	@Override
	public GoodsPO addGoods(String name, String size, int cla, long amount, long alarmAmount,
			double defaultPurchasePrice, double defaultPrice, boolean isGiveable, int batch)
			throws RemoteException {
		// TODO Auto-generated method stub
		DecimalFormat df = new DecimalFormat(STR_FORMAT);  
		String number = cla + "-";
		GoodsClassificationPO classification = classificationBL.searchGoodsClassificationByID(cla);
		int newNumberOfGoods = classification.getNumberOfGoods() + 1;
		classification.setNumberOfGoods(newNumberOfGoods);
		classificationBL.updateGoodsClassification(classification, cla);
		
		number = number + df.format(newNumberOfGoods);
		Date d = new Date();
		GoodsPO addGoods = new GoodsPO(number, name, size, cla, amount, alarmAmount, 
				defaultPurchasePrice,defaultPrice, isGiveable, batch, d);
		RemoteHelper.getInstance().getStockDataService().addGoods(addGoods);
		return addGoods;
	}

	@Override
	public boolean deleteGoods(String number) throws RemoteException {
		// TODO Auto-generated method stub
		return RemoteHelper.getInstance().getStockDataService().deleteGoods(number);
	}

	@Override
	public boolean updateGoods(GoodsPO goods, String number) throws RemoteException {
		// TODO Auto-generated method stub
		return RemoteHelper.getInstance().getStockDataService().updateGoods(goods, number);
	}

}

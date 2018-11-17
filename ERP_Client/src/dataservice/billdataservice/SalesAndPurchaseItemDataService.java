package dataservice.billdataservice;

import java.rmi.RemoteException;

import po_salesandpurchasebill.GoodsItem;

public interface SalesAndPurchaseItemDataService {

	/**
	 * 新增销售、销售退货、进货、进货退货单的清单某项
	 * @author 钟镇鸿
	 * @param 单据id， 新增的某项
	 * @return boolean
	 * */
	public boolean addGoodsItem(String billID, GoodsItem goods) throws RemoteException;
	
	/**
	 * 删除销售、销售退货、进货、进货退货单的清单某项
	 * @author 钟镇鸿
	 * @param 单据id， 删除的某项名称
	 * @return boolean
	 * */
	public boolean deleteGoodsItem(String billID, String goodsid) throws RemoteException;
	
	/**
	 * 更新item
	 * @param updateLoc 用数字表示修改内容（包括数量，单价，备注）
	 * 修改数量为0，修改单价为1，修改备注为2
	 * @author 钟镇鸿
	 * @return boolean
	 * */
	public boolean updateGoodsItem(String billID, String goodsid , int updateLoc, String message) throws RemoteException;
}

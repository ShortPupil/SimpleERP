package dataservice.billdataservice;

import java.rmi.RemoteException;

import po_salesandpurchasebill.GoodsItem;

public interface SalesAndPurchaseItemDataService {

	/**
	 * �������ۡ������˻��������������˻������嵥ĳ��
	 * @author �����
	 * @param ����id�� ������ĳ��
	 * @return boolean
	 * */
	public boolean addGoodsItem(String billID, GoodsItem goods) throws RemoteException;
	
	/**
	 * ɾ�����ۡ������˻��������������˻������嵥ĳ��
	 * @author �����
	 * @param ����id�� ɾ����ĳ������
	 * @return boolean
	 * */
	public boolean deleteGoodsItem(String billID, String goodsid) throws RemoteException;
	
	/**
	 * ����item
	 * @param updateLoc �����ֱ�ʾ�޸����ݣ��������������ۣ���ע��
	 * �޸�����Ϊ0���޸ĵ���Ϊ1���޸ı�עΪ2
	 * @author �����
	 * @return boolean
	 * */
	public boolean updateGoodsItem(String billID, String goodsid , int updateLoc, String message) throws RemoteException;
}

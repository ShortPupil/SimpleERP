package dataservice.stockdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.GoodsClassificationPO;

public interface GoodsClassificationDataService extends Remote{

		public List<GoodsClassificationPO> getAllClassification() throws RemoteException;

		public int getNewClassificationID() throws RemoteException;
		public boolean addClassification(GoodsClassificationPO classification) throws RemoteException;  
		public boolean deleteClassification(int id) throws RemoteException;
		public boolean updateClassification(GoodsClassificationPO newClassification , int id) throws RemoteException;
}

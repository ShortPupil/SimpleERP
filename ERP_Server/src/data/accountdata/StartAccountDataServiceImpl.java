package data.accountdata;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import databaseutil.BaseDao;
import dataservice.accountdataservice.StartAccountDataService;
import po.StartAccountPO;


public class StartAccountDataServiceImpl extends BaseDao<StartAccountPO>implements StartAccountDataService{
	
	@Override
	public List<StartAccountPO> getAllStartAccount() throws RemoteException {
		// TODO Auto-generated method stub
		return queryList();
	}

	@Override
	public boolean addStartAccount(StartAccountPO startAccount) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			addPo(startAccount);
			return true;
		}catch (Exception e) {
		e.printStackTrace();
		}
		return false;
	}

}

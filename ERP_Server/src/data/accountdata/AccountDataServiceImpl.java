package data.accountdata;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import databaseutil.BaseDao;
import dataservice.accountdataservice.AccountDataService;
import dataservice.customerdataservice.CustomerDataService;
import po.AccountPO;
import po.CustomerPO;

public class AccountDataServiceImpl extends BaseDao<AccountPO> implements AccountDataService {

	@Override
	public List<AccountPO> getAllAccount() throws RemoteException {
		// TODO Auto-generated method stub
		return queryList();
	}

	public AccountPO getAccountByName(String name) throws RemoteException{
		// TODO Auto-generated method stub
		return queryPo(name);
	}
	
	@Override
	public List<AccountPO> searchAccountByInfo(String field) throws RemoteException {
		// TODO Auto-generated method stub
		return queryListByInfo(field);
	}

	@Override
	public boolean addAccount(AccountPO account) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			addPo(account);
			return true;
		}catch (Exception e) {
		e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteAccount(String name) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			deletePo(name);
			return true;
		}catch (Exception e) {
		e.printStackTrace();
		}
		return false;
	}
	
}

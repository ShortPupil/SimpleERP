package data.userdata;

import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import databaseutil.BaseDao;
import dataservice.userdataservice.UserDataService;
import po.UserPO;
import po.UserRole;

public class UserDataServiceImpl extends BaseDao<UserPO> implements UserDataService{
	
	private static final String STR_FORMAT = "00000";  
	
	@Override
	public String getUserNewID(UserRole role) throws RemoteException {
		// TODO Auto-generated method stub
		String res = "";
		int roleInt = UserRole.getIntByState(role);
		res = res + roleInt;
		DecimalFormat df = new DecimalFormat(STR_FORMAT);  
		List<UserPO> list = queryList();
		int counter = list.size()-1;
		while(list.get(counter).getRole() != UserRole.getIntByState(role)) {
			counter--;
		}
		UserPO user = list.get(counter);
		String originalNum = user.getId().substring(1, 6);
	    String num = df.format(Integer.valueOf(originalNum)+1);
	    res = res + num;
		return res;
	}

	@Override
	public UserPO searchUserByID(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return queryPo(id);
	}

	@Override
	public List<UserPO> searchUserByInfo(String field) throws RemoteException {
		// TODO Auto-generated method stub
		return queryListByInfo(field);
	}

	@Override
	public boolean addUser(UserPO user) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			addPo(user);
			return true;
		}catch (Exception e) {
		e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteUser(String id) throws RemoteException {
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
	public boolean updateUser(UserPO user, String id) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			updatePo(user, id);
			return true;
		}catch (Exception e) {
		e.printStackTrace();
		}
		return false;
	}

}

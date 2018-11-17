package businesslogic.userbl;

import java.rmi.RemoteException;

import blservice.userblservice.UserBLService;
import po.UserPO;
import po.UserRole;
import rmi.RemoteHelper;
import vo.UserVO;

public class UserBLServiceImpl implements UserBLService{

	@Override
	public boolean login(boolean isUser, boolean isAdministeror, String id, String password) throws RemoteException {
		// TODO Auto-generated method stub
		UserPO loginuser = RemoteHelper.getInstance().getUserDataService().searchUserByID(id);
		if(loginuser.getName()== null) return false;
		if(isUser && isAdministeror) return false;
		if(isUser && loginuser.getPassword().equals(password) && loginuser.getRole()!=0) return true;
		if(isAdministeror && loginuser.getPassword().equals(password) && loginuser.getRole()==0) return true;
		
		return true;
	}

	@Override
	public UserPO addUser(String name , String password, int role) throws RemoteException {
		// TODO Auto-generated method stub
		String newID = RemoteHelper.getInstance().getUserDataService().getUserNewID(UserRole.getStateByInt(role));
		UserPO newuser = new UserPO(newID, name, password, UserRole.getStateByInt(role));
		RemoteHelper.getInstance().getUserDataService().addUser(newuser);
		return newuser;
	}

	@Override
	public boolean deleteUser(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return RemoteHelper.getInstance().getUserDataService().deleteUser(id);
	}

}

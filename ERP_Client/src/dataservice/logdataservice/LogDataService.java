package dataservice.logdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.LogPO;

public interface LogDataService extends Remote{

	/**模糊查找日志*/
	public ArrayList<LogPO> checkLog() throws RemoteException;
	
	/**新增日志*/
	public boolean addLog(LogPO log) throws RemoteException;
}

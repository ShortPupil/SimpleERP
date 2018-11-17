package dataservice.logdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.LogPO;

public interface LogDataService extends Remote{

	/**ģ��������־*/
	public ArrayList<LogPO> checkLog() throws RemoteException;
	
	/**������־*/
	public boolean addLog(LogPO log) throws RemoteException;
}

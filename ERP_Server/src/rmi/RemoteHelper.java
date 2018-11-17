package rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RemoteHelper {
	public RemoteHelper(){
		initServer();
	}
	
	public void initServer(){
	
		DataRemoteObject dataRemoteObject;
		try {
			dataRemoteObject = new DataRemoteObject();
			LocateRegistry.createRegistry(8880);
			Naming.bind("rmi://127.0.0.1:8880/DataRemoteObject",
					dataRemoteObject);
			System.out.println("Create Registry Server!");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		}
		
	}
	
}

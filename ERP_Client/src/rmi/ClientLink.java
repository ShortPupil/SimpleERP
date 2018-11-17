package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.logdataservice.LogDataService;

public class ClientLink {
	private RemoteHelper remoteHelper;
	public ClientLink() {
		
		linkToServer();
	}
	
	private void linkToServer() {
		
		try {
			remoteHelper = RemoteHelper.getInstance();
			remoteHelper.setRemote(Naming.lookup("rmi://127.0.0.1:8880/DataRemoteObject"));
			System.out.println("linked");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String [] args) {
		ClientLink l = new ClientLink();
	}
}
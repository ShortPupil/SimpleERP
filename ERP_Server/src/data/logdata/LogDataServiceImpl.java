package data.logdata;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.logdataservice.LogDataService;
import po.LogPO;

public class LogDataServiceImpl implements LogDataService{

	String fileName = "src/Log.txt";
	String separator = " : ";
	
	/**
	 * 在文本文件中写数据
	 * @param LogPO对象
	 * @return boolean
	 * */
	public boolean writeLogInfoIntoFile(LogPO log) {
		try {
			//相对路径写文件
			OutputStreamWriter writer = new OutputStreamWriter(
					new FileOutputStream(fileName,true));
			BufferedWriter br = new BufferedWriter(writer);
			String content = log.getOperation() +separator+ log.getTime() +
					separator+ log.getOperator();
 			br.write(content+"\n");	
			br.close();
			return true;
		}catch(IOException e) {
			e.printStackTrace();
		}
		return false;	
	}
	
	/**
	 * 新增日志信息
	 * @param logPO对象
	 * @return boolean
	 * */
	@Override
	public boolean addLog(LogPO log) throws RemoteException {
		// TODO Auto-generated method stub
		if(writeLogInfoIntoFile(log)) {
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<LogPO> checkLog() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<LogPO> res = new ArrayList<LogPO>();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(fileName)));
			String content = null;
			while((content = br.readLine()) != null) {
				String [] a = content.split(separator);
				LogPO newLog = new LogPO(a[0], a[1], a[2]);
				res.add(newLog);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		return res;
	}

}

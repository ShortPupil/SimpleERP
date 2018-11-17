package po_accountbill;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * �ֽ���õ�
 * ���ݱ�ţ�XJFYD-yyyyMMdd-xxxxx��,����Ա����ǰ��¼�û����������˻�����Ŀ�嵥���ܶʱ��
 * ��Ŀ�嵥�а�������Ŀ��������ע��
 * */
public class CashBillPO implements Serializable{

	private String ID;
	private String userID;
	private String AccountName;
	private ArrayList<CashItem> itemList;
	private double totalMoney;
	private Date date;
	
	public CashBillPO(String i, String userid, String accountname, ArrayList<CashItem> list, Date d) {
		this.ID = i;
		this.userID = userid;
		this.AccountName = accountname;
		this.itemList = list;
		for(int j=0 ; j<list.size() ; j++) {
			if(list.get(j).getInOut() == 1) {
				this.totalMoney = this.totalMoney + list.get(j).getItemMoney();
			}
			else if(list.get(j).getInOut() == 0) {
				this.totalMoney = this.totalMoney - list.get(j).getItemMoney();
			}
		}
		this.setDate(d);
	}
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getAccountName() {
		return AccountName;
	}
	public void setAccountName(String accountname) {
		AccountName = accountname;
	}
	public ArrayList<CashItem> getItemList() {
		return itemList;
	}
	public void setItemList(ArrayList<CashItem> list) {
		this.itemList = list;
		for(int j=0 ; j<list.size() ; j++) {
			if(list.get(j).getInOut() == 1) {
				this.totalMoney = this.totalMoney + list.get(j).getItemMoney();
			}
			else if(list.get(j).getInOut() == 0) {
				this.totalMoney = this.totalMoney - list.get(j).getItemMoney();
			}
		}
	}
	
	public double getTotalMoney() {
		return totalMoney;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}

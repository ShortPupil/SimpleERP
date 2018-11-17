package po_accountbill;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import po.BillCategory;
import po.BillState;

/**
 * �տ�͸��
 * ���ݱ�ţ�SKD-yyyyMMdd-xxxxx�����ͻ���ͬʱ������Ӧ�̺������̣�������Ա����ǰ��¼�û�����ת���б��ܶ���ܣ�ʱ��
 * ת���б��е�һ������������˻���ת�˽���ע��
 * */
public class PayAndReceiveBillPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BillState billState;
	private BillCategory category;
	private String ID;
	private String CustomerID;
	private String UserID;
	private ArrayList<PayAndReceiveItem> list;
	private double TotalMoney;
	private Date date;
	
	public PayAndReceiveBillPO(BillCategory bc, BillState bs,  String id, String cid, String oid, 
			ArrayList<PayAndReceiveItem> list, Date d) {
		this.billState = bs;
		this.category = bc;
		this.ID = id;
		this.CustomerID = cid;
		this.UserID = oid;
		this.list = list;
		this.date = d;
		
		for(int i=0 ; i<list.size() ; i++) {
			this.TotalMoney = this.TotalMoney + list.get(i).getMoney();
		}
	}

	public BillState getBillState() {
		return billState;
	}

	public void setBillState(BillState billState) {
		this.billState = billState;
	}

	public BillCategory getCategory() {
		return category;
	}

	public void setCategory(BillCategory category) {
		this.category = category;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(String customerID) {
		CustomerID = customerID;
	}

	public String getUserID() {
		return UserID;
	}

	public void setUserID(String userID) {
		UserID = userID;
	}

	public ArrayList<PayAndReceiveItem> getList() {
		return list;
	}

	public void setList(ArrayList<PayAndReceiveItem> list) {
		this.list = list;
		for(int i=0 ; i<list.size() ; i++) {
			this.TotalMoney = this.TotalMoney + list.get(i).getMoney();
		}
	}
	
	public double getTotalMoney() {
		return this.TotalMoney;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public String toString() {
		return this.toString();
	}
}

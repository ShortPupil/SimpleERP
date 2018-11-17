package po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * �ڳ�����
 * ��Ʒ��Ϣ����Ʒ���࣬ĳһ��Ʒ�����ƣ�����ͺţ�����/�ۼ�(Ĭ��Ϊ����ƽ��)��������ۺ�����ۼ����գ�
 * �ͻ���Ϣ���ͻ����࣬ĳһ���ͻ������ƣ���ϵ��ʽ�ȣ�Ӧ��Ӧ��(֮ǰ����)��
 * �����˻���Ϣ�����ƣ���
 * */
public class StartAccountPO implements Serializable{

	private String name;
	private ArrayList<GoodsPO> goodsList;
	private ArrayList<CustomerPO> customerList;
	private ArrayList<AccountPO> accountList;
	private Date date;

	public StartAccountPO(String n, ArrayList<GoodsPO> gList, ArrayList<CustomerPO> cList, 
			ArrayList<AccountPO> aList, Date d){
		this.name = n;
		this.goodsList = gList;
		this.customerList = cList;
		this.accountList = aList;
		this.date = d;
	}
	
	
	public ArrayList<GoodsPO> getGoodsList() {
		return goodsList;
	}
	
	public void setGoodsList(ArrayList<GoodsPO> goodsList) {
		this.goodsList = goodsList;
	}
	public ArrayList<CustomerPO> getCustomerList() {
		return customerList;
	}
	public void setCustomerList(ArrayList<CustomerPO> customerList) {
		this.customerList = customerList;
	}
	public ArrayList<AccountPO> getAccountList() {
		return accountList;
	}
	public void setAccountList(ArrayList<AccountPO> accountList) {
		this.accountList = accountList;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

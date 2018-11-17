package po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * 期初建账
 * 商品信息（商品分类，某一商品的名称，类别，型号，进价/售价(默认为上年平均)，最近进价和最近售价留空）
 * 客户信息（客户分类，某一个客户的名称，联系方式等，应收应付(之前遗留)）
 * 银行账户信息（名称，余额）
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

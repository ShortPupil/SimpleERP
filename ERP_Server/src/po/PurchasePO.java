package po;

import java.io.Serializable;
import java.util.ArrayList;

public class PurchasePO implements Serializable{
	
	/*单据编号（格式为：JHD-yyyyMMdd-xxxxx，后五位每天从1开始编号，所以一天最多可以生成99999条单子），
	 * 供应商，仓库，操作员，入库商品列表，备注，总额合计。
	 * 其中入库商品列表包含的信息有：商品编号，名称（从商品选择界面进行选择），型号，数量（手动输入），单价（默认为商品信息中的进价），金额，
	 * 备注（手动输入）。*/
	private String number;
	private CustomerPO customer;
	private UserPO user;
	private String wareID;
	private String remark;//备注
	private ArrayList<GoodsPO> goodsPOList = new ArrayList<GoodsPO>();
	private double amount;
	
	public PurchasePO(String num, CustomerPO cus, UserPO u, String w, String r, ArrayList<GoodsPO> l){
		number = num;
		customer =cus;
		user= u;
		wareID = w;
		remark = r;
		goodsPOList = l;
		setAmount(l);
	}
	
	public double getAmount() {
		return amount;
	}
	private void setAmount(ArrayList<GoodsPO> list) {
		double amount = 0;
		for(int i=0 ; i<list.size() ; i++) {
			amount = amount + list.get(i).getTotalPurchasePrice();
		}
		this.amount = amount;
	}
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public CustomerPO getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerPO customer) {
		this.customer = customer;
	}
	public UserPO getUser() {
		return user;
	}
	public void setUser(UserPO user) {
		this.user = user;
	}
	public String getWareID() {
		return wareID;
	}
	public void setWareID(String wareID) {
		this.wareID = wareID;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public ArrayList<GoodsPO> getGoodsPOList() {
		return goodsPOList;
	}
	public void setGoodsPOList(ArrayList<GoodsPO> goodsPOList) {
		this.goodsPOList = goodsPOList;
		setAmount(goodsPOList);
	}

	public String toString() {
		String goodsList = null;
		for(int i=0 ; i<this.goodsPOList.size() ; i++) {
			goodsList = goodsList +","+ this.goodsPOList.get(i).toString();
		}
		return this.number +":"+ this.customer +":"+ this.user +":"+ this.wareID +":"+ this.remark
				+":"+goodsList;
	}
}

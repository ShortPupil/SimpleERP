package po;

import java.io.Serializable;
import java.util.ArrayList;


public class SalesPO implements Serializable{
	/*单据编号（XSD-yyyyMMdd-xxxxx），客户（仅显示销售商），业务员（和这个客户打交道的公司员工，可以设置一个客户的默认业务员），
	操作员（当前登录系统的用户），仓库，出货商品清单，折让前总额，折让，使用代金卷金额，折让后总额，备注。
	出货商品清单中要显示商品的编号，名称（从商品选择界面选择），型号，数量（手工输入），单价（默认为商品信息里的销售价，可修改），
	金额（自动生成），商品备注*/
	private String number;
	private CustomerPO customer;
	private String staff;
	private UserPO user;
	private String wareID;
	private ArrayList<GoodsPO> goodsPOList = new ArrayList<GoodsPO>();
	private double discountAmount;//折让金额
	private double voucher;//代金券
	private String remark;
	/**
	 * 总售价(未计算折让金额和代金卷，只涉及商品的售价)
	 * */
	private double amount;
	
	public SalesPO(String num, CustomerPO cus, String sta, UserPO u, String w,  ArrayList<GoodsPO> l,
			double da, double v, String r){
		number = num;
		customer = cus;
		staff = sta;
		user = u;
		wareID = w;
		goodsPOList = l;
		discountAmount = da;
		voucher = v;
		remark = r;
		
		setAmount(l);
	}
	
	public double getAmount() {
		return amount;
	}
	private void setAmount(ArrayList<GoodsPO> l) {

		for(int i=0 ; i<l.size() ; i++) {
			amount =amount + l.get(i).getTotalPrice();
		}
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
	public String getStaff() {
		return staff;
	}
	public void setStaff(String staff) {
		this.staff = staff;
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
	public ArrayList<GoodsPO> getGoodsPOList() {
		return goodsPOList;
	}
	public void setGoodsPOList(ArrayList<GoodsPO> goodsPOList) {
		this.goodsPOList = goodsPOList;
		setAmount(goodsPOList);
	}
	public double getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}
	public double getVoucher() {
		return voucher;
	}
	public void setVoucher(double voucher) {
		this.voucher = voucher;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String toString() {
		String goodsList = null;
		for(int i=0 ; i<this.goodsPOList.size() ; i++) {
			goodsList = goodsList +","+ this.goodsPOList.get(i).toString();
		}
		return this.number +":"+ this.customer +":"+ this.staff +":"+ this.user +":"+
				this.wareID +":"+ goodsList +":"+ this.discountAmount +
				":"+ this.voucher+":"+this.remark;
	}
}

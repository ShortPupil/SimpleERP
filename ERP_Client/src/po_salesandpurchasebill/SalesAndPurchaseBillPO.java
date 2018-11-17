package po_salesandpurchasebill;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import po.BillCategory;
import po.BillState;

/**
 * 单据编号（XSD-yyyyMMdd-xxxxx），
 * 客户，业务员，操作员（当前登录系统的用户），仓库，出货商品清单，折让前总额，折让，使用代金卷金额，折让后总额，备注。
 * 出货商品清单中要显示
 * 商品的编号，名称（从商品选择界面选择），型号，数量（手工输入），单价（默认为商品信息里的销售价，可修改），金额（自动生成），商品备注。
 * */
public class SalesAndPurchaseBillPO implements Serializable{

	private BillState billState;
	private BillCategory category;
	private String ID;
	private String customerID;
	private String staff;//业务员
	private String userID;//操作员
	private String wareID;
	private ArrayList<GoodsItem > goodsPOList = new ArrayList<GoodsItem>();
	private double discountAmount;//折让金额
	private double voucher;//代金券
	private String remark;
	private Date date;
	
	public SalesAndPurchaseBillPO(BillCategory saps, BillState bs, String id, String cID, 
			String s, String uID, String wID, ArrayList<GoodsItem> list, double da, double v, String re, Date d) {
		billState = bs;
		category = saps;
		ID = id;
		customerID = cID;
		staff = s;
		userID = uID;
		wareID = wID;
		goodsPOList = list;
		discountAmount = da;
		voucher = v;
		remark = re;
		date = d;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getStaff() {
		return staff;
	}

	public void setStaff(String staff) {
		this.staff = staff;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getWareID() {
		return wareID;
	}

	public void setWareID(String wareID) {
		this.wareID = wareID;
	}

	public ArrayList<GoodsItem> getGoodsPOList() {
		return goodsPOList;
	}

	public void setGoodsPOList(ArrayList<GoodsItem> goodsPOList) {
		this.goodsPOList = goodsPOList;
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

	public BillState getBillState() {
		return billState;
	}

	public void setBillState(BillState billState) {
		this.billState = billState;
	}

	public BillCategory getCategory() {
		return this.category;
	}

	public void setSapstate(BillCategory category) {
		this.category = category;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}

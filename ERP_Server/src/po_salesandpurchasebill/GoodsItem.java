package po_salesandpurchasebill;

import java.io.Serializable;

/**
 * 出货商品清单中要显示
 * 商品的编号，名称（从商品选择界面选择），型号，数量（手工输入），单价（默认为商品信息里的销售价/进价，可修改），金额（自动生成），商品备注。
 * */
public class GoodsItem implements Serializable{

	private String goodsID;
	private String name;
	private String size;
	private long amount;
	private double price;
	private double totalPrice;
	private String remark;
	
	public GoodsItem(String id, String n, String s, long a, double p, String re) {
		goodsID = id;
		name = n;
		size = s;
		amount = a;
		price = p;
		totalPrice = a*p;
		remark = re;
	}
	
	public String getGoodsID() {
		return goodsID;
	}
	public void setGoodsID(String goodsID) {
		this.goodsID = goodsID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
		this.totalPrice = amount * this.price;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
		this.totalPrice = price * this.amount;
	}
	public double getTotalPrice() {
		return totalPrice;
	}

	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}

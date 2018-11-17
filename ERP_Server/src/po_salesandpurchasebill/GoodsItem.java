package po_salesandpurchasebill;

import java.io.Serializable;

/**
 * ������Ʒ�嵥��Ҫ��ʾ
 * ��Ʒ�ı�ţ����ƣ�����Ʒѡ�����ѡ�񣩣��ͺţ��������ֹ����룩�����ۣ�Ĭ��Ϊ��Ʒ��Ϣ������ۼ�/���ۣ����޸ģ������Զ����ɣ�����Ʒ��ע��
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

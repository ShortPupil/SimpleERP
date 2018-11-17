package po;

import java.io.Serializable;
import java.util.ArrayList;


public class SalesPO implements Serializable{
	/*���ݱ�ţ�XSD-yyyyMMdd-xxxxx�����ͻ�������ʾ�����̣���ҵ��Ա��������ͻ��򽻵��Ĺ�˾Ա������������һ���ͻ���Ĭ��ҵ��Ա����
	����Ա����ǰ��¼ϵͳ���û������ֿ⣬������Ʒ�嵥������ǰ�ܶ���ã�ʹ�ô��������ú��ܶ��ע��
	������Ʒ�嵥��Ҫ��ʾ��Ʒ�ı�ţ����ƣ�����Ʒѡ�����ѡ�񣩣��ͺţ��������ֹ����룩�����ۣ�Ĭ��Ϊ��Ʒ��Ϣ������ۼۣ����޸ģ���
	���Զ����ɣ�����Ʒ��ע*/
	private String number;
	private CustomerPO customer;
	private String staff;
	private UserPO user;
	private String wareID;
	private ArrayList<GoodsPO> goodsPOList = new ArrayList<GoodsPO>();
	private double discountAmount;//���ý��
	private double voucher;//����ȯ
	private String remark;
	/**
	 * ���ۼ�(δ�������ý��ʹ����ֻ�漰��Ʒ���ۼ�)
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

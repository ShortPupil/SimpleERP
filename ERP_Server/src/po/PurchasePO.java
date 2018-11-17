package po;

import java.io.Serializable;
import java.util.ArrayList;

public class PurchasePO implements Serializable{
	
	/*���ݱ�ţ���ʽΪ��JHD-yyyyMMdd-xxxxx������λÿ���1��ʼ��ţ�����һ������������99999�����ӣ���
	 * ��Ӧ�̣��ֿ⣬����Ա�������Ʒ�б���ע���ܶ�ϼơ�
	 * ���������Ʒ�б��������Ϣ�У���Ʒ��ţ����ƣ�����Ʒѡ��������ѡ�񣩣��ͺţ��������ֶ����룩�����ۣ�Ĭ��Ϊ��Ʒ��Ϣ�еĽ��ۣ�����
	 * ��ע���ֶ����룩��*/
	private String number;
	private CustomerPO customer;
	private UserPO user;
	private String wareID;
	private String remark;//��ע
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

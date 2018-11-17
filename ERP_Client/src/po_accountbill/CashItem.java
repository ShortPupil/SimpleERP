package po_accountbill;

import java.io.Serializable;

/**
 * ��Ŀ�嵥�а�������Ŀ��������ע��
 * */
public class CashItem implements Serializable{

	/**1��ʾ����Ϊ����+, 0��ʾ����Ϊ֧��-*/
	private String ID;
	private int InOut;
	private String itemName;
	private double itemMoney;
	private String remark;
	
	public CashItem(String id, int io, String name, double money, String r) {
		this.setID(id);
		this.InOut = io;
		this.itemName = name;
		this.itemMoney = money;
		this.remark = r;
	}
	
	public int getInOut() {
		return InOut;
	}
	public void setInOut(int inOut) {
		this.InOut = inOut;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getItemMoney() {
		return itemMoney;
	}
	public void setItemMoney(double itemMoney) {
		this.itemMoney = itemMoney;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}
	
	
}

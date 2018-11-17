package po_accountbill;

import java.io.Serializable;

/**
 *  转账列表中的一项
 *  包含：银行账户，转账金额，备注。
 * */
public class PayAndReceiveItem implements Serializable{

	private String id;
	private String AccountName;
	private double Money;
	private String Remark;
	
	public PayAndReceiveItem(String id, String an, double tm, String r) {
		this.id = id;
		this.AccountName = an;
		this.Money = tm;
		this.Remark = r;
	}

	public String getAccountName() {
		return this.AccountName;
	}

	public void setAccountName(String accountName) {
		this.AccountName = accountName;
	}

	public String getRemark() {
		return this.Remark;
	}

	public void setRemark(String remark) {
		this.Remark = remark;
	}

	public double getMoney() {
		return this.Money;
	}

	public void setMoney(double money) {
		this.Money = money;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}

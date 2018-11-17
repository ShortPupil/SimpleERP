package po;

import java.io.Serializable;

/**
 * ’Àµ•
 * */
public class AccountPO implements Serializable{

	private String AccountName;
	private double AccountMoney;
	
	public AccountPO(String an, double am) {
		this.AccountName = an;
		this.AccountMoney = am;
	}

	public String getAccountName() {
		return AccountName;
	}

	public void setAccountName(String accountName) {
		AccountName = accountName;
	}

	public double getAccountMoney() {
		return AccountMoney;
	}

	public void setAccountMoney(double accountMoney) {
		AccountMoney = accountMoney;
	}
}

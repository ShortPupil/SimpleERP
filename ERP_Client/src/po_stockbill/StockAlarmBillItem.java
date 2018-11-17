package po_stockbill;

import java.io.Serializable;

/**
 * 库存报警单的各单项
 * */
public class StockAlarmBillItem implements Serializable{

	private String number;
	private String name;
	/**库存数量*/
	private long amount;
	/**报警数量*/
	private long AlarmAmount;
	
	public StockAlarmBillItem(String num, String n, long a, long aa) {
		number = num;
		name= n;
		amount = a;
		AlarmAmount = aa;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public long getAlarmAmount() {
		return AlarmAmount;
	}

	public void setAlarmAmount(long alarmAmount) {
		AlarmAmount = alarmAmount;
	}
	
	
}

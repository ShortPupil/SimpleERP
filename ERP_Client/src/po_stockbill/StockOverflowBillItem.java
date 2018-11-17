package po_stockbill;

import java.io.Serializable;

public class StockOverflowBillItem implements Serializable{

	private String number;
	private String name;
	/**库存数量*/
	private long amount;
	/**实际数量*/
	private long ActualAmount;
	/**变化数量**/
	private long range;
	
	public StockOverflowBillItem(String num, String na, long a, long r) {
		setNumber(num);
		setName(na);
		setAmount(a);
		setRange(r);
		this.ActualAmount=a+r;
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

	public long getActualAmount() {
		return ActualAmount;
	}
	public long getRange() {
		return range;
	}
	public void setRange(long range) {
		this.range=range;
	}
	
}

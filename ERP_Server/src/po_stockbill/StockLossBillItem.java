package po_stockbill;

import java.io.Serializable;

public class StockLossBillItem implements Serializable{

	private String number;
	private String name;
	/**库存数量*/
	private long amount;
	/**实际数量*/
	private long ActualAmount;
	/**减少数量**/
	private long range;
	
	public StockLossBillItem(String num, String na, long a,long r) {
		this.number=num;
		this.name=na;
		this.amount=a;
		this.range=r;
		this.ActualAmount=a-r;
		
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
	
	public long getRange() {
		return range;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public long getActualAmount() {
		return ActualAmount;
	}

	public void setRange(long range) {
		this.range = range;
	}
	
}

package po_stockbill;

import java.io.Serializable;

/**
 * 库存赠送的单项
 * */
public class StockGiftBillItem implements Serializable{

	private String number;
	private String name;
	/**库存数量*/
	private long amount;
	/**赠送数量*/
	private long GiftAmount;
	
	public StockGiftBillItem(String num, String na, long a, long ga) {
		number = num;
		name = na;
		amount = a;
		GiftAmount = ga;
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
	public long getGiftAmount() {
		return GiftAmount;
	}
	public void setGiftAmount(long giftAmount) {
		GiftAmount = giftAmount;
	}
}

package po_salesandpurchasebill;

import java.io.Serializable;

/**��Ʒ*/
public class StrategyGiftItem implements Serializable{

	/**��ƷID*/
	private String goodsID;
	/**��������*/
	private long giftAmount;
	/**����������*/
	private int startAmount;
	
	public StrategyGiftItem(String g, long ga, int sa){
		this.goodsID = g;
		this.giftAmount = ga;
		this.startAmount = sa;
	}

	public String getGoodsID() {
		return goodsID;
	}

	public void setGoodsID(String goodsID) {
		this.goodsID = goodsID;
	}

	public long getGiftAmount() {
		return giftAmount;
	}

	public void setGiftAmount(long giftAmount) {
		this.giftAmount = giftAmount;
	}

	public int getStartAmount() {
		return startAmount;
	}

	public void setStartAmount(int startAmount) {
		this.startAmount = startAmount;
	}
}

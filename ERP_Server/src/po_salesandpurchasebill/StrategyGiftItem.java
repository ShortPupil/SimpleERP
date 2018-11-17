package po_salesandpurchasebill;

import java.io.Serializable;

/**赠品*/
public class StrategyGiftItem implements Serializable{

	/**商品ID*/
	private String goodsID;
	/**赠送数量*/
	private long giftAmount;
	/**满多少起送*/
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

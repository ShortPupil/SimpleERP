package po_salesandpurchasebill;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**销售策略*/
public class SalesStrategyPO implements Serializable{

	private String ID;
	/**用户级别*/
	private int CustomerLevel;
	/**赠品*/
	private ArrayList<StrategyGiftItem> giftList;
	/**特价包*/
	private ArrayList<StrategyPackItem> packList;
	private Date date;
	
	public SalesStrategyPO(String id, int cl, ArrayList<StrategyGiftItem> gl, ArrayList<StrategyPackItem> pl, Date d) {
		ID = id;
		CustomerLevel = cl;
		giftList = gl;
		packList = pl;
		date = d;
	}

	public int getCustomerLevel() {
		return CustomerLevel;
	}

	public void setCustomerLevel(int customerLevel) {
		CustomerLevel = customerLevel;
	}

	public ArrayList<StrategyGiftItem> getGiftList() {
		return giftList;
	}

	public void setGiftList(ArrayList<StrategyGiftItem> giftList) {
		this.giftList = giftList;
	}

	public ArrayList<StrategyPackItem> getPackList() {
		return packList;
	}

	public void setPackList(ArrayList<StrategyPackItem> packList) {
		this.packList = packList;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}

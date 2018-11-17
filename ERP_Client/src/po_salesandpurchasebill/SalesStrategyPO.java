package po_salesandpurchasebill;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**���۲���*/
public class SalesStrategyPO implements Serializable{

	private String ID;
	/**�û�����*/
	private int CustomerLevel;
	/**��Ʒ*/
	private ArrayList<StrategyGiftItem> giftList;
	/**�ؼ۰�*/
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

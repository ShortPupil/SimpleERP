package po_stockbill;

import java.util.Date;
import java.io.Serializable;
import java.util.ArrayList;

import po.BillState;

/**
 * 库存赠送单，包含赠送的各项组成的表
 * 
 *  *注意构造时输入时间
 * */
public class StockGiftBillPO implements Serializable{
	
	private String ID;
	private ArrayList<StockGiftBillItem> itemList;
	private BillState state; 
	private String operatorID;
	private Date date;
	private String WareID;
	
	public StockGiftBillPO(String id, ArrayList<StockGiftBillItem> list, BillState bs, Date d,String operatorid, String wareid) {
		ID = id;
		itemList = list;
		state = bs;
		date = d;
		operatorID = operatorid;
		WareID = wareid;
	}
	
	public ArrayList<StockGiftBillItem> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<StockGiftBillItem> itemList) {
		this.itemList = itemList;
	}

	public BillState getState() {
		return state;
	}

	public void setState(BillState state) {
		this.state = state;
	}

	public String getOperatorID() {
		return operatorID;
	}

	public void setOperatorID(String operatorID) {
		this.operatorID = operatorID;
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

	public String getWareID() {
		return WareID;
	}

	public void setWareID(String wareID) {
		WareID = wareID;
	}
	
}

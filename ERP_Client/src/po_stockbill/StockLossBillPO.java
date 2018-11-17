package po_stockbill;

import java.util.Date;
import java.io.Serializable;
import java.util.ArrayList;

import po.BillState;

/**
 * 库存报损单
 * 
 * 注意构造时输入时间
 * */
public class StockLossBillPO implements Serializable{
	
	private String ID;
	private ArrayList<StockLossBillItem> itemList;
	private BillState state; 
	private String operatorID;
	private Date date;
	private String WareID;
	
	public StockLossBillPO(String id, ArrayList<StockLossBillItem> list,BillState st, String operatorId, Date d, String wareid) {
		ID = id;
		itemList = list;
		state = st;
		operatorID = operatorId;
		date = d;
		WareID = wareid;
	}

	public ArrayList<StockLossBillItem> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<StockLossBillItem> itemList) {
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

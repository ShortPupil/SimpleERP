package po_stockbill;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import po.BillState;

/**
 * 库存报警单
 *包含各个单项构成的表
 *
 *注意构造时输入时间
 * */
public class StockAlarmBillPO implements Serializable{

	private String ID;
	private ArrayList<StockAlarmBillItem> itemList;
	private BillState state; 
	private String operatorID;
	private Date date;
	private String WareID;
	
	public StockAlarmBillPO(String id,ArrayList<StockAlarmBillItem> list, BillState st, Date d, String operatorid, String wareid) {
		itemList = list;
		state = st;
		ID = id;
		operatorID = operatorid;
		date = d;
		WareID = wareid;
	}

	public ArrayList<StockAlarmBillItem> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<StockAlarmBillItem> itemList) {
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

	public Date getDate() {
		return date;
	}
	public void setDate(Date d) {
		date = d;
	}

	public String getId() {
		return ID;
	}

	public void setId(String id) {
		this.ID = id;
	}

	public String getWareID() {
		return WareID;
	}

	public void setWareID(String wareID) {
		WareID = wareID;
	}
}

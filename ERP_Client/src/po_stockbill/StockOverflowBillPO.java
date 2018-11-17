package po_stockbill;

import java.util.Date;
import java.io.Serializable;
import java.util.ArrayList;

import po.BillState;

/**
 * ��汨�絥��������������ɵı�
 * 
 * ע�⹹��ʱ����ʱ��
 * */
public class StockOverflowBillPO implements Serializable{	
	private String ID;
	private ArrayList<StockOverflowBillItem> itemList;
	private BillState state; 
	private String operatorID;
	private Date date;
	private String WareID;
	
	public StockOverflowBillPO(String id, ArrayList<StockOverflowBillItem> list,BillState bs, String operatorId, Date d, String wareid) {
		setID(id);
		itemList = list;
		state = bs;
		operatorID = operatorId;
		date = d;
		WareID = wareid;
	}

	public ArrayList<StockOverflowBillItem> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<StockOverflowBillItem> itemList) {
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

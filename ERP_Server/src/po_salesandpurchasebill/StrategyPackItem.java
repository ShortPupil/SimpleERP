package po_salesandpurchasebill;

import java.io.Serializable;
import java.util.ArrayList;

import po.GoodsPO;

public class StrategyPackItem implements Serializable{

	/**��������Ʒ*/
	private ArrayList<GoodsPO> list;
	/**ԭ��*/
	private double originalPrice;
	/**�ּ�*/
	private double presentPrice;
	
	public StrategyPackItem(ArrayList<GoodsPO> l, double pp) {
		list = l;
		for(int i=0 ; i<list.size() ; i++) {
			originalPrice = originalPrice + list.get(i).getTotalPrice();
		}
		presentPrice = pp;
	}

	public ArrayList<GoodsPO> getList() {
		return list;
	}

	public void setList(ArrayList<GoodsPO> list) {
		this.list = list;
		for(int i=0 ; i<list.size() ; i++) {
			this.originalPrice = this.originalPrice + list.get(i).getTotalPrice();
		}
	}

	public double getOriginalPrice() {
		return originalPrice;
	}

	public double getPresentPrice() {
		return presentPrice;
	}

	public void setPresentPrice(double presentPrice) {
		this.presentPrice = presentPrice;
	}
	
}

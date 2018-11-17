package po;

import java.io.Serializable;

/**
 * type 对应父节点的id
 * */
public class GoodsClassificationPO implements Serializable{

	private int ID;
	private int type;
	private String name;
	private int numberOfGoods;
	
	public GoodsClassificationPO(int id, int t, String string, int n) {
		// TODO Auto-generated constructor stub
		setID(id);
		setType(t);
		name = string;
		setNumberOfGoods(n);
	}
	public String getName() {
		return name;
	}
	public void setName(String n) {
		this.name = n;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getNumberOfGoods() {
		return numberOfGoods;
	}
	public void setNumberOfGoods(int numberOfGoods) {
		this.numberOfGoods = numberOfGoods;
	}
	
}

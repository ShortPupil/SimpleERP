package vo;

import java.io.Serializable;

public class CustomerVO implements Serializable{

	private String id;
	private int role;
	private int level;
	private String name;
	private double receivablesamount;
	private double receivables;
	private double pay;
	private String salesman;
    
	public CustomerVO(){
	}
	
	public CustomerVO(String _id, int r, int l, String n, double ra, String sm){
		id = _id;
		role = r;
		level = l;
		name = n;
		receivablesamount = ra;
		receivables = 0;
		pay = 0;
		salesman = sm;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getRole(){
		return role;
	}
	public void setRole(int r) {
		this.role = r;
	}
	
	public int getLevel(){
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	public String getName(){
		return name;
	}
	public void setName(String n) {
		this.name = n;
	}
	
	public double getReceivablesamount(){
		return receivablesamount;
	}
	public void setReceivablesamount(double ra) {
		this.receivablesamount = ra;
	}
	
	public double getReceivables()
	{
		return receivables;
	}
	
	public double getPay(){
		return pay;
	}
	
	public String getSalesman(){
		return salesman;
	}
	public void setSalesman(String sm) {
		this.salesman = sm;
	}
	
	public String toString() {
		return this.id +":"+ this.role +":"+ this.level +":"+ this.name +":"+ this.receivablesamount
				+":"+ this.receivables +":"+ this.pay +":"+ this.salesman;
	}
}

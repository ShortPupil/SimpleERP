package po;

import java.io.Serializable;
/**编号、分类（进货商、销售商）、级别（五级，一级普通用户，五级VIP客户）、
 * 姓名、电话、地址、邮编、电子邮箱、应收额度、应收、应付、默认业务员*/
public class CustomerPO implements Serializable{

	private String id;
	private int role;
	private int level;
	private String name;
	private String phonenumber;
	private String address;
	private String email;
	private String postcode;
	private double receivablesamount;
	private double receivables;
	private double pay;
	private String salesman;
    
	public CustomerPO(){
	}
	
	public CustomerPO(String _id, int r, int l, String n, String pn, String add, String e, String pc,
			double ra, String sm){
		id = _id;
		role = r;
		level = l;
		name = n;
		phonenumber = pn;
		address = add;
		email = e;
		postcode = pc;
		receivablesamount = ra;
		receivables = 0;
		pay = 0;
		salesman = sm;
	}
	
	public String getId(){
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
	
	public String getPhonenumber(){
		return phonenumber;
	}
	public void setPhonenumber(String p) {
		this.phonenumber = p;
	}
	
	public String getAddress(){
		return address;
	}
	public void setAddress(String a) {
		this.address = a;
	}
	
	public String getEmail(){
		return email;
	}
	public void setEmail(String e) {
		this.email = e;
	}
	
	public String getPostcode(){
		return postcode;
	}
	public void setPostcode(String p) {
		this.postcode = p;
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
		return this.id +":"+ this.role +":"+ this.level +":"+ this.name +":"+ this.phonenumber
				+":"+this.address +":"+ this.email +":"+ this.postcode +":"+ this.receivablesamount
				+":"+ this.receivables +":"+ this.pay +":"+ this.salesman;
	}
}

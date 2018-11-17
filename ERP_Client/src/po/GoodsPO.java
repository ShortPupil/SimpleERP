package po;

import java.io.Serializable;
import java.util.Date;

public class GoodsPO implements Serializable{

	private String number;
	private String name;
	private String size;
	private  int classification;
	private  long amount;
	/**报警数量*/
	private long alarmAmount;
     /**新进货价*/
	private double newPurchasePrice;
     /**新售价*/
	private double newPrice;
     /**默认进货价*/
	private double defaultPurchasePrice;
     /**默认售价*/
	private double defaultPrice;
     /**是否可赠送*/
	private  boolean isGiveable;
    private double totalPrice; 
    private double totalPurchasePrice;
    /**版本号*/
    private int batch;
    /**日期*/
    private Date date;
    
     public GoodsPO(String num, String n, String s, int GCpo, long a, long aa, double dpur, double dpri, boolean give, int b, Date d){
    	 number = num;
    	 name = n;
    	 size = s;
    	 classification = GCpo;
    	 amount = a;
    	 alarmAmount = aa;
    	 newPurchasePrice = dpur;
    	 newPrice = dpri;
    	 defaultPurchasePrice = dpur;
    	 defaultPrice = dpri;
    	 isGiveable = give;
    	 batch = b;
    	 setDate(d);
    	 
    	 totalPrice= dpri * a;
    	 totalPurchasePrice = dpur * a;
     }
     
     public double getTotalPrice() {
    	 return this.totalPrice;
     }
     public double getTotalPurchasePrice() {
    	 return this.totalPurchasePrice;
     }
     public String getNumber(){
    	 return number;
     }
     public void setNumber(String n) {
    	 this.number = n;
     }
     
     public String getName(){
    	 return name;
     }
     public void setName(String n) {
    	 this.name = n;
     }
     
     public String getSize(){
    	 return size;
     }
     public void setSize(String s) {
    	 this.size = s;
     }
     
     public int getGoodsClassification() {
    	 return classification;
     }
     public void setGoodsClassification(int GCpo) {
    	 this.classification = GCpo;
     }
     
     public long getAmount(){
    	 return amount;
     }
     public void setAmount(long a) {
    	 this.amount = a;
    	 this.totalPrice = a*this.newPrice;
     }
     
     public double getNewPurchasePrice(){
    	 return newPurchasePrice;
     }
     public void setNewPurchasePrice(double npp) {
    	 this.newPurchasePrice = npp;
    	 this.totalPurchasePrice = npp * this.amount;
     }
     
     public double getNewPrice(){
    	 return newPrice;
     }
     public void setNewPrice(double np) {
    	 this.newPrice = np;
    	 this.totalPrice = np * this.amount;
     }
     
     public double getDefaultPurchasePrice(){
    	 return defaultPurchasePrice;
     }
     public void setDefaultPurchasePrice(double dpp) {
    	 this.defaultPurchasePrice =dpp;
     }
     
     public double getDefaultPrice(){
    	 return defaultPrice;
     }
     public void setDefaultPrice(double dp) {
    	 this.defaultPrice = dp;
     }
     
     public boolean getIsGiveable() {
    	 return isGiveable;
     }
     public void setIsGiveable(boolean g) {
    	 this.isGiveable = g;
     }

 	public int getBatch() {
 		return batch;
 	}

 	public void setBatch(int batch) {
 		this.batch = batch;
 	}

 	public Date getDate() {
 		return date;
 	}

 	public void setDate(Date date) {
 		this.date = date;
 	}
     
     
     public String toString() {
    	 return this.number +":"+ this.name +":"+ this.size +":"+ this.classification
    			 +":"+this.amount+":"+this.newPurchasePrice +":"+ this.newPrice +":"+ this.defaultPurchasePrice
    			 +":"+this.defaultPrice +":"+ this.isGiveable +":"+ this.batch +":"+ this.date;
     }

	public long getAlarmAmount() {
		return alarmAmount;
	}

	public void setAlarmAmount(long alarmAmount) {
		this.alarmAmount = alarmAmount;
	}
}

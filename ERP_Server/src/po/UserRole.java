package po;

import java.io.Serializable;

public enum UserRole implements Serializable{

	/**
	 * 库存管理人员
	 * */
	StockStaff(1),
	
	/**
	 * 进货销售人员
	 * */
	SalesPurchaseStaff(2),
	
	/**
	 * 财务人员
	 * */
	FinancialStaff(3),
	
	/**
	 * 总经理
	 * */
	GeneralManager(4),
	
	/**
	 * 管理员
	 * */
	Administrator(0);
	
	  private int value;

	    private UserRole(int value){
	        this.value = value;
	    }
	    
	    public static UserRole getStateByInt(int value) {
	    	for (UserRole c : UserRole.values()) {
	            if (c.value == value) {
	                return c;
	            }
	        }
	        return null;
	    }
	    
	    public static int getIntByState(UserRole i) {
	    	if(i.equals(StockStaff)) return 1;
	    	else if(i.equals(SalesPurchaseStaff)) return 2;
	    	else if(i.equals(FinancialStaff)) return 3;
	    	else if(i.equals(GeneralManager)) return 4;
	    	return 0;
	    }
}

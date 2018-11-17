package po;

import java.io.Serializable;

public enum UserRole implements Serializable{

	/**
	 * ��������Ա
	 * */
	StockStaff(1),
	
	/**
	 * ����������Ա
	 * */
	SalesPurchaseStaff(2),
	
	/**
	 * ������Ա
	 * */
	FinancialStaff(3),
	
	/**
	 * �ܾ���
	 * */
	GeneralManager(4),
	
	/**
	 * ����Ա
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

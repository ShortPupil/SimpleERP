package po;

import java.io.Serializable;

public enum BillCategory implements Serializable{

	/**
	 * 销售
	 * */
	Sales(0),
	
	/**
	 * 销售退货
	 * */
	SalesReturn(1),
	
	/**
	 * 进货
	 * */
	Purchase(2),
	
	/**
	 * 进货退货
	 * */
	PurchaseReturn(3),
	
	/**
	 * 付款
	 * */
	Pay(4),
	
	/**
	 * 收款
	 * */
	Receive(5),
	
	/**
	 * 现金费用
	 * */
	Cash(6),
	
	/**
	 * 库存报溢
	 * */
	StockOverflow(7),
	
	/**
	 * 库存报损
	 * */
	StockLoss(8),
	
	/**
	 * 库存赠送
	 * */
	StockGift(9),
	
	/**
	 * 库存报警
	 * */
	StockAlarm(10),
	
	/**
	 * 所有单据
	 * */
	AllBill(11);
	
    private int value;

    private BillCategory(int value){
        this.value = value;
    }
    
    public static BillCategory getCategoryByInt(int value) {
    	for (BillCategory c : BillCategory.values()) {
            if (c.value == value) {
                return c;
            }
        }
        return null;
    }
    
    public static int getIntByCategory(BillCategory s) {
   
    	if(s.equals(Receive)) return 5;
    	else if(s.equals(Pay)) return 4;
    	else if(s.equals(PurchaseReturn)) return 3;
    	else if(s.equals(Purchase)) return 2;
    	else if(s.equals(SalesReturn)) return 1;
    	else if(s.equals(Sales)) return 0;
    	else if(s.equals(Cash)) return 6;
    	else if(s.equals(StockOverflow)) return 7;
    	else if(s.equals(StockLoss)) return 8;
    	else if(s.equals(StockGift)) return 9;
    	else if(s.equals(StockAlarm)) return 9;
    	return 11;
    }
}

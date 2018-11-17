package po;

import java.io.Serializable;

public enum BillCategory implements Serializable{

	/**
	 * ����
	 * */
	Sales(0),
	
	/**
	 * �����˻�
	 * */
	SalesReturn(1),
	
	/**
	 * ����
	 * */
	Purchase(2),
	
	/**
	 * �����˻�
	 * */
	PurchaseReturn(3),
	
	/**
	 * ����
	 * */
	Pay(4),
	
	/**
	 * �տ�
	 * */
	Receive(5),
	
	/**
	 * �ֽ����
	 * */
	Cash(6),
	
	/**
	 * ��汨��
	 * */
	StockOverflow(7),
	
	/**
	 * ��汨��
	 * */
	StockLoss(8),
	
	/**
	 * �������
	 * */
	StockGift(9),
	
	/**
	 * ��汨��
	 * */
	StockAlarm(10),
	
	/**
	 * ���е���
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

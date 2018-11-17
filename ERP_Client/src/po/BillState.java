package po;

import java.io.Serializable;

public enum BillState implements Serializable{

	/**
	 * �ݸ�״̬
	 * */
	DRAFT(0),
	
	/**
	 * δ���
	 * */
	UNCHECKED(1),
	
	/**
	 * ���ͨ��
	 * */
	PASS(2),
	
	/**
	 * δͨ��״̬
	 * */
	FAIL(3);
	
    private int value;

    private BillState(int value){
        this.value = value;
    }
    
    public static BillState getStateByInt(int value) {
    	for (BillState c : BillState.values()) {
            if (c.value == value) {
                return c;
            }
        }
        return null;
    }
    
    public static int getIntByState(BillState s) {
    	if(s.equals(FAIL)) return 3;
    	else if(s.equals(PASS)) return 2;
    	else if(s.equals(UNCHECKED)) return 1;
    	return 0;
    }
}

package po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

/**
 * ���PO��
 * ������������Ʒ���ơ����
 * */
public class StockPO implements Serializable{

	
	private Map<GoodsClassificationPO, ArrayList<GoodsPO>> stockMap;
    
    public Map<GoodsClassificationPO, ArrayList<GoodsPO>> getStock(){
    	return stockMap;
    }
    public void setStock(Map<GoodsClassificationPO, ArrayList<GoodsPO>> stockMap) {
    	this.stockMap = stockMap;
    }
}

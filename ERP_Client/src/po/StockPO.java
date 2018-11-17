package po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

/**
 * 库存PO类
 * 包含变量：商品名称、类别
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

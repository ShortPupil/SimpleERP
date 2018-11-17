package po;

import java.io.Serializable;

public class LogPO implements Serializable{

	private String operation;
	private String time;
	private String operator;
    
    public LogPO(String op, String t, String optor){
    	operation = op;
    	time = t;
    	operator = optor;
    }
    
    public String getOperation(){
    	return operation;
    }
    public String getTime(){
    	return time;
    }
    public String getOperator(){
    	return operator;
    }
    
    public String toString() {
    	return this.operation +":"+ this.time +":"+ this.operator;
    }
}

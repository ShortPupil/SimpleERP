package po;

import java.io.Serializable;

/**
 * 用户po对象
 * */
public class UserPO implements Serializable{

	private String id;
	private String name;
	 private String password;
	   /**
	   * 用户职业
	   * */
	 private int role;
	  public UserPO() {
	  }
	 
	  public UserPO(String i, String n, String p, UserRole r)
	  {
	    id = i;
	    name = n;
	    password = p;
	    role = UserRole.getIntByState(r);
	  }
	  
	  public String getName()
	  {
	    return name;
	  }
	  
	  public void setName(String name) {
		  this.name = name;
	  }

	  public String getId()
	  {
	    return id;
	  }
	  
	  public void setId(String id) {
		  this.id = id;
	  }
	 
	  public String getPassword()
	  {
	    return password;
	  }
	  
	  public void setPassword(String password) {
		  this.password = password;
	  }
	  
	  public int getRole()
	  {
	    return role;
	  }

	  public void setRole(int role) {
		  this.role = role;
	  }
	  
	  public UserRole getTrueRole() {
		  return UserRole.getStateByInt(this.role);
	  }
	  
	  public String toString() {
		  return this.id + ":" + this.name + ":" + UserRole.getStateByInt(this.role);
	  }
}

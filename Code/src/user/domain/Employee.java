package user.domain;


public class Employee {
	protected  int employee_id;
	protected int compny_id;
	protected String user;
	protected String name;
	protected String date_of_hiring;
	protected String gender;
	protected String date_of_birth;


	public Employee() {
	}
	
	  public Employee(int employee_id) {
	        this.employee_id = employee_id;
	    }
	  

	  public Employee(int employee_id, int compny_id , String user, String name, String date_of_hiring ,String gender, String date_of_birth) {
		    this.employee_id = employee_id;
		  	this.compny_id = compny_id;
	        this.user = user;
	        this.name = name;
	        this.date_of_hiring = date_of_hiring;
	        this.gender = gender;
	        this.date_of_birth = date_of_birth;
	    }
	  
	 public int getEmployee_id() {
	        return employee_id;
	    }
	 
	 public void setEmployee_id(int employee_id) {
	        this.employee_id = employee_id;
	    }
	    
	 public int getCompny_id() {
	        return compny_id;
	    }
	 
	 public void setCompny_id(int compny_id) {
	        this.compny_id = compny_id;
	    }

	 public String getUser() {
	        return user;
	    }
	 
	 public void setUser(String user) {
	        this.user = user;
	    }

	 public String getName() {
	        return name;
	    }
	 
	 public void setName(String name) {
	        this.name = name;
	 }

	 public String getDate_of_hiring() {
	        return date_of_hiring;
	    }
	 
	 public void setDate_of_hiring(String date_of_hiring) {
	        this.date_of_hiring = date_of_hiring;
	 }

	 
	 public String getGender() {
	        return gender;
    }
	 
	 public void setGender(String gender) {
	        this.gender = gender;
	 }

	 public String getDate_of_birth() {
	        return date_of_birth;
    }
	 
	 public void setDate_of_birth(String date_of_birth) {
	        this.date_of_birth = date_of_birth;
	 }
	 
}
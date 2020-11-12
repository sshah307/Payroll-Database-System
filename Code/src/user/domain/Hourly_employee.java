package user.domain;

public class Hourly_employee {
	protected String hourly_ssn;
	protected int employee_id;
	protected float hrs_worked;
	protected float rate;
	protected String pay_start_date;
	protected String pay_end_date;

	
	public Hourly_employee() {	
	}
	
	public Hourly_employee(String hourly_ssn) {
        this.hourly_ssn = hourly_ssn;
    }
	
	public Hourly_employee(String hourly_ssn, int employee_id , float hrs_worked, float rate, String pay_start_date ,String  pay_end_date) {
		this.hourly_ssn = hourly_ssn;
		this.employee_id = employee_id;
	  	this.hrs_worked = hrs_worked;
        this.rate = rate;
        this.pay_start_date = pay_start_date;
        this.pay_end_date = pay_end_date;
    }
	
	 public String gethourly_ssn() {
	        return hourly_ssn;
	    }
	 
	 public void sethourly_ssn(String hourly_ssn) {
	        this.hourly_ssn = hourly_ssn;
	    }
	    
	 public int getemployee_id() {
	        return employee_id;
	    }
	 
	 public void setemployee_id(int employee_id) {
	        this.employee_id = employee_id;
	    }

	
	 public float gethrs_worked() {
	        return hrs_worked;
	    }
	 
	 public void sethrs_worked(float hrs_worked) {
	        this.hrs_worked = hrs_worked;
	    }
	 
	 public float getrate() {
	        return hrs_worked;
	    }
	 
	 public void setrate(float rate) {
	        this.rate = rate;
	    }
	 
	 
	 public String getDateStart() {
	        return pay_start_date;
	    }
	 
	 public void setDateStart(String pay_start_date) {
	        this.pay_start_date = pay_start_date;
	    }
	 
	 public String getEnd() {
	        return pay_end_date;
	    }
	 
	 public void setEnd(String pay_end_date) {
	        this.pay_end_date = pay_end_date;
	    }

	
}	
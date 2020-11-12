package user.domain;

public class Company{
		private int compny_id;
		private String compny_name;
		private String compny_address;
		private String contact_no;
		private int employee_size;
	 
	    public Company() {
	    }
	    
	    public Company(int compny_id) {
	    	this.compny_id = compny_id;
	    }
	    
	    public Company(int compny_id, String compny_name, String compny_address, String contact_no, int employee_size) {
	    	this(compny_name, compny_address, contact_no, employee_size);
	    	this.compny_id = compny_id;
	    }
	    
	    public Company(String compny_name, String compny_address, String contact_no, int employee_size) {
	    	this.compny_name = compny_name;
	    	this.compny_address = compny_address;
	    	this.contact_no = contact_no;
	    	this.employee_size = employee_size;
	    }
	    
	
	    public int getId() {
	        return compny_id;
	    }
	 
	    public void setId(int compny_id) {
	        this.compny_id = compny_id;
	    }
	 
	    public String getName() {
	        return compny_name;
	    }
	 
	    public void setName(String compny_name) {
	        this.compny_name = compny_name;
	    }
	 
	    public String getAddress() {
	        return compny_address;
	    }
	 
	    public void setAddress(String compny_address) {
	        this.compny_address = compny_address;
	    }
	    
	    public String getContact() {
	        return contact_no;
	    }
	 
	    public void setContact(String contact_no) {
	        this.contact_no = contact_no;
	    }
	 
	    public int getSize() {
	        return employee_size;
	    }
	 
	    public void setSize(int employee_size) {
	        this.employee_size = employee_size;
	    }

}

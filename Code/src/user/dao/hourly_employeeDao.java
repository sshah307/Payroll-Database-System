package user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import user.domain.Hourly_employee;


public class hourly_employeeDao {

	
	public void add(Hourly_employee hrs) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/pay_role" , "root" ,"5824");
								
			String sql = "insert into hourly_employee values(?,?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			
			preparestatement.setString(1,hrs.gethourly_ssn());
		    preparestatement.setInt(2,hrs.getemployee_id());
		    preparestatement.setFloat(3,hrs.gethrs_worked());
		    preparestatement.setFloat(4,hrs.getrate());
		    preparestatement.setString(5,hrs.getDateStart());
		    preparestatement.setString(6,hrs.getEnd());
		    System.out.print("Before");
		    preparestatement.executeUpdate();
		    System.out.print("After");
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Object> findallHourly_employee() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/pay_role" , "root" ,"5824");

			
			String sql = "select * from   hourly_employee";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();
			
			while(resultSet.next()){
				
				Hourly_employee hrs = new Hourly_employee();
				
				hrs.sethourly_ssn(resultSet.getString("hourly_ssn"));
				hrs.setemployee_id(resultSet.getInt("employee_id"));
	    		hrs.sethrs_worked(resultSet.getFloat("hrs_worked"));
	    		hrs.setrate(resultSet.getFloat("rate"));
	    		hrs.setDateStart(resultSet.getString("pay_start_date"));
	    		hrs.setEnd(resultSet.getString("pay_end_date"));
				list.add(hrs);
			 }
			 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} 
		return list;
		
	}
		
	public void deleteHourly_employee(Hourly_employee hrs) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/pay_role" , "root" ,"5824");
								
			String sql = "delete from hourly_employee where hourly_ssn = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,hrs.gethourly_ssn());
		    preparestatement.executeUpdate() ;
		    	    
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public Hourly_employee findByHourly_ssn(String hourly_ssn) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Hourly_employee hrs = new Hourly_employee();
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/pay_role" , "root" ,"5824");

			
		    String sql = "select * from hourly_employee where hourly_ssn = ?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,hourly_ssn);
		    ResultSet resultSet = preparestatement.executeQuery();
		    //ResultSet resultSet  = preparestatement.executeUpdate();
		    while(resultSet.next()){
		    	String ssn = resultSet.getString("hourly_ssn");
		    	if(ssn == hourly_ssn){
		    		hrs.sethourly_ssn(resultSet.getString("hourly_ssn"));
		    		hrs.setemployee_id(resultSet.getInt("employee_id"));
		    		hrs.sethrs_worked(resultSet.getFloat("hrs_worked"));
		    		hrs.setrate(resultSet.getFloat("rate"));
		    		hrs.setDateStart(resultSet.getString("pay_start_date"));
		    		hrs.setEnd(resultSet.getString("pay_end_date"));
		    	}
		    }
		
		    
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		

		return hrs;
	}
	
	public void updateHourly_employee(Hourly_employee hrs) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/pay_role" , "root" ,"5824");
								
			String sql = "update hourly_employee set hourly_ssn = ?, employee_id = ?, hrs_worked = ?, rate =?, pay_start_date =?, pay_end_date=? where hourly_ssn = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			
			preparestatement.setString(1,hrs.gethourly_ssn());
		    preparestatement.setInt(2,hrs.getemployee_id());
		    preparestatement.setFloat(3,hrs.gethrs_worked());
		    preparestatement.setFloat(4,hrs.getrate());
		    preparestatement.setString(5,hrs.getDateStart());
		    preparestatement.setString(6,hrs.getEnd());
		    preparestatement.setString(7,hrs.gethourly_ssn());
			
			preparestatement.executeUpdate() ;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}	
	}
	

}
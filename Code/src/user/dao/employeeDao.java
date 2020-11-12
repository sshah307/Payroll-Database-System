
package user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import user.domain.Employee;




public class employeeDao {
	
	
	public void addEmployee(Employee empl) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/pay_role" , "root" ,"5824");
								
			String sql = "insert into employee values(?,?,?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			
			preparestatement.setInt(1,empl.getEmployee_id());
		    preparestatement.setInt(2,empl.getCompny_id());
		    preparestatement.setString(3,empl.getUser());
		    preparestatement.setString(4,empl.getName());
		    preparestatement.setString(5,empl.getDate_of_hiring());
		    preparestatement.setString(6,empl.getGender());
		    preparestatement.setString(7,empl.getDate_of_birth());
		    
		    
		    
		    preparestatement.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public void updateEmployee(Employee empl) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/pay_role" , "root" ,"5824");
								
			String sql = "update employee set employee_id = ?, compny_id = ?, user = ?, name =?, date_of_hiring =?, gender =?, date_of_birth=? where employee_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			preparestatement.setInt(1,empl.getEmployee_id());
		    preparestatement.setInt(2,empl.getCompny_id());
		    preparestatement.setString(3,empl.getUser());
		    preparestatement.setString(4,empl.getName());
		    preparestatement.setString(5,empl.getDate_of_hiring());
		    preparestatement.setString(6,empl.getGender());
		    preparestatement.setString(7,empl.getDate_of_birth());
			preparestatement.setInt(8,empl.getEmployee_id());
			preparestatement.executeUpdate(); 
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}	
	}
	
	public void deleteEmployee(Employee empl) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/pay_role" , "root" ,"5824");
								
			String sql = "delete from employee where employee_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,empl.getEmployee_id());
		    preparestatement.executeUpdate();

		    
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
			
	public Employee findByEmployeeID(int employee_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Employee empl = new Employee();
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/pay_role" , "root" ,"5824");

			
		    String sql = "select * from employee where employee_id = ?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,employee_id);
		    ResultSet resultSet = preparestatement.executeQuery();
		    //ResultSet resultSet  = preparestatement.executeUpdate();
		    while(resultSet.next()){
		    	int id = resultSet.getInt("employee_id");
		    	if(id == employee_id){
		    		empl.setEmployee_id(resultSet.getInt("employee_id"));
		    		empl.setCompny_id(resultSet.getInt("compny_id"));
		    		empl.setUser(resultSet.getString("user"));
		    		empl.setName(resultSet.getString("name"));
		    		empl.setDate_of_hiring(resultSet.getString("date_of_hiring"));
		    		empl.setGender(resultSet.getString("gender"));
		    		empl.setDate_of_birth(resultSet.getString("date_of_birth"));
		    	}
		    }
		
		    
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	
		return empl;
	}
	
		
	
	public List<Object> findallEmployee() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/pay_role" , "root" ,"5824");

			String sql = "select * from employee";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();
			
			while(resultSet.next()){
				
				Employee  empl = new Employee();
				empl.setEmployee_id(resultSet.getInt("employee_id"));
	    		empl.setCompny_id(resultSet.getInt("compny_id"));
				empl.setUser(resultSet.getString("user"));
	    		empl.setName(resultSet.getString("name"));
	    		empl.setDate_of_hiring(resultSet.getString("date_of_hiring"));
	    		empl.setGender(resultSet.getString("gender"));
	    		empl.setDate_of_birth(resultSet.getString("date_of_birth"));
				list.add(empl);
			 }
			 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
		
}
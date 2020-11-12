package user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import user.domain.Company;



public class CompanyDao {
	


	public void addCompany(Company comp) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/pay_role", "root", "5824");
								
			String sql = "insert into company values(?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,comp.getId());
		    preparestatement.setString(2,comp.getName());
		    preparestatement.setString(3,comp.getAddress());
		    preparestatement.setString(4,comp.getContact());
		    preparestatement.setInt(5,comp.getSize());

		    preparestatement.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	

	public void updateCompany(Company comp) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/pay_role", "root", "5824");
								
			String sql = "update company set compny_id = ?, compny_name = ?, compny_address = ?, contact_no = ?, employee_size = ? where compny_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,comp.getId());
		    preparestatement.setString(2,comp.getName());
		    preparestatement.setString(3,comp.getAddress());
		    preparestatement.setString(4,comp.getContact());
		    preparestatement.setInt(5,comp.getSize());
		    preparestatement.setInt(6,comp.getId());
		    preparestatement.executeUpdate();

		} catch(SQLException e) {
			throw new RuntimeException(e);
		}	
	}
	
	

	public void deleteCompany(Company comp) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/pay_role", "root", "5824");
								
			String sql = "delete from company where compny_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1, comp.getId());
		    preparestatement.executeUpdate();
		    
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	
	
	public Company findByCompanyID(int compny_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Company comp = new Company();
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/pay_role", "root", "5824");

			
		    String sql = "select * from company where compny_id = ?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,compny_id);
		    ResultSet resultSet = preparestatement.executeQuery();
		    //ResultSet resultSet  = preparestatement.executeUpdate();
		    while(resultSet.next()){
		    	int id = resultSet.getInt("compny_id");
		    	if(id == compny_id){
		    		comp.setId(resultSet.getInt("compny_id"));
		    		comp.setName(resultSet.getString("compny_name"));
		    		comp.setAddress(resultSet.getString("compny_address"));  
		    		comp.setContact(resultSet.getString("contact_no")); 
		    		comp.setSize(resultSet.getInt("employee_size")); 
		    	}
		    }
		
		    
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		return comp;
	}
	
	
	

	public List<Object> findallCompany() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/pay_role", "root", "5824");
			
			String sql = "select * from company";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();
			
			while(resultSet.next()){
				Company comp = new Company();
	    		comp.setId(resultSet.getInt("compny_id"));
	    		comp.setName(resultSet.getString("compny_name"));
	    		comp.setAddress(resultSet.getString("compny_address"));  
	    		comp.setContact(resultSet.getString("contact_no")); 
	    		comp.setSize(resultSet.getInt("employee_size")); 
	    		list.add(comp);
			 }
			 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
		
}
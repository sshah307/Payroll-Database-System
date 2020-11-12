package user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List;
//import user.domain.User;




public class InitalizeDao {
	
	public void initDB(){
		Statement statement; 
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/pay_role?"
				              + "user=root&password=Palna@4706");	
			
			
			statement = connect.createStatement();
			statement.executeUpdate("DROP TABLE IF EXISTS tb_user");
			
            String sqlstmt = "CREATE TABLE IF NOT EXISTS tb_user" +
                            "(username VARCHAR(50) primary key," +
                            "`password` VARCHAR(50) NOT NULL, " +
                            "email VARCHAR(50) NOT NULL)";
            statement.executeUpdate(sqlstmt);
            
			statement.executeUpdate("DROP TABLE IF EXISTS company");
            
            String sqlstmt2 = "CREATE TABLE IF NOT EXISTS company" +
                    "(compny_id INT PRIMARY KEY," +
                    "compny_name varchar(45) DEFAULT NULL, " +
                    "compny_address varchar(45) DEFAULT NULL, " +
					"contact_no varchar(45) DEFAULT NULL, " +
					"employee_size int DEFAULT NULL)";
            statement.executeUpdate(sqlstmt2);
            
            
            PreparedStatement preparedStatement = connect
                    .prepareStatement("insert into  company (compny_id, compny_name, compny_address, contact_no, employee_size ) values (?, ?, ?, ?, ?)");
                preparedStatement.setString(1, "9001");
                preparedStatement.setString(2, "Apple");
                preparedStatement.setString(3, "Wall Street");
                preparedStatement.setString(4, "999-999-9999");
                preparedStatement.setString(5, "560");
                preparedStatement.executeUpdate(); // RUN A TRANSACTION
            
            preparedStatement = connect
                    .prepareStatement("insert into  company (compny_id, compny_name, compny_address, contact_no, employee_size ) values (?, ?, ?, ?, ?)");
                preparedStatement.setString(1, "9002");
                preparedStatement.setString(2, "Sony");
                preparedStatement.setString(3, "Dancing Water Drive");
                preparedStatement.setString(4, "888-888-8888");
                preparedStatement.setString(5, "200");
                preparedStatement.executeUpdate(); // RUN A TRANSACTION
    
            preparedStatement = connect
                    .prepareStatement("insert into  company (compny_id, compny_name, compny_address, contact_no, employee_size ) values (?, ?, ?, ?, ?)");
                preparedStatement.setString(1, "9003");
                preparedStatement.setString(2, "FB");
                preparedStatement.setString(3, "Water Drive");
                preparedStatement.setString(4, "555-888-8888");
                preparedStatement.setString(5, "250");
                preparedStatement.executeUpdate(); // RUN A TRANSACTION
               
    			statement.executeUpdate("DROP TABLE IF EXISTS employee");
                
                String sqlstmt3 = "CREATE TABLE IF NOT EXISTS employee" +
        				"(employee_id int PRIMARY KEY, "+
        				"compny_id int DEFAULT NULL,"+
        				"username varchar(50) DEFAULT NULL,"+
        				"name varchar(45) DEFAULT NULL,"+
        				"date_of_hiring date DEFAULT NULL,"+
        				"gender varchar(45) DEFAULT NULL,"+
        				"date_of_birth date DEFAULT NULL)";
                statement.executeUpdate(sqlstmt3);
        
        PreparedStatement preparedStatement2 = connect
                    .prepareStatement("insert into  employee (employee_id, compny_id, name, date_of_hiring, gender, date_of_birth, username ) values (?, ?, ?, ?, ?, ?, ?)");
                preparedStatement2.setString(1, "100");
                preparedStatement2.setString(2, "1");
                preparedStatement2.setString(3, "Sam");
                preparedStatement2.setString(4, "2017-05-18");
                preparedStatement2.setString(5, "Male");
                preparedStatement2.setString(6, "1991-10-03");
                preparedStatement2.setString(7, "S12");
                preparedStatement2.executeUpdate(); // RUN A TRANSACTION
            
            preparedStatement2 = connect
                    .prepareStatement("insert into  employee(employee_id, compny_id, name, date_of_hiring, gender, date_of_birth, username ) values (?, ?, ?, ?, ?, ?, ?)");
                preparedStatement2.setString(1, "101");
                preparedStatement2.setString(2, "2");
                preparedStatement2.setString(3, "Mike");
                preparedStatement2.setString(4, "2015-08-20");
                preparedStatement2.setString(5, "Male");
                preparedStatement2.setString(6, "1993-12-09");
                preparedStatement2.setString(7, "S13");
                preparedStatement2.executeUpdate(); // RUN A TRANSACTION
		    
            preparedStatement2 = connect
                    .prepareStatement("insert into  employee (employee_id, compny_id, name, date_of_hiring, gender, date_of_birth, username ) values (?, ?, ?, ?, ?, ?, ?)");
                preparedStatement2.setString(1, "102");
                preparedStatement2.setString(2, "3");
                preparedStatement2.setString(3, "Jay");
                preparedStatement2.setString(4, "2019-02-19");
                preparedStatement2.setString(5, "250");
                preparedStatement2.setString(6, "1995-1-23");
                preparedStatement2.setString(7, "S14");
                preparedStatement2.executeUpdate(); // RUN A TRANSACTION

    			statement.executeUpdate("DROP TABLE IF EXISTS pay");
                
                String sqlstmt5 = "CREATE TABLE IF NOT EXISTS pay" +
                		"(employee_id int DEFAULT NULL,"+
                		"pay_type varchar(45) DEFAULT NULL,"+
                		"rate float DEFAULT NULL,"+
                		"hours_worked float DEFAULT NULL,"+
                		"salary float DEFAULT NULL,"+
                		"salary_days float DEFAULT NULL,"+
                		"pay_start_date date DEFAULT NULL,"+
                		"pay_end_date date DEFAULT NULL)";
                statement.executeUpdate(sqlstmt5);
       
                PreparedStatement preparedStatement88 = connect
                		.prepareStatement("insert into pay  (employee_id, pay_type, rate, hours_worked, salary, salary_days, pay_start_date, pay_end_date) values (?, ?, ?, ?, ?, ?, ?, ?)");
                	preparedStatement88.setString(1, "9004");
                	preparedStatement88.setString(2, "hrly");
                	preparedStatement88.setString(3, "40.00");
                	preparedStatement88.setString(4, "20.00");
                	preparedStatement88.setString(5, "0.00");
                	preparedStatement88.setString(6, "0.00");
                	preparedStatement88.setString(7, "2020-01-20");
                	preparedStatement88.setString(8, "2020-02-10");

                	preparedStatement88.executeUpdate(); // RUN A TRANSACTION


                	preparedStatement88 = connect
                		.prepareStatement("insert into pay  (employee_id, pay_type, rate, hours_worked, salary, salary_days, pay_start_date, pay_end_date) values (?, ?, ?, ?, ?, ?, ?, ?)");
                	preparedStatement88.setString(1, "9002");
                	preparedStatement88.setString(2, "salary");
                	preparedStatement88.setString(3, "0.00");
                	preparedStatement88.setString(4, "0.00");
                	preparedStatement88.setString(5, "90000.00");
                	preparedStatement88.setString(6, "7.00");
                	preparedStatement88.setString(7, "2020-01-01");
                	preparedStatement88.setString(8, "2020-01-07");

                	preparedStatement88.executeUpdate(); // RUN A TRANSACTION



                	preparedStatement88 = connect
                		.prepareStatement("insert into pay  (employee_id, pay_type, rate, hours_worked, salary, salary_days, pay_start_date, pay_end_date) values (?, ?, ?, ?, ?, ?, ?, ?)");
                	preparedStatement88.setString(1, "9003");
                	preparedStatement88.setString(2, "hrly");
                	preparedStatement88.setString(3, "30.69");
                	preparedStatement88.setString(4, "20.00");
                	preparedStatement88.setString(5, "0.00");
                	preparedStatement88.setString(6, "0.00");
                	preparedStatement88.setString(7, "2020-02-02");
                	preparedStatement88.setString(8, "2020-01-08");

                	preparedStatement88.executeUpdate(); // RUN A TRANSACTION

        			statement.executeUpdate("DROP TABLE IF EXISTS deductibles");
                    
                    String sqlstmt6 = "CREATE TABLE IF NOT EXISTS deductibles" +
                    		"(employee_id int DEFAULT NULL,"+
                    		"dental float DEFAULT NULL,"+
                    		"vision float DEFAULT NULL,"+
                    		"medical float DEFAULT NULL,"+
                    		"401k float DEFAULT NULL,"+
                    		"life_insurance float DEFAULT NULL)";
                    statement.executeUpdate(sqlstmt6);
                    
                    PreparedStatement preparedStatement99 = connect
                    		.prepareStatement("insert into  deductibles (employee_id, dental, vision, medical, 401K, life_insurance ) values (?, ?, ?, ?, ?, ?)");
                    	preparedStatement99.setString(1, "9001");
                    	preparedStatement99.setString(2, "20.00");
                    	preparedStatement99.setString(3, "30.00");
                    	preparedStatement99.setString(4, "400.00");
                    	preparedStatement99.setString(5, "80.00");
                    	preparedStatement99.setString(6, "7.00");
                    	preparedStatement99.executeUpdate(); // RUN A TRANSACTION

                    	preparedStatement99 = connect
                    		.prepareStatement("insert into  deductibles (employee_id, dental, vision, medical, 401K, life_insurance ) values (?, ?, ?, ?, ?, ?)");
                    	preparedStatement99.setString(1, "9002");
                    	preparedStatement99.setString(2, "10.00");
                    	preparedStatement99.setString(3, "30.00");
                    	preparedStatement99.setString(4, "200.00");
                    	preparedStatement99.setString(5, "80.00");
                    	preparedStatement99.setString(6, "70.00");
                    	preparedStatement99.executeUpdate(); // RUN A TRANSACTION


                    	preparedStatement99 = connect
                    		.prepareStatement("insert into  deductibles (employee_id, dental, vision, medical, 401K, life_insurance ) values (?, ?, ?, ?, ?, ?)");
                    	preparedStatement99.setString(1, "9003");
                    	preparedStatement99.setString(2, "20.00");
                    	preparedStatement99.setString(3, "70.00");
                    	preparedStatement99.setString(4, "300.00");
                    	preparedStatement99.setString(5, "30.00");
                    	preparedStatement99.setString(6, "70.00");
                    	preparedStatement99.executeUpdate(); // RUN A TRANSACTION
                    	
                    	
            			statement.executeUpdate("DROP TABLE IF EXISTS tax");

                        String sqlstmt7 = "CREATE TABLE IF NOT EXISTS tax" +
                        		"(employee_id int DEFAULT NULL,"+
                        		"state float DEFAULT NULL,"+
                        		"federal float DEFAULT NULL,"+
                        		"social_security float DEFAULT NULL,"+
                        		"medicare float DEFAULT NULL)";
                        statement.executeUpdate(sqlstmt7);
                        
                        PreparedStatement preparedStatement3 = connect
                        		.prepareStatement("insert into tax  (employee_id, state, federal, social_security, medicare ) values (?, ?, ?, ?, ?)");
                        preparedStatement3.setString(1, "9001");
                        preparedStatement3.setString(2, "30.00");
                        preparedStatement3.setString(3, "30.00");
                        preparedStatement3.setString(4, "50.00");
                        preparedStatement3.setString(5, "80.00");
                        preparedStatement3.executeUpdate(); // RUN A TRANSACTION


                        preparedStatement3 = connect
                        	.prepareStatement("insert into tax  (employee_id, state, federal, social_security, medicare ) values (?, ?, ?, ?, ?)");
                        preparedStatement3.setString(1, "9002");
                        preparedStatement3.setString(2, "40.00");
                        preparedStatement3.setString(3, "30.00");
                        preparedStatement3.setString(4, "30.00");
                        preparedStatement3.setString(5, "40.00");
                        preparedStatement3.executeUpdate(); // RUN A TRANSACTION


                        preparedStatement3 = connect
                        	.prepareStatement("insert into tax  (employee_id, state, federal, social_security, medicare ) values (?, ?, ?, ?, ?)");
                        preparedStatement3.setString(1, "9003");
                        preparedStatement3.setString(2, "30.00");
                        preparedStatement3.setString(3, "30.00");
                        preparedStatement3.setString(4, "50.00");
                        preparedStatement3.setString(5, "80.00");
                        preparedStatement3.executeUpdate(); // RUN A TRANSACTION
	
		
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

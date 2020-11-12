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




public class InitializeDao {
	
	public void initDB(){
		Statement statement; 
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/pay_role?"
				              + "user=root&password=5824");	
			
			
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
                    "compny_name varchar(50) DEFAULT NULL, " +
                    "compny_address varchar(50) DEFAULT NULL, " +
					"contact_no varchar(50) DEFAULT NULL, " +
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
        				"user varchar(50) DEFAULT NULL,"+
        				"name varchar(50) DEFAULT NULL,"+
        				"date_of_hiring varchar(50) DEFAULT NULL,"+
        				"gender varchar(50) DEFAULT NULL,"+
        				"date_of_birth varchar(50) DEFAULT NULL)";
                statement.executeUpdate(sqlstmt3);
        
        PreparedStatement preparedStatement2 = connect
                    .prepareStatement("insert into  employee (employee_id, compny_id, name, date_of_hiring, gender, date_of_birth, user) values (?, ?, ?, ?, ?, ?, ?)");
                preparedStatement2.setString(1, "100");
                preparedStatement2.setString(2, "1");
                preparedStatement2.setString(3, "Sam");
                preparedStatement2.setString(4, "2017-05-18");
                preparedStatement2.setString(5, "Male");
                preparedStatement2.setString(6, "1991-10-03");
                preparedStatement2.setString(7, "S12");
                preparedStatement2.executeUpdate(); // RUN A TRANSACTION
            
            preparedStatement2 = connect
                    .prepareStatement("insert into  employee(employee_id, compny_id, name, date_of_hiring, gender, date_of_birth, user) values (?, ?, ?, ?, ?, ?, ?)");
                preparedStatement2.setString(1, "101");
                preparedStatement2.setString(2, "2");
                preparedStatement2.setString(3, "Mike");
                preparedStatement2.setString(4, "2015-08-20");
                preparedStatement2.setString(5, "Male");
                preparedStatement2.setString(6, "1993-12-09");
                preparedStatement2.setString(7, "S13");
                preparedStatement2.executeUpdate(); // RUN A TRANSACTION
		    
            preparedStatement2 = connect
                    .prepareStatement("insert into  employee (employee_id, compny_id, name, date_of_hiring, gender, date_of_birth, user) values (?, ?, ?, ?, ?, ?, ?)");
                preparedStatement2.setString(1, "102");
                preparedStatement2.setString(2, "3");
                preparedStatement2.setString(3, "Jay");
                preparedStatement2.setString(4, "2019-02-19");
                preparedStatement2.setString(5, "250");
                preparedStatement2.setString(6, "1995-1-23");
                preparedStatement2.setString(7, "S14");
                preparedStatement2.executeUpdate(); // RUN A TRANSACTION

    			statement.executeUpdate("DROP TABLE IF EXISTS salary_employee");
                
                String sqlstmt5 = "CREATE TABLE IF NOT EXISTS salary_employee" +
                		"(employee_id int DEFAULT NULL,"+
                		"salary_ssn varchar(50) PRIMARY KEY,"+
                		"salary float DEFAULT NULL,"+
                		"salary_days int DEFAULT NULL,"+
                		"pay_start_date varchar(50) DEFAULT NULL,"+
                		"pay_end_date varchar(50) DEFAULT NULL)";
                statement.executeUpdate(sqlstmt5);
       
                PreparedStatement preparedStatement88 = connect
                		.prepareStatement("insert into salary_employee  (employee_id, salary_ssn, salary, salary_days, pay_start_date, pay_end_date) values (?, ?, ?, ?, ?, ?)");
                	preparedStatement88.setString(1, "9004");
                	preparedStatement88.setString(2, "665-657-5758");
                	preparedStatement88.setString(3, "4000");
                	preparedStatement88.setString(4, "20");
                	preparedStatement88.setString(5, "2020-01-20");
                	preparedStatement88.setString(6, "2020-02-10");

                	preparedStatement88.executeUpdate(); // RUN A TRANSACTION


                	preparedStatement88 = connect
                		.prepareStatement("insert into salary_employee  (employee_id, salary_ssn, salary, salary_days, pay_start_date, pay_end_date) values (?, ?, ?, ?, ?, ?)");
                	preparedStatement88.setString(1, "9002");
                	preparedStatement88.setString(2, "212-354-5345");
                	preparedStatement88.setString(3, "9000.00");
                	preparedStatement88.setString(4, "30");
                	preparedStatement88.setString(5, "2020-01-01");
                	preparedStatement88.setString(6, "2020-01-30");

                	preparedStatement88.executeUpdate(); // RUN A TRANSACTION
                	

                	preparedStatement88 = connect
                		.prepareStatement("insert into salary_employee  (employee_id, salary_ssn, salary, salary_days, pay_start_date, pay_end_date) values (?, ?, ?, ?, ?, ?)");
                	preparedStatement88.setString(1, "9003");
                	preparedStatement88.setString(2, "677-464-2423");
                	preparedStatement88.setString(3, "3000");
                	preparedStatement88.setString(4, "20");
                	preparedStatement88.setString(5, "2020-02-02");
                	preparedStatement88.setString(6, "2020-02-22");

                	preparedStatement88.executeUpdate(); // RUN A TRANSACTION
                	
                	statement.executeUpdate("DROP TABLE IF EXISTS hourly_employee");
                	
                    String sqlstmt9 = "CREATE TABLE IF NOT EXISTS hourly_employee" +
                    		"(employee_id int DEFAULT NULL,"+
                    		"hourly_ssn varchar(50) PRIMARY KEY,"+
                    		"rate float DEFAULT NULL,"+
                    		"hrs_worked float DEFAULT NULL,"+
                    		"pay_start_date varchar(50) DEFAULT NULL,"+
                    		"pay_end_date varchar(50) DEFAULT NULL)";
                    statement.executeUpdate(sqlstmt9);
           
                    PreparedStatement preparedStatement8 = connect
                    		.prepareStatement("insert into hourly_employee  (employee_id, hourly_ssn, rate, hrs_worked, pay_start_date, pay_end_date) values (?, ?, ?, ?, ?, ?)");
                    	preparedStatement8.setString(1, "9004");
                    	preparedStatement8.setString(2, "089-766-6466");
                    	preparedStatement8.setString(3, "40.00");
                    	preparedStatement8.setString(4, "30.00");
                    	preparedStatement8.setString(5, "2020-01-20");
                    	preparedStatement8.setString(6, "2020-01-30");

                    	preparedStatement8.executeUpdate(); // RUN A TRANSACTION


                    	preparedStatement8 = connect
                    		.prepareStatement("insert into hourly_employee  (employee_id, hourly_ssn, rate, hrs_worked, pay_start_date, pay_end_date) values (?, ?, ?, ?, ?, ?)");
                    	preparedStatement8.setString(1, "9002");
                    	preparedStatement8.setString(2, "757-576-7677");
                    	preparedStatement8.setString(3, "20.00");
                    	preparedStatement8.setString(4, "40.00");
                    	preparedStatement8.setString(5, "2020-01-01");
                    	preparedStatement8.setString(6, "2020-01-07");

                    	preparedStatement8.executeUpdate(); // RUN A TRANSACTION
                    	

                    	preparedStatement8 = connect
                    		.prepareStatement("insert into hourly_employee  (employee_id, hourly_ssn, rate, hrs_worked, pay_start_date, pay_end_date) values (?, ?, ?, ?, ?, ?)");
                    	preparedStatement8.setString(1, "9003");
                    	preparedStatement8.setString(2, "797-447-2344");
                    	preparedStatement8.setString(3, "30.69");
                    	preparedStatement8.setString(4, "20.00");
                    	preparedStatement8.setString(5, "2020-01-02");
                    	preparedStatement8.setString(6, "2020-01-08");

                    	preparedStatement8.executeUpdate(); // RUN A TRANSACTION

        			statement.executeUpdate("DROP TABLE IF EXISTS salary_deductibles");
                    
                    String sqlstmt6 = "CREATE TABLE IF NOT EXISTS salary_deductibles" +
                    		"(salary_ssn varchar(50) DEFAULT NULL,"+
                    		"dental float DEFAULT NULL,"+
                    		"vision float DEFAULT NULL,"+
                    		"medical float DEFAULT NULL,"+
                    		"401k float DEFAULT NULL,"+
                    		"life_insurance float DEFAULT NULL)";
                    statement.executeUpdate(sqlstmt6);
                    
                    PreparedStatement preparedStatement99 = connect
                    		.prepareStatement("insert into  salary_deductibles (salary_ssn, dental, vision, medical, 401K, life_insurance ) values (?, ?, ?, ?, ?, ?)");
                    	preparedStatement99.setString(1, "900-678-6868");
                    	preparedStatement99.setString(2, "20.00");
                    	preparedStatement99.setString(3, "30.00");
                    	preparedStatement99.setString(4, "400.00");
                    	preparedStatement99.setString(5, "80.00");
                    	preparedStatement99.setString(6, "7.00");
                    	preparedStatement99.executeUpdate(); // RUN A TRANSACTION

                    	preparedStatement99 = connect
                    		.prepareStatement("insert into  salary_deductibles (salary_ssn, dental, vision, medical, 401K, life_insurance ) values (?, ?, ?, ?, ?, ?)");
                    	preparedStatement99.setString(1, "902-797-5758");
                    	preparedStatement99.setString(2, "10.00");
                    	preparedStatement99.setString(3, "30.00");
                    	preparedStatement99.setString(4, "200.00");
                    	preparedStatement99.setString(5, "80.00");
                    	preparedStatement99.setString(6, "70.00");
                    	preparedStatement99.executeUpdate(); // RUN A TRANSACTION


                    	preparedStatement99 = connect
                    		.prepareStatement("insert into  salary_deductibles (salary_ssn, dental, vision, medical, 401K, life_insurance ) values (?, ?, ?, ?, ?, ?)");
                    	preparedStatement99.setString(1, "903-698-6577");
                    	preparedStatement99.setString(2, "20.00");
                    	preparedStatement99.setString(3, "70.00");
                    	preparedStatement99.setString(4, "300.00");
                    	preparedStatement99.setString(5, "30.00");
                    	preparedStatement99.setString(6, "70.00");
                    	preparedStatement99.executeUpdate(); // RUN A TRANSACTION
                    	
                    	
            			statement.executeUpdate("DROP TABLE IF EXISTS salary_tax");

                        String sqlstmt7 = "CREATE TABLE IF NOT EXISTS salary_tax" +
                        		"(salary_ssn varchar(50) DEFAULT NULL,"+
                        		"state float DEFAULT NULL,"+
                        		"federal float DEFAULT NULL,"+
                        		"social_security float DEFAULT NULL,"+
                        		"medicare float DEFAULT NULL)";
                        statement.executeUpdate(sqlstmt7);
                        
                        PreparedStatement preparedStatement3 = connect
                        		.prepareStatement("insert into salary_tax  (salary_ssn, state, federal, social_security, medicare ) values (?, ?, ?, ?, ?)");
                        preparedStatement3.setString(1, "9001");
                        preparedStatement3.setString(2, "30.00");
                        preparedStatement3.setString(3, "30.00");
                        preparedStatement3.setString(4, "50.00");
                        preparedStatement3.setString(5, "80.00");
                        preparedStatement3.executeUpdate(); // RUN A TRANSACTION


                        preparedStatement3 = connect
                        	.prepareStatement("insert into salary_tax  (salary_ssn, state, federal, social_security, medicare ) values (?, ?, ?, ?, ?)");
                        preparedStatement3.setString(1, "9002");
                        preparedStatement3.setString(2, "40.00");
                        preparedStatement3.setString(3, "30.00");
                        preparedStatement3.setString(4, "30.00");
                        preparedStatement3.setString(5, "40.00");
                        preparedStatement3.executeUpdate(); // RUN A TRANSACTION


                        preparedStatement3 = connect
                        	.prepareStatement("insert into salary_tax  (salary_ssn, state, federal, social_security, medicare ) values (?, ?, ?, ?, ?)");
                        preparedStatement3.setString(1, "9003");
                        preparedStatement3.setString(2, "30.00");
                        preparedStatement3.setString(3, "30.00");
                        preparedStatement3.setString(4, "50.00");
                        preparedStatement3.setString(5, "80.00");
                        preparedStatement3.executeUpdate(); // RUN A TRANSACTION
                        
            			statement.executeUpdate("DROP TABLE IF EXISTS hourly_deductibles");
                        
                        String sqlstmt10 = "CREATE TABLE IF NOT EXISTS hourly_deductibles" +
                        		"(hourly_ssn varchar(50) DEFAULT NULL,"+
                        		"dental float DEFAULT NULL,"+
                        		"vision float DEFAULT NULL,"+
                        		"medical float DEFAULT NULL,"+
                        		"401k float DEFAULT NULL,"+
                        		"life_insurance float DEFAULT NULL)";
                        statement.executeUpdate(sqlstmt10);
                        
                        PreparedStatement preparedStatement9 = connect
                        		.prepareStatement("insert into  hourly_deductibles (hourly_ssn, dental, vision, medical, 401K, life_insurance ) values (?, ?, ?, ?, ?, ?)");
                        	preparedStatement9.setString(1, "900-678-6868");
                        	preparedStatement9.setString(2, "20.00");
                        	preparedStatement9.setString(3, "30.00");
                        	preparedStatement9.setString(4, "400.00");
                        	preparedStatement9.setString(5, "80.00");
                        	preparedStatement9.setString(6, "7.00");
                        	preparedStatement9.executeUpdate(); // RUN A TRANSACTION

                        	preparedStatement9 = connect
                        		.prepareStatement("insert into  hourly_deductibles (hourly_ssn, dental, vision, medical, 401K, life_insurance ) values (?, ?, ?, ?, ?, ?)");
                        	preparedStatement9.setString(1, "902-797-5758");
                        	preparedStatement9.setString(2, "10.00");
                        	preparedStatement9.setString(3, "30.00");
                        	preparedStatement9.setString(4, "200.00");
                        	preparedStatement9.setString(5, "80.00");
                        	preparedStatement9.setString(6, "70.00");
                        	preparedStatement9.executeUpdate(); // RUN A TRANSACTION


                        	preparedStatement9 = connect
                        		.prepareStatement("insert into  hourly_deductibles (hourly_ssn, dental, vision, medical, 401K, life_insurance ) values (?, ?, ?, ?, ?, ?)");
                        	preparedStatement9.setString(1, "903-698-6577");
                        	preparedStatement9.setString(2, "20.00");
                        	preparedStatement9.setString(3, "70.00");
                        	preparedStatement9.setString(4, "300.00");
                        	preparedStatement9.setString(5, "30.00");
                        	preparedStatement9.setString(6, "70.00");
                        	preparedStatement9.executeUpdate(); // RUN A TRANSACTION
                        	
                        	
                			statement.executeUpdate("DROP TABLE IF EXISTS hourly_tax");

                            String sqlstmt11 = "CREATE TABLE IF NOT EXISTS hourly_tax" +
                            		"(hourly_ssn varchar(50) DEFAULT NULL,"+
                            		"state float DEFAULT NULL,"+
                            		"federal float DEFAULT NULL,"+
                            		"social_security float DEFAULT NULL,"+
                            		"medicare float DEFAULT NULL)";
                            statement.executeUpdate(sqlstmt11);
                            
                            PreparedStatement preparedStatement33 = connect
                            		.prepareStatement("insert into hourly_tax  (hourly_ssn, state, federal, social_security, medicare ) values (?, ?, ?, ?, ?)");
                            preparedStatement33.setString(1, "9001");
                            preparedStatement33.setString(2, "30.00");
                            preparedStatement33.setString(3, "30.00");
                            preparedStatement33.setString(4, "50.00");
                            preparedStatement33.setString(5, "80.00");
                            preparedStatement33.executeUpdate(); // RUN A TRANSACTION


                            preparedStatement33 = connect
                            	.prepareStatement("insert into hourly_tax  (hourly_ssn, state, federal, social_security, medicare ) values (?, ?, ?, ?, ?)");
                            preparedStatement33.setString(1, "9002");
                            preparedStatement33.setString(2, "40.00");
                            preparedStatement33.setString(3, "30.00");
                            preparedStatement33.setString(4, "30.00");
                            preparedStatement33.setString(5, "40.00");
                            preparedStatement33.executeUpdate(); // RUN A TRANSACTION


                            preparedStatement33 = connect
                            	.prepareStatement("insert into hourly_tax  (hourly_ssn, state, federal, social_security, medicare ) values (?, ?, ?, ?, ?)");
                            preparedStatement33.setString(1, "9003");
                            preparedStatement33.setString(2, "30.00");
                            preparedStatement33.setString(3, "30.00");
                            preparedStatement33.setString(4, "50.00");
                            preparedStatement33.setString(5, "80.00");
                            preparedStatement33.executeUpdate(); // RUN A TRANSACTION

	
		
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

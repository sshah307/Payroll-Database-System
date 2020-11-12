package user.web.servlet;

import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;

//import javax.jws.WebService;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.domain.Employee;
import user.service.EmployeeService;
import user.service.UserException;


public class UserServletEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UserServletEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		EmployeeService employeeservice = new EmployeeService();  
		Employee form = new Employee();	

		
		int id = Integer.parseInt(request.getParameter("employee_id"));
		int compny_id = Integer.parseInt(request.getParameter("compny_id"));
		String user = request.getParameter("user");
		String name = request.getParameter("name");
		String date_of_hiring = request.getParameter("date_of_hiring");
		String gender = request.getParameter("gender");
		String date_of_birth = request.getParameter("date_of_birth");
			
		
        
		form.setEmployee_id(id);
		form.setCompny_id(compny_id);
		form.setUser(user);
		form.setName(name);
		form.setDate_of_hiring(date_of_hiring);
		form.setGender(gender);
		form.setDate_of_birth(date_of_birth);
		
		
		try {
			employeeservice.registEmployee(form);
			request.getRequestDispatcher("/jsps/employee/employeePage.jsp").forward(request, response);
			
		} catch (ClassNotFoundException | UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
package user.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.domain.Employee;
import user.service.EmployeeService;


public class updateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EmployeeService employeeservice = new EmployeeService();
		try {
			
			int id = Integer.parseInt(request.getParameter("employee_id"));
			int compny_id = Integer.parseInt(request.getParameter("compny_id"));
			String user = request.getParameter("user");
			String name = request.getParameter("name");
			String date_of_hiring = request.getParameter("date_of_hiring");
			String gender = request.getParameter("gender");
			String date_of_birth = request.getParameter("date_of_birth");
				
			
			Employee empl = new Employee(id, compny_id, user, name, date_of_hiring, gender, date_of_birth);
			
			employeeservice.updateEmployee(empl);
		
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			List<Object> li = employeeservice.findallEmployee();
			for(int i = 0; i < li.size();i++){
				System.out.println(li.get(i).toString());
			}
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.getRequestDispatcher("/jsps/employee/employeePage.jsp").forward(request, response);
	}

}
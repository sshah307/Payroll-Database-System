package user.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.domain.Hourly_employee;
import user.service.hourly_employeeService;


public class updateHourly_employee extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		hourly_employeeService hourlyemployeeservice = new hourly_employeeService();
		try {
			
			String hourly_ssn = request.getParameter("hourly_ssn");
			int employee_id = Integer.parseInt(request.getParameter("employee_id"));
			float hrs_worked = Float.parseFloat(request.getParameter("hrs_worked"));
			float rate = Float.parseFloat(request.getParameter("rate"));
			String pay_start_date = request.getParameter("pay_start_date");
			String pay_end_date = request.getParameter("pay_end_date");
			
			Hourly_employee hrs = new Hourly_employee(hourly_ssn, employee_id, hrs_worked, rate, pay_start_date, pay_end_date);
			
			hourlyemployeeservice.updateHourly_employee(hrs);
		
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			List<Object> li = hourlyemployeeservice.findallHourly_employee();
			for(int i = 0; i < li.size();i++){
				System.out.println(li.get(i).toString());
			}
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.getRequestDispatcher("/jsps/hourly_employee/hourly_employeePage.jsp").forward(request, response);
	}


}
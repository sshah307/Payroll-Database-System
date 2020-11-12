package user.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.domain.Hourly_employee;
import user.service.UserException;
import user.service.hourly_employeeService;

public class UserServletHourly_employee extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public UserServletHourly_employee() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		hourly_employeeService hourlyemployeeservice = new hourly_employeeService();  
		Hourly_employee form = new Hourly_employee();	
		
		String hourly_ssn = request.getParameter("hourly_ssn");
		int employee_id = Integer.parseInt(request.getParameter("employee_id"));
		float hrs_worked = Float.parseFloat(request.getParameter("hrs_worked"));
		float rate = Float.parseFloat(request.getParameter("rate"));
		String pay_start_date = request.getParameter("pay_start_date");
		String pay_end_date = request.getParameter("pay_end_date");
	
        
		form.sethourly_ssn(hourly_ssn);
		form.setemployee_id(employee_id);
		form.sethrs_worked(hrs_worked);
		form.setrate(rate);
		form.setDateStart(pay_start_date);
		form.setEnd(pay_end_date);
		
		
		try {
			hourlyemployeeservice.registhourly_employee(form);
			
			request.getRequestDispatcher("/jsps/hourly_employee/hourly_employeePage.jsp").forward(request, response);
			
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
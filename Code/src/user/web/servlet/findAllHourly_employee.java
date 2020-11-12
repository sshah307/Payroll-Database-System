package user.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.service.hourly_employeeService;
 

public class findAllHourly_employee extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		hourly_employeeService hourlyemployeeservice = new hourly_employeeService();
		try {
			request.setAttribute("Hourly_employeeList", hourlyemployeeservice.findallHourly_employee());
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			
			System.out.println("SHOWING DATABASE FOR EMPLOYEE");


			List<Object> lists = hourlyemployeeservice.findallHourly_employee();

		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.getRequestDispatcher("/jsps/hourly_employee/Hourly_employeeDisplay.jsp").forward(request, response);
	}

}
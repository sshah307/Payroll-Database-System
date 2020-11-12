package user.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.service.CompanyService;

/**
 * Servlet implementation class findAll
 */

public class findAllCompany extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CompanyService companyservice = new CompanyService();
		try {
			request.setAttribute("CompanyList", companyservice.findallCompany());
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			
			System.out.println("SHOWING DATABASE FOR COMPANY");
		
			List<Object> lists = companyservice.findallCompany();
			for(int i = 0; i < lists.size();i++){
				System.out.println(lists.get(i).toString());
				System.out.println("");
			}

		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.getRequestDispatcher("/jsps/company/CompanyDisplay.jsp").forward(request, response);
	}

}
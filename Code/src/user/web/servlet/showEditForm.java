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

public class showEditForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CompanyService companyservice = new CompanyService();
	
		try {
			
			
			int id = Integer.parseInt(request.getParameter("compny_id"));		
			request.setAttribute("companyInfo", companyservice.findByCompanyID(id));
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			List<Object> li = companyservice.findallCompany();
			for(int i = 0; i < li.size();i++){
				System.out.println(li.get(i).toString());
			}
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
		
			e.printStackTrace();
		}
		
		
		request.getRequestDispatcher("/jsps/company/companyEditForm.jsp").forward(request, response);
	}

}
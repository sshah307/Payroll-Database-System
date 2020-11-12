package user.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.domain.Company;
import user.service.CompanyService;

/**
 * Servlet implementation class findAll
 */

public class updateCompany extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CompanyService companyservice = new CompanyService();
		try {
			int id = Integer.parseInt(request.getParameter("compny_id"));
			String name = request.getParameter("compny_name");
			String address = request.getParameter("compny_address");
			String contact = request.getParameter("contact_no");
			int size = Integer.parseInt(request.getParameter("employee_size"));			
			
			
			Company comp = new Company(id, name, address, contact, size);
			
			companyservice.updateCompany(comp);
		
			
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.getRequestDispatcher("/jsps/company/companyPage.jsp").forward(request, response);
	}

}

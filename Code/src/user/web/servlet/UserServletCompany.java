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

import user.domain.Company;
import user.service.CompanyService;
import user.service.UserException;

/**
 * Servlet implementation class UserServlet
 */

public class UserServletCompany extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserServletCompany() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CompanyService companyservice = new CompanyService();  
		Company form = new Company();	

        int id = Integer.parseInt(request.getParameter("compny_id"));
        String name = request.getParameter("compny_name");
        String address = request.getParameter("compny_address");
        String contact = request.getParameter("contact_no");
        int size = Integer.parseInt(request.getParameter("employee_size"));

        
		form.setId(id);
		form.setName(name);
		form.setAddress(address);
		form.setContact(contact);
		form.setSize(size);
		
		try {
			companyservice.registCompany(form);
			request.getSession().setAttribute("session_company", form);
			request.getRequestDispatcher("/jsps/company/companyPage.jsp").forward(request, response);
			
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
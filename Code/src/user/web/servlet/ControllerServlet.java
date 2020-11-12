 package user.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dao.CompanyDao;
import user.domain.Company;

/**
* ControllerServlet.java
* This servlet acts as a page controller for the application, handling all
* requests from the user.
* @author www.codejava.net
*/
public class ControllerServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
   private CompanyDao companyDao;

   public void init() {
       String jdbcURL = getServletContext().getInitParameter("jdbc:mysql://localhost:3306/pay_role");
       String jdbcUsername = getServletContext().getInitParameter("root");
       String jdbcPassword = getServletContext().getInitParameter("Palna@4706");

       companyDao = new CompanyDao(jdbcURL, jdbcUsername, jdbcPassword);

   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       doGet(request, response);
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       
	   String action = request.getServletPath();
       System.out.println("action: " + action);
       try {
           switch (action) {
           case "/new":
               showNewForm(request, response);
               break;
           case "/insert":
               insertCompany(request, response);
               break;
           case "/delete":
               deleteCompany(request, response);
               break;
           case "/edit":
               showEditForm(request, response);
               break;
           case "/update":
               updateCompany(request, response);
               break;
           default:
               listCompany(request, response);
               break;
           }
       } catch (SQLException ex) {
           throw new ServletException(ex);
       }
   }

   private void listCompany(HttpServletRequest request, HttpServletResponse response)
           throws SQLException, IOException, ServletException {
       List<Company> listCompany = companyDao.listAllCompany();
       request.setAttribute("listCompany", listCompany);
       RequestDispatcher dispatcher = request.getRequestDispatcher("CompanyList.jsp");
       dispatcher.forward(request, response);
   }

   private void showNewForm(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       RequestDispatcher dispatcher = request.getRequestDispatcher("CompanyForm.jsp");
       dispatcher.forward(request, response);
   }

   private void showEditForm(HttpServletRequest request, HttpServletResponse response)
           throws SQLException, ServletException, IOException {
       int compny_id = Integer.parseInt(request.getParameter("compny_id"));
       Company existingCompany = companyDao.getCompany(compny_id);
       RequestDispatcher dispatcher = request.getRequestDispatcher("CompanyForm.jsp");
       request.setAttribute("company", existingCompany);
       dispatcher.forward(request, response);

   }

   private void insertCompany(HttpServletRequest request, HttpServletResponse response)
           throws SQLException, IOException {
       String compny_name = request.getParameter("compny_name");
       String compny_address = request.getParameter("compny_address");
       String contact_no = request.getParameter("contact_no");
       int employee_size = Integer.parseInt(request.getParameter("employee_size"));

       Company newCompany = new Company(compny_name, compny_address, contact_no, employee_size);
       companyDao.insertCompany(newCompany);
       response.sendRedirect("list");
   }

   private void updateCompany(HttpServletRequest request, HttpServletResponse response)
           throws SQLException, IOException {
       int compny_id = Integer.parseInt(request.getParameter("compny_id"));
       String compny_name = request.getParameter("compny_name");
       String compny_address = request.getParameter("compny_address");
       String contact_no = request.getParameter("contact_no");
       int employee_size = Integer.parseInt(request.getParameter("employee_size"));

       Company company = new Company(compny_id, compny_name, compny_address, contact_no, employee_size);
       companyDao.updateCompany(company);
       response.sendRedirect("list");
   }

   private void deleteCompany(HttpServletRequest request, HttpServletResponse response)
           throws SQLException, IOException {
       int compny_id = Integer.parseInt(request.getParameter("compny_id"));

       Company company = new Company(compny_id);
       companyDao.deleteCompany(company);
       response.sendRedirect("list");

   }
}
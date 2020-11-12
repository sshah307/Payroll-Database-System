<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Payroll Database Application</title>
</head>
<body>
    <center>
        <h1>Payroll Database</h1>
        <h2>
            <a href="CompanyForm.jsp?action=/new">Add New Company</a>
            &nbsp;&nbsp;&nbsp;
            <a href="CompanyList.jsp?action=/list">List All Company</a>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Company</h2></caption>
            <tr>
                <th>Company Id</th>
                <th>Name</th>
                <th>Address</th>
                <th>Contact No</th>
                <th>Employee Size</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="company" items="${listCompany}">
                <tr>
                    <td><c:out value="${company.compny_id}" /></td>
                    <td><c:out value="${company.compny_name}" /></td>
                    <td><c:out value="${company.compny_address}" /></td>
                    <td><c:out value="${company.contact_no}" /></td>
                    <td><c:out value="${company.employee_size}" /></td>
                    <td>
                        <a href="/edit?compny_id=<c:out value='${company.compny_id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?compny_id=<c:out value='${company.compny_id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>
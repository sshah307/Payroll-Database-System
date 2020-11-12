<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align = "center"> Employee Table </h3>
	<br>
    <div style="margin: 0 auto; text-align: center">
	<a href="<c:url value='/jsps/employee/employeeAddForm.jsp'/>" style="margin: 0px; display:block;" "target="body">Add New Employee</a>
	</div>
    <br>
	<br>
	<table border="1" width="70%" align="center">
	<tr>
		<th>employee_id</th>
		<th>compny_id</th>
		<th>user</th>
		<th>name</th> 
		<th>date_of_hiring</th>
		<th>gender</th>
		<th>date_of_birth</th>
	</tr>
<c:forEach items="${EmployeeList}" var="employee">
	<tr>
		<td>${employee.employee_id}</td>
		<td>${employee.compny_id}</td>
		<td>${employee.user} </td>
		<td>${employee.name} </td>
		<td>${employee.date_of_hiring} </td>
		<td>${employee.gender}</td>
		<td>${employee.date_of_birth}</td>
		<td>
		<a href="<%=request.getContextPath()%>/showEditFormEmployee?employee_id=<c:out value='${employee.employee_id}'/>">Edit</a>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="<%=request.getContextPath()%>/deleteEmployee?employee_id=<c:out value='${employee.employee_id}'/>">Delete</a>
		</td>
	</tr>
</c:forEach>
</table>


</body>
</html>
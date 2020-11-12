<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align = "center">Hourly Employee Table </h3>
	<br>
    <div style="margin: 0 auto; text-align: center">
	<a href="<c:url value='/jsps/hourly_employee/hourly_employeeAddform.jsp'/>" target="body">Hourly Employee form</a>
	</div>
    <br>
	<br>
	<table border="1" width="70%" align="center">
	<tr>
		<th>hourly_ssn</th>
		<th>employee_id</th>
		<th>hrs_worked</th>
		<th>rate</th> 
		<th>pay_start_date</th>
		<th>pay_end_date</th>
		
	</tr>
<c:forEach items="${Hourly_employeeList}" var="hourly_employee">
	<tr>
		<td>${hourly_employee.hourly_ssn}</td>
		<td>${hourly_employee.employee_id} </td>
		<td>${hourly_employee.hrs_worked}</td>
		<td>${hourly_employee.rate} </td>
		<td>${hourly_employee.getDateStart()} </td>
		<td>${hourly_employee.getEnd()}</td>
		<td>
		<a href="<%=request.getContextPath()%>/showEditFormhourly?hourly_ssn=<c:out value='${hourly_employee.hourly_ssn}'/>">Edit</a>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="<%=request.getContextPath()%>/deleteHourly_employee?hourly_ssn=<c:out value='${hourly_employee.hourly_ssn}'/>">Delete</a>
		</td>
</c:forEach>
</table>


</body>
</html>
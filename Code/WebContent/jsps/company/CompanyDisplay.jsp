<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center"> Company Table </h3>
	<div style="margin: 0 auto; text-align: center">
	<a href="<c:url value='/jsps/company/companyAddForm.jsp'/>" style="margin: 0px; display:block;" target="body">Add new Company</a>
	</div>
    <br>
	<br>
	<table border="1" width="70%" align="center">
	<tr>
		<th>Company Id</th>
		<th>Company Name</th>
		<th>Address</th>
		<th>Contact</th>
		<th>Size</th>
	</tr>
<c:forEach items="${CompanyList}" var="company">
	<tr>
		<td>${company.getId()}</td>
		<td>${company.getName()} </td>
		<td>${company.getAddress()}</td>
		<td>${company.getContact()} </td>
		<td>${company.getSize()}</td>
		
		<td>
		<a href="<%=request.getContextPath()%>/showEditForm?compny_id=<c:out value='${company.getId()}'/>">Edit</a>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="<%=request.getContextPath()%>/deleteCompany?compny_id=<c:out value='${company.getId()}'/>">Delete</a>
		</td>
	</tr>
</c:forEach>
</table>
</body>
</html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Edit Company</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">

  </head>
  
  <body>
  <h1>Edit Company</h1>

<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='updateCompany'/>" method="post">

	<input type="hidden" name="method" value="updateCompany"/>
	Company ID   :<input type="text" name="compny_id" value="<c:out value = '${companyInfo.getId() }' />" readonly = "readonly" />
	<br/>
	Company Name	:<input type="text" name="compny_name" value="${companyInfo.getName() }"/>
	<br/>
	Company Address ：<input type="text" name="compny_address" value="${companyInfo.getAddress() }"/>
	<br/>
	Company Contact ：<input type="text" name="contact_no" value="${companyInfo.getContact() }"/>
	<br/>
	Company Size  ：<input type="text" name="employee_size" value="${companyInfo.getSize() }"/>
	<br/>
	
	<input type="submit" value="Edit"/>
</form>
  </body>
</html>
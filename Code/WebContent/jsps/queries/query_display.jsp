<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="">
    
    <title>body</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <h1>Simple Query</h1>
    <br>
    <a href="<c:url value='/queryOne'/>" target="body">Query 1</a>&nbsp;&nbsp;
 	<a href="<c:url value='/queryTwo'/>" target="body">Query 2</a>&nbsp;&nbsp;
 	<a href="<c:url value='/queryThree'/>" target="body">Query 3</a>&nbsp;&nbsp;
 	
 	<br>
 	
 	<h1>Complex Query</h1>
 	<br>
 	<a href="<c:url value='/queryFour'/>" target="body">Query 1</a>&nbsp;&nbsp;
 	<a href="<c:url value='/queryFive'/>" target="body">Query 2</a>&nbsp;&nbsp;
    <a href="<c:url value='/querySix'/>" target="body">Query 3</a>&nbsp;&nbsp;
    <a href="<c:url value='/querySeven'/>" target="body">Query 4</a>&nbsp;&nbsp;
    <a href="<c:url value='/queryEight'/>" target="body">Query 5</a>&nbsp;&nbsp;
  </body>
</html>
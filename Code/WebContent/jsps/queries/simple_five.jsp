<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
 
<html>

   <body>
      <h1>Complex Query 2</h1>
      <h3>Description</h3>
      <p> Getting the count of all the employees working for the specific company regardless of the company's different locations. </p>
      <br>
      
      <sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://localhost/pay_role"
         user = "root"  password = "5824"/>
 
      <sql:query dataSource = "${snapshot}" var = "result">
		SELECT employee.compny_id, compny_name, COUNT(name) As EmployeeNo
		FROM employee
		JOIN company ON employee.compny_id = company.compny_id
		GROUP BY compny_name
		ORDER BY compny_id ASC;
      </sql:query>
 
      <table border = "1" width = "100%">
         <tr>
            <th>compny_id</th>
			<th>compny_name</th>
			<th>EmployeeNo</th>
         </tr>
         
         <c:forEach var = "row" items = "${result.rows}">
            <tr>
               <td><c:out value = "${row.compny_id}"/></td>
               <td><c:out value = "${row.compny_name}"/></td>
               <td><c:out value = "${row.EmployeeNo}"/></td>
            </tr>
         </c:forEach>
      </table>
 
   </body>
</html>
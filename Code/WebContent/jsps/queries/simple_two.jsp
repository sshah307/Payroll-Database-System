<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
 
<html>


   <body>
   	  <h1>Simple Query 2</h1>
   	  <h3>Description</h3>
      <p> Concatenating and giving the name and the employee id of all the employee from company id. </p>
      <br>
      
      <sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://localhost/pay_role"
         user = "root"  password = "5824"/>
 
      <sql:query dataSource = "${snapshot}" var = "result">
		SELECT CONCAT(employee_id, ', ',  name ) AS employee_identification
		FROM employee
		WHERE compny_id = 111;
      </sql:query>
 
      <table border = "1" width = "100%">
         <tr>
            <th>employee_identification</th>

         </tr>
         
         <c:forEach var = "row" items = "${result.rows}">
            <tr>
               <td><c:out value = "${row.employee_identification}"/></td>
            </tr>
         </c:forEach>
      </table>
 
   </body>
</html>
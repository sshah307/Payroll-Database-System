<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
 
<html>

   <body>
      <h1>Simple Query 3</h1>   
      <h3>Description</h3>
      <p> Getting the total tax of all the salaried employees from the salary tax, showing it with the most tax paying employee. </p>
      <br>
      
      
      
      <sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://localhost/pay_role"
         user = "root"  password = "5824"/>
 
      <sql:query dataSource = "${snapshot}" var = "result">
		SELECT salary_ssn, (state + federal + social_security + medicare) AS total_tax
		FROM salary_tax
		ORDER BY total_tax DESC;
      </sql:query>
 
      <table border = "1" width = "100%">
         <tr>
            <th>salary_ssn</th>
            <th>total_tax</th>

         </tr>
         
         <c:forEach var = "row" items = "${result.rows}">
            <tr>
               <td><c:out value = "${row.salary_ssn}"/></td>
               <td><c:out value = "${row.total_tax}"/></td>
            </tr>
         </c:forEach>
      </table>
 
   </body>
</html>
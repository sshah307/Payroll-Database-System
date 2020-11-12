<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
 
<html>


   <body>
      <h1>Complex Query 1</h1>
      <h3>Description</h3>
      <p> Showing the net income(income after deductibles and tax) of all the salaried employee. </p>
      <br>
      
      <sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://localhost/pay_role"
         user = "root"  password = "5824"/>
 
      <sql:query dataSource = "${snapshot}" var = "result">
	SELECT salary_employee.salary_ssn,(salary - (dental + vision + medical + 401k + life_insurance + state + federal + social_security + medicare)) AS NetIncome
	FROM salary_employee
	JOIN salary_deductibles ON salary_employee.salary_ssn = salary_deductibles.salary_ssn
	JOIN salary_tax ON salary_employee.salary_ssn = salary_deductibles.salary_ssn
      </sql:query>
 
      <table border = "1" width = "100%">
         <tr>
            <th>salary_ssn</th>
			<th>NetIncome</th>
         </tr>
         
         <c:forEach var = "row" items = "${result.rows}">
            <tr>
               <td><c:out value = "${row.salary_ssn}"/></td>
               <td><c:out value = "${row.NetIncome}"/></td>
            </tr>
         </c:forEach>
      </table>
 
   </body>
</html>
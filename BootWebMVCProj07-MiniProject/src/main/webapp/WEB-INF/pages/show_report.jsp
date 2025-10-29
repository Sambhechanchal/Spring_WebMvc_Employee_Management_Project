<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<header style="display:flex; justify-content:space-around; border:1px solid black">
<h2 style="color:green;">Welcome To Employee Management Project</h2>
<h2> <a href="add" style="text-decoration:none;color:green;">Add Employee<img src="images/add.jpg" width="30px" height="30px"> </a></h2>
<h2> <img src="images/home.jpg" width="30px" height="30px"> <a href="./" style="text-decoration:none;color:green;">Home</a></img></h2>
</header>
<section>
<c:choose>
<c:when test="${!empty empList}">

<h2 style="color:pink;text-align:center;">Employee Report</h2>

<table border="1" cellspacing="0" align="center" bgcolor="cyan">

<tr>
<th>EmpNo</th> <th>EmpName</th><th>EmpAddrs</th><th>Salary</th><th>Desg</th><th>Edit</th><th>Delete</th>
</tr>

<c:forEach var="emp" items="${empList}">
<tr>
<td>${emp.empno}</td>
<td>${emp.empName}</td>
<td>${emp.addrs}</td>
<td>${emp.desg}</td>
<td>${emp.salary}</td>
<td><a href="edit?empno=${emp.empno}" style="text-decoration:none"> <img src="images/edit.jpg" width="30px" height="30px"> </a></td>
<td><a href="delete?empno=${emp.empno}" style="text-decoration:none"> <img src="images/delete.jpg" width="30px" height="30px" onclick="return confirm('Are you wan to delete...')"> </a></td>
</tr>

</c:forEach>
</table>
</c:when>
<c:otherwise>
<h2 style="color:red; text-align:center">Employee Not Found</h2>

</c:otherwise>
</c:choose>
<h1>${resultMsg}</h1>
</section>
</body>
</html>
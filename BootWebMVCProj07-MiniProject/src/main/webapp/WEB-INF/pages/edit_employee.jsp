<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Employee</title>
</head>
<body>
<header style="display:flex; justify-content:space-around; border:1px solid black">
<h2 style="color:green;">Welcome To Employee Management Project</h2>
<h2> <img src="images/home.jpg" width="30px" height="30px"> <a href="./" style="text-decoration:none;color:green;">Home</a></img></h2>
</header>
<section>
<frm:form modelAttribute="emp">

<table>

<tr>
<th>EmpNo:</th>
<td><frm:input path="empno" readonly="true"/></td>
</tr>
<tr>
<th>Name:</th>
<td><frm:input path="empName"/></td>
</tr>

<tr>
<th>Address:</th>
<td><frm:input path="addrs"/></td>
</tr>
<tr>
<th>Job Role:</th>
<td><frm:input path="desg"/></td>
</tr>
<tr>
<th>Salary:</th>
<td><frm:input path="salary"/></td>
</tr>
<tr>
<th><input type="submit" value="Update"></th>
<th><input type="reset" value="Cancel"></th>
</tr>

</table>

</frm:form>

</section>
</body>
</html>
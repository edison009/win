<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>

<title>Employee List</title>
<link rel='stylesheet' href='<c:url value="/resources/css/style.css" />' type='text/css' media='all' />
</head>
<body>
<a href="employeeFormPage?personalId=0&officeId=0">Add New</a>
<table width="100%" border="1">
<tr>	
<td> Employee Name</td>
<td> Employee Age</td>
<td> Employee Address</td>
<td> Gender	</td> 
<td> State</td>
<td> Degree</td>
<td> Department</td>
<td> Designation</td>
<td> Salary</td> 
<td> DOJ</td> 
<td> </td> 
<td> </td> 
</tr>
<c:forEach var="emp" items="${employeeDetailList}">
<tr>
<td> <c:out value="${emp.personName}"/></td>
<td> <c:out value="${emp.age}"/></td>
<td> <c:out value="${emp.address}"/></td>
<td> <c:out value="${emp.gender}"/>	</td> 
<td> <c:out value="${emp.stateName}"/></td>
<td> <c:out value="${emp.degree}"/></td>
<td> <c:out value="${emp.department}"/></td>
<td> <c:out value="${emp.designation}"/></td>
<td> <c:out value="${emp.salary}"/></td> 
<td> <c:out value="${emp.doj}"/></td> 
<td> <a href="employeeFormPage?personalId=${emp.personalId}&officeId=${emp.officeId}">Edit</a></td> 
<td><a href="deleteEmployee?personalId=${emp.personalId}&officeId=${emp.officeId}">Delete</a> </td> 
</tr>
</c:forEach>
</body>
</html>
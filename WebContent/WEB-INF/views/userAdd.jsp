<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
	<title>Spring 4 MVC Hello World Example with Maven Eclipse</title>
	<link rel='stylesheet' href='<c:url value="/resources/css/style.css" />' type='text/css' media='all' /> 
</head>
<body>
	<form:form action='saveUser' method='post' modelAttribute="user">
	Name : <form:input path="username" />
	<br>	Password : <form:password path="passwords"/>	
	<br>City : <form:select path="city">
	<br><form:option value="0" label="select"></form:option>
	<form:options items='${cityList}'/>
	</form:select>
	<br>JobType : <form:radiobuttons path="jobType" items='${jobTypeList}'/>
	
	<br>   Department : <form:checkboxes items='${dList}'	path="dept" itemLabel="departmentDesc" itemValue="departmentMasterId"/>

		<br>Colors : <form:checkboxes items='${colorList}' path="color"/>
	<br>About : <form:textarea path="abt"/>
	<br><form:button >Submit</form:button>
	</form:form>
</body>
</html>
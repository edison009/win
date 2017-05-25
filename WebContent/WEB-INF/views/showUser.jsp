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
		Name: <c:out value='${user.username}'/>
	<br>Password : <c:out value='${user.passwords }'/>
	<br>City : <c:out value='${user.city}'/>
	<br>JobType : <c:out value='${user.jobType}'/>
	<br>Department : <c:out value='${user.dept}'/>
	<br>Color : <c:out value='${user.color}'/>
	<br>About : <c:out value='${user.abt}'/>
</body>
</html>
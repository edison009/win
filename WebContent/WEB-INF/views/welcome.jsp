<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<!DOCTYPE html>
<html>
<head>
	<title>Spring 4 MVC Hello World Example with Maven Eclipse</title>
	<link rel='stylesheet' href='<c:url value="/resources/css/style.css" />' type='text/css' media='all' /> 
</head>
<body>
	<h2>Hello World, Spring MVC</h2>

	<p>Welcome, ${name}</p>
	<c:out value='${name}'/>
	<c:set var='obj' value='10'/>
	<c:out value='${obj}'/>
	<c:if test='${obj eq 1}'>
	<c:out value="true"></c:out>
	</c:if>
	<c:forEach items='${nlist}' var='i'>
	<c:choose>
		<c:when test='${fn:contains(i,"1")}'><c:out value='One'></c:out></c:when>
		<c:when test='${i eq 2 }'><c:out value='Two'></c:out></c:when>
		<c:when test='${i eq 3 }'><c:out value='Three'></c:out></c:when>
		<c:when test='${i eq 4 }'><c:out value='Four'></c:out></c:when>
	     <c:otherwise><c:out value='Five'></c:out></c:otherwise>
	</c:choose>  
	</c:forEach>
	${fn:replace(obj,'1','TTTTTTT') }<c:out value='Yes Contains'></c:out>
	<c:forEach items='${mapList}' var='m'>
	<br><c:out value='${m.key}'/>:<c:out value='${m.value}'/>
	</c:forEach>
	
	<c:set var='x' value='999.9900'></c:set>
	<fmt:parseNumber var='j' type='number' value='${x}'></fmt:parseNumber>
	<fmt:formatNumber value='${x}' type='currency'></fmt:formatNumber>
	<c:out value='${x}'></c:out>
	<fmt:formatDate pattern='dd-MMM-yyyy' value="<%=new java.util.Date()%>"/>
	<c:set var='dat' value='23-11-2016'/>
	<fmt:parseDate pattern='dd-MM-yyyy' var='dd' value='${dat}'></fmt:parseDate>
	<c:out value='${dd}'></c:out>
	<c:set var="date" value="12-08-2016" />  
  <fmt:parseDate value="${date}" var="parsedDate"  pattern="dd-MM-yyyy" />  
<p><c:out value="${parsedDate}" /></p>
	
</body>
</html>
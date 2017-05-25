<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
	<title>Employee Form </title>
	<link rel='stylesheet' href='<c:url value="/resources/css/style.css" />' type='text/css' media='all' /> 
</head>
<body>
<form:form action="saveEmployeeForm" method="post" modelAttribute="empForm">
<form:hidden path="empPersonal.personalId" id="personalId"/>
<form:hidden path="empOffice.officeId" id="officeId"/>

<c:if test='${not empty errorsList}'>
<c:forEach var="error" items="${errorsList}">
<c:out value="${error}"></c:out>
</c:forEach>
</c:if>
<table width="100%" border="1">

<tr><td> Employee Name	:</td> <td><form:input path="empPersonal.personName"/></tr>
<tr><td> Employee Age	:</td> <td><form:input path="empPersonal.Age"/></td></tr>
<tr><td> Employee Address	:</td> <td><form:textarea path="empPersonal.Address"/></td></tr>
<tr><td> Select Gender	:</td> <td><form:radiobuttons path="empPersonal.genderId" items='${genderList}' itemLabel="genderDesc" itemValue="genderId" /></td></tr>
<tr><td> Select State	:</td> 
	<td>
	<form:select path="empPersonal.stateId">
	<form:option value="0" label="select"></form:option>
	<form:options items='${stateList}' itemValue="stateMasterId" itemLabel="stateMasterName"/>
	</form:select>
	</td>
	</tr>
	
	<tr><td> Select Degree	:</td> 
	<td>
	<form:select path="empOffice.degreeId">
	<form:option value="0" label="select"></form:option>
	<form:options items='${degreeList}' itemValue="degreeMasterId" itemLabel="degreeMasterDesc"/>
	</form:select>
	</td>
	</tr>
	
	<tr><td> Select Department	:</td> 
	<td>
	<form:select path="empOffice.deptId">
	<form:option value="0" label="select"></form:option>
	<form:options items='${departmentList}' itemValue="departmentMasterId" itemLabel="departmentDesc"/>
	</form:select>
	</td>
	</tr>
	
	<tr><td> Select Designation	:</td> 
	<td>
	<form:select path="empOffice.designId">
	<form:option value="0" label="select"></form:option>
	<form:options items='${designationList}' itemValue="designationMasterId" itemLabel="designationMasterDesc"/>
	</form:select>
	</td>
	</tr>
	
<%-- <tr><td> Select State	:</td> <td><form:checkboxes path="empPersonal.stateId" items='${stateList}' itemLabel="stateMasterName" itemValue="stateMasterId"/></td></tr> --%>

<%-- <tr><td> Select Degree	:</td> <td><form:radiobuttons path="empOffice.degreeId" items='${degreeList}' itemLabel="degreeMasterDesc" itemValue="degreeMasterId" /></td></tr>
<tr><td> Select Department	:</td> <td><form:radiobuttons path="empOffice.deptId"" items='${departmentList}' itemLabel="departmentDesc" itemValue="departmentMasterId" /></td></tr>
<tr><td> Select Designation	:</td> <td><form:radiobuttons path="empOffice.designId"" items='${designationList}' itemLabel="designationMasterDesc" itemValue="designationMasterId" /></td></tr>
 --%>
<tr><td> Employee Salary	:</td> <td><form:input path="empOffice.salary"/></td></tr>
<tr><td> Employee DOJ	:</td> <td><form:input path="empOffice.doj"/></td></tr>


</table>

<br><form:button >Submit</form:button>

</form:form>

</body>
</html>
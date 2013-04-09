<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/include/headers.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Security -- Proof of Concept</title>
</head>
<body>
	<h1>Spring Security -- Proof of Concept</h1>
	
	<table>
		<tr>
			<td><spring:message code="id" /> </td>
			<td><spring:message code="group" /> </td>
		</tr>
		<c:forEach items="${ groups }" var="group">
			<tr>
				<td> <c:out value="${ group.id }" /> </td>
				<td> <c:out value="${ group.groupName }" /> </td>
			</tr>
		</c:forEach>
	</table>
	
	
	<a href="<c:url value='/logout' />">Log out</a>
</body>
</html>
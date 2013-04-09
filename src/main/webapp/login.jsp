<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/include/headers.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><fmt:message key="loginPageTitle" /></title>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css" />">
<link rel="stylesheet" type="text/css" href="<c:url value="/css/menu.css" />">
<link rel="stylesheet" type="text/css" href="<c:url value="/css/jquery-ui-1.8.16.custom.css" />">
<script type="text/javascript" src="<c:url value="/js/jquery-1.6.2.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/jquery-ui-1.8.16.custom.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/loginpage.js" />"></script>
</head>
<body class="standard">
	<div id="loginDialog" title="Login">
		<c:if test="${not empty param.login_error}">
			<font color="red">
				Your login attempt was not successful, please try again.<br/><br/>
				Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
			</font>
		</c:if>
		<form id="loginForm" action="<c:url value='j_spring_security_check'/>" method="POST">
			<table>
				<tr>
					<td>Username</td>
					<td><input type="text" name="j_username" value="<c:if test="${not empty param.login_error}"><c:out value="${SPRING_SECURITY_LAST_USERNAME}"/></c:if>" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="j_password" value="${password}" /></td>
				</tr>
				<tr>
					<td><input id="remember_me" type="checkbox" name="_spring_security_remember_me"></td>
					<td><label for="remember_me">Remember me</label></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
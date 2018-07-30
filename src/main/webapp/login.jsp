<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html>
<%-- Using Struts2 Tags in JSP --%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Login Page</title>
</head>
<body>
<h3>Welcome User, please login below</h3>
<s:form action="login">
	<s:textfield key="login.userName" name="userName"></s:textfield>
	<s:textfield key="password" type="password"></s:textfield>
	<s:submit key="login.submit"/>
</s:form>
</body>
</html>
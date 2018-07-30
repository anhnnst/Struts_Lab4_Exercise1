<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Welcome Page</title>
</head>
<body>
<h3>Welcome <s:property value="userName"/></h3>
<h3>Your name is <s:property value="name"/> </h3>

<s:action name="addUser">Add New User</s:action>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<s:url action="logout" namespace="/account" var="logoutURL" />
<jsp:include page="fragment/head.jsp" />
<title>Tài khoản bị khóa</title>
</head>
<body>
	<s:include value="fragment/navbar.jsp" />
	<div class="container pt-5 pb-5">
		<h2>
			<font color="red" style="background-color: gray"> Tài khoản của bạn đã bị khóa !!!</font></h2><br/>
			<h3>Lý do: <s:property value=" #session.user.report"/></h3><br/>
		<h4>Vui lòng liên hệ: 09999999 để được mở khóa !!!!</h4>
		
		
		 <s:submit value="Quay Lại" cssClass="btn btn-danger" href="%{logoutURL}"/>
		
	</div>
	<s:include value="fragment/js.jsp" />
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../fragment/head.jsp" />
<title>Đăng nhập</title>
<style type="text/css">
.actionMessage {
	color: red;
	list-style-type: none;
	margin: 0;
	padding: 0;
}

.errorMessage {
	color: red;
	list-style-type: none;
	margin: 0;
	padding: 0;
}
</style>
</head>
<body>
	<jsp:include page="../fragment/navbar.jsp" />
	<div class="container pt-5 pb-5">
		<s:form action="login" namespace="/">
			<div class="form-group">
				<label>Tài khoản</label>
				<s:textfield name="username" cssClass="form-control" />
				<s:fielderror fieldName="username" />
				<s:actionmessage />
			</div>
			<div class="form-group">
				<label>Mật khẩu</label>
				<s:password name="password" cssClass="form-control" />
				<s:fielderror fieldName="password" />
			</div>
			<div class="form-group">
				<s:submit value="Đăng nhập" cssClass="btn btn-primary" />
			</div>
		</s:form>
	</div>
	<jsp:include page="../fragment/js.jsp" />
</body>
</html>
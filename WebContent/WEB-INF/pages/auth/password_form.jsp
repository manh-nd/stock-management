<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../fragment/head.jsp" />
<title>Đổi mật khẩu</title>
<style type="text/css">
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
		<s:actionmessage />
		<s:form action="change" namespace="/account">
			<div class="form-group">
				<label>Mật khẩu hiện tại</label>
				<s:password name="currentPassword" cssClass="form-control" />
				<s:fielderror fieldName="currentPassword" />
			</div>
			<div class="form-group">
				<label>Mật khẩu mới</label>
				<s:password name="newPassword" cssClass="form-control" />
				<s:fielderror fieldName="newPassword" />
			</div>
			<div class="form-group">
				<label>Nhập lại mật khẩu mới</label>
				<s:password name="verifyPassword" cssClass="form-control" />
				<s:fielderror fieldName="verifyPassword" />
			</div>
			<div class="form-group">
				<s:submit value="Đăng nhập" cssClass="btn btn-primary" />
			</div>
		</s:form>
	</div>
	<jsp:include page="../fragment/js.jsp" />
</body>
</html>
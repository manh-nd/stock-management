<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../fragment/head.jsp" />
<title>Tài khoản - Thêm mới</title>
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
		<h1>Thêm mới tài khoản</h1>
		<hr>
		<s:form action="save" namespace="/account">
			<s:hidden name="account.id" />
			<div class="form-group">
				<label>Tên tài khoản</label>
				<s:textfield name="account.username" cssClass="form-control" />
				<s:fielderror fieldName="account.username"/>
			</div>
			<div class="form-group">
				<label>Tên đầy đủ</label>
				<s:textfield name="account.fullname" cssClass="form-control" />
				<s:fielderror fieldName="account.fullname"/>
			</div>
			<div class="form-group">
				<label>Mật khẩu</label>
				<s:password name="account.password" cssClass="form-control" />
				 <s:fielderror fieldName="account.password"/>
			</div>
			<div class="form-group">
				<label>Vai Trò</label>
				<s:select cssClass="form-control" name="account.role"
					list="{'admin','Quản lý kho','Quản lý tài khoản'}"
					headerValue="Chọn" headerKey="" label="Chọn vai trò" />
					 <s:fielderror fieldName="account.role"/>
			</div>

			<div class="form-group">
				<label>Trạng thái</label>
				<s:radio list="actives" name="account.active" value="account.active" />
			</div>

			<div class="form-group">
				<s:submit value="Lưu" cssClass="btn btn-primary" />
			</div>
		</s:form>
	</div>
	<jsp:include page="../fragment/js.jsp" />
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../fragment/head.jsp" />
<title>Nhà cung cấp - Biểu mẫu</title>
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
		<s:form action="save" namespace="/category">
			<div class="form-group">
				<label>Tài khoản</label>
				<s:textfield name="account.username" cssClass="form-control" />
				<s:fielderror fieldName="categoryBean.code" />
			</div>
			<div class="form-group">
				<label>Tên danh mục phân loại</label>
				<s:textfield name="categoryBean.name" cssClass="form-control" />
				<s:fielderror fieldName="categoryBean.name" />
			</div>
			<div class="form-group">
				<s:submit value="Lưu" cssClass="btn btn-primary" />
			</div>
		</s:form>
	</div>
	<jsp:include page="../fragment/js.jsp" />
</body>
</html>
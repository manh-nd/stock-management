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
		<h1>Biểu mẫu nhà cung cấp</h1>
		<hr>
		<s:form action="save" namespace="/supplier">
			<s:hidden name="supplierBean.id" />
			<div class="form-group">
				<label>Mã nhà cung cấp</label>
				<s:textfield name="supplierBean.code" cssClass="form-control" />
				<s:fielderror fieldName="supplierBean.code"/>
			</div>
			<div class="form-group">
				<label>Tên nhà cung cấp</label>
				<s:textfield name="supplierBean.name" cssClass="form-control" />
				<s:fielderror fieldName="supplierBean.name"/>
			</div>
			<div class="form-group">
				<label>Trạng thái</label>
				<s:radio list="actives" name="supplierBean.active" value="supplierBean.active"/>
			</div>
			<div class="form-group">
				<s:submit value="Lưu" cssClass="btn btn-primary" />
			</div>
		</s:form>
	</div>
	<jsp:include page="../fragment/js.jsp" />
</body>
</html>
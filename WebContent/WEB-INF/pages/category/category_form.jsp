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
		<h1>Biểu mẫu danh mục phân loại</h1>
		<hr>
		<s:form action="save" namespace="/category">
			<s:hidden id="categoryId" name="categoryBean.id" />
			<div class="form-group">
				<label>Mã danh mục phân loại</label>
				<s:textfield id="categoryCode" name="categoryBean.code" cssClass="form-control" />
				<s:fielderror fieldName="categoryBean.code" />
			</div>
			<div class="form-group">
				<label>Tên danh mục phân loại</label>
				<s:textfield id="categoryName" name="categoryBean.name" cssClass="form-control" />
				<s:fielderror fieldName="categoryBean.name" />
			</div>
			<div class="form-group">
				<label>Trạng thái</label>
				<s:radio list="actives" name="categoryBean.active"
					value="defaultActiveValue" />
			</div>
			<div class="form-group">
				<s:submit value="Lưu" cssClass="btn btn-primary" />
				<button id="backBtn" type="button" class="btn btn-success">Quay
				lại</button>
			</div>
		</s:form>
	</div>
	<jsp:include page="../fragment/js.jsp" />
	<script src="<s:url value="/js/category.js"/>"></script>
</body>
</html>
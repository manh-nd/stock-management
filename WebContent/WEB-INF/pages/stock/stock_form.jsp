<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../fragment/head.jsp" />
<title>Kho hàng - Biểu mẫu</title>
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
		<h1>Biểu mẫu kho hàng</h1>
		<hr>
		<s:form action="save" namespace="/stock">
			<s:hidden id="stockId" name="stockBean.id" />
			<div class="form-group">
				<label>Mã kho hàng</label>
				<s:textfield id="stockCode" name="stockBean.code"
					cssClass="form-control" />
				<s:fielderror fieldName="stockBean.code" />
			</div>
			<div class="form-group">
				<label>Tên kho hàng</label>
				<s:textfield id="stockName" name="stockBean.name"
					cssClass="form-control" />
				<s:fielderror fieldName="stockBean.name" />
			</div>
			<div class="form-group">
				<label>Trạng thái</label>
				<s:radio list="actives" name="stockBean.active"
					value="defaultActiveValue" />
			</div>
			<div class="form-group">
				<s:submit value="Lưu" cssClass="btn btn-primary" />
				<button id="backBtn" type="button" class="btn btn-success">Quay
					lại</button>
			</div>
		</s:form>
	</div>
	<jsp:include page="../fragment/js.jsp"></jsp:include>
	<script src="<s:url value="/js/stock.js"/>"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../fragment/head.jsp"></jsp:include>
<style type="text/css">
.errorMessage {
	color: red;
	margin: 0;
	padding: 0;
	list-style-type: none;
}
</style>
<title>Hãng sản xuất</title>
</head>
<body>
	<jsp:include page="../fragment/navbar.jsp" />
	<div class="container pt-5 pb-5">

		<h1>Biểu mẫu danh mục hãng sản xuất</h1>
		<hr>

		<s:form action="save" namespace="/producer">
			<s:hidden id="producerId" name="producerBean.id" />

			<div class="form-group">
				<label>Mã hãng sản xuất</label>
				<s:textfield id="producerCode" name="producerBean.code"
					cssClass="form-control" />
				<s:fielderror fieldName="producerBean.code" />
			</div>

			<div class="form-group">
				<label>Tên hãng sản xuất</label>
				<s:textfield id="producerName" name="producerBean.name"
					cssClass="form-control" />
				<s:fielderror fieldName="producerBean.name" />
			</div>
			<div class="form-group">
				<label>Trạng thái</label>
				<s:radio list="actives" name="producerBean.active"
					value="defaultActiveValue" />
			</div>
			<div class="form-group">
				<s:submit value="Lưu" cssClass="btn btn-success" />
				<button id="backBtn" type="button" class="btn btn-success">Quay
					lại</button>
			</div>
		</s:form>
	</div>
	<jsp:include page="../fragment/js.jsp"></jsp:include>
	<script src="<s:url value="/js/producer.js"/>"></script>
</body>
</html>
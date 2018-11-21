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
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../fragment/navbar.jsp" />
	<div class="container pt-5 pb-5">
		<s:form action="save" namespace="/producer">
			<s:hidden name="producerBean.id" />

			<div class="form-group">
				<label>Mã Nhà sản xuất</label>
				<s:textfield name="producerBean.code" cssClass="form-control" />
				<s:fielderror fieldName="producerBean.code" />
			</div>

			<div class="form-group">
				<label>Tên Nhà sản xuất</label>
				<s:textfield name="producerBean.name" cssClass="form-control" />
				<s:fielderror fieldName="producerBean.name" />
			</div>
			<div class="form-group">
				<s:submit value="Lưu" cssClass="btn btn-success" />
			</div>
		</s:form>
	</div>
	<jsp:include page="../fragment/js.jsp"></jsp:include>
</body>
</html>
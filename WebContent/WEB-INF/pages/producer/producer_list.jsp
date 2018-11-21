<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../fragment/head.jsp" />
<style type="text/css">
#add_0 {
	
}
</style>
<title>Danh sách hãng sản xuất</title>
</head>
<body>
	<jsp:include page="../fragment/navbar.jsp" />
	<div class="container pt-5 pb-5">
		<h2>Danh sách Nhà sản xuất</h2>
		<br>
		<div class="addProducer">
			<s:a cssClass="btn btn-primary" href="add" namespace="/producer">Thêm mới nhà sản xuất</s:a>
		</div>
		<br>
		<table class="table table-bordered table-sm">
			<tr>
				<td>STT</td>
				<td>Mã Hãng Sản Xuất</td>
				<td>Tên Hãng sản xuất</td>
				<td>Sửa</td>
				<td>Xóa</td>
			</tr>
			<s:iterator value="producerList" status="statusProducerList">
				<tr>
					<td><s:property value="%{#statusProducerList.count}" /></td>
					<td><s:property value="code" /></td>
					<td><s:property value="name" /></td>
					<td><s:url var="editURL" action="edit" namespace="/producer">
							<s:param name="id" value="%{id}"></s:param>
						</s:url> <s:a href="%{editURL}">Sửa</s:a></td>
					<td><s:url var="deleteURL" action="delete">
							<s:param name="id" value="%{id}"></s:param>
						</s:url> <s:a href="%{deleteURL}">Xóa</s:a></td>

				</tr>
			</s:iterator>
		</table>
	</div>
	<jsp:include page="../fragment/js.jsp" />
</body>
</html>
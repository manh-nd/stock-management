<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../fragment/head.jsp" />
<title>Stock List</title>
</head>
<body>
	<div class="container pt-5 pb-5">
		<h1>Danh sách kho hàng</h1>
		<s:a cssClass="btn btn-primary" href="add" name="/stock">Thêm kho mới</s:a>
		<table class="table mt-3">
			<tr>
				<th>STT</th>
				<th>Mã kho</th>
				<th>Tên kho</th>
				<th>Sửa</th>
				<th>Xóa</th>
			</tr>
			<s:iterator value="stockList" status="status">
				<tr>
					<td><s:property value="#status.count" /></td>
					<td><s:property value="code" /></td>
					<td><s:property value="name" /></td>
					<td><s:url action="edit" var="editURL" namespace="/stock">
							<s:param name="id" value="id" />
						</s:url> <a href="${editURL}">Sửa</a></td>
					<td><s:url action="delete" var="deleteURL" namespace="/stock">
							<s:param name="id" value="id" />
						</s:url> <a href="${deleteURL}">Xóa</a></td>
				</tr>
			</s:iterator>
		</table>
	</div>
	<jsp:include page="../fragment/js.jsp" />
</body>
</html>
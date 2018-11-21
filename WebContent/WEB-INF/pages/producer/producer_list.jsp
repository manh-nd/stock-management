<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../fragment/head.jsp" />
<title>Danh sách hãng sản xuất</title>
</head>
<body>
	<div class="container pt-5 pb-5">
		<h1>Mậu LOL</h1>

		<s:a href="add" namespace="/producer">Them</s:a>

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
					<td><s:url id="editURL" action="editProducer" namespace="/producer">
							<s:param name="id" value="%{id}"></s:param>
							</s:url> <s:a href="%{editURL}">Sửa</s:a></td>
					<td><s:url id="deleteURL" action="deleteProducer">
							<s:param name="id" value="%{id}"></s:param>
							</s:url> <s:a href="%{deleteURL}">Xóa</s:a></td>		

				</tr>
			</s:iterator>
		</table>
	</div>
	<jsp:include page="../fragment/js.jsp" />
</body>
</html>
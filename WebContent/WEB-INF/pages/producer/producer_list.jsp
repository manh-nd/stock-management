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
	<jsp:include page="../fragment/navbar.jsp" />
	<div class="container pt-5 pb-5">
	<s:if
			test="%{#session.user.role == 'admin' || #session.user.role == 'Quản lý kho'}">
		<h3>Danh sách hãng sản xuất</h3>
		<hr>
		<s:a cssClass="btn btn-primary" href="add" namespace="/producer">Thêm mới nhà sản xuất</s:a>
		<table class="table table-sm table-striped table-bordered mt-1">
			<thead>
				<tr>
					<th>STT</th>
					<th>Mã hãng sản xuất</th>
					<th>Tên hãng sản xuất</th>
					<th width="60px" class="text-center">Sửa</th>
					<th width="60px" class="text-center">Xóa</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="producerList" status="status">
					<tr>
						<td><s:property value="%{#status.count}" /></td>
						<td><s:property value="code" /></td>
						<td><s:property value="name" /></td>
						<td class="text-center"><s:url var="editURL" action="edit"
								namespace="/producer">
								<s:param name="id" value="%{id}"></s:param>
							</s:url> <s:a href="%{editURL}" cssClass="btn btn-sm btn-warning">Sửa</s:a></td>
						<td class="text-center"><s:url var="deleteURL"
								action="delete">
								<s:param name="id" value="%{id}"></s:param>
							</s:url> <s:a href="%{deleteURL}" cssClass="btn btn-sm btn-danger delete">Xóa</s:a></td>

					</tr>
				</s:iterator>
			</tbody>
		</table>
		</s:if>
		<s:else>
	
		<h3>Bạn không có quyền truy cập</h3>
	</s:else>
	</div>
	<jsp:include page="../fragment/js.jsp" />
	<script>
		$(document).ready(function() {
			$(".delete").click(function(e) {
				var result = confirm("Bạn có muốn xóa hãng sản xuất này không?");
				if (result) {
					return true;
				}
				return false;
			});
		});
	</script>
</body>
</html>
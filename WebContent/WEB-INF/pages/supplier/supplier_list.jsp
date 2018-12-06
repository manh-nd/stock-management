<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../fragment/head.jsp" />
<title>Danh sách nhà cung cấp</title>
</head>
<body>
	<jsp:include page="../fragment/navbar.jsp" />
	<div class="container pt-5 pb-5">
		<s:if
			test="%{#session.user.role == 'admin' || #session.user.role == 'Quản lý kho'}">
			<h3>Danh sách nhà cung cấp</h3>
			<hr>

			<s:a cssClass="btn btn-primary" href="add" name="/supplier">Thêm nhà cung cấp mới</s:a>

			<table class="table table-sm table-striped table-bordered mt-1">
				<thead>
					<tr>
						<th>STT</th>
						<th>Mã nhà cung cấp</th>
						<th>Tên nhà cung cấp</th>
						<th width="60px" class="text-center">Sửa</th>
						<th width="60px" class="text-center">Xóa</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="supplierList" status="status">
						<tr>
							<td><s:property value="#status.count" /></td>
							<td><s:property value="code" /></td>
							<td><s:property value="name" /></td>
							<td class="text-center"><s:url action="edit" var="editURL"
									namespace="/supplier">
									<s:param name="id" value="id" />
								</s:url> <s:a href="%{editURL}" cssClass="btn btn-sm btn-warning">Sửa</s:a>
							</td>
							<td class="text-center"><s:url action="delete"
									var="deleteURL" namespace="/supplier">
									<s:param name="id" value="id" />
								</s:url> <s:a href="%{deleteURL}"
									cssClass="btn btn-sm btn-danger delete">Xóa</s:a></td>
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
		$(document)
				.ready(
						function() {
							$(".delete")
									.click(
											function(e) {
												var result = confirm("Bạn có muốn xóa nhà cung cấp này không?");
												if (result) {
													return true;
												}
												return false;
											});
						});
	</script>
</body>
</html>
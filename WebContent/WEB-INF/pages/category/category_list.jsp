<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../fragment/head.jsp" />
<title>Danh sách danh mục phân loại</title>
</head>
<body>
	<jsp:include page="../fragment/navbar.jsp" />
	<div class="container pt-5 pb-5">
		<h3>Danh sách danh mục phân loại</h3>
		<hr>

		<s:a cssClass="btn btn-primary" href="add" name="/category">Thêm danh mục phân loại mới</s:a>

		<table class="table table-sm table-striped table-bordered mt-1">
			<thead>
				<tr>
					<th>STT</th>
					<th>Mã danh mục phân loại</th>
					<th>Tên danh mục phân loại</th>
					<th width="60px" class="text-center">Sửa</th>
					<th width="60px" class="text-center">Xóa</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="categoryList" status="status">
					<tr>
						<td><s:property value="#status.count" /></td>
						<td><s:property value="code" /></td>
						<td><s:property value="name" /></td>
						<td class="text-center"><s:url action="edit" var="editURL"
								namespace="/category">
								<s:param name="id" value="id" />
							</s:url> <s:a href="%{editURL}" cssClass="btn btn-sm btn-warning">Sửa</s:a>
						</td>
						<td class="text-center"><s:url action="delete"
								var="deleteURL" namespace="/category">
								<s:param name="id" value="id" />
							</s:url> <s:a href="%{deleteURL}" cssClass="btn btn-sm btn-danger delete">Xóa</s:a>
						</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
	<jsp:include page="../fragment/js.jsp" />
	<script>
		$(document).ready(function() {
			$(".delete").click(function(e) {
				var result = confirm("Bạn có muốn xóa chủng loại này không?");
				if (result) {
					return true;
				}
				return false;
			});
		});
	</script>
</body>
</html>
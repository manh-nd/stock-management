<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../fragment/head.jsp" />
<title>Danh sách tài khoản</title>


</head>
<body>
	<jsp:include page="../fragment/navbar.jsp" />
	<div class="container pt-5 pb-5">
		<s:if
			test="%{#session.user.role == 'admin' || #session.user.role == 'Quản lý tài khoản'}">
			<h1>Danh sách tài khoản</h1>
			<hr>
			<s:if test="%{#session.user.role == 'Quản lý tài khoản'}">
				<s:a cssClass="btn btn-primary" href="add" name="/category">Thêm tài khoản mới</s:a>
			</s:if>
			<table class="table table-sm table-bordered mt-3">
				<tr>
					<th class="text-center">STT</th>
					<th class="text-center">Tên tài khoản</th>
					<th class="text-center">Tên đầy đủ</th>
					<th class="text-center">Vai trò</th>
					<s:if test="%{#session.user.role == 'Quản lý tài khoản'}">
						<th width="60px" class="text-center">Trạng thái</th>

						<th width="60px" class="text-center">Sửa</th>
						<th width="60px" class="text-center">Xóa</th>
					</s:if>
				</tr>
				<s:iterator value="accountList" status="status">
					<tr>
						<td><s:property value="#status.count" /></td>
						<td><s:property value="username" /></td>
						<td><s:property value="fullname" /></td>
						<td><s:property value="role" /></td>
						<s:if test="%{#session.user.role == 'Quản lý tài khoản'}">
							<s:if test="active == true">
								<td class="text-center"><s:url action="block"
										var="blockURL" namespace="/account">
										<s:param name="id" value="id" />
									</s:url> <s:a href="%{blockURL}" cssClass="btn btn-sm btn-warning">Khóa</s:a>
								</td>
							</s:if>

							<s:else>
								<td class="text-center"><s:url action="block"
										var="blockURL" namespace="/account">
										<s:param name="id" value="id" />
									</s:url> <s:a href="%{blockURL}" cssClass="btn btn-sm btn-warning">Mở Khóa</s:a>
								</td>
							</s:else>

							<td class="text-center"><s:url action="edit" var="editURL"
									namespace="/account">
									<s:param name="id" value="id" />
								</s:url> <s:a href="%{editURL}" cssClass="btn btn-sm btn-warning">Sửa</s:a>
							</td>
							<td class="text-center"><s:url action="delete"
									var="deleteURL" namespace="/account">
									<s:param name="id" value="id" />
								</s:url> <s:a href="%{deleteURL}" cssClass="btn btn-sm btn-danger">Xóa</s:a>
							</td>
						</s:if>




					</tr>
				</s:iterator>
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
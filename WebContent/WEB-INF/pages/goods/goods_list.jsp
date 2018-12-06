<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../fragment/head.jsp" />
<title>Danh sách hàng hóa</title>
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
		<s:if
			test="%{#session.user.role == 'admin' || #session.user.role == 'Quản lý kho'}">
			<div class="row">
				<div class="col-md-3">
					<div class="list-group">
						<s:set var="stockId" value="%{#parameters.stockId}" />
						<s:iterator value="stockList">
							<s:url var="stockURL" value="list" namespace="/goods">
								<s:param name="stockId" value="id" />
							</s:url>
							<s:text name="%{#stockId} == %{id} ? 'active' : ''" var="active" />
							<s:a href="%{stockURL}"
								cssClass="list-group-item list-group-item-action %{#active}">
								<s:property value="name" />
							</s:a>
						</s:iterator>
					</div>
				</div>

				<div class="col-md-9">
					<s:if test="%{#parameters.stockId != NULL}">
						<s:url action="add" namespace="/goods" var="addURL">
							<s:param name="stockId" value="%{#parameters.stockId}" />
						</s:url>
						<s:a href="%{#addURL}" cssClass="btn btn-primary">Thêm mới hàng hóa</s:a>
						<s:if test="goodsList.size() > 0">
							<table class="table mt-3">
								<tr>
									<th>STT</th>
									<th>Mã hàng hóa</th>
									<th>Tên hàng hóa</th>
									<th>Hạn sử dụng</th>
									<th>Tồn kho</th>
									<th>Sửa</th>
									<th>Xóa</th>
								</tr>
								<s:iterator value="goodsList" status="status">
									<tr>
										<td><s:property value="#status.count" /></td>
										<td><s:property value="code" /></td>
										<td><s:property value="name" /></td>
										<td><s:date name="expiration" format="dd/MM/yyyy" /></td>
										<td><s:property value="inStock" /></td>
										<td><s:url action="edit" var="editURL" namespace="/goods">
												<s:param name="id" value="id" />
												<s:param name="stockId" value="%{#parameters.stockId}" />
											</s:url> <s:a href="%{editURL}">Sửa</s:a></td>
										<td><s:url action="delete" var="deleteURL"
												namespace="/goods">
												<s:param name="id" value="id" />
												<s:param name="stockId" value="%{#parameters.stockId}" />
											</s:url> <s:a href="%{deleteURL}" cssClass="delete">Xóa</s:a></td>
									</tr>
								</s:iterator>
							</table>
							<s:url action="export" namespace="/goods" var="exportURL">
								<s:param name="stockId" value="%{#parameters.stockId}" />
							</s:url>
							<s:a href="%{exportURL}">Kết xuất</s:a>
						</s:if>
						<s:else>
							<div class="alert alert-danger mt-3" role="alert">Kho hàng
								trống.</div>
						</s:else>
					</s:if>
					<s:else>
						<h3>Chọn một kho hàng để xem thông tin về hàng hóa!</h3>
					</s:else>
				</div>
			</div>
		</s:if>
		<s:else>

			<h3>Bạn không có quyền truy cập</h3>
		</s:else>

	</div>
	<jsp:include page="../fragment/js.jsp" />
	<script>
		$(document).ready(function() {
			$(".delete").click(function(e) {
				var result = confirm("Bạn có muốn xóa hàng hóa này không?");
				if (result) {
					return true;
				}
				return false;
			});
		});
	</script>
</body>
</html>
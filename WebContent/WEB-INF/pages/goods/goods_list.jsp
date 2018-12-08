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

						<div class="row">
							<div class="col-xs-12 col-md-3">
								<s:a href="%{#addURL}" cssClass="btn btn-primary">Thêm mới hàng hóa</s:a>
							</div>
							<div class="col-xs-12 col-md-9">
								<form class="form-inline float-right my-lg-0">
									<s:hidden name="stockId" value="%{#parameters.stockId}" />
									<input name="find" class="form-control mr-sm-2" type="search"
										placeholder="Tìm theo mã hoặc tên" aria-label="Tìm kiếm">
									<button class="btn btn-success my-2 my-sm-0" type="submit">Tìm
										kiếm</button>
								</form>
							</div>
						</div>

						<s:if test="goodsList.size() > 0">
							<table class="table mt-3">
								<tr>
									<th>STT</th>
									<th>Mã hàng hóa</th>
									<th>Tên hàng hóa</th>
									<th>Hạn sử dụng</th>
									<th>Tồn kho</th>
									<th class="text-center" width="60px">Sửa</th>
									<th class="text-center" width="60px">Xóa</th>
								</tr>
								<s:iterator value="goodsList" status="status">
									<tr>
										<td>
											<s:property value="#status.count" />
										</td>
										<td>
											<s:property value="code" />
										</td>
										<td>
											<s:property value="name" />
										</td>
										<td>
											<s:date name="expiration" format="dd/MM/yyyy" />
										</td>
										<td>
											<s:property value="inStock" />
										</td>
										<td width="60px">
											<s:url action="edit" var="editURL" namespace="/goods">
												<s:param name="id" value="id" />
												<s:param name="stockId" value="%{#parameters.stockId}" />
											</s:url>
											<s:a href="%{editURL}" cssClass="btn btn-sm btn-warning">Sửa</s:a>
										</td>
										<td width="60px">
											<s:url action="delete" var="deleteURL" namespace="/goods">
												<s:param name="id" value="id" />
												<s:param name="stockId" value="%{#parameters.stockId}" />
											</s:url>
											<s:a href="%{deleteURL}"
												cssClass="btn btn-sm btn-danger delete">Xóa</s:a>
										</td>
									</tr>
								</s:iterator>
							</table>
							<s:url action="export" namespace="/goods" var="exportURL">
								<s:param name="stockId" value="%{#parameters.stockId}" />
								<s:param name="find" value="%{#parameters.find}" />
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
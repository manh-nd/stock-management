<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../fragment/head.jsp" />
<title>Danh sách kho hàng</title>
</head>
<body>
	<jsp:include page="../fragment/navbar.jsp" />
	<div class="container pt-5 pb-5">
		<s:if
			test="%{#session.user.role == 'admin' || #session.user.role == 'Quản lý kho'}">
			<h3>Danh sách kho hàng</h3>
			<hr>

			<div class="row">
				<div class="col-xs-12 col-md-3">
					<s:a cssClass="btn btn-primary" href="add" name="/stock">Thêm kho mới</s:a>
				</div>
				<div class="col-xs-12 col-md-9">
					<form class="form-inline float-right my-lg-0">
						<input name="find" class="form-control mr-sm-2" type="search"
							placeholder="Tìm theo mã hoặc tên" aria-label="Tìm kiếm">
						<button class="btn btn-success my-2 my-sm-0" type="submit">Tìm
							kiếm</button>
					</form>
				</div>
			</div>

			<s:if test="stockList.size() > 0">
				<table class="table table-sm table-striped table-bordered mt-2">
					<thead>
						<tr>
							<th>STT</th>
							<th>Mã kho</th>
							<th>Tên kho</th>
							<th width="60px" class="text-center">Sửa</th>
							<th width="60px" class="text-center">Xóa</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="stockList" status="status">
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
								<td class="text-center">
									<s:url action="edit" var="editURL" namespace="/stock">
										<s:param name="id" value="id" />
									</s:url>
									<s:a href="%{editURL}" cssClass="btn btn-sm btn-warning">Sửa</s:a>
								</td>
								<td class="text-center">
									<s:url action="delete" var="deleteURL" namespace="/stock">
										<s:param name="id" value="id" />
									</s:url>
									<s:a href="%{deleteURL}"
										cssClass="btn btn-sm btn-danger delete">Xóa</s:a>
								</td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</s:if>
			<s:else>
				<h4 class="mt-3">Không có dữ liệu.</h4>
			</s:else>
		</s:if>
		<s:else>

			<h3>Bạn không có quyền truy cập</h3>
		</s:else>
	</div>
	<jsp:include page="../fragment/js.jsp" />
	<script>
		$(document).ready(function() {
			$(".delete").click(function(e) {
				var result = confirm("Bạn có muốn xóa kho này không?");
				if (result) {
					return true;
				}
				return false;
			});
		});
	</script>
</body>
</html>
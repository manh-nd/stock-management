<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../fragment/head.jsp" />
<title>Goods form</title>
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
		<s:form action="save" namespace="/goods">
			<s:hidden name="goodsBean.id" />
			<s:hidden name="stockBean.id" />
			<s:hidden name="inventoryBean.id" />
			<h3>
				<s:property value="stockBean.name" />
			</h3>
			<hr>

			<div class="form-row">
				<div class="form-group col-md-2">
					<label>Mã hàng hóa</label>
					<s:textfield name="goodsBean.code"
						cssClass="form-control form-control-sm" />
					<s:fielderror fieldName="goodsBean.code" />
				</div>
				<div class="form-group col-md-4">
					<label>Phân loại</label>
					<s:select name="goodsBean.category.id" list="categoryList"
						listKey="id" listValue="name" value="goodsBean.category.id"
						headerKey="" headerValue="Chọn phân loại"
						cssClass="form-control form-control-sm" />
					<s:fielderror fieldName="goodsBean.category.id" />
				</div>
				<div class="form-group col-md-3">
					<label>Hãng sản xuất</label>
					<s:select name="goodsBean.producer.id" list="producerList"
						listKey="id" listValue="name" value="goodsBean.producer.id"
						headerKey="" headerValue="Chọn hãng sản xuất"
						cssClass="form-control form-control-sm" />
					<s:fielderror fieldName="goodsBean.producer.id" />
				</div>
				<div class="form-group col-md-3">
					<label>Nhà cung cấp</label>
					<s:select name="goodsBean.supplier.id" list="supplierList"
						listKey="id" listValue="name" value="goodsBean.supplier.id"
						headerKey="" headerValue="Chọn nhà cung cấp"
						cssClass="form-control form-control-sm" />
					<s:fielderror fieldName="goodsBean.supplier.id" />
				</div>
			</div>

			<div class="form-row">
				<div class="form-group col-md-6">
					<label>Tên hàng hóa</label>
					<s:textfield name="goodsBean.name"
						cssClass="form-control form-control-sm" />
					<s:fielderror fieldName="goodsBean.name" />
				</div>
				<div class="form-group col-md-4">
					<label>Đặc tính</label>
					<s:textfield name="goodsBean.feature"
						cssClass="form-control form-control-sm" />
				</div>

				<div class="form-group col-md-2">
					<label>Đơn vị tính</label>
					<s:textfield name="goodsBean.unit"
						cssClass="form-control form-control-sm" />
					<s:fielderror fieldName="goodsBean.unit" />
				</div>

			</div>

			<div class="form-row">

				<div class="form-group col-md-2">
					<label>Hạn sử dụng</label>
					<s:textfield name="goodsBean.expiration"
						cssClass="form-control form-control-sm" />
				</div>

				<div class="form-group col-md-3">
					<label>Giá nhập</label>
					<s:textfield name="goodsBean.importPrice"
						cssClass="form-control form-control-sm" />
					<s:fielderror fieldName="goodsBean.importPrice" />
				</div>

				<div class="form-group col-md-3">
					<label>Giá bán</label>
					<s:textfield name="goodsBean.exportPrice"
						cssClass="form-control form-control-sm" />
					<s:fielderror fieldName="goodsBean.exportPrice" />
				</div>

			</div>

			<div class="form-row">
				<div class="form-group col-md-2">
					<label>Số lô</label>
					<s:textfield name="goodsBean.lotNumber"
						cssClass="form-control form-control-sm" />
				</div>
				<div class="form-group col-md-3">
					<label>Số lượng tồn kho</label>
					<s:textfield name="inventoryBean.quantity"
						cssClass="form-control form-control-sm" />
					<s:fielderror fieldName="inventoryBean.quantity" />
				</div>
			</div>

			<div class="form-group">
				<s:checkbox name="goodsBean.newBrand" id="newBrand" />
				<label for="newBrand">Nhãn hàng mới?</label>
			</div>

			<s:submit value="Lưu" cssClass="btn btn-primary" />

		</s:form>
	</div>
	<jsp:include page="../fragment/js.jsp" />
</body>
</html>
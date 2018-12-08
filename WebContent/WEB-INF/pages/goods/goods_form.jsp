<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../fragment/head.jsp" />
<title>Goods form</title>
<sx:head />
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

		<h3 id="stockName">
			<s:property value="stockBean.name" />
		</h3>
		<hr>

		<s:form action="save" namespace="/goods">
			<s:hidden id="goodsId" name="goodsBean.id" />
			<s:hidden id="stockId" name="stockBean.id" />
			<s:hidden id="inventoryId" name="inventoryBean.id" />

			<div style="color: red" id="goodsMessage"></div>

			<div class="form-row">
				<div class="form-group col-md-2">
					<label>Mã hàng hóa</label>
					<s:textfield id="goodsCodeField" name="goodsBean.code"
						cssClass="form-control form-control-sm" />
					<s:fielderror fieldName="goodsBean.code" />
				</div>
				<div class="form-group col-md-4">
					<label>Phân loại</label>
					<s:select id="categoryId" name="goodsBean.category.id"
						list="categoryList" listKey="id" listValue="name"
						value="goodsBean.category.id" headerKey=""
						headerValue="Chọn phân loại"
						cssClass="form-control form-control-sm" />
					<s:fielderror fieldName="goodsBean.category.id" />
				</div>
				<div class="form-group col-md-3">
					<label>Hãng sản xuất</label>
					<s:select id="producerId" name="goodsBean.producer.id"
						list="producerList" listKey="id" listValue="name"
						value="goodsBean.producer.id" headerKey=""
						headerValue="Chọn hãng sản xuất"
						cssClass="form-control form-control-sm" />
					<s:fielderror fieldName="goodsBean.producer.id" />
				</div>
				<div class="form-group col-md-3">
					<label>Nhà cung cấp</label>
					<s:select id="supplierId" name="goodsBean.supplier.id"
						list="supplierList" listKey="id" listValue="name"
						value="goodsBean.supplier.id" headerKey=""
						headerValue="Chọn nhà cung cấp"
						cssClass="form-control form-control-sm" />
					<s:fielderror fieldName="goodsBean.supplier.id" />
				</div>
			</div>

			<div class="form-row">
				<div class="form-group col-md-6">
					<label>Tên hàng hóa</label>
					<s:textfield id="goodsName" name="goodsBean.name"
						cssClass="form-control form-control-sm" />
					<s:fielderror fieldName="goodsBean.name" />
				</div>
				<div class="form-group col-md-4">
					<label>Đặc tính</label>
					<s:textfield id="goodsFeature" name="goodsBean.feature"
						cssClass="form-control form-control-sm" />
				</div>

				<div class="form-group col-md-2">
					<label>Đơn vị tính</label>
					<s:textfield id="goodsUnit" name="goodsBean.unit"
						cssClass="form-control form-control-sm" />
					<s:fielderror fieldName="goodsBean.unit" />
				</div>

			</div>

			<div class="form-row">

				<div class="form-group col-md-2">
					<label>Hạn sử dụng</label>
					<sx:datetimepicker id="goodsExpiration" name="goodsBean.expiration"
						displayFormat="dd/MM/yyyy" />
					<s:fielderror fieldName="goodsBean.expiration" />
				</div>

				<div class="form-group col-md-3">
					<label>Giá nhập</label>
					<s:textfield id="goodsImportPrice" name="goodsBean.importPrice"
						cssClass="form-control form-control-sm" />
					<s:fielderror fieldName="goodsBean.importPrice" />
				</div>

				<div class="form-group col-md-3">
					<label>Giá bán</label>
					<s:textfield id="goodsExportPrice" name="goodsBean.exportPrice"
						cssClass="form-control form-control-sm" />
					<s:fielderror fieldName="goodsBean.exportPrice" />
				</div>

			</div>

			<div class="form-row">
				<div class="form-group col-md-2">
					<label>Số lô</label>
					<s:textfield id="goodsLotNumber" name="goodsBean.lotNumber"
						cssClass="form-control form-control-sm" />
				</div>
				<div class="form-group col-md-3">
					<label>Số lượng tồn kho</label>
					<s:textfield id="inventoryQuantity" name="inventoryBean.quantity"
						cssClass="form-control form-control-sm" />
					<s:fielderror fieldName="inventoryBean.quantity" />
				</div>
			</div>

			<div class="form-group">
				<s:checkbox id="goodsNewBrand" name="goodsBean.newBrand" />
				<label for="goodsNewBrand">Nhãn hàng mới?</label>
			</div>

			<div class="form-group">
				<label>Trạng thái</label>
				<s:radio id="goodsActive" list="actives" name="goodsBean.active"
					value="defaultActiveValue" />
			</div>

			<s:submit value="Lưu" cssClass="btn btn-primary" />
			<button id="backBtn" type="button" class="btn btn-success">Quay
				lại</button>
		</s:form>
	</div>

	<jsp:include page="../fragment/js.jsp" />
	<script src="<s:url value="/js/goods.js"/>"></script>
</body>
</html>
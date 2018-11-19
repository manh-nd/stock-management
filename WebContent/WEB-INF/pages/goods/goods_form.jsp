<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container pt-5 pb-5">
	<s:form action="save" namespace="/goods">
		<s:hidden name="goodsBean.id" />

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
			</div>
			<div class="form-group col-md-3">
				<label>Nhà cung cấp</label>
				<s:select name="goodsBean.supplier.id" list="supplierList"
					listKey="id" listValue="name" value="goodsBean.supplier.id"
					headerKey="" headerValue="Chọn nhà cung cấp"
					cssClass="form-control form-control-sm" />
			</div>
		</div>

		<div class="form-row">
			<div class="form-group col-md-6">
				<label>Tên hàng hóa</label>
				<s:textfield name="goodsBean.name"
					cssClass="form-control form-control-sm" />
			</div>
			<div class="form-group col-md-4">
				<label>Đặc tính</label>
				<s:textfield name="goodsBean.feature"
					cssClass="form-control form-control-sm" />
			</div>
			<div class="form-group col-md-2">
				<label>Số lô</label>
				<s:textfield name="goodsBean.lotNumber"
					cssClass="form-control form-control-sm" />
			</div>
		</div>

		<div class="form-row">
			<div class="form-group col-md-2">
				<label>Hạn sử dụng</label>
				<s:textfield name="goodsBean.expiration"
					cssClass="form-control form-control-sm" />
			</div>

			<div class="form-group col-md-2">
				<label>Giá nhập</label>
				<s:textfield name="goodsBean.importPrice"
					cssClass="form-control form-control-sm" />
			</div>

			<div class="form-group col-md-2">
				<label>Giá bán</label>
				<s:textfield name="goodsBean.exportPrice"
					cssClass="form-control form-control-sm" />
			</div>

			<div class="form-group col-md-2">
				<label>Đơn vị tính</label>
				<s:textfield name="goodsBean.unit"
					cssClass="form-control form-control-sm" />
			</div>

			<div class="form-group col-md-4">
				<label>Số lượng tồn kho</label>
				<s:textfield cssClass="form-control form-control-sm" />
			</div>

		</div>

		<div class="form-group">
			<s:checkbox name="goodsBean.newBrand" id="newBrand" />
			<label for="newBrand">Nhãn hàng mới</label>
		</div>

		<s:submit value="Lưu" cssClass="btn btn-primary" />
	</s:form>
</div>

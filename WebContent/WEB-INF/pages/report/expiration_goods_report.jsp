<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="container pt-5 pb-5">
	<s:if
			test="%{#session.user.role == 'admin' }">
	<h3>Danh sách hàng hóa sẽ hết hạn trong vòng 30 ngày tới</h3>
	<br>
	<table class="table table-sm">
		<tr>
			<th>STT</th>
			<th>Mã hàng hóa</th>
			<th>Tên hàng hóa</th>
			<th>Chủng loại</th>
			<th>Nhà cung cấp</th>
			<th>Kho</th>
			<th>Hạn sử dụng</th>
			<th>Số lượng</th>
		</tr>
		<s:iterator value="expirationGoodsReport" status="status">
			<tr>
				<td><s:property value="#status.count" /></td>
				<td><s:property value="code" /></td>
				<td><s:property value="name" /></td>
				<td><s:property value="category" /></td>
				<td><s:property value="supplier" /></td>
				<td><s:property value="stock" /></td>
				<td><s:property value="expiration" /></td>
				<td><s:property
						value="getText('{0,number, #,##0}', {quantity == null ? 0 : quantity})" />
				</td>
			</tr>
		</s:iterator>
	</table>
	</s:if>
		<s:else>
	
		<h3>Bạn không có quyền truy cập</h3>
	</s:else>
	
</div>
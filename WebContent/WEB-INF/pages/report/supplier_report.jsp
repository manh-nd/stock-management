<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="container pt-5 pb-5">
	<s:if test="%{#session.user.role == 'admin'}">
		<h3 class="text-success mb-3">Thống kê số lượng và tổng giá trị
			hàng hóa theo nhà cung cấp</h3>
		<table class="table table-sm">
			<thead>
				<tr>
					<th>STT</th>
					<th>Chủng loại</th>
					<th>Số lượng</th>
					<th>Tổng giá trị</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="supplierGoodsReport" status="status">
					<tr>
						<td>
							<s:property value="#status.count" />
						</td>
						<td>
							<s:property value="name" />
						</td>
						<td>
							<s:property
								value="getText('{0,number, #,##0}',{quantity == null ? 0 : quantity})" />
						</td>
						<td>
							<s:property
								value="getText('{0,number, #,##0}', {totalValue == null ? 0 : totalValue})" />
						</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</s:if>
	<s:else>

		<h3>Bạn không có quyền truy cập</h3>
	</s:else>
</div>
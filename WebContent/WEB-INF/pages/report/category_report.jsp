<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="container pt-5 pb-5">
	<h1>Thống kê số lượng và tổng giá trị hàng hóa theo chủng loại</h1>
	<br>
	<table class="table table-sm">
		<tr>
			<th>STT</th>
			<th>Chủng loại</th>
			<th>Số lượng</th>
			<th>Tổng giá trị</th>
		</tr>
		<s:iterator value="categoryGoodsReport" status="status">
			<tr>
				<td>
					<s:property value="#status.count" />
				</td>
				<td>
					<s:property value="name" />
				</td>
				<td>
					<s:property value="quantity" default="0" />
				</td>
				<td>
					<s:property value="totalValue" default="0" />
				</td>
			</tr>
		</s:iterator>
	</table>
</div>
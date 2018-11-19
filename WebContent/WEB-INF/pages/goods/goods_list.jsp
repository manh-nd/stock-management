<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container pt-5 pb-5">
	<h1>Danh sách hàng hóa</h1>
	<s:a cssClass="btn btn-primary" href="add" name="/goods">Thêm mới hàng hóa</s:a>
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
				<td><s:property value="expiration" /></td>
				<td></td>
				<td><s:url action="edit" var="editURL" namespace="/goods">
						<s:param name="id" value="id" />
					</s:url> <a href="${editURL}">Sửa</a></td>
				<td><s:url action="delete" var="deleteURL" namespace="/goods">
						<s:param name="id" value="id" />
					</s:url> <a href="${deleteURL}">Xóa</a></td>
			</tr>
		</s:iterator>
	</table>
</div>
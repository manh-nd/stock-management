<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:form action="save" namespace="producer">
		<s:hidden name="producerBean.id" />
		<s:textfield name="producerBean.code" label="Mã nhà cung cấp" />
		<s:textfield name="producerBean.name" label="Tên nhà cung cấp" />
		<s:submit value="Manh lol`" />
	</s:form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="fragment/head.jsp" />
<title>${title}</title>
</head>
<body>
	<s:include value="fragment/navbar.jsp" />
	<s:include value="%{page}" />
	<s:include value="fragment/js.jsp" />
</body>
</html>
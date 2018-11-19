<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="fragment/head.jsp" />
<title>${title}</title>
</head>
<body>
	<jsp:include page="${page}" />
	<jsp:include page="fragment/js.jsp" />
</body>
</html>
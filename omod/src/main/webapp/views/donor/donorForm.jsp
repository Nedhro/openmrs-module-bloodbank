<!doctype html>
<%@ taglib prefix="context" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<context:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html lang="en">
<head>
		<meta name="viewport"
		      content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
		<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
		<link rel="stylesheet" href="${contextPath}/moduleResources/bloodbank/css/bootstrap.min.css"/>

		<script type="javascript" src="${contextPath}/moduleResources/bloodbank/js/bootstrap.min.js"></script>

		<script type="javascript" src="${contextPath}/moduleResources/bloodbank/js/jquery-3.6.0.min.js"></script>
		<title>Blood Donor</title>
</head>
<body>
<div class="container">
		<div class="text-center">
				<h2><spring:message code="bloodbank.title"/></h2>
		</div>
</div>

</body>
</html>

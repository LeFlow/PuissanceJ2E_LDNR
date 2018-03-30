<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>En attende d'une nouvelle partie</title>
		<%@ include file="head.jsp" %>
	</head>
	<body>
		<div class="loader"></div>
		
	    <c:if test="${ !empty sessionScope.pseudo}">
	        <p>${ sessionScope.pseudo }</p>
	    </c:if>
	</body>
</html>
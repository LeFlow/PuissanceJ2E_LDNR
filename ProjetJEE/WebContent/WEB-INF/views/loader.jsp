<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>En attende d'une nouvelle partie</title>
		<%@ include file="head.jsp" %>
		<link rel="stylesheet" type="text/css" href="css/loader.css"/>
	</head>
	<body>
	
	
	
		<div class="container">
		    <div class="row">
		        <div class="col-md-12">
		            <div class="loader">
		                <span></span>
		                <span></span>
		                <span></span>
		                <span></span>
		                <span></span>
		                <span></span>
		                <span></span>
		                <span></span>
		                <span></span>
		                <span></span>
		            </div>
		        </div>
		    </div>
		    <div class="row">
		    	<div class="col-md-12">
		    	    <c:if test="${ !empty sessionScope.pseudo}">
				        <h1>Bonjour ${ sessionScope.pseudo } !</h1>
				        <h3>En attente d'un adversaire</h3>
				    </c:if>
		    	</div>
		    </div>
		</div>






	</body>
</html>
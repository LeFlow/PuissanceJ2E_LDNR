<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Puissance 4</title>
		<%@ include file="head.jsp" %>
	</head>
	<body>
		<div class="container">
			<h1>Puissance 4</h1>
			<form action="loading" method="POST">
				<div class="row">
				  <div class="col-lg-6">
				    <div class="input-group">
				      <input name="pseudo" type="text" class="form-control" placeholder="Votre Pseudo">
				      <span class="input-group-btn">
				        <button id="btn-valid_pseudo" class="btn btn-default" type="submit">Valider</button>
				      </span>
				    </div><!-- /input-group -->
				  </div><!-- /.col-lg-6 -->
				</div><!-- /.row -->
			</form>
		</div>
	</body>
</html>
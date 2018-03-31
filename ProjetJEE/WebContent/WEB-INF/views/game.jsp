<%@ page language="java" contentType="text/html; charset=UTF-8" import="jee.DAO.pack.*" pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>
<%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="css/bootstrap.css">
	<link rel="stylesheet" href="css/jeu.css">
	<script src='js/jquery-3.3.1.min.js'></script>
	<script defer src="js/jeu.js"></script>
<title>jeu2</title>
</head>
<body>
	<h1>Bienvenue dans notre jeu Puissance LDNR</h1>
	<form id="topform" method="post" action="jeu2">
		<p id="info_partie">
		<input  name ="joueur" value="ldnr" id="joueurid"/>
		<input  name ="num_partie" value="partie1" id ="num_partieid"/>
		</p>		
		<div>			
		<button class="topbutton" type="submit" value="0" name="adressecase"><c:out value="${casecochees[0]}"/></button>
		<button class="topbutton" type="submit" value="1" name="adressecase"><c:out value="${casecochees[1]}"/></button>
		<button class="topbutton" type="submit" value="2" name="adressecase"><c:out value="${casecochees[2]}"/></button>
		<button class="topbutton" type="submit" value="3" name="adressecase"><c:out value="${casecochees[3]}"/></button>
		<button class="topbutton" type="submit" value="4" name="adressecase"><c:out value="${casecochees[4]}"/></button>
		</div>
		<div>
		<button class="topbutton" type="submit" value="5" name="adressecase"><c:out value="${casecochees[5]}"/></button>
		<button class="topbutton" type="submit" value="6" name="adressecase"><c:out value="${casecochees[6]}"/></button>
		<button class="topbutton" type="submit" value="7" name="adressecase"><c:out value="${casecochees[7]}"/></button>
		<button class="topbutton" type="submit" value="8" name="adressecase"><c:out value="${casecochees[8]}"/></button>
		<button class="topbutton" type="submit" value="9" name="adressecase"><c:out value="${casecochees[9]}"/></button>
		</div>
		<div>
		<button class="topbutton" type="submit" value="10" name="adressecase"><c:out value="${casecochees[10]}"/></button>
		<button class="topbutton" type="submit" value="11" name="adressecase"><c:out value="${casecochees[11]}"/></button>
		<button class="topbutton" type="submit" value="12" name="adressecase"><c:out value="${casecochees[12]}"/></button>
		<button class="topbutton" type="submit" value="13" name="adressecase"><c:out value="${casecochees[13]}"/></button>
		<button class="topbutton" type="submit" value="14" name="adressecase"><c:out value="${casecochees[14]}"/></button>
		</div>
		<div>
		<button class="topbutton" type="submit" value="15" name="adressecase"><c:out value="${casecochees[15]}"/></button>
		<button class="topbutton" type="submit" value="16" name="adressecase"><c:out value="${casecochees[16]}"/></button>
		<button class="topbutton" type="submit" value="17" name="adressecase"><c:out value="${casecochees[17]}"/></button>
		<button class="topbutton" type="submit" value="18" name="adressecase"><c:out value="${casecochees[18]}"/></button>
		<button class="topbutton" type="submit" value="19" name="adressecase"><c:out value="${casecochees[19]}"/></button>
		</div>
		<div>
		<button class="topbutton" type="submit" value="20" name="adressecase"><c:out value="${casecochees[20]}"/></button>
		<button class="topbutton" type="submit" value="21" name="adressecase"><c:out value="${casecochees[21]}"/></button>
		<button class="topbutton" type="submit" value="22" name="adressecase"><c:out value="${casecochees[22]}"/></button>
		<button class="topbutton" type="submit" value="23" name="adressecase"><c:out value="${casecochees[23]}"/></button>
		<button class="topbutton" type="submit" value="24" name="adressecase"><c:out value="${casecochees[24]}"/></button>
		</div>
	</form>
</body>
</html>
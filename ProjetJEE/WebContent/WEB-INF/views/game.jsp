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
<title>jeu</title>
</head>
<body>
	
	<h1>Bienvenue dans notre jeu Puissance LDNR</h1>
	<section id="formulaire">
		<form method="post" action="jeu">
			<table>
			<tr>
				<td><button class="topbutton" type="submit" value="x:1 y:1" name="adressecase" id="boutton1"></button></td>
				<td><button class="topbutton" type="submit" value="x:1 y:2" name="adressecase" id="boutton2"></button></td>
				<td><button class="topbutton" type="submit" value="x:1 y:3" name="adressecase" id="boutton3"></button></td>
				<td><button class="topbutton" type="submit" value="x:1 y:4" name="adressecase" id="boutton4"></button></td>
				<td><button class="topbutton" type="submit" value="x:1 y:5" name="adressecase" id="boutton5"></button></td>
			</tr>
			<tr>
				<td><button class="topbutton" type="submit" value="x:2 y:1" name="adressecase" id="boutton6"></button></td>
				<td><button class="topbutton" type="submit" value="x:2 y:2" name="adressecase" id="boutton7"></button></td>
				<td><button class="topbutton" type="submit" value="x:2 y:3" name="adressecase" id="boutton8"></button></td>
				<td><button class="topbutton" type="submit" value="x:2 y:4" name="adressecase" id="boutton9"></button></td>
				<td><button class="topbutton" type="submit" value="x:2 y:5" name="adressecase" id="boutton10"></button></td>
			</tr>
			<tr>
				<td><button class="topbutton" type="submit" value="x:3 y:1" name="adressecase" id="boutton11"></button></td>
				<td><button class="topbutton" type="submit" value="x:3 y:2" name="adressecase" id="boutton12"></button></td>
				<td><button class="topbutton" type="submit" value="x:3 y:3" name="adressecase" id="boutton13"></button></td>
				<td><button class="topbutton" type="submit" value="x:3 y:4" name="adressecase" id="boutton14"></button></td>
				<td><button class="topbutton" type="submit" value="x:3 y:5" name="adressecase" id="boutton15"></button></td>
			</tr>
			<tr>
				<td><button class="topbutton" type="submit" value="x:4 y:1" name="adressecase" id="boutton16"></button></td>
				<td><button class="topbutton" type="submit" value="x:4 y:2" name="adressecase" id="boutton17"></button></td>
				<td><button class="topbutton" type="submit" value="x:4 y:3" name="adressecase" id="boutton18"></button></td>
				<td><button class="topbutton" type="submit" value="x:4 y:4" name="adressecase" id="boutton19"></button></td>
				<td><button class="topbutton" type="submit" value="x:4 y:5" name="adressecase" id="boutton20"></button></td>
			</tr>
			<tr>
				<td><button class="topbutton" type="submit" value="x:5 y:1" name="adressecase" id="boutton20"></button></td>
				<td><button class="topbutton" type="submit" value="x:5 y:2" name="adressecase" id="boutton20"></button></td>
				<td><button class="topbutton" type="submit" value="x:5 y:3" name="adressecase" id="boutton20"></button></td>
				<td><button class="topbutton" type="submit" value="x:5 y:4" name="adressecase" id="boutton20"></button></td>
				<td><button class="topbutton" type="submit" value="x:5 y:5" name="adressecase" id="boutton20"></button></td>
			</tr>
			</table>
		</form>
	</section>
	
</body>
</html>
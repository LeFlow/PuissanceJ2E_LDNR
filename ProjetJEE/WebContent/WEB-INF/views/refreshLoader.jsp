<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <div id="text" class="row">
   	<div class="col-md-12">
   		<h1>Bonjour ${ sessionScope.pseudo } !</h1>
   	    <c:if test="${ sessionScope.pseudo != '' && oppenent==''}">
	        <h3>En attente d'un adversaire</h3>
	    </c:if>
	    <c:if test="${ !empty oppenent}">
	        <h3>Adversaire ${ oppenent } trouvé !</h3>
	    </c:if>
   	</div>
   </div>
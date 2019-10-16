
<%@page import="tp3.TPRI3"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
html {
	background-color: lightslategray;
}

.content {
	width: 500px;
	height: 600px;
	position: absolute; /*it can be fixed too*/
	left: 0;
	right: 0;
	top: 0;
	bottom: 0;
	margin: auto;
	/*this to solve "the content will not be cut when the window is smaller than the content": */
	max-width: 100%;
	max-height: 100%;
	overflow: auto;
	text-align: center;
}

textarea {
	background: Gainsboro;
}

h3 {
	text-align: left;
}
</style>
<meta charset="ISO-8859-1">
<title>RI TP3</title>
</head>

<body>
	<form>
		<div class="content">
			<label for="ta"></label>
			<h2>Chercher:</h2>			
			<textarea name="textareadata" id="ta" rows="5"
				style="margin: 0px; width: 494px; height: 363px;">${text} </textarea>
			<input type="submit" name="submit" value="Envoyer!" />

			<h3>RESULTATS :</h3>
			<ol>
				<c:forEach var="columnHeader" items="${columnHeaders}">
					<li><c:url value="${columnHeader}" /></li>
				</c:forEach>
			</ol>


		</div>
	</form>





</body>
</html>
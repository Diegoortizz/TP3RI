<%@page import="tp3.TPRI3"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link href="https://fonts.googleapis.com/css?family=Poppins"
	rel="stylesheet" />
<link href="css/main.css" rel="stylesheet" />
</head>
<body>
	<div class="s003">
		<form>
			<img src="./images/wikil.png" height="200" width="200">
			<div class="inner-form">
				<div class="input-field first-wrap">
					<div class="input-select">
						<select data-trigger="" name="choices-single-defaul">
							<option placeholder="">Choix de la langue</option>
							<option>Anglais (recommandé)</option>
							<option>Français</option>
						</select>
					</div>
				</div>
				<div class="input-field second-wrap">
					<input id="search" type="text" name="textareadata"
						placeholder="Entrer votre texte / paragraphe..." value="${text}" />
				</div>
				<div class="input-field third-wrap">
					<input class="btn-search" type="submit" name="submit" value="GO" />

				</div>
			</div>

		</form>

	</div>
	<div class="s003">
		<ol>
			<c:set var="count" value="0" scope="page" />
			<li><c:forEach var="columnHeader" items="${columnHeaders}">
					<li><p>
							<c:set var="count" value="${count + 1}" scope="page" />
							<img src="./images/wikil.png" width="25" height="25">
							<c:url value="${count}.) ${columnHeader}" /></li>
					</p>
				</c:forEach>
		</ol>

	</div>
	<script src="js/extention/choices.js"></script>
	<script>
		const choices = new Choices('[data-trigger]', {
			searchEnabled : false,
			itemSelectText : '',
		});
	</script>
</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>

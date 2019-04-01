<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Matière</title>
<link rel="stylesheet" type="text/css"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" />
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<!-- 	<nav class="navbar navbar-expand-sm bg-dark navbar-dark"> -->
	<!-- 		<ul class="navbar-nav"> -->
	<!-- 			<li class="nav-item active"><a class="nav-link" -->
	<!-- 				href="matiere.html">Matière</a></li> -->
	<!-- 			<li class="nav-item"><a class="nav-link" href="eleve.html">Eleve</a></li> -->
	<!-- 			<li class="nav-item"><a class="nav-link" href="formateur.html">Formateur</a></li> -->
	<!-- 		</ul> -->
	<!-- 	</nav> -->
	<div class="container">
		<div id="formateurEdit" class="card mt-5">
			<form>
				<div class="card-header">
					<h5>Edition du formateur</h5>
				</div>
				<div class="card-body">

					<div class="form-group">
						<label for="id">Identifiant:</label> <input type="number"
							class="form-control" id="id" name="id" value="${formateur.id}">
					</div>
					<div class="form-group">
						<label for="civilite">Civilité:</label> <select class="form-control" id="civilite" name="civilite">
							<option value="">------------</option>
							<c:forEach items="${civilites}" var="civ">
								<option value="${civ}" ${formateur.civilite == civ ? 'selected':''}>${civ.label}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="nom">Nom:</label> <input type="text"
							class="form-control" id="nom" name="nom" value="${formateur.nom}">
					</div>
					<div class="form-group">
						<label for="prenom">Prénom:</label> <input type="text"
							class="form-control" id="prenom" name="nom" value="${formateur.prenom}">
					</div>
					<div class="form-group">
						<label for="exp">Expérience:</label> <input type="number"
							class="form-control" id="exp" name="exp" value="${formateur.exp}">
					</div>
					<div class="form-group">
						<label for="rue">Rue:</label> <input type="text"
							class="form-control" id="rue" name="rue" value="${formateur.adr.rue}">
					</div>
					<div class="form-group">
						<label for="codePostal">Code postal:</label> <input type="text"
							class="form-control" id="codePostal" name="codePostal" value="${formateur.adr.codePostal}">
					</div>
					<div class="form-group">
						<label for="ville">Ville:</label> <input type="text"
							class="form-control" id="ville"  name="ville" value="${formateur.adr.ville}">
					</div>

				</div>
				<div class="card-footer text-right">
					<div class="btn-group ">
						<button class="btn btn-success" onclick="save();">
							<i class="far fa-check-square fa-2x"></i>
						</button>
						<button class="btn btn-warning text-white" onclick="cancel();">
							<i class="far fa-window-close fa-2x"></i>
						</button>
					</div>
				</div>
			</form>
		</div>
	</div>

</body>
</html>
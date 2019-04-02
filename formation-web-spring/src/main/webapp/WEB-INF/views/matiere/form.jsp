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
		<div id="matiereEdit" class="card mt-5">
			<form action="save" method="post">
				<input type="hidden" name="id" value="${maMatiere.id}">
				<input type="hidden" name="version" value="${maMatiere.version}">
				<div class="card-header">
					<h5>Edition de la matière</h5>
				</div>
				<div class="card-body">

					<div class="form-group">
						<label for="nom">Nom:</label> <input type="text"
							class="form-control" id="nom" name="nom" value="${maMatiere.nom}">
					</div>
					<div class="form-group">
						<label for="duree">Durée:</label> <input type="number"
							class="form-control" id="duree" name="duree"
							value="${maMatiere.duree}">
					</div>

				</div>
				<div class="card-footer text-right">
					<div class="btn-group ">
						<button type="submit" class="btn btn-success">
							<i class="far fa-check-square fa-2x"></i>
						</button>
						<a href="cancel" class="btn btn-warning text-white">
							<i class="far fa-window-close fa-2x"></i>
						</a>
					</div>
				</div>
			</form>
		</div>
	</div>

</body>
</html>
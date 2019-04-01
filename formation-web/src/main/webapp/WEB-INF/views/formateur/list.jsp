<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formateur</title>
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
		<div class="card" class="card mt-5">
			<div class="card-header bg-primary text-white">
				<h2>Liste des formateurs</h2>
			</div>
			<div class="card-body">
				<table id="formateurTab" class="table table-striped">
					<thead>
						<tr>
							<th>#</th>
							<th>Civilité</th>
							<th>Nom</th>
							<th>Prénom</th>
							<th>Expérience</th>
							<th>Rue</th>
							<th>Code postal</th>
							<th>Ville</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${formateurs}" var="formateur">
							<tr>
								<td>${formateur.id}</td>
								<td>${formateur.civilite.label}</td>
								<td>${formateur.nom}</td>
								<td>${formateur.prenom}</td>
								<td>${formateur.exp}</td>
								<td>${formateur.adr.rue}</td>
								<td>${formateur.adr.codePostal}</td>
								<td>${formateur.adr.ville}</td>
								<td><div class='btn-group'>
										<a href="formateur?page=edit&id=${formateur.id}"
											class='btn btn-primary'> <i class='fas fa-edit'></i>
										</a> <a href="formateur?page=remove&id=${formateur.id}"
											class='btn btn-danger'> <i class='far fa-trash-alt'></i>
										</a>
									</div></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="card-footer">
				<a href="formateur?page=add" class="btn btn-primary"> <i
					class="fas fa-plus-square fa-2x"></i>
				</a>
			</div>
		</div>
	</div>

</body>
</html>
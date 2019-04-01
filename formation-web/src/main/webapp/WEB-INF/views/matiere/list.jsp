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
		<div class="card" class="card mt-5">
			<div class="card-header bg-primary text-white">
				<h2>Liste des matières</h2>
			</div>
			<div class="card-body">
				<table id="matiereTab" class="table table-striped">
					<thead>
						<tr>
							<th>#</th>
							<th>Nom</th>
							<th>Durée</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${mesMatieres}" var="mat">
							<tr>
								<td>${mat.id}</td>
								<td>${mat.nom}</td>
								<td>${mat.duree}</td>
								<td><div class='btn-group'>
										<a href="matiere?page=edit&id=${mat.id}"
											class='btn btn-primary'> <i class='fas fa-edit'></i>
										</a> <a href="matiere?page=remove&id=${mat.id}"
											class='btn btn-danger'> <i class='far fa-trash-alt'></i>
										</a>
									</div></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="card-footer">
				<a href="matiere?page=add" class="btn btn-primary"> <i
					class="fas fa-plus-square fa-2x"></i>
				</a>
			</div>
		</div>
	</div>

</body>
</html>
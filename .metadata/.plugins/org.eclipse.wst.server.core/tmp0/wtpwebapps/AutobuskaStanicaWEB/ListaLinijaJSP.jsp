<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista linija</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<style>
body {
	/* 	background-image: */
	/* 		url("https://stil.kurir.rs/data/images/2017/06/30/20/120607_pica_ls.jpg"); */
	/* 	background-repeat: no-repeat; */
	background-color: grey;
	background-size: 100%;
}

.custab {
	border: 1px solid #ccc;
	padding: 5px;
	margin: 5% 0;
	box-shadow: 3px 3px 2px #ccc;
	transition: 0.5s;
	width: 100%;
}

.custab:hover {
	box-shadow: 3px 3px 0px transparent;
	transition: 0.5s;
}

.thead {
	background: white;
}

p.message {
	text-align: center;
	font-family: Ariel;
}

h3 {
	text-align: center;
	font: ariel;
	font-weight: bold;
	color: black;
}
</style>
</head>
<body>

	<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Logo</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/AutobuskaStanicaWEB/Main" method="get">HOME</a></li>
				<li><a href="/AutobuskaStanicaWEB/LoginSERVLET" method="get">LOGIN</a></li>
				<li><a href="/AutobuskaStanicaWEB/RegistrationSERVLET"
					method="get">SIGNUP</a></li>
				<li><a href="/AutobuskaStanicaWEB/Coment" method="get">COMENT</a></li>
				<li><a href="/AutobuskaStanicaWEB/Contact" method="get">CONTACT</a></li>

			</ul>
		</div>
	</div>
	</nav>

	<h3>Lista linija</h3>

	<p id="message">${message }</p>
	<div class="container">
		<div class="row col-md-12 custyle">
			<table class="table table-striped custab">
				<thead class="thead">
					<tr>
						<th>Id linije</th>
						<th>Naziv linije</th>
						<th>Opis linije</th>
						<th>Action</th>
						<th>Action</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach var="listaLinija" items="${listaLinija }">
						<tr>
							<td>${listaLinija.idLinija }</td>
							<td>${listaLinija.nazivLinije }</td>
							<td>${listaLinija.opisLinije }</td>
							<form action="/AutobuskaStanicaWEB/CreateRedVoznjeSERVLET"
								method="post">
								<td><input type="hidden" name="idLinija"
									value="${listaLinija.idLinija }" />
									<button class="btn btn-success active btn-md" id="slobodno"
										type="submit">RedVoznje</button></td>
							</form>
							<form action="/AutobuskaStanicaWEB/ListaRedVoznjeSERVLET"
								method="post">
								<td><input type="hidden" name="idLinija"
									value="${listaLinija.idLinija }" />
									<button class="btn btn-success active btn-md" id="slobodno"
										type="submit">RedVoznje</button></td>
							</form>

						</tr>
					</c:forEach>
				</tbody>
			</table>


		</div>
	</div>

</body>
</html>
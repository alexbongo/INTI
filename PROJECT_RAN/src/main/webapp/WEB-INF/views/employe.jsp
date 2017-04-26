<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Gestion des employés</title>

<!-- Bootstrap Core CSS -->
<link
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link
	href="<%=request.getContextPath()%>/resources/css/landing-page.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/css/employe.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="<%=request.getContextPath()%>/resources/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-default navbar-fixed-top topnav"
		role="navigation">
		<div class="container topnav">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand topnav" href="<%=request.getContextPath()%>/">Gestionnaire de
					banque RAN</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="<%=request.getContextPath()%>/groupe">Groupes</a></li>
					<li class="dropdown"><a href="#employe"
						class="dropdown-toggle" data-toggle="dropdown" role="button"
						aria-haspopup="true" aria-expanded="false">RH<span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#section1">Ajouter</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#section2">Chercher</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#section3">Afficher tous</a></li>
						</ul></li>
					<li><a href="<%=request.getContextPath()%>/Client">Clients</a></li>
					<li><a href="<%=request.getContextPath()%>/Compte">Comptes</a></li>
					<li><a href="<%=request.getContextPath()%>/op_ran">Opérations</a></li>
					<li class="dropdown"><a href="#banques" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Banques<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#banques">GARIP Limited Bank</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#banques">BONGO Limited Bank</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#banques">ALSAFADI Limited Bank</a></li>
						</ul></li>
					<li class="dropdown"><a href="#employe" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Accès<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="<%=request.getContextPath()%>/ac_admin">Administrateur</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="<%=request.getContextPath()%>/ac_employe">Employé</a></li>
						</ul></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>


	<!-- Header -->
	<a name="about"></a>
	<div class="intro-header">
		<div class="container">

			<div class="row">
				<div class="col-lg-12">
					<div class="intro-message">
						<h1>Gestion des employés</h1>
						<h3>Choisissez une option ci-dessous</h3>
						<hr class="intro-divider">
						<ul class="list-inline  intro-social-buttons">
							<li><a href="#section1" class="btn btn-default btn-lg">
									<span class="network-name">Ajouter</span>
							</a></li>
							<li><a href="#section2" class="btn btn-default btn-lg">
									<span class="network-name">Chercher</span>
							</a></li>
							<li><a href="#section3" class="btn btn-default btn-lg">
									<span class="network-name">Afficher tous</span>
							</a></li>
						</ul>
					</div>
				</div>
			</div>

		</div>
		<!-- /.container -->

	</div>
	<!-- /.intro-header -->

	<!-- Page Content -->

	<a name="services"></a>
	<div class="content-section-a" id="section1">

		<div class="container">
			<div class="row">
				<div class="col-lg-5 col-sm-6">

					<h4>Enregistrer un nouvel employé</h4>
					<hr class="section-heading-spacer">
					<div class="clearfix"></div>
					<form action="addemploye" method="post">
						<table>
							<tr>
								<td><p class="objet">Nom de l'employé</p></td>
								<td class="objet">Banque</td>
							</tr>
							<tr>
								<td><input class="objet" type="text" name="nomEmploye" placeholder="nom"
									required></td>

								<td><select class="objet" name="choixbanque" required>
										<option disabled selected></option>
										<c:forEach items="${listeBanque}" var="b">
											<option value="${b.idBanque}">${b.nomBanque}</option>
										</c:forEach>
								</select></td>
								<td><input class="objet" type="submit" value="Ajouter"></td>
							</tr>
						</table>
					</form>
				</div>
				<div class="col-lg-5 col-lg-offset-2 col-sm-6">
					<img class="img-responsive"
						src="<%=request.getContextPath()%>/resources/img/employeeById.jpg" alt="">
				</div>
			</div>

		</div>
		<!-- /.container -->

	</div>
	<!-- /.content-section-a -->

	<div class="content-section-b" id="section2">

		<div class="container">

			<div class="row">
				<div>
					<h4>Rechercher des informations sur un employé</h4>
					<hr class="section-heading-spacer">
					<div class="clearfix"></div>
					<h2 class="section-heading"></h2>

					<form action="getemployebyid" method="post">
						<table class="patate">
							<tr>
								<td><p class="objet">Identifiant de l'employé</p></td>

								<td><select class="objet" name="idEmploye" required>
										<option disabled selected></option>
										<c:forEach items="${listeEmploye}" var="emp">
											<option value="${emp.idEmploye}">${emp.idEmploye}--
												${emp.nomEmploye}</option>
										</c:forEach>
								</select></td>
								<td><input class="objet" type="submit" value="Chercher"></td>
							</tr>

							
						</table>
					</form>
					<br><br>
                   <table class="table">
                   <thead class=thead-inverse>
                       <tr>
								<th>Identifiant</th>
								<th>Nom</th>
								<th>Banque</th>
								<th>Comptes crées</th>
								<th>Nombre d'opérations réalisées :</th>
								<th>Groupes</th>
							</tr>
					</thead>
							<tr>
								<td>${employeById.idEmploye}</td>
								<td>${employeById.nomEmploye}</td>
								<td>${employeById.banque.nomBanque}</td>
								<td><c:forEach items="${comptes}" var="cpte">
										${cpte.idCompte} ,
										
									</c:forEach></td>
								<td>${employeById.listeOperation.size()}</td>
								<%-- <td><c:forEach items="${employeById.listeGroupes}" var="groupe">
										<p>${groupe.nomGroupes}</p>
									</c:forEach></td> --%>
									<td><c:forEach items="${groupesdelemploye}" var="groupe">
										<p>${groupe.nomGroupes}</p>
									</c:forEach></td>
							</tr>
                   </table>
				</div>
				<div class="col-lg-5 col-sm-pull-8  col-sm-8">
					<%-- <img class="img-responsive"
						src="<%=request.getContextPath()%>/resources/img/dog.png" alt=""> --%>
				</div>
			</div>

		</div>
		<!-- /.container -->

	</div>
	<!-- /.content-section-b -->

	<div class="content-section-a" id="section3">

		<div class="container">

			<div class="row">
				<div class="col-lg-12 col-sm-6" >
					<h4 >Afficher tous les employés par banque</h4>
					<hr class="section-heading-spacer">
					<div class="clearfix"></div>
					<form action="getallemploye" method="post">
						<select class="objet" name="choixbanque" required>
							<option disabled selected></option>
							<c:forEach items="${listeBanque}" var="b">
								<option value="${b.idBanque}">${b.nomBanque}</option>
							</c:forEach>
						</select> 
						<input class="objet" type="submit" value="Voir" >
					</form>
					<table class="table">
						<tr>
							<td>Identifiant</td>
							<td>Nom</td>
							<td>Banque</td>
							<td>Nombre de comptes</td>
							<td>Nombre d'opérations réalisées</td>
							<td>Groupes</td>
						</tr>
						<c:forEach items="${allemploye}" var="emp">
							<tr>
								<td>${emp.idEmploye}</td>
								<td>${emp.nomEmploye}</td>
								<td>${emp.banque.nomBanque}</td>
								<td>${emp.listeCompte.size()}</td>
								<td>${emp.listeOperation.size()}</td>
								<td><c:forEach items="${emp.listeGroupes}" var="groupe">
										<p>${groupe.nomGroupes}</p>
									</c:forEach></td>
							</tr>
						</c:forEach>
					</table>


				</div>
			<%-- 	<div class="col-lg-4 col-lg-offset-1 col-sm-4">
					<img class="img-responsive"
						src="<%=request.getContextPath()%>/resources/img/employees.jpg"
						alt="">
				</div> --%>
			</div>

		</div>
		<!-- /.container -->

	</div>
	<!-- /.content-section-a -->

	<a name="contact"></a>
	<div class="banner">

		<div class="container">

			<div class="row">
				<div class="col-lg-6">
					<h2>Que souhaitez-vous faire?</h2>
				</div>
				<div class="col-lg-6">

					<ul class="list-inline  intro-social-buttons">
						<li><a href="#section1" class="btn btn-default btn-lg"> <span
								class="network-name">Ajouter</span>
						</a></li>
						<li><a href="#section2" class="btn btn-default btn-lg"> <span
								class="network-name">Chercher</span>
						</a></li>
						<li><a href="#section3" class="btn btn-default btn-lg"> <span
								class="network-name">Afficher tous</span>
						</a></li>
					</ul>
				</div>
			</div>

		</div>
		<!-- /.container -->

	</div>
	<!-- /.banner -->

	<!-- Footer -->
	<footer>
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<ul class="list-inline">
						<li><a href="<%=request.getContextPath()%>/">Home</a></li>
						<li class="footer-menu-divider">&sdot;</li>
						<li><a href="<%=request.getContextPath()%>/groupe">Groupes</a></li>
						<li class="footer-menu-divider">&sdot;</li>
						<li><a href="<%=request.getContextPath()%>/employe">RH</a></li>
						<li class="footer-menu-divider">&sdot;</li>
						<li><a href="<%=request.getContextPath()%>/Client">Clients</a></li>
						<li class="footer-menu-divider">&sdot;</li>
						<li><a href="<%=request.getContextPath()%>/Compte">Comptes</a></li>
						<li class="footer-menu-divider">&sdot;</li>
						<li><a href="<%=request.getContextPath()%>/">Banques</a></li>
						<li class="footer-menu-divider">&sdot;</li>
						<li><a href="<%=request.getContextPath()%>/">Accès</a></li>
					</ul>
					<p class="copyright text-muted small">Copyright &copy; RAN 2017. All Rights Reserved</p>
				</div>
			</div>
		</div>
	</footer>

	<!-- jQuery -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>

</body>

</html>


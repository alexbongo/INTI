<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Gestionnaire RAN</title>

<!-- Bootstrap Core CSS -->
<link
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link
	href="<%=request.getContextPath()%>/resources/css/landing-page.css"
	rel="stylesheet">

<!-- Imagelink CSS -->
<link href="<%=request.getContextPath()%>/resources/css/imagelink.css"
	rel="stylesheet">


<!-- Custom Fonts -->
<link
	href="<%=request.getContextPath()%>/resources/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic"
	rel="stylesheet" type="text/css">

<!--<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css ">

<script
			  src="https://code.jquery.com/jquery-3.1.1.min.js"
			  integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
			  crossorigin="anonymous"></script>
	<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 -->
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
					<li><a href="<%=request.getContextPath()%>/employe">RH</a></li>
					<li><a href="<%=request.getContextPath()%>/Client">Clients</a></li>
					<li class="dropdown"><a href="#employe" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Compte<span class="caret"></span></a>
						<ul class="dropdown-menu">
						
							<li><a href="#about">Ajouter Compte</a></li>
							<li role="separator" class="divider"></li>
					<li><a href="#services">supprimer Compte</a></li>
					<li role="separator" class="divider"></li>
					<li><a href="#contact">Modifier Compte</a></li>
					<li role="separator" class="divider"></li>
					<li><a href="#Recuperer">Récupérer Compte</a></li>
				
						</ul></li>
					<li><a href="<%=request.getContextPath()%>/op_ran">Opérations</a></li>
					<li><a href="<%=request.getContextPath()%>/">Banques</a></li>
					
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
	
	</nav>



	<!-- Header -->
	<a name="Accueille"></a>
	<div class="intro-header">
		<div class="container">

			<br> <br>
			<div class="row">
				<form action="employerCompte" method="post">

					<div>

						<select class="form-control" name="validEmploye" id="choix" required="required">
							<option disabled selected>EmployeCompte</option>
							<c:forEach items="${listEmployeCompte}" var="ette">
								<option value="${ette.nomEmploye}">${ette.nomEmploye}</option>
							</c:forEach>
						</select> <br> <br>
						<button type="submit" class="btn btn-default">Valider</button>

					</div>
				</form>
				<div class="col-lg-12">
					<div class="intro-message">
						<h1>Gestion Des Comptes</h1>
						<h3></h3>
						<hr class="intro-divider">



					</div>


				</div>
			</div>

		</div>
		<!-- /.container -->

	</div>
	<!-- /.intro-header -->

	<!-- Page Content -->


	<form action="ajouterCompteCourant" method="post">
		<a name="about"></a>
		<div class="content-section-a">

			<div class="container">
				<div class="row">
					<div class="col-lg-5 col-sm-6">
						<hr class="section-heading-spacer">
						<div class="clearfix">
						
						
						</div>
						<h2 class="section-heading">
							Ajouter Des Comptes Courant<br>
						</h2>
						<div class="form-group">
						
						<select class="form-control" name="nomClient" id="choix" required="required">
							<option disabled selected>Nom Client</option>
							<c:forEach items="${listClientCompte}" var="xxv">
								<option value="${xxv.nomClient}">${xxv.nomClient}</option>
							</c:forEach>
						</select>
							<input type="text" class="form-control" placeholder="soldeCompte"
								name="soldeCompte" required="required">
							 <input type="text" class="form-control" placeholder="decouvert" name=decouvert required="required">
							 
							<%-- <select class="form-control"
								name="choixEmploye" id="choix">
								<option disabled selected>Employe</option>
								<c:forEach items="${listEmploye}" var="xx">
									<option value="${xx.nomEmploye}">${xx.nomEmploye}</option>
								</c:forEach>
							</select> --%>
							<br>
							<button type="submit" class="btn btn-default">Ajouter
								Compte Courant</button>
						</div>
					</div>
					<div class="col-lg-5 col-lg-offset-2 col-sm-6">
						<img class="img-responsive"
							src="<%=request.getContextPath()%>/resources/img/ipad.png" alt="">
					</div>
				</div>

			</div>
			<!-- /.container -->

		</div>

	</form>
	
	<!-- hesqsq -->
	<a name="about"></a>
	<form action="ajouterCompteEpargne" method="post">
		
		<div class="content-section-b">

			<div class="container">
				<div class="row">
					<div class="col-lg-5 col-sm-6">
						<hr class="section-heading-spacer">
						<div class="clearfix">
						
						
						</div>
						<h2 class="section-heading">
							Ajouter Des Comptes Epargne<br>
						</h2>
						<div class="form-group">
						
						<select class="form-control" name="nomClientEpargne" id="choix" required="required">
							<option disabled selected>Nom Client</option>
							<c:forEach items="${listClientCompte}" var="xxv">
								<option value="${xxv.nomClient}">${xxv.nomClient}</option>
							</c:forEach>
						</select>
							<input type="text" class="form-control" placeholder="soldeCompte"
								name="soldeCompteEpargne" required="required">
							 <input type="text" class="form-control" placeholder="tauxInteret" name=tauxInteret required="required">
							<%-- <select class="form-control"
								name="choixEmploye" id="choix">
								<option disabled selected>Employe</option>
								<c:forEach items="${listEmploye}" var="xx">
									<option value="${xx.nomEmploye}">${xx.nomEmploye}</option>
								</c:forEach>
							</select> --%>
							<br>
							<button type="submit" class="btn btn-default">Ajouter
								Compte Epargne</button>
						</div>
					</div>
					<div class="col-lg-5 col-lg-offset-2 col-sm-6">
						<img class="img-responsive"
							src="<%=request.getContextPath()%>/resources/img/ipad.png" alt="">
					</div>
				</div>

			</div>
			<!-- /.container -->

		</div>

	</form>
	

	<!-- /.content-section-a -->

	<a name="services"></a>
	<div class="content-section-a">

		<div class="container">

			<div class="row">
				<div class="col-lg-5 col-lg-offset-1 col-sm-push-6  col-sm-6">
					<hr class="section-heading-spacer">
					<div class="clearfix"></div>
					<h2 class="section-heading">
						Supprimer Un Compte<br>
					</h2>
					<br>

					<form action="SupprimerCompte" method="post">
						<div class="form-group">
							<select class="form-control" name="SuprumerCompte"
								id="choixSuprumer" required="required">
								<option disabled selected>ID Compte</option>
								<c:forEach items="${listCompte}" var="et">
									<option value="${et.idCompte}">${et.idCompte}</option>
								</c:forEach>
							</select>

							<button type="submit" class="btn btn-default">Supprimer
								Compte</button>
						</div>
					</form>


				</div>
				<div class="col-lg-5 col-sm-pull-6  col-sm-6">
				
				<img class="img-circle img-responsive img-center" src="<%=request.getContextPath() %>/resources/img/delet.jpg" alt="">
				</div>
			</div>

		</div>
		<!-- /.container -->

	</div>
	<!-- /.content-section-b -->


	<a name="contact"></a>
	<div class="content-section-b">

		<div class="container">

			<div class="row">
				<div class="col-lg-5 col-sm-6">
					
					
					<div class="clearfix"></div>
					<h2 class="section-heading">
						Afficher Les Comptes Courant
					</h2>
					
					<form action="afficherCompteCourant" method="post">
					<div class="form-group">
						<select class="form-control" name="AfficherdCourant"
							id="choixSuprumer" required="required">
							<option disabled selected>Id Compte</option>
							<c:forEach items="${listCompteCourant}" var="et">
								<option value="${et.idCompte}">${et.idCompte}</option>
							</c:forEach>
						</select>
						 <input type="text" class="form-control" placeholder="Sold" name="soldUpdateA" value="${sold}">
						<input type="text" class="form-control" placeholder="Decouvert" name="PreUpdateA" value="${decouvert}">
						
						<button type="submit" class="btn btn-default">AfficherCompteCourant</button>
					</div>
					</form>
					
				</div>
				<div class="col-lg-5 col-lg-offset-2 col-sm-6">
				<h2 class="section-heading">
						Modifier les Comptes Courant
					</h2>
					<form action="updateCompteCourant" method="post">
					<div class="form-group">
						<select class="form-control" name="updatecompteid"
							id="choixSuprumer" required="required">
							<option disabled selected>Id Compte</option>
							<c:forEach items="${listCompteCourant}" var="et">
								<option value="${et.idCompte}">${et.idCompte}</option>
							</c:forEach>
						</select>
						 <input type="text" class="form-control" placeholder="Sold" name="soldUpdate" required="required">
						<input type="text" class="form-control" placeholder="Decouvert" name="decouvertUpdate" required="required">
						<button type="submit" class="btn btn-default">UpdateClient</button>
					</div>
					</form>

				</div>
			</div>

		</div>
		<!-- /.container -->

	</div>
	<!-- /.content-section-a -->


<!-- hell -->

<a name="contact"></a>
	<div class="content-section-a">

		<div class="container">

			<div class="row">
				<div class="col-lg-5 col-sm-6">
					
					
					<div class="clearfix"></div>
					<h2 class="section-heading">
						Afficher Les Comptes Epargne
					</h2>
					
					<form action="afficherCompteEpargne" method="post">
					<div class="form-group">
						<select class="form-control" name="AfficherEpargneid"
							id="choixSuprumer" required="required">
							<option disabled selected>Id Compte</option>
							<c:forEach items="${listCompteEpargne}" var="et">
								<option value="${et.idCompte}">${et.idCompte}</option>
							</c:forEach>
						</select>
						 <input type="text" class="form-control" placeholder="Sold" name="soldUpdateA" value="${soldEpargne}">
						<input type="text" class="form-control" placeholder="TauxInteret" name="PreUpdateA" value="${TauxInteret}">
						
						<button type="submit" class="btn btn-default">AfficherCompteEpargne</button>
					</div>
					</form>
					
				</div>
				<div class="col-lg-5 col-lg-offset-2 col-sm-6">
				<h2 class="section-heading">
						Modifier les Comptes Epargne
					</h2>
					<form action="updateCompteEpargne" method="post">
					<div class="form-group">
						<select class="form-control" name="updateEpargnexid"
							id="choixSuprumer" required="required">
							<option disabled selected>Id Compte</option>
							<c:forEach items="${listCompteEpargne}" var="et">
								<option value="${et.idCompte}">${et.idCompte}</option>
							</c:forEach>
						</select>
						 <input type="text" class="form-control" placeholder="sold" name="soldEpargneUpdate" required="required">
						<input type="text" class="form-control" placeholder=TauxInteret name="TauxInteretUpdate" required="required">
						<button type="submit" class="btn btn-default">UpdateClient</button>
					</div>
					</form>

				</div>
			</div>

		</div>
		<!-- /.container -->

	</div>
	<a name="Recuperer"></a>
	<div class="content-section-b">

		<div class="container">

			<div class="row">
				<div class="col-lg-5 col-lg-offset-1 col-sm-push-6  col-sm-6">
					<hr class="section-heading-spacer">
					<div class="clearfix">
					
					</div>
					<h2 class="section-heading">
						Afficher tous les comptes courant<br>
					</h2>
					<form action="chercherCompte" method="post">
					
					<div class="form-group">
						
					</div>
					<button type="submit" class="btn btn-default">Afficher</button>
					</form>
					
				</div>
				<div class="col-lg-5 col-sm-pull-6  col-sm-6">
					<%-- <img class="img-responsive"
						src="<%=request.getContextPath()%>/resources/img/dog.png" alt=""> --%>

					<table class=table>
					<tr>
					<th>SoldeCompte</th>
					<th>Decouvert</th>
					</tr>
					
					<c:forEach items="${ListCompteByBanque}" var="lcbb">
								
								<tr>
								<td>${lcbb.soldeCompte}</td>
								<td>${lcbb.decouvert}</td>
									</tr>
							</c:forEach>
				
					</table>
				
					
					
					
				</div>
			</div>

		</div>
		<!-- /.container -->

	</div>
	
	
		<a name="Recuperer"></a>
	<div class="content-section-a">

		<div class="container">

			<div class="row">
				<div class="col-lg-5 col-lg-offset-1 col-sm-push-6  col-sm-6">
					<hr class="section-heading-spacer">
					<div class="clearfix">
					
					</div>
					<h2 class="section-heading">
						Afficher tous les comptes Epargne<br>
					</h2>
					<form action="chercherCompteEpargne" method="post">
					
					<div class="form-group">
						
					</div>
					<button type="submit" class="btn btn-default">Afficher</button>
					</form>
					
				</div>
				<div class="col-lg-5 col-sm-pull-6  col-sm-6">
					<%-- <img class="img-responsive"
						src="<%=request.getContextPath()%>/resources/img/dog.png" alt=""> --%>

					<table class=table>
					<tr>
					<th>Solde Compte</th>
					<th>taux Interet</th>
					</tr>
					
					<c:forEach items="${ListCompteByBanqueEpargne}" var="lcbbE">
								
								<tr>
								<td>${lcbbE.soldeCompte}</td>
								<td>${lcbbE.tauxInteret}</td>
									</tr>
							</c:forEach>
				
					</table>
				
					
					
					
				</div>
			</div>

		</div>
		<!-- /.container -->

	</div>
	<!-- 	<div class="banner">

		<div class="Recuperer"">

			<div class="col">
				<div class="col-lg-6">
					<h2>Chercher Des Clients:</h2>
				</div>
				<div class="col-lg-6">
					<div class="list-group">
						<a href="#" class="list-group-item list-group-item-action">Chercher des clients par mots clé</a> 
							<a href="#"
							class="list-group-item list-group-item-action">Afficher les clients par Banque</a>
							 <a href="#" class="list-group-item list-group-item-action">Chercher un client par identifiant</a>
							
					</div>

				</div>
			</div>

		</div>
		/.container

	</div> -->
	<div class="banner">

		<div class="container">

			<div class="row">
				<div class="col-lg-6">
					<h2>Contactez nous sur les reseaux sociaux:</h2>
				</div>
				<div class="col-lg-6">
					<ul class="list-inline banner-social-buttons">
						<li><a href="https://twitter.com/SBootstrap"
							class="btn btn-default btn-lg"><i class="fa fa-twitter fa-fw"></i>
								<span class="network-name">Twitter</span></a></li>
						<li><a
							href="https://github.com/IronSummitMedia/startbootstrap"
							class="btn btn-default btn-lg"><i class="fa fa-github fa-fw"></i>
								<span class="network-name">Github</span></a></li>
						<li><a href="#" class="btn btn-default btn-lg"><i
								class="fa fa-linkedin fa-fw"></i> <span class="network-name">Linkedin</span></a>
						</li>
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


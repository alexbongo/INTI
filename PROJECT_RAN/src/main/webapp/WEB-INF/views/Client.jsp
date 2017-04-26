<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
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
					<li class="dropdown"><a href="#employe" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Client<span class="caret"></span></a>
						<ul class="dropdown-menu">
						
							<li><a href="#about">Ajouter Client</a></li>
							<li role="separator" class="divider"></li>
					<li><a href="#services">Supprimer Client</a></li>
					<li role="separator" class="divider"></li>
					<li><a href="#contact">Modifier Client</a></li>
					<li role="separator" class="divider"></li>
					<li><a href="#Recuperer">Récupérer Client</a></li>
				
						</ul></li>
					<li><a href="<%=request.getContextPath()%>/Compte">Comptes</a></li>
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
				<form action="employer" method="post">

					<div>

						<select class="form-control" name="validEmploye" id="choix" required="required">
							<option disabled selected>Employe</option>
							<c:forEach items="${listEmploye}" var="xx">
								<option value="${xx.nomEmploye}">${xx.nomEmploye}</option>
							</c:forEach>
						</select> <br> <br>
						<button type="submit" class="btn btn-default">Valider</button>

					</div>
				</form>
				<div class="col-lg-12">
					<div class="intro-message">
						<h1>Gestion Des Client</h1>
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


	<form action="ajouterClient" method="post">
		<a name="about"></a>
		<div class="content-section-a">

			<div class="container">
				<div class="row">
					<div class="col-lg-5 col-sm-6">
						<hr class="section-heading-spacer">
						<div class="clearfix">
						
						
						</div>
						<h2 class="section-heading">
							Ajouter Des Clients<br>
						</h2>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Nom"
								name="clientNom" required="required"> <input type="text"
								class="form-control" placeholder="Preom" name="clientPrenom" required="required">
							<input type="date"  class="form-control"
								placeholder="Date de Naissance" name="clientDdn"> <input
								type="text" class="form-control" placeholder="Code Postal"
								name="clientCB" required="required">
							<%-- <select class="form-control"
								name="choixEmploye" id="choix">
								<option disabled selected>Employe</option>
								<c:forEach items="${listEmploye}" var="xx">
									<option value="${xx.nomEmploye}">${xx.nomEmploye}</option>
								</c:forEach>
							</select> --%>
							<br>
							<button type="submit" class="btn btn-default">Ajouter
								client</button>
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
	<div class="content-section-b">

		<div class="container">

			<div class="row">
				<div class="col-lg-5 col-lg-offset-1 col-sm-push-6  col-sm-6">
					<hr class="section-heading-spacer">
					<div class="clearfix"></div>
					<h2 class="section-heading">
						Supprimer Des Clients<br>
					</h2>
					<br>
					<form action="SupprimerClient" method="post">
						<div class="form-group">
							<select class="form-control" name="Suprumerchoix"
								id="choixSuprumer" required="required">
								<option disabled selected>Nom Client</option>
								<c:forEach items="${listClient}" var="et">
									<option value="${et.nomClient}">${et.nomClient}</option>
								</c:forEach>
							</select>
                            <br>
							<button type="submit" class="btn btn-default">Supprimer
								Client</button>
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
	<div class="content-section-a">

		<div class="container">

			<div class="row">
				<div class="col-lg-5 col-sm-6">
					
					
					<div class="clearfix"></div>
					<h2 class="section-heading">
						Afficher Les Clients
					</h2>
					
					<form action="afficher" method="post">
					<div class="form-group">
						<select class="form-control" name="updatechoixid"
							id="choixSuprumer" required="required">
							<option disabled selected>Nom Client</option>
							<c:forEach items="${listClient}" var="et">
								<option value="${et.idClient}">${et.nomClient} ${et.prenomClient}</option>
							</c:forEach>
						</select>
						 <input type="text" class="form-control" placeholder="Nom" name="nomUpdateA" value="${nombefor}">
						<input type="text" class="form-control" placeholder="Preom" name="PreUpdateA" value="${prenombefor}">
						<input type="text" name="anniversaire" class="form-control" placeholder="Date de Naissance" name="ddnUpdateA" value="${datebefor}" >
							 <input type="text" class="form-control" placeholder="Code Postal" name="CpUpdateA" value="${cpbefor}"> <br>
						<button type="submit" class="btn btn-default">AfficherClient</button>
					</div>
					</form>
					
				</div>
				<div class="col-lg-5 col-lg-offset-2 col-sm-6">
				<h2 class="section-heading">
						Modifier Des Clients
					</h2>
					<form action="updateClient" method="post">
					<div class="form-group">
						<select class="form-control" name="updatechoixid"
							id="choixSuprumer" required="required">
							<option disabled selected>Id Client</option>
							<c:forEach items="${listClient}" var="et">
								<option value="${et.idClient}">${et.idClient}</option>
							</c:forEach>
						</select>
						 <input type="text" class="form-control" placeholder="Nom" name="nomUpdate" required="required">
						<input type="text" class="form-control" placeholder="Preom" name="PreUpdate" required="required">
						<input type="date"  class="form-control" placeholder="Date de Naissance" name="ddnUpdate" required="required" >
							 <input type="text" class="form-control" placeholder="Code Postal" name="CpUpdate" required="required" > <br>
						<button type="submit" class="btn btn-default">UpdateClient</button>
					</div>
					</form>

				</div>
			</div>

		</div>
		<!-- /.container -->

	</div>
	<!-- /.content-section-a -->

	<a name="Recuperer"></a>
	<div class="content-section-b">

		<div class="container">

			<div class="row">
				<div class="col-lg-5 col-lg-offset-1 col-sm-push-6  col-sm-6">
					<hr class="section-heading-spacer">
					<div class="clearfix">
					
					</div>
					<h2 class="section-heading">
						Chercher des clients par mots clé<br>
					</h2>
					<form action="chercher" method="post">
					
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Mots clé" name="keyword" required="required">
					</div>
					<button type="submit" class="btn btn-default">Chercher</button>
					</form>
					
				</div>
				<div class="col-lg-5 col-sm-pull-6  col-sm-6">
					<%-- <img class="img-responsive"
						src="<%=request.getContextPath()%>/resources/img/dog.png" alt=""> --%>

					<table class=table>
					<tr>
					<th>Nom  </th>
					<th>Prenom  </th>
					<th>Code postal</th>
					</tr>
					
					<c:forEach items="${ListeClientByMc}" var="lcbm">
								
								<tr>
								<td>${lcbm.nomClient}</td>
								<td>${lcbm.prenomClient}</td>
								<td>${lcbm.cpClient}</td>
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


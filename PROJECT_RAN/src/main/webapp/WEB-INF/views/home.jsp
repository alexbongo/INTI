<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="fr">

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
				<a class="navbar-brand topnav" href="#about">Gestionnaire de
					banque RAN</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Groupes</a></li>
					<li><a href="#">Clients</a></li>
					<li><a href="#">Comptes</a></li>
					<li><a href="#">Op&eacute;rations</a></li>
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
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Acc&egrave;s<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#administrateur">Administrateur</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#employe">Employ&eacute;</a></li>
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
						<h1>Bienvenue sur le Gestionnaire de banque RAN</h1>
						<h3>Gestion de compte client pour les employ&eacute;s de 3 banques</h3>
						<hr class="intro-divider">
						
  <div class="col-lg-3 col-md-4 col-sm-6">
      <div class="circular"><img class="img-circle" src="<%=request.getContextPath()%>/resources/img/groupe.jpg" alt="Flower" ></div>
      <div><h2>Groupes</h2></div>
      <div><span> </span></div>
  </div>
  <div  class="col-lg-3 col-md-4 col-sm-6">
    <div class="circular"><img class="img-circle" src="<%=request.getContextPath()%>/resources/img/client.jpg"  alt="Flower" ></div>
      <div><h2>Clients</h2></div>
      <div><span></span></div>
  </div>
  <div  class="col-lg-3 col-md-4 col-sm-6">
    <div class="circular"><img class="img-circle" src="<%=request.getContextPath()%>/resources/img/compte.jpg" alt="Flower" ></div>
      <div><h2>Comptes</h2></div>
      <div><span></span></div>
  </div>
  <div  class="col-lg-3 col-md-4 col-sm-6">
    <div class="circular"><img class="img-circle" src="<%=request.getContextPath()%>/resources/img/operation.jpg" alt="Flower" ></div>
      <div><h2>Operations</h2></div>
      <div><span></span></div>
  </div>
					</div>
				</div>
			</div>

		</div>
		<!-- /.container -->

	</div>
	<!-- /.intro-header -->

	<!-- Page Content -->

	<a name="banques"></a>
	<div class="content-section-a">

		<div class="container">
			<div class="row">
				<div class="col-lg-4 col-sm-6">
					<hr class="section-heading-spacer">
					<div class="clearfix"></div>
					<h2 class="section-heading">
						GARIP Limited Bank:<br> Banque d'investissement
					</h2>
					<p class="lead">
						Une banque d'investissement est une banque, ou une division de 
						la banque, qui rassemble l'ensemble des activit&eacute;s de conseil, 
						d'interm&eacute;diation et d'ex&eacute;cution ayant trait aux op&eacute;rations dites 
						de haut de bilan (introduction en Bourse, &eacute;mission de dette, 
						fusion/acquisition) de grands clients corporate 
						(entreprises, investisseurs, mais aussi &eacute;tats).
					</p>
				</div>
				<div class="col-lg-4 col-sm-6">
					<hr class="section-heading-spacer">
					<div class="clearfix"></div>
					<h2 class="section-heading">
						BONGO Limited Bank:<br> Banque de financement
					</h2>
					<p class="lead">
						Une banque de financement est une banque, ou le d&eacute;partement 
						d'une banque, dont l'activit&eacute; d'octroi de cr&eacute;dit repose sur 
						l'accompagnement des grandes entreprises, investisseurs 
						institutionnels, collectivit&eacute;s territoriales et &eacute;tats dans 
						leurs op&eacute;rations financi&egrave;res importantes et complexes, 
						souvent dans un contexte international
					</p>
				</div>
				<div class="col-lg-4 col-sm-6">
					<hr class="section-heading-spacer">
					<div class="clearfix"></div>
					<h2 class="section-heading">
						ALSAFADI Limited Bank:<br> Banque coop&eacute;rative
					</h2>
					<p class="lead">
						Une coop&eacute;rative de cr&eacute;dit, ou banque mutualiste1 est une banque 
						coop&eacute;rative, c'est-&agrave;-dire une entit&eacute; dans laquelle les soci&eacute;taires 
						ont la double-qualit&eacute; d'usagers (clients d&eacute;posants ou emprunteurs) 
						et de propri&eacute;taires (participant &agrave; la gouvernance).
					</p>
				</div>
			</div>

		</div>
		<!-- /.container -->

	</div>
	<!-- /.content-section-a -->
	<a name="employe"></a>
	<div class="content-section-b">

		<div class="container">

			<div class="row">
				<div class="col-lg-5 col-lg-offset-1 col-sm-push-6  col-sm-6">
					<hr class="section-heading-spacer">
					<div class="clearfix"></div>
					<h2 class="section-heading">
						Employ&eacute;s<br>du gestionnaire RAN
					</h2>
					<p class="lead">
						Les'employ&eacute;s du gestionnaire RAN peuvent effectuer des cr&eacute;ations de
						 compte pour des clients dans leur banque respective.
						 Ils sont aussi habilit&eacute; &agrave; effectuer des op&eacute;rations sur les comptes de leur client.
					</p>
				</div>
				<div class="col-lg-5 col-sm-pull-6  col-sm-6">
					<img class="img-responsive"
						src="<%=request.getContextPath()%>/resources/img/employe.jpg" alt="">
				</div>
			</div>

		</div>
		<!-- /.container -->

	</div>
	<!-- /.content-section-b -->
	<a name="administrateur"></a>
	<div class="content-section-a">

		<div class="container">

			<div class="row">
				<div class="col-lg-5 col-sm-6">
					<hr class="section-heading-spacer">
					<div class="clearfix"></div>
					<h2 class="section-heading">
						Administrateur du<br>gestionnaire RAN
					</h2>
					<p class="lead">
						Les administrateurs du gestionnaire RAN sont des employ&eacute;s particuliers
						qui d&eacute;tiennent certains droits d'&eacute;criture.
						 Ils ont par exemple la possibilit&eacute; d'ajouter de nouveaux employ&eacute;s dans 
						 la base de donn&eacute;e, mais aussi de g&eacute;rer les groupes d'employ&eacute;.
					 
					</p>
				</div>
				<div class="col-lg-5 col-lg-offset-2 col-sm-6">
					<img class="img-responsive"
						src="<%=request.getContextPath()%>/resources/img/administrateur.jpg"
						alt="">
				</div>
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
						<li><a href="#">Home</a></li>
						<li class="footer-menu-divider">&sdot;</li>
						<li><a href="#">Groupes</a></li>
						<li class="footer-menu-divider">&sdot;</li>
						<li><a href="#">Clients</a></li>
						<li class="footer-menu-divider">&sdot;</li>
						<li><a href="#">Comptes</a></li>
						<li class="footer-menu-divider">&sdot;</li>
						<li><a href="#banques">Banques</a></li>
						<li class="footer-menu-divider">&sdot;</li>
						<li><a href="#employe">Acc&egrave;s</a></li>
					</ul>
					<p class="copyright text-muted small">Copyright &copy; Your
						Company 2014. All Rights Reserved</p>
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


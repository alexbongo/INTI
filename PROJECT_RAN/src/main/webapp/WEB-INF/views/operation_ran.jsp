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

	<!-- Navigation commit new  -->
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
		<!-- /.container -->
	</nav>


	<!-- Header -->
	<a name="about"></a>
	<div class="intro-header">
		<div class="container">

			<div class="row">
				<div class="col-lg-12">
					<div class="intro-message">
						<h1>Gestion des opérations</h1>
						<br>
						<h3>Identification</h3>
						<hr class="intro-divider">
						<br>
						<form action="choixoperation" method="post"  > <!-- onsubmit="return smoothScroll(document.getElementById('second'));" -->
							<div class="col-lg-4 col-md-4 col-sm-6">
								<div class="form-group">
									<select class="form-control" name="choixidemploye1"
										id="choixemploye1" required>
										<option disabled selected>---Employe---</option>
										<c:forEach items="${listeEmploye}" var="lem">
											<option value="${lem.idEmploye}">${lem.nomEmploye}</option>
										</c:forEach>
									</select>
									</div>
							</div> 
							<!-- <div class="col-lg-3 col-md-4 col-sm-6">
								<div class="form-group">
									<select class="form-control" name="choixtypeop"
										id="choixop">
										<option disabled selected>---Operation---</option>
											<option value="Versement">Versement</option>
											<option value="Retrait">Retrait</option>
											<option value="Virement">Virement</option>
									</select>
									</div>
							</div > -->
							<div  class="col-lg-4 col-md-4 col-sm-6"><input type="number" class="form-control" placeholder="Montant" name="montant1" required>
								</div>
						<div  class="col-lg-4 col-md-4 col-sm-6"><button type="submit" class="btn btn-default" > Valider </button>
								</div>
						</form>

<br>
					<h3></h3>
					<br>
					<h3>Aller effectuer :</h3>
						<hr class="intro-divider"><br>
					
					<div  class="col-lg-4 col-md-4 col-sm-6"><a href="#versement"><button class="btn btn-default" > Versement </button></a>
					</div>
					<div  class="col-lg-4 col-md-4 col-sm-6"><a href="#retrait"> <button class="btn btn-default" >Retrait </button></a>
					</div>
					<div  class="col-lg-4 col-md-4 col-sm-6"><a href="#virement"><button class="btn btn-default" > Virement</button></a> 
					</div>
					
					<br>
					<br>
					<h3>Information sur la dernière opération réalisée :</h3>
						<hr class="intro-divider"><br>
					
					<div class="alert alert-danger">
						<h2>
						     <p>"${resultat_op}"</p>
						</h2>
					</div>
						</div>
						</div>
				</div>
			</div>

		</div>
		<!-- /.container -->

	</div>
	<!-- /.intro-header -->
						
	<!-- Page Content -->
	
    <div id="g">
	    <a name="versement"  ></a>
	</div>
	<div class="content-section-a">

		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-sm-6">
					<hr class="section-heading-spacer">
					<div class="clearfix"></div>
					<h2 class="section-heading">
						Effectuer un versement<br> 
					</h2>
					<form action="choixversement" method="post">
					<div class="form-group">
									<select class="form-control" name="choixidemploye2"
										id="choixemploye2" required>
										<option value="${choixidemploye1}">${nomemploye1}</option>
										<c:forEach items="${listeEmploye}" var="et">
											<option value="${et.idEmploye}">${et.nomEmploye}</option>
										</c:forEach>
									</select>
									<br><br>
									<select class="form-control" name="choixidcompte1"
										id="choixcompte1" required>
										<option disabled selected>---Choix compte---</option>
											<c:forEach items="${listecompteemploye1}" var="lce">
											<option value="${lce.idCompte}">${lce.idCompte}</option>
										</c:forEach>
									</select>
									<br><br>
					<input type="number" class="form-control" placeholder="Montant" value="${montant1}" name="montant2" required>
					<br><br>
					
					<button type="submit" class="btn btn-default">Valider</button>
					</div>
					
					</form>
					
				</div>
				<div class="col-lg-6 col-sm-6">
					<hr class="section-heading-spacer">
					<div class="clearfix"></div>
					<h2 class="section-heading">
						Aide pour l'exécution d'un versement<br> 
					</h2>
					<p class="lead">
					<h4>
					<ul >
							<li>Identifier vous <a href="#about">"ici"</a>, puis cliquez sur versement. </li>
							<li>Verifier les données préremplies. Attention en cas d'ereur d'identification, procéder à nouveau à l'identification. </li>
							<li>Renseigner le compte à créditer.</li>
							<li>Valider. Attention tous les champs doivent être remplis.</li>
					</ul>
					</h4>
					</p>
				</div>
			</div>

		</div>
		<!-- /.container -->

	</div>
	<!-- /.content-section-a -->
	<a name="retrait"></a>
	<div class="content-section-b">

		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-sm-6">
					<hr class="section-heading-spacer">
					<div class="clearfix"></div>
					<h2 class="section-heading">
						Effectuer un retrait<br> 
					</h2>
					<form action="choixretrait" method="post">
					<div class="form-group">
									<select class="form-control" name="choixidemploye3"
										id="choixemploye" required="required">
										<option value="${choixidemploye1}">${nomemploye1}</option>
										<c:forEach items="${listeEmploye}" var="et">
											<option value="${et.idEmploye}">${et.nomEmploye}</option>
										</c:forEach>
									</select>
									<br><br>
									<select class="form-control" name="choixidcompte2"
										id="choixcompte2" required="required">
										<option disabled selected>---Choix compte---</option>
											<c:forEach items="${listecompteemploye1}" var="lce">
											<option value="${lce.idCompte}">${lce.idCompte}</option>
										</c:forEach>
									</select>
									<br><br>
					<input type="number" class="form-control" placeholder="Montant"  value="${montant1}" name="montant3" required="required">
					<br><br>
					
					<button type="submit" class="btn btn-default">Valider</button>
					</div>
					
					</form>
					
				</div>

				<div class="col-lg-6 col-sm-6">
					<hr class="section-heading-spacer">
					<div class="clearfix"></div>
					<h2 class="section-heading">
						Aide pour l'exécution d'un retrait<br> 
					</h2>
					<p class="lead">
					<h4>
					<ul >
							<li>Identifier vous <a href="#about">"ici"</a>, puis cliquez sur retrait. </li>
							<br> <li>Verifier les données préremplies. Attention en cas d'ereur d'identification, procéder à nouveau à l'identification. </li>
							<li>Renseigner le compte à débiter.</li>
							<li>Valider. Attention tous les champs doivent être remplis.</li>
					</ul>
					</h4>
					</p>
				</div>
			</div>

		</div>
		<!-- /.container -->

	</div>

	<!-- /.content-section-b -->
	<a name="virement"></a>
	<div class="content-section-a">

		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-sm-6">
					<hr class="section-heading-spacer">
					<div class="clearfix"></div>
					<h2 class="section-heading">
						Effectuer un virement<br> 
					</h2>
					<form action="choixvirement" method="post">
					<div class="form-group">
									<select class="form-control" name="choixidemploye4"
										id="choixemploye4" required>
										<option value="${choixidemploye1}">${nomemploye1}</option>
										<c:forEach items="${listeEmploye}" var="et">
											<option value="${et.idEmploye}">${et.nomEmploye}</option>
										</c:forEach>
									</select>
									<br><br>
									<select class="form-control" name="choixidcompte3"
										id="choixcompte3" required>
										<option disabled selected>---Choix compte---</option>
											<c:forEach items="${listecompteemploye1}" var="lce">
											<option value="${lce.idCompte}">${lce.idCompte}</option>
										</c:forEach>
									</select>
									<br><br>
									<select class="form-control" name="choixidcompte4"
										id="choixcompte4" required>
										<option disabled selected>---Choix compte beneficiaire---</option>
											<c:forEach items="${listecompte}" var="lce">
											<option value="${lce.idCompte}">${lce.idCompte}</option>
										</c:forEach>
									</select>
									<br><br>
					<input type="number" class="form-control" placeholder="Montant"  value="${montant1}" name="montant4" required>
					<br><br>
					
					<button type="submit" class="btn btn-default">Valider</button>
					</div>
					
					</form>
					
				</div>
				<div class="col-lg-6 col-sm-6">
					<hr class="section-heading-spacer">
					<div class="clearfix"></div>
					<h2 class="section-heading">
						Aide pour l'exécution d'un virement<br> 
					</h2>
					<p class="lead">
					<h4>
					<ul >
							<li>Identifier vous <a href="#about">"ici"</a>, puis cliquez sur virement. </li>
							<li>Verifier les données préremplies. Attention en cas d'ereur d'identification, procéder à nouveau à l'identification. </li>
							<li>Renseigner le compte à débiter et celui à créditer.</li>
							<li>Valider. Attention tous les champs doivent être remplis.</li>
					</ul>
					</h4>
					</p>
				</div>
			</div>

		</div>
		<!-- /.container -->

	</div>
	
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

   <div class="second" id="second">Hi</div>

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
		
		<script type="text/javascript">
		window.smoothScroll = function(target) {
			
		    var scrollContainer = target;
		    do { //find scroll container
		        scrollContainer = scrollContainer.parentNode;
		        if (!scrollContainer) return;
		        scrollContainer.scrollTop += 1;
		    } while (scrollContainer.scrollTop == 0);
		    
		    var targetY = 0;
		    do { //find the top of target relatively to the container
		        if (target == scrollContainer) break;
		        targetY += target.offsetTop;
		    } while (target = target.offsetParent);
		    
		    scroll = function(c, a, b, i) {
		        i++; if (i > 30) return;
		        c.scrollTop = a + (b - a) / 30 * i;
		        setTimeout(function(){ scroll(c, a, b, i); }, 20);
		    }
		    // start scrolling
		    scroll(scrollContainer, scrollContainer.scrollTop, targetY, 0);
		}
</script>

<script type="text/javascript">
//<![CDATA[

function valider(){
  // si la valeur du champ prenom est non vide
  if(document.formSaisie.prenom.value != "") {
    // les données sont ok, on peut envoyer le formulaire    
    return true;
  }
  else {
    // sinon on affiche un message
    alert("Saisissez le prénom");
    // et on indique de ne pas envoyer le formulaire
    return false;
  }
}

//]]>
</script>


</body>

</html>


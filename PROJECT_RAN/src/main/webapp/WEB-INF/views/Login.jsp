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
<link
	href="<%=request.getContextPath()%>/resources/css/imagelink.css"
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

	<div >
		<header class="page-header">
			<h1>Authentification</h1>
		</header>

		<form class="form-horizontal" action="j_spring_security_check"
			method="POST">

			<div class="form-group">
				<label class="control-label col-sm-2" for="name">Utilisateur
					: </label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="j_username"/>

				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Mot de passe
					: </label>
				<div class="col-sm-10">
					<input type="password" class="form-control" name="j_password"/>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="submit" class="btn btn-info" value="Connexion" />
				</div>
			</div>
		</form>

		<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
			<div class="container alert alert-warning">
				<p>
					<%-- ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message"} --%>
					Mot de passe incorrect !
				</p>
			</div>
		</c:if>
	</div>
</body>
</html>
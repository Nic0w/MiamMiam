<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page import="fr.esiea.web_dev.miammiam.core.User" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>		
		<meta name="title" content=" MiamMiam"/>
		<meta name="subject" content="Cooking with what you havr"/>		
		<meta name="revisit-after" content="15 days"/>
		<meta name="language" content="EN"/>
		<meta name="robots" content="All"/>
		<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
		<title>Fiche utilisateur </title>
		<!-- <link href="img/favicon.ico" rel="shortcut icon" type="image/x-icon" />    -->
		<link href="css/style.css" media="screen" rel="stylesheet" type="text/css" />	
		<link href='http://fonts.googleapis.com/css?family=Cookie' rel='stylesheet' type='text/css'>
		<link href='http://fonts.googleapis.com/css?family=Advent+Pro:400,100' rel='stylesheet' type='text/css'>
		<script language="javascript" type="text/javascript" src="js/jquery-1.10.2.js"></script>
		<script language="javascript" type="text/javascript" src="js/script.js"></script>
	</head>
	<body>
		<!-- HEADER -->
		<div id="header">
			<div class="center">
				<!-- LISTE MENU -->
				<ul>
					<li><a href="home"><img id="pic-home" src="img/home.png" alt="pictoHome"/></a><a href="home">Accueil</a></li>
					<li><a href="apropos"><img id="pic-about" src="img/user.png" alt="pictoAboutUs"/></a><a href="apropos">A propos</a></li>
					<li><a href="contact"><img id="pic-mail" src="img/mail.png" alt="pictoMail"/></a> <a href="contact">Contact</a></li>
				</ul>
				<!-- PSEUDO MDP -->
				<div id="login">
					<form method="post" action="logout">
							<input type="hidden" name="user" value="<%  out.print(((User)request.getAttribute("user")).getEmail());  %>"/>
   					    	<input class="deconnection" type="submit" value="Deconexion" name="#" />	
					</form>
				</div>
				<!-- END PSEUDO MDP -->	
			</div>
		</div>
		<!-- END HEADER -->	
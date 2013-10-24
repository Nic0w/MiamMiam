<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>		
		<meta name="title" content=" MiamMiam"/>
		<meta name="subject" content="Cooking with what you havr"/>		
		<meta name="revisit-after" content="15 days"/>
		<meta name="language" content="EN"/>
		<meta name="robots" content="All"/>
		<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
		<title>Index MiamMiam </title>
		<!-- <link href="img/favicon.ico" rel="shortcut icon" type="image/x-icon" />    -->
		<link href="css/style.css" media="screen" rel="stylesheet" type="text/css" />	
		<link href='http://fonts.googleapis.com/css?family=Cookie' rel='stylesheet' type='text/css'>
		<link href='http://fonts.googleapis.com/css?family=Advent+Pro:400,100' rel='stylesheet' type='text/css'>
	</head>
	<body>
		<!-- HEADER -->
		<div id="header">
			<div class="center">
				<!-- LISTE MENU -->
				<ul>
					<li><a href="#"><img id="pic-home" src="img/home.png" alt="pictoHome"/></a><a href="#">Accueil</a></li>
					<li><a href="aPropos.html"><img id="pic-about" src="img/user.png" alt="pictoAboutUs"/></a><a href="aPropos.html">A propos</a></li>
					<li><a href="contact.html"><img id="pic-mail" src="img/mail.png" alt="pictoMail"/></a> <a href="contact.html">Contact</a></li>
				</ul>
				<!-- PSEUDO MDP -->
				<div id="login">
					<form method="POST" action="index.jsp">
   					    	<label for="log">Log in :</label>
  					     	<input class="txt" type="text" name="pseudo" id="pseudo" value="" />
  					     	<label for="pass">Password :</label>
   					    	<input class="txt" type="password" name="pass" id="pass" value=""/>
   					    	<a id="inscription" href="inscription.html">Inscription</a>
   					    	<input id="connection" type="submit" value="Connexion" name="B1" />	
					</form>
				</div>
				<!-- END PSEUDO MDP -->	
			</div>
		</div>
		<!-- END HEADER -->			
					
		<!--  HEART -->
		<div id="loopedSlider">
			<div class="container">	
				<ul class="slides">
					<li>
						<img src="img2/images_slider/1.png" alt="picto first house in the slider"/>
					</li>
					<li>
						<img src="img2/images_slider/5.png" alt="picto first house in the slider"/>
					</li>
					<li>
						<img src="img2/images_slider/6.png" alt="picto first house in the slider"/>
					</li>
				</ul>
			</div>	
			<a href="#" class="previous">‹</a>
			<a href="#" class="next">›</a>
			<ul class="pagination">
				<li><a href="#"></a></li>
				<li><a href="#"></a></li>
				<li><a href="#"></a></li>
			</ul>	
		</div>
		
		<div id=products>
			<div class="center">
				<div id="productDesc" class="product">		
					<h2>Fonctionnement</h2>
					<p>Cette application permet à nos membres d'accéder en illimité et gratuitement à toutes nos recettes de manière simple. En effet en une étape seulement, il sélectionne les ingrédients qu'il a à sa disposition et notre moteur de recherche va lui proposer toutes les recettes de dessert qui correspondent à ses attentes. Si il souhaite retrouver une recette qu'il a déjà préparé, il accèdera à son historique personnalisé. <b style="color: blue; text-decoration:underline">Pour les tests: log admin: admin | mdp admin: admin et log user: root | mdp user: toor</b>.
					</p>
				</div>
				<div class="product">
					<img src="img2/images_recettes/cremeBrulee.jpg" alt= "first picture of the house in the description"/>
					<h3> Crème brulée </h3>
					<p>La crème brulée est à base de jaunes d’œufs et de lait, saupoudrée de sucre et brulée à l’aide d’une pelle de feu rouge vif. A ce jour, plusieurs pays revendique l’origine de cette recette, mais la plus ancienne référence est bien française.
					</p>
				</div>			
				<div class="product">
					<img src="img2/images_recettes/banana.jpg" alt= "second picture of the house in the description"/>
					<h3> Banana split </h3>
					<p>Le banana split est un dessert glacé composé traditionnellement d'une banane coupée en longueur, enserrant trois boules de glaces (vanille, chocolat, fraise en France ou trois boules vanille en Belgique).
					</p>
				</div>
				<div class="last-product">
					<img src="img2/images_recettes/profiteroles.jpg" alt= "last picture of the house in the description"/>
					<h3> Profiteroles </h3>
					<p>Le profiteroles est une chouquette remplie de crème pâtissière ou crème glacée à la vanille accompagnée très souvent de chantilly.
Elle peut se manger à température ambiante ou bien glacée et recouverte de chocolat chaud.
					</p>
				</div>
			</div>
		</div>	
		<!-- END HEART -->
		<!-- FOOTER -->		
		<div id="footer">
			<div class="center">		
				<p>Copyright © 2013 Nicolas Broquet | Sylvain Prudhon All right reserved
				</p>
			</div>	
		</div>
		<!-- END FOOTER -->

		<script src="js/jquery-1.4.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/loopedslider.js" type="text/javascript" charset="utf-8"></script>		
		<script type="text/javascript" charset="utf-8">$(function(){$('#loopedSlider').loopedSlider({autoStart:7000,restart:14000});$('#newsSlider').loopedSlider({autoHeight:85});});</script>
		</body>
</html>
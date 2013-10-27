<%@include file="includes/logged_header.jsp" %>		
<%@ page import="fr.esiea.web_dev.miammiam.db.tables.pojos.Recipe" %>		

<%

	Recipe recipe = (Recipe) request.getAttribute("recipe");

%>		
		<!-- HEART -->
		<div class="container">
			<div class="center">	
				<img class="recipeImg" src="<%= recipe.getPhoto() %>"/>
				<div class="recipeName"><%= recipe.getName() %></div>
			</div>
			<div class=" corp center">	
				<ol class="recipeIngredient">
					<li>50g de farine</li>
					<li>20g de sucre</li>
					<li>4 cuill�res � soupe d'huile</li>
					<li>1/2 L de lait</li>
					<li>3 oeufs</li>
					<li>Fruits selon le clafoutis</li>
					<li>Beurre pour le moule</li>
				</ol>

				<ol class="recipeCooking">
					<li><%= recipe.getPersons() %> personnes</li>
					<li><%= recipe.getPrepTime() %>min de pr�paration</li>
					<li><%= recipe.getCookingTime() %>min de cuisson</li>
				</ol>
			</div>
			<div class="center recipe">
				<p>Pr�chauffez le four th.6 (180�C).</p>
				<p>M�langez la farine, le sucre, l'huile et les oeufs dans une terrine, m�langez bien afin d'obtenir une pate homog�ne.</p>
				<p>Ajoutez le lait pour obtenir une pate un peu plus �paisse que la pate � cr�pes.</p>
				<p>Beurrez un moule.</p>
				<p>Ajoutez les fruits choisis.</p>
				<p>Versez la pate et enfournez pendant 40 min.</p>
			</div>
		</div>
		<!-- END HEART -->
		
<%@include file="includes/footer.jsp" %>
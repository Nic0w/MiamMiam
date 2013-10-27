<%@include file="includes/logged_header.jsp" %>		
<%@ page import="fr.esiea.web_dev.miammiam.db.tables.pojos.Recipe" %>		
<%@ page import="com.google.gson.Gson" %>
<%@ page import="com.google.gson.reflect.TypeToken" %>
<%@ page import="java.lang.reflect.Type" %>
<%@ page import="java.util.Map" %>
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
					<li>4 cuillères à  soupe d'huile</li>
					<li>1/2 L de lait</li>
					<li>3 oeufs</li>
					<li>Fruits selon le clafoutis</li>
					<li>Beurre pour le moule</li>
				</ol>

				<ol class="recipeCooking">
					<li><%= recipe.getPersons() %> personnes</li>
					<li><%= recipe.getPrepTime() %>min de préparation</li>
					<li><%= recipe.getCookingTime() %>min de cuisson</li>
				</ol>
			</div>
			<div class="center recipe">
				<%= recipe.getSteps() %>
			</div>
		</div>
		<!-- END HEART -->
		
<%@include file="includes/footer.jsp" %>
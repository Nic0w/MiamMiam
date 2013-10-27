<%@include file="includes/logged_header.jsp" %>		
<%@ page import="fr.esiea.web_dev.miammiam.db.tables.pojos.Recipe" %>		
<%@ page import="java.util.List" %>
<%

	Recipe recipe = (Recipe) request.getAttribute("recipe");

	if(recipe==null)
		return;

	List<String> ingredients = (List<String>) request.getAttribute("ingredients");
	
%>		
		<!-- HEART -->
		<div class="container">
			<div class="center">	
				<img class="recipeImg" src="<%= recipe.getPhoto() %>"/>
				<div class="recipeName"><%= recipe.getName() %></div>
			</div>
			<div class=" corp center">	
				<ol class="recipeIngredient">
				
				<%
					for(String s : ingredients)
						out.println("<li>" + s + "</li>");
				
				%>
				
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
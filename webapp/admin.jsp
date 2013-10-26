<%@include file="includes/logged_header.jsp" %>	
<%@ page import="java.util.List" %>
<%@ page import="fr.esiea.web_dev.miammiam.db.tables.pojos.Recipe" %>		
		<!-- HEART -->
		<div class="center container">
		
		
		
			<h1>Bienvenue: Bob</h1>
			
			<h2>Recap membre</h2>
			<table border="1">
				<tr>
					<th>Login</th>
					<th>Supprimer</th>
				</tr>
				
				
				<% 
					for(User u : (List<User>) request.getAttribute("users")) {
						
						out.println("<tr>");
						out.println(String.format("<td>%s</td>", u.getMail()));
						out.println(String.format("<td><a href=\"delete_user?user=%s\">Supprimer</a></td>", u.getMail()));
						out.println("</tr>");
					}
				%>
			</table>
			
			<h2>Recap recette</h2>
			<table border="1">
				<tr>
					<th>Recette</th>
					<th>Voir</th>
					<th>Supprimer</th>
				</tr>
				<% 
					for(Recipe r : (List<Recipe>) request.getAttribute("recipes")) {
						
						out.println("<tr>");
						out.println(String.format("<td>%s</td>", r.getName()));
						out.println(String.format("<td><a href=\"recipe?id=%d\">Voir</a></td>", r.getId()));
						out.println(String.format("<td><a href=\"delete_recipe?id=%d\">Supprimer</a></td>", r.getId()));
						out.println("</tr>");
					}
				%>
			</table>
			<form method="post" action="new_recipe">
				<input class="button" type="submit" value="Créer recette" />
			</form>
		
		
		</div>
		<!-- END HEART -->
		
<%@include file="includes/footer.jsp" %>
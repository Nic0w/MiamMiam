<%@include file="includes/logged_header.jsp" %>	
<%@ page import="java.util.List" %>
		
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
				<tr>
					<td>Banana Split</td>
					<td><a href="#">Voir</a></td>
					<td><a href="#">Supprimer</a></td>
				</tr>
				<tr>
					<td>Clafoutis</td>
					<td><a href="#">Voir</a></td>
					<td><a href="#">Supprimer</a></td>
				</tr>
			</table>
			<form method="#" action="#">
				<input class="button" type="submit" value="Créer recette" />
			</form>
		
		
		</div>
		<!-- END HEART -->
		
<%@include file="includes/footer.jsp" %>
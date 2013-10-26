
<%@include file="includes/logged_header.jsp" %>	
		
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
				
					List<User>
				
				
				%>
				
				<tr>
					<td>Nic0w@gmail.com</td>
					<td><a href="#">Supprimer</a></td>
				</tr>
				<tr>
					<td>bob@gmail.com</td>
					<td><a href="#">Supprimer</a></td>
				</tr>
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
<%@include file="includes/logged_header.jsp" %>	
<%@ page import="java.util.List" %>
<%@ page import="fr.esiea.web_dev.miammiam.db.tables.pojos.Recipe" %>
<%@ page import="fr.esiea.web_dev.miammiam.db.tables.daos.RecipeDao" %>
<%@ page import="fr.esiea.web_dev.miammiam.db.tables.pojos.RecipeHistory" %>		
		<!-- HEART -->
		<div class="center container">
			<h1>Bienvenue Bob</h1>
			<h2>Effectuer une recherche</h2>
			<div>
				<form method="post" action="search_recipe">
					<div>
						<label class="labelRecherche"><input id="farine" type="checkbox" name="flour"/>Farine</label>
						<label class="labelRecherche"><input id="sucre" type="checkbox" name="sugar"/>Sucre</label>
						<label class="labelRecherche"><input id="huile" type="checkbox" name="oil"/>Huile</label>
					</div>
					<div>
						<label class="labelRecherche"><input id="lait" type="checkbox" name="milk"/>Lait</label>
						<label class="labelRecherche"><input id="beurre" type="checkbox" name="butter"/>Beurre</label>
						<label class="labelRecherche"><input id="oeuf" type="checkbox" name="egg"/>Oeufs</label>
					</div>
					<div>
						<label class="labelRecherche"><input id="fruit" type="checkbox" name="fruit"/>Fruits (ou chocolat)</label>
						<label class="labelRecherche"><input id="sucreV" type="checkbox" name="vanilla_sugar"/>Sucre vanillé</label>
					</div>
					<div>
						<label class="labelRecherche"><input id="coco" type="checkbox" name="coconut"/>Noix de coco</label>
						<label class="labelRecherche"><input id="vanille" type="checkbox" name="vanilla"/>Vanille</label>
						<span id="validIngredient" class="errorMessage">Vous devez sélectionner au moins un ingrédient</span>
					</div>
					<input id="envoieRecherche" class="button" type="submit" value="Rechercher"/>
				</form>
			</div>
			<h2>Votre historique</h2>
			
			<table border="1">
				<tr>
					<th>Date</th>
					<th>Recette cherchée</th>
				</tr>
							
			<%
				
			RecipeDao recipes = (RecipeDao) request.getAttribute("recipes");
			
			for(RecipeHistory record : (List<RecipeHistory>) request.getAttribute("history")) {
				
				Recipe recipe = recipes.fetchOneById(record.getRecipe());
				
				out.println("<tr>");
				out.println(String.format("<td>%s</td>", record.getDate().toString()));
				out.println(String.format("<td>%s</td>", recipe.getName()));
				out.println("</tr>");
			}
			
			%>
				
				<tr>
					<td>19 mars 2013</td>
					<td>Clafoutis</td>
				</tr>
				<tr>
					<td>02 juillet 2012</td>
					<td>Cake à la noix de coco</td>
				</tr>
			</table>
		</div>
		<!-- END HEART -->
		
<%@include file="includes/footer.jsp" %>
<%@include file="includes/logged_header.jsp" %>	
		
		<!-- HEART -->
		<div class="center container">
			<h1>Bienvenue Bob</h1>
			<h2>Effectuer une recherche</h2>
			<div>
				<form method="#" action="#">
					<div>
						<label class="labelRecherche"><input id="farine" type="checkbox"/>Farine</label>
						<label class="labelRecherche"><input id="sucre" type="checkbox"/>Sucre</label>
						<label class="labelRecherche"><input id="huile" type="checkbox"/>Huile</label>
					</div>
					<div>
						<label class="labelRecherche"><input id="lait" type="checkbox"/>Lait</label>
						<label class="labelRecherche"><input id="beurre" type="checkbox"/>Beurre</label>
						<label class="labelRecherche"><input id="oeuf" type="checkbox"/>Oeufs</label>
					</div>
					<div>
						<label class="labelRecherche"><input id="fruit" type="checkbox"/>Fruits (ou chocolat)</label>
						<label class="labelRecherche"><input id="sucreV" type="checkbox"/>Sucre vanillé</label>
						<label class="labelRecherche"><input id="levure" type="checkbox"/>Levure</label>
					</div>
					<div>
						<label class="labelRecherche"><input id="coco" type="checkbox"/>Noix de coco</label>
						<label class="labelRecherche"><input id="vanille" type="checkbox"/>Vanille</label>
						<span id="validIngredient" class="errorMessage">Vous devez sélectionner au moins un ingrédient</span>
					</div>
					<input id="envoieRecherche" class="button" type="submit" value="Rechercher"/>
				</form>
			</div>
			<h2>Votre historique</h2>
			
			<%
				
			
			
			%>
			
			<table border="1">
				<tr>
					<th>Date</th>
					<th>Recette cherchée</th>
				</tr>
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
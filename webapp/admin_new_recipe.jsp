<%@include file="includes/logged_header.jsp" %>		
		
		<!-- HEART -->
		<div class="center container">
			<h1>Nouvelle Recette</h1>
			<form id="recipeForm" action="add_recipe" method="post">
				<h2>Ingrédients</h2>
				<label class="labelForm" id="labelRphoto">Photo <b class="star">*</b><input class="inputForm " id="Rphoto" type="text" name="photo"></label>
				<label class="labelForm" id="labelRnom">Nom <b class="star">*</b> <input id="Rnom" class="inputForm " type="text"  name="name"></label>
				<label class="labelForm" id="">Sucre (g)<input id="" class="inputForm" type="number" step="5" min="0" name="sugar"></label>
				<label class="labelForm" id="">Farine (g)<input id="" class="inputForm" type="number" step="5" min="0" name="flour"></label>
				<label class="labelForm" id="">Huile (c.s.)<input id="" class="inputForm" type="number" step="1" min="0" name="oil"></label>
				<label class="labelForm" id="">Lait (L)<input id="" class="inputForm" type="number" step="0.125" min="0" name="milk"></label>
				<label class="labelForm" id="">Beurre (g)<input id="" class="inputForm" type="number" step="5" min="0" name="butter"></label>
				<label class="labelForm" id="">Oeuf(s) <input id="" class="inputForm" type="number" step="1" min="0" name="egg"></label>
				<label class="labelForm" id="">Fruit / Chocolat <input id="" class="inputForm" type="text"  name="fruit"></label>
				<label class="labelForm" id="">Sachet de sucre vanillé <input id="" class="inputForm" type="number" step="0.25" min="0" name="vanilla_sugar"></label>
				<label class="labelForm" id="">Noix de coco (g)<input id="" class="inputForm" type="number" step="5" min="0" name="coconut"></label>
				<label class="labelForm" id="">Vanille (g)<input id="" class="inputForm" type="number" step="5" min="0" name="vanilla"></label>
				<label class="labelForm" id="">Autre (sel, eau) <input id="" class="inputForm" type="text"  name="other"></label>
				<h2>Informations</h2>
				<label class="labelForm" id="labelRpersonne">Nombre de personne <b class="star">*</b><input id="Rpersonne" class="inputForm " type="number" step="1" min="0" name="nb_people"></label>
				<label class="labelForm" id="labelRprep">Préparation (min) <b class="star">*</b><input id="Rprep" class="inputForm " type="number" step="1" min="0" name="prep_time"></label>
				<label class="labelForm" id="labelRcuisson">Cuisson (min) <b class="star">*</b><input id="Rcuisson" class="inputForm " type="number" step="1" min="0" name="cooking_time"></label>
				<h2>Préparation</h2>
				<label class="labelForm" id="labelRetape">Etapes <b class="star">*</b> <textarea  id="Retape" class="inputForm " type="text"  name="steps" ></textarea>
				<div>	
					<input id="envoieRecette" type="submit" value="Enregistrer" class="button"/>
				</div>
			</form>
		</div>
		<!-- END HEART -->
		
<%@include file="includes/footer.jsp" %>
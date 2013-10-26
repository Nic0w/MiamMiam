package fr.esiea.web_dev.miammiam.controllers;

import static com.google.common.collect.Maps.newHashMap;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.google.common.collect.Maps;
import com.google.gson.Gson;

import fr.esiea.web_dev.miammiam.db.tables.daos.RecipeDao;
import fr.esiea.web_dev.miammiam.db.tables.daos.SessionDao;
import fr.esiea.web_dev.miammiam.db.tables.daos.UserDao;
import fr.esiea.web_dev.miammiam.db.tables.pojos.Recipe;

public class RecipeController extends DynamicPage {

	private final RecipeDao recipeTable;
	
	public RecipeController(SessionDao sessionDao, UserDao userDao, RecipeDao recipeDao, String jsp) {
		super(sessionDao, userDao, jsp, true);
		
		this.recipeTable = recipeDao;
	}

	private void redirectToAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("action", "admin");
		
		request.getRequestDispatcher("/MiamServlet").forward(request, response);
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		switch((String)request.getAttribute("action")) {
		
			case "new_recipe" : 
				super.execute(request, response);
				return;
				
			case "add_recipe" :
				
				Map<String, String[]> args = request.getParameterMap();
				
				Map<String, String> ingredients = newHashMap();
				
				Gson json = new Gson();
				
				ingredients.put("fruit", args.get("fruit")[0]);
				ingredients.put("coconut", args.get("coconut")[0]);
				ingredients.put("egg", args.get("egg")[0]);
				ingredients.put("oil", args.get("oil")[0]);
				ingredients.put("flour", args.get("flour")[0]);
				ingredients.put("butter", args.get("butter")[0]);
				ingredients.put("milk", args.get("milk")[0]);
				ingredients.put("vanilla", args.get("vanilla")[0]);
				ingredients.put("vanilla_sugar", args.get("vanilla_sugar")[0]);
				ingredients.put("sugar", args.get("sugar")[0]);
				ingredients.put("other", args.get("other")[0]);
				
				Recipe newRecipe = new Recipe(
						null, 
						args.get("name")[0], 
						args.get("photo")[0], 
						Integer.parseInt(args.get("nb_people")[0]),
						Integer.parseInt(args.get("prep_time")[0]), 
						Integer.parseInt(args.get("cooking_time")[0]), 
						json.toJson(ingredients), 
						args.get("steps")[0]);

				this.recipeTable.insert(newRecipe);
				
				this.redirectToAdmin(request, response);
				
				break;
				
			case "delete_recipe" : 
				
				Integer id = Integer.parseInt(request.getParameter("id"));
				
				this.recipeTable.deleteById(id);
				
				this.redirectToAdmin(request, response);
				
				return;
		
		}
		
		
		
	}

}

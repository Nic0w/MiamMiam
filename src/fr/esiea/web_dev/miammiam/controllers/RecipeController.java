package fr.esiea.web_dev.miammiam.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.esiea.web_dev.miammiam.db.tables.daos.RecipeDao;
import fr.esiea.web_dev.miammiam.db.tables.daos.SessionDao;
import fr.esiea.web_dev.miammiam.db.tables.daos.UserDao;

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
				break;
				
			case "delete_recipe" : 
				
				Integer id = Integer.parseInt(request.getParameter("id"));
				
				this.recipeTable.deleteById(id);
				
				this.redirectToAdmin(request, response);
				
				return;
		
		}
		
		
		
	}

}

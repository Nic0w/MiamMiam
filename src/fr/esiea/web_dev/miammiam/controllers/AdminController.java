package fr.esiea.web_dev.miammiam.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jooq.DSLContext;

import fr.esiea.web_dev.miammiam.db.tables.daos.RecipeDao;
import fr.esiea.web_dev.miammiam.db.tables.daos.SessionDao;
import fr.esiea.web_dev.miammiam.db.tables.daos.UserDao;
import fr.esiea.web_dev.miammiam.db.tables.pojos.Recipe;
import fr.esiea.web_dev.miammiam.db.tables.pojos.User;

public class AdminController extends DynamicPage {

	private final UserDao userTable;
	private final RecipeDao recipeTable;
	
	public AdminController(SessionDao sessionDao, UserDao userDao, RecipeDao recipeDao, String jsp) {
		super(sessionDao, userDao, jsp, true);
		
		this.userTable = userDao;
		this.recipeTable = recipeDao;
		
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		
		List<User> users = this.userTable.findAll();
		
		List<Recipe> recipes = this.recipeTable.findAll();
		
		if(users == null)
		 System.out.println("probmmele");
		else
			System.out.println("Users : " + users.size());
		
		request.setAttribute("users", users);
		request.setAttribute("recipes", recipes);
		
		super.execute(request, response);
	}

}



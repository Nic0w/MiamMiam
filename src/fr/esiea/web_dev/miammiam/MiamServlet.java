package fr.esiea.web_dev.miammiam;

import static com.google.common.collect.Maps.newHashMap;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import fr.esiea.web_dev.miammiam.controllers.DynamicPage;
import fr.esiea.web_dev.miammiam.controllers.InscriptionController;
import fr.esiea.web_dev.miammiam.controllers.LoginController;
import fr.esiea.web_dev.miammiam.controllers.LogoutController;
import fr.esiea.web_dev.miammiam.controllers.StaticPage;
import fr.esiea.web_dev.miammiam.db.tables.daos.RecipeDao;
import fr.esiea.web_dev.miammiam.db.tables.daos.SessionDao;
import fr.esiea.web_dev.miammiam.db.tables.daos.UserDao;

/**
 * Servlet implementation class MiamServlet
 */
@WebServlet("/MiamServlet")
public class MiamServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private final Map<String, MiamController> controllers = newHashMap();
	
	private static final String DB_USER 		= "miam";
	private static final String DB_PASSWORD	= "test"; //OMG Hardcoded password !
	private static final String DB_URL		= "jdbc:mysql://localhost:3306/miam";
	
	private final DSLContext miam;
	
	private final Configuration miamConfig;
	
    /**
     * Default constructor. 
     */
    public MiamServlet() {
    	
    	Connection sqlConn = null;
    	
    	try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			sqlConn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			throw new RuntimeException(e);
		}
    	
    	this.miam = DSL.using(sqlConn, SQLDialect.MYSQL);
    	this.miamConfig = this.miam.configuration();
    	
    	
    	UserDao userTable =			new UserDao(miamConfig);
    	SessionDao sessionTable =	new SessionDao(miamConfig);
    	RecipeDao recipeTable =		new RecipeDao(miamConfig);
    	
    	StaticPage home = new StaticPage("home.jsp");
    	
    	this.registerController("",		home);
    	this.registerController("home",	home);
    	
    	this.registerController("apropos",		new StaticPage("apropos.jsp"));
    	this.registerController("contact",		new StaticPage("contact.jsp"));
    	this.registerController("inscription",	new StaticPage("inscription.jsp"));
    	
    	this.registerController("search", new DynamicPage(sessionTable, userTable, "search.jsp", false));
    	this.registerController("admin", new DynamicPage(sessionTable, userTable, "admin.jsp", true));
    	
    	this.registerController("new_user", new InscriptionController(userTable));
    	this.registerController("login", new LoginController(sessionTable, userTable));
    	this.registerController("logout", new LogoutController(sessionTable, userTable));
    }
    
    private MiamServlet registerController(String action, MiamController controller) {
    	
    	this.controllers.put(action, controller);
    	
    	return this;
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		/*Enumeration<String> actions = request.getAttributeNames();
		
		String action = null;
		if(actions.hasMoreElements())
			action = actions.nextElement();*/
		
		String action = (String) request.getAttribute("action");
		
		MiamController controller = this.controllers.get(action);
		
		controller.execute(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}

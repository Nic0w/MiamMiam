package fr.esiea.web_dev.miammiam;

import static com.google.common.collect.Maps.newHashMap;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import com.google.common.collect.Maps;

import fr.esiea.web_dev.miammiam.controllers.InscriptionController;
import fr.esiea.web_dev.miammiam.controllers.LoginController;
import fr.esiea.web_dev.miammiam.controllers.LogoutController;
import fr.esiea.web_dev.miammiam.controllers.PageController;
import fr.esiea.web_dev.miammiam.controllers.RestrictedPageController;
import fr.esiea.web_dev.miammiam.core.User;
import fr.esiea.web_dev.miammiam.db.tables.daos.UserDao;

/**
 * Servlet implementation class MiamServlet
 */
@WebServlet("/MiamServlet")
public class MiamServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private final Map<String, MiamController> controllers = newHashMap();
	
	private static final String DB_USER 		= "miam";
	private static final String DB_PASSWORD	= "wJsYBGR74BMa4ups"; //OMG Hardcoded password !
	private static final String DB_URL		= "jdbc:mysql://localhost:3306/miam";
	
	private final DSLContext miam;
	
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
    	
    	PageController home = new PageController("home.jsp");
    	
    	this.registerController("", home);
    	this.registerController("home", home);
    	this.registerController("apropos", new PageController("apropos.jsp"));
    	this.registerController("contact", new PageController("contact.jsp"));
    	this.registerController("inscription", new PageController("inscription.jsp"));
    	
    	this.registerController("search", new RestrictedPageController(this.miam, "search.jsp", false));
    	this.registerController("admin", new RestrictedPageController(this.miam, "admin.jsp", true));
    	
    	this.registerController("new_user", new InscriptionController(new UserDao(this.miam.configuration())));
    	this.registerController("login", new LoginController(this.miam));
    	this.registerController("logout", new LogoutController(this.miam));
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

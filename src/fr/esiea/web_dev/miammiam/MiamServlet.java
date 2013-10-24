package fr.esiea.web_dev.miammiam;

import static com.google.common.collect.Maps.newHashMap;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.collect.Maps;

import fr.esiea.web_dev.miammiam.controllers.PageController;

/**
 * Servlet implementation class MiamServlet
 */
@WebServlet("/MiamServlet")
public class MiamServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private final Map<String, MiamController> controllers = newHashMap();
	
    /**
     * Default constructor. 
     */
    public MiamServlet() {
    	
    	PageController home = new PageController("home.jsp");
    	
    	this.registerController("", home);
    	this.registerController("home", home);
    	this.registerController("apropos", new PageController("apropos.jsp"));
    	this.registerController("contact", new PageController("contact.jsp"));
    	this.registerController("inscription", new PageController("inscription.jsp"));
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

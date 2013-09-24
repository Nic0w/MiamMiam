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
    	
    	
    	
    	
    }
    
    private MiamServlet registerController(String action, MiamController controller) {
    	
    	this.controllers.put(action, controller);
    	
    	return this;
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		Enumeration<String> actions = request.getAttributeNames();
		
		String action;
		if(actions.hasMoreElements())
			action = actions.nextElement();
		
		this.controllers.get(key);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}

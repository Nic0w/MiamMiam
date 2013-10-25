/**
 * 
 */
package fr.esiea.web_dev.miammiam.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jooq.DSLContext;

import fr.esiea.web_dev.miammiam.core.Session;
import fr.esiea.web_dev.miammiam.core.User;

/**
 * @author nic0w
 *
 */
public class RestrictedPageController extends PageController {

	protected final DSLContext miam;
	
	private final boolean isAdminOnly;
	
	/**
	 * @param jsp
	 */
	public RestrictedPageController(DSLContext miam, String jsp, boolean adminOnly) {
		super(jsp);
		
		this.isAdminOnly = adminOnly;
		this.miam = miam;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Session storedSession = Session.getSession(miam, request.getSession());
		
		System.out.println("P0LOPOPLP");
		
		if(storedSession.isValid()) {
			
			System.out.println("User is logged in...");
			
			User user = storedSession.getUser();
			
			if(request.getAttribute("user") == null)
				 request.setAttribute("user", user);
			
			if(this.isAdminOnly && !user.isAdmin()) {
				
				request.getRequestDispatcher("/home.jsp").forward(request, response);
				
				return;
			}
			
			System.out.println("AND HERE WE GO MOTHER FUCKER !");
			
			super.execute(request, response);
		
			return;
		}
		
		request.getRequestDispatcher("/home.jsp").forward(request, response);
		
	}

	
}

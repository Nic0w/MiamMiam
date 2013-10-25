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

import fr.esiea.web_dev.miammiam.core.User;

/**
 * @author nic0w
 *
 */
public class RestrictedPageController extends PageController {

	private final DSLContext miam;
	
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
		
		HttpSession session = request.getSession();
		
		System.out.println("P0LOPOPLP");
		
		if(User.isLoggedIn(this.miam, session)) {
			
			System.out.println("User is logged in...");
			
			User user = (User) request.getAttribute("user");
			
			if(user == null) {
				 user = User.loadUser(miam, session);
				 request.setAttribute("user", user);
			}
			
			
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

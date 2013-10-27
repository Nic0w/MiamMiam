/**
 * 
 */
package fr.esiea.web_dev.miammiam.controllers;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jooq.DSLContext;

import fr.esiea.web_dev.miammiam.db.tables.daos.SessionDao;
import fr.esiea.web_dev.miammiam.db.tables.daos.UserDao;
import fr.esiea.web_dev.miammiam.db.tables.pojos.Session;
import fr.esiea.web_dev.miammiam.db.tables.pojos.User;

/**
 * @author nic0w
 *
 */
public class DynamicPage extends StaticPage {
	
	protected boolean isAdminOnly;
	
	private final SessionDao sessionTable;
	private final UserDao userTable;
	
	/**
	 * @param jsp
	 */

	public DynamicPage(SessionDao sessionDao, UserDao userDao, String jsp, boolean b) {
		
		super(jsp);
		
		this.isAdminOnly = b;
		
		this.sessionTable = sessionDao;
		this.userTable = userDao;
		
	}

	protected void redirectToHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setAttribute("action", "home");
		
		request.getRequestDispatcher("/MiamServlet").forward(request, response);
	}
	
	private Session getStoredSession(HttpSession session) {
		
		String uid = (String) session.getAttribute("uid");
		
		if(uid == null)
			return null;
		
		return this.sessionTable.fetchOneByUid(uid);
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Session storedSession = this.getStoredSession(request.getSession());
		
		if(storedSession.getExpiration().after(new Date())) {
			
			System.out.println("User is logged in...");
			
			User user = this.userTable.fetchOneById(storedSession.getUser());
			
			if(request.getAttribute("user") == null)
				 request.setAttribute("user", user);
			
			if(this.isAdminOnly && user.getAdmin() == 0) {
				
				this.redirectToHome(request, response);
				
				return;
			}
			
			super.execute(request, response);
		
			return;
		}
		
		this.redirectToHome(request, response);
		
	}

	
}

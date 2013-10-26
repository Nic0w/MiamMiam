package fr.esiea.web_dev.miammiam.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.esiea.web_dev.miammiam.MiamController;
import fr.esiea.web_dev.miammiam.db.tables.daos.SessionDao;
import fr.esiea.web_dev.miammiam.db.tables.daos.UserDao;
import fr.esiea.web_dev.miammiam.db.tables.pojos.Session;
import fr.esiea.web_dev.miammiam.db.tables.pojos.User;

public class LogoutController implements MiamController {


	private final SessionDao sessionTable;
	
	private final UserDao userTable;

	public LogoutController(SessionDao sessions, UserDao users) {
		
		this.sessionTable = sessions;
		this.userTable = users;
		
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
		
		String userMail = request.getParameter("user");
		
		Session storedSession = this.getStoredSession(request.getSession());
		
		if(storedSession == null) { //
			
			response.sendError(403);
			
			return;
		}
		
		User user = this.userTable.fetchOneById(storedSession.getUser());
		
		if(user.getMail().equalsIgnoreCase(userMail)) {
			
			this.sessionTable.delete(storedSession);
			
			request.getRequestDispatcher("/home.jsp").forward(request, response);
		}
	}

}

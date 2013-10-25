package fr.esiea.web_dev.miammiam.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jooq.DSLContext;

import fr.esiea.web_dev.miammiam.MiamController;
import fr.esiea.web_dev.miammiam.core.Session;
import fr.esiea.web_dev.miammiam.core.User;

public class LogoutController implements MiamController {


	private final DSLContext miam;

	public LogoutController(DSLContext miam) {
		this.miam = miam;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userMail = request.getParameter("user");
		
		Session storedSession = Session.getSession(miam, request.getSession());
		
		if(storedSession == null) { //
			return;
		}
		
		User user = storedSession.getUser();
		
		if(user.getEmail().equalsIgnoreCase(userMail)) {
			
			Session.remove(miam, storedSession);
			
			request.getRequestDispatcher("/home.jsp").forward(request, response);
		}
	}

}

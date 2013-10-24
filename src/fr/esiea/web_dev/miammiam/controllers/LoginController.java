package fr.esiea.web_dev.miammiam.controllers;

import static fr.esiea.web_dev.miammiam.db.Tables.USER;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;

import fr.esiea.web_dev.miammiam.MiamController;

public class LoginController implements MiamController {

	private final DSLContext miam;
	
	public LoginController(DSLContext miam) {
		
		this.miam = miam;
		
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userMail		= request.getParameter("pseudo");
		String userPassword	= request.getParameter("pass"); 
		
		System.out.println("User '" + userMail + "' tries to login with password '"+ userPassword + "'.");
		
		Result<Record> result = miam.
				select().
					from(USER).
					where(
							USER.MAIL.equal(userMail).and(USER.PASSWORD.equal(userPassword))).
				fetch();
	
		if(result.size() == 0) { //User don't exist or bad password !
		
			System.out.println("User doesn't exist or bad password !");
			request.getRequestDispatcher("/home.jsp").forward(request, response);
			
			return;
		}
		
		Record user = result.get(0);
		
		if(user.getValue(USER.ADMIN, 0) == 1) { //user is admin
			
			request.getRequestDispatcher("/admin").forward(request, response);
			
		}
		else {
			
			request.getRequestDispatcher("/search").forward(request, response);
			
		}
		
		
	}

}

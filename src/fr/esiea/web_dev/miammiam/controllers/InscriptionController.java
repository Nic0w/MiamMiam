package fr.esiea.web_dev.miammiam.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;

import fr.esiea.web_dev.miammiam.MiamController;
import fr.esiea.web_dev.miammiam.db.tables.pojos.User;
import fr.esiea.web_dev.miammiam.db.tables.daos.UserDao;

public class InscriptionController implements MiamController {

	
	private final UserDao userTable;
	
	public InscriptionController(UserDao userDao) {
		
		this.userTable = userDao;
		
		
		
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userMail		= request.getParameter("mail");
		String userPassword	= request.getParameter("pwd"); 
		
		System.out.println("mail = " + userMail);
		System.out.println("password = " + userPassword);
		
		List<User> users = this.userTable.fetchByMail(userMail);
		
		
		if(users.size() == 0) { //User don't exist !

			System.out.println("Adding new user in db...");
			
			User newUser = new User(null, userMail, userPassword, 0);
			
			this.userTable.insert(newUser);
			
		}
		
		request.getRequestDispatcher("/home.jsp").forward(request, response);
		
		
	}

}

package fr.esiea.web_dev.miammiam.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;

import fr.esiea.web_dev.miammiam.MiamController;
import static fr.esiea.web_dev.miammiam.db.Tables.*;

public class InscriptionController implements MiamController {

	private final DSLContext miam;
	
	public InscriptionController(DSLContext miam) {
		
		this.miam = miam;
		
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userMail		= request.getParameter("mail");
		String userPassword	= request.getParameter("pwd"); 
		
		System.out.println("mail = " + userMail);
		System.out.println("password = " + userPassword);
		
		Result<Record> result = miam.select().from(USER).where(USER.MAIL.equal(userMail)).fetch();
		
		
		
		if(result.size() == 0) { //User don't exist !
			
			
			System.out.println("Adding new user in db...");
			miam.insertInto(USER, USER.MAIL, USER.PASSWORD, USER.ADMIN).values(userMail, userPassword, 0).execute();
			
		}
		
		request.getRequestDispatcher("/home.jsp").forward(request, response);
		
		
	}

}

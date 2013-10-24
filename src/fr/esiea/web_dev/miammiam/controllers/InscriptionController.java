package fr.esiea.web_dev.miammiam.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import fr.esiea.web_dev.miammiam.MiamController;

public class InscriptionController implements MiamController {

	public InscriptionController() {
		
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("mail = " + request.getParameter("mail"));
		System.out.println("password = " + request.getParameter("pwd"));
		
		request.getRequestDispatcher("/home.jsp").forward(request, response);
	}

}

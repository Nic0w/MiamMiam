package fr.esiea.web_dev.miammiam.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.esiea.web_dev.miammiam.MiamController;

public class StaticPage implements MiamController {

	private final String jspPage;
	
	public StaticPage(String jsp) {
		this.jspPage = jsp;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher(this.jspPage).forward(request, response);
	}

}

package fr.esiea.web_dev.miammiam.controllers;

import static fr.esiea.web_dev.miammiam.db.Tables.*;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jooq.DSLContext;

import fr.esiea.web_dev.miammiam.MiamController;
import fr.esiea.web_dev.miammiam.core.User;

public class LoginController implements MiamController {

	private static final int SESSION_DURATION = 3000; //in milliseconds
	
	private final static char[] hexArray = "0123456789ABCDEF".toCharArray();
	
	private final DSLContext miam;
	
	private final Random random;
	
	public LoginController(DSLContext miam) {
		
		this.miam = miam;
		
		random = new Random(System.currentTimeMillis());
		
	}
	
	
	/**
	 * Found here : http://stackoverflow.com/questions/9655181/convert-from-byte-array-to-hex-string-in-java
	 * 
	 * @param bytes
	 * @return
	 */
	private static String bytesToHex(byte[] bytes) {
	    char[] hexChars = new char[bytes.length * 2];
	    int v;
	    for ( int j = 0; j < bytes.length; j++ ) {
	        v = bytes[j] & 0xFF;
	        hexChars[j * 2] = hexArray[v >>> 4];
	        hexChars[j * 2 + 1] = hexArray[v & 0x0F];
	    }
	    return new String(hexChars);
	}
	
	private void registerSession(User u, HttpSession session) {
		
		Integer salt = random.nextInt();
		
		long loginTime = System.currentTimeMillis();
		
		String uid_base =  salt + "" + u.getEmail() + "" + loginTime;
		
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			
			return;
		}
		
		String uid = bytesToHex(md5.digest(uid_base.getBytes()));
		
		System.out.println("Session uid generated for user '"+ u.getEmail() +"' : " + uid);
		
		boolean insertOK = this.miam.
				insertInto(SESSIONS, 
						SESSIONS.UID, 
						SESSIONS.USER, 
						SESSIONS.EXPIRATION).
					values(uid, u.getID(), new Timestamp(loginTime + SESSION_DURATION)).
				execute() == 1;
				
		if(insertOK) {//Insert successfull

			session.setAttribute("uid", uid);
		}
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userMail		= request.getParameter("pseudo");
		String userPassword	= request.getParameter("pass"); 
		
		System.out.println("User '" + userMail + "' tries to login with password '"+ userPassword + "'.");
		
	
		User user = User.login(miam, userMail, userPassword);
		
		if(user == null) { //User doesn't exist or wrong password
		
			request.getRequestDispatcher("/home.jsp").forward(request, response);
			
			return;
		}
		
		
		registerSession(user, request.getSession());
		request.setAttribute("user", user);
		
		if(user.isAdmin()) { //user is admin
			
			request.getRequestDispatcher("/admin").forward(request, response);
			
		}
		else {
			
			request.getRequestDispatcher("/search").forward(request, response);
			
		}
		
		
	}

}

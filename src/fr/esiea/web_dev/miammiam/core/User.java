/**
 * 
 */
package fr.esiea.web_dev.miammiam.core;

import static fr.esiea.web_dev.miammiam.db.Tables.*;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Result;

/**
 * @author broquet
 *
 */
public class User {

	private final int id;
	
	private final String mail;
	
	private final boolean isAdmin;
	
	
	public User(Integer id, String userMail, boolean isAdmin) {
		this.id = id;
		this.mail		= userMail;
		this.isAdmin	= isAdmin;
	}
	
	public String getEmail() {
		return this.mail;
	}
	
	public Integer getID() {
		return this.id;
	}
	
	public boolean isAdmin() {
		return this.isAdmin;
	}

	public static boolean isLoggedIn(DSLContext miam, HttpSession session) {
		
		String session_uid = (String) session.getAttribute("uid");
		
		if(session_uid == null)
			return false;
		
		Result<Record1<Timestamp>> storedSessions = miam.select(SESSIONS.EXPIRATION).from(SESSIONS).where(SESSIONS.UID.eq(session_uid)).fetch();
		
		if(storedSessions.size() == 0) {
			
			System.out.println("Warning : outdated cookie or attempt at session spoofing !");
			
			return false;
		}
			
		Timestamp expiration_date = storedSessions.get(0).value1();
		

		return expiration_date.after(new Date());
	}

	public static User loadUser(DSLContext miam, HttpSession session) {
		
		String session_uid = (String) session.getAttribute("uid");
		
		if(session_uid == null)
			return null;
		
		Result<Record> users = miam.
				select().
					from(SESSIONS.join(USER).on(SESSIONS.USER.equal(USER.ID))).
					where(SESSIONS.UID.equal(session_uid)).
				fetch();
		
		if(users.size() == 0) {
			
			System.out.println("Fake session, fake user or it user doesn't exist.");
			
			return null;
		}
		
		Record loggedInUser = users.get(0);
		
		Integer id		 = loggedInUser.getValue(USER.ID);
		String userMail  = loggedInUser.getValue(USER.MAIL);
		boolean isAdmin = loggedInUser.getValue(USER.ADMIN) == 1;
		
		
		return new User(id, userMail, isAdmin);
	}
	
	public static User login(DSLContext miam, String mail, String password) {
		
		Result<Record2<Integer, Integer>> result = miam.
				select(USER.ID, USER.ADMIN).
					from(USER).
					where(
							USER.MAIL.equal(mail).and(USER.PASSWORD.equal(password))).
				fetch();
	
		if(result.size() == 0) { //User don't exist or bad password !
			return null;
		}
		
		Record2<Integer, Integer> user = result.get(0);
		
		return new User(user.value1(), mail, user.value2() == 1);
	}
}

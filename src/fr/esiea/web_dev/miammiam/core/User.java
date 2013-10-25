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
	
	
	protected User(Integer id, String userMail, boolean isAdmin) {
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
		
		Session storedSession = Session.getSession(miam, session);
		
		if(storedSession == null)
			return false;
		
		return storedSession.isValid();
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

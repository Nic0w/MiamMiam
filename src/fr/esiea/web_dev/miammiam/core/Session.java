package fr.esiea.web_dev.miammiam.core;

import static fr.esiea.web_dev.miammiam.db.Tables.*;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;

import fr.esiea.web_dev.miammiam.db.Tables;

public class Session {

	private static final String UID_SESSION_FIELD = "uid";
	
	private final String uid;
	private final User user;
	private final Timestamp expiration;
	
	public Session(String uid, User user, Timestamp date) {
		
		this.uid = uid;
		this.user = user;
		this.expiration = date;
	}

	public boolean isValid() {
		
		return this.expiration.after(new Date());
		
	}
	
	public static Session getSession(DSLContext miam, HttpSession session) {
		
		String uid = (String) session.getAttribute(UID_SESSION_FIELD);
		
		if(uid == null)
			return null;
		
		Result<Record> sessions = miam.select().
										from(SESSIONS.join(USER).on(SESSIONS.USER.eq(USER.ID))).
										where(SESSIONS.UID.eq(uid)).
									fetch();

		if(sessions.size() == 0)
			return null;
		
		Record storedSession = sessions.get(0);
		
		User user = new User(
				storedSession.getValue(USER.ID), 
				storedSession.getValue(USER.MAIL), 
				storedSession.getValue(USER.ADMIN) == 1
				);		
		
		return new Session(uid, user, storedSession.getValue(SESSIONS.EXPIRATION));
	}

	public User getUser() {
		return this.user;
	}

	public static boolean remove(DSLContext miam, Session storedSession) {

		 return miam.delete(SESSIONS).where(SESSIONS.UID.eq(storedSession.uid)).execute() == 1;
	}

}

package com.eunjy.stockid.utiliy;

import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;

import com.eunjy.stockid.domain.common.SessionUser;

public class LoginManager {
	
	private static LoginManager loginManager = null;
	private static Hashtable<String, HttpSession> loginUsers = new Hashtable<String, HttpSession>();

	private LoginManager() {
		super();
	}

	public static synchronized LoginManager getInstance() {
		if (loginManager == null) {
			loginManager = new LoginManager();
		}
		return loginManager;
	}

	// 중복 로그인 막기 위해 아이디 사용 중인지 체크
	public boolean isUsing(String userID) {
		boolean isUsing = false;
		Enumeration<String> e = loginUsers.keys();
		String key = "";
		while (e.hasMoreElements()) {
			key = e.nextElement();
			HttpSession httpSession = loginUsers.get(key);
			try {
				if (httpSession != null) {
					if (userID.equals(key)) {
						isUsing = true;
					}
				}
			} catch(Exception ex) {
			}
		}
		return isUsing;
	}

	// 세션 생성
	public void setSession(HttpSession session) {
		Object obj = session.getAttribute(Consts.SessionAttr.USER);
		if (obj != null) {
			SessionUser sessionUser = (SessionUser)obj;
			loginUsers.put(sessionUser.getUsrId(), session);
		}
	}

	// 세션 성립될 때
	public void valueBound(HttpSessionBindingEvent event) {
	}

	// 세션 끊길때
	public void valueUnbound(HttpSessionBindingEvent event) {
		HttpSession session = event.getSession();
		Object obj = session.getAttribute(Consts.SessionAttr.USER);
		if (obj != null) {
			SessionUser sessionUser = (SessionUser)obj;
			loginUsers.remove(sessionUser.getUsrId());
		}
	}

	// 세션 ID로 로그인된 ID 구분
	public HttpSession getUserSession(String userId) {
		return loginUsers.get(userId);
	}

	// 현재 접속자수
	public int getUserCount() {
		return loginUsers.size();
	}
}

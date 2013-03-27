package com.bmw.sell.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionAttributeListener
 * 
 */
@WebListener
public class SessionAttributeListener implements HttpSessionListener,HttpSessionAttributeListener {

	public SessionAttributeListener() {

	}

	public void attributeAdded(HttpSessionBindingEvent event) {
		String name=event.getName();
		HttpSession session = event.getSession();
		ServletContext application = session.getServletContext();
		if (session.getAttribute("user") != null && "user".equals(name)) {
			
				System.out.print(session.getAttribute("user")+"登陆了/n");
				int usernum = (Integer) application.getAttribute("usernum") + 1;
				application.setAttribute("usernum", usernum);
			}
		} 

	public void attributeReplaced(HttpSessionBindingEvent event) {
	}

	public void attributeRemoved(HttpSessionBindingEvent event) {
	}


	@Override
	public void sessionCreated(HttpSessionEvent event) {
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {

		
		HttpSession session = event.getSession();
		ServletContext application = session.getServletContext();
		int usernum = (Integer) application.getAttribute("usernum") - 1;
		application.setAttribute("usernum", usernum);
		
		
	}

}

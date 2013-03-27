package com.bmw.sell.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


/**
 * Application Lifecycle Listener implementation class ApplicationListener
 *
 */
@WebListener
public class ApplicationListener implements  ServletContextListener {

    public void contextInitialized(ServletContextEvent event) {
    	ServletContext application=event.getServletContext();
    	application.setAttribute("usernum",0);
    	application.setAttribute("visit",0);
    }

    public void contextDestroyed(ServletContextEvent event) {
        // TODO Auto-generated method stub
    }

	
	
}

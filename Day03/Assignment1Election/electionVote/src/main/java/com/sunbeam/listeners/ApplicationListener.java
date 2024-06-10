package com.sunbeam.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationListener implements ServletContextListener {
	// event: Application Start
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext ctx = sce.getServletContext();
		System.out.println("ElectrionServlets Application started.");
	}
	// event: Application End
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("ElectrionServlets Application stopped.");
	}
}

package com.oms.application;

import static org.eclipse.jetty.servlet.ServletContextHandler.NO_SESSIONS;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

public class Application {
	public static void main(String[] args) {
		final Server server = new Server(8080);

		final ServletContextHandler servletContextHandler = new ServletContextHandler(NO_SESSIONS);

		servletContextHandler.setContextPath("/");
		server.setHandler(servletContextHandler);

		final ServletHolder servletHolder = servletContextHandler.addServlet(ServletContainer.class, "/rs/v1/*");
		servletHolder.setInitOrder(0);
		servletHolder.setInitParameter("jersey.config.server.provider.packages", "com.oms.api");

		try {
			server.start();
			server.join();
		} catch (final Exception ex) {
			// logger.error("Error occurred while starting Jetty", ex);
		}

		finally {
			server.destroy();
		}
	}
}

package com.domain.heroku;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * This class launches the web application in an embedded Jetty container. 
 * This is the entry point to your application. 
 * The Java command that is used for launching should fire this main method.
 */
public class Main {
  /**
   * Main method sets the port.
   * @param args the input arguments
   * @throws Exception if default options are not correctly.
   */
   Server server;
	
  public static void main(String[] args) throws Exception {
	Main main = new Main();
	main.start();
	if(args.length == 0 || !args[0].equals("test")) {
		main.server.join();
	}
    main.stop();
  }
  
  
  public void start() throws Exception {
	    // The port that we should run on can be set into an environment variable
	    // Look for that variable and default to 8080 if it isn't there.
	    String webPort = System.getenv("PORT");
	    if (webPort == null || webPort.isEmpty()) {
	      webPort = "8080";
	    }
	    server = new Server(Integer.valueOf(webPort));
	    final WebAppContext root = new WebAppContext();

	    root.setContextPath("/");
	    // Parent loader priority is a class loader setting that Jetty accepts.
	    // By default Jetty will behave like most web containers in that it will
	    // allow your application to replace non-server libraries that are part of the
	    // container. Setting parent loader priority to true changes this behavior.
	    // Read more here: http://wiki.eclipse.org/Jetty/Reference/Jetty_Classloading
	    root.setParentLoaderPriority(true);

	    final String webappDirLocation = "src/main/webapp/";
	    root.setDescriptor(webappDirLocation + "/WEB-INF/web.xml");
	    root.setResourceBase(webappDirLocation);

	    server.setHandler(root);

	    server.start();
  }
  
  public void stop() throws Exception {
		server.stop();	  
  }
}

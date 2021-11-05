package es.iespuertodelacruz.adrian.instituto.servlets;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import es.iespuertodelacruz.adrian.instituto.dao.GestorConexionDDBB;

/**
 * Application Lifecycle Listener implementation class ArrancarPool
 *
 */
public class ArrancarPool implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ArrancarPool() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	
		GestorConexionDDBB gc = new GestorConexionDDBB("oficina", "root", "1q2w3e4r");

		sce.getServletContext().setAttribute("gc", gc);
    }
	
}

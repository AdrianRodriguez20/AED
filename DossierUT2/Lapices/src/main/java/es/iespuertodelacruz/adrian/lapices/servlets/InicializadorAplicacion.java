package es.iespuertodelacruz.adrian.lapices.servlets;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import es.iespuertodelacruz.adrian.lapices.dao.GestorConexionDDBB;
import es.iespuertodelacruz.adrian.lapices.dao.LapizDAO;

/**
 * Application Lifecycle Listener implementation class InicializadorAplicacion
 *
 */
public class InicializadorAplicacion implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public InicializadorAplicacion() {
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

		LapizDAO  lapizDAO = new LapizDAO(gc);
		
		sce.getServletContext().setAttribute("lapizDAO", lapizDAO);
    }
	
}

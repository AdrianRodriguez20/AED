package es.iespuertodelacruz.adrian.acertarnumero.servlets;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import es.iespuertodelacruz.adrian.acertarnumero.modelo.Secreto;

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
      
    	Secreto secreto = new Secreto();
    	sce.getServletContext().setAttribute("secreto", secreto);
    }
	
}

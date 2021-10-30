package es.iespuertodelacruz.adrian.acertarnumero.servlets;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import es.iespuertodelacruz.adrian.acertarnumero.modelo.ManejoFichero;
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
      
    	String pathToWeb = sce.getServletContext().getRealPath(File.separator);      
    	File f = new File(pathToWeb+ File.separator + "WEB-INF" + File.separator + "secretosSerializable.txt");

    	ManejoFichero mf = new ManejoFichero(f.toString());
        sce.getServletContext().setAttribute("mf", mf);
        try {
			sce.getServletContext().setAttribute("secretos", mf.getAll());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Secreto secreto = new Secreto();
    	sce.getServletContext().setAttribute("secreto", secreto);
    }
	
}

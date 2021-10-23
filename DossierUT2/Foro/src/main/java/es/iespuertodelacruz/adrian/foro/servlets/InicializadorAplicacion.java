package es.iespuertodelacruz.adrian.foro.servlets;

import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import es.iespuertodelacruz.adrian.foro.modelo.ManejoFichero;
import es.iespuertodelacruz.adrian.foro.modelo.Mensaje;

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
    	ManejoFichero mf = (ManejoFichero) sce.getServletContext().getAttribute("mf");
    	Vector<Mensaje> lista = (Vector<Mensaje>)sce.getServletContext().getAttribute("mensajes");
    	mf.aniadirMensaje(lista);
    	
  
        
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    
    public void contextInitialized(ServletContextEvent sce)  { 
    	String pathToWeb = sce.getServletContext().getRealPath(File.separator);      
    	File f = new File(pathToWeb+ File.separator + "WEB-INF" + File.separator + "mensajesSerializable.txt");
        ManejoFichero mf = new ManejoFichero(f.toString());
        
        sce.getServletContext().setAttribute("mf", mf);
        try {
			sce.getServletContext().setAttribute("mensajes", mf.getAll());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
}

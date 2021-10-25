package es.iespuertodelacruz.adrian.foro.modelo;

import java.util.TimerTask;
import java.util.Vector;

import javax.servlet.ServletContextEvent;

public class MyTimerTask extends TimerTask{

	ServletContextEvent sce ;
	ManejoFichero mf ;
	
	
	public MyTimerTask(ServletContextEvent sce, ManejoFichero mf) {
		super();
		this.sce = sce;
		this.mf = mf;
	}


	@Override
	public void run() {
		
		
			int sizeMensajes=(int)sce.getServletContext().getAttribute("sizeMensajes");
			
			
			Vector<Mensaje> lista = (Vector<Mensaje>)sce.getServletContext().getAttribute("mensajes");
		
			if (lista.size()>sizeMensajes) {
				
		    	mf.aniadirMensaje(lista);
		    	sizeMensajes=lista.size();
		    	sce.getServletContext().setAttribute("sizeMensajes", sizeMensajes);
			}
		
		
		
	}
	
}

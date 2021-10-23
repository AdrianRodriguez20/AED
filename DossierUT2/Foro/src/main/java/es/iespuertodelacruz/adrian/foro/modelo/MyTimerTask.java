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
		
		System.out.println("-----Entro-----");
			int sizeMensajes=(int)sce.getServletContext().getAttribute("sizeMensajes");
			System.out.println("sizeMensaje: "+sizeMensajes);
			
			Vector<Mensaje> lista = (Vector<Mensaje>)sce.getServletContext().getAttribute("mensajes");
			System.out.println("Lista.size()"+ lista.size());
			if (lista.size()>sizeMensajes) {
				System.out.println("Guardo");
		    	mf.aniadirMensaje(lista);
		    	sizeMensajes=lista.size();
		    	sce.getServletContext().setAttribute("sizeMensajes", sizeMensajes);
			}
			System.out.println("----FIN----");
		
		
	}
	
}

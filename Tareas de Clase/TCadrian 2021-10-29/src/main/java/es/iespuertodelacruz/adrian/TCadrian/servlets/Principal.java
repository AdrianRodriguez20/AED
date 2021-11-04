package es.iespuertodelacruz.adrian.TCadrian.servlets;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.iespuertodelacruz.adrian.TCadrian.ManejoFichero;

/**
 * Servlet implementation class Principal
 */
public class Principal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Principal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String rutaGuardar =request.getParameter("rutaGuardar");
		System.out.println("RG" +rutaGuardar);
		//rutaGuardar =rutaPorDefecto(rutaGuardar,request);
		if (rutaGuardar!=null ) {

			String contenido = request.getParameter("contenido");
			ManejoFichero mf = new ManejoFichero(rutaGuardar);
			mf.guardar(contenido);
			request.getSession().setAttribute("rutaGuardar", rutaGuardar);
			request.getSession().setAttribute("contenido", contenido);
			
			
		}
		String rutaCargar = request.getParameter("rutaCargar");
		System.out.println("RC"+rutaCargar);
		rutaCargar =rutaPorDefecto(rutaCargar,request);
		if (rutaCargar!=null) {
			
			ManejoFichero mf = new ManejoFichero(rutaCargar);
			String contenido = mf.leer();
			request.getSession().setAttribute("rutaGuardar", rutaCargar);
			request.getSession().setAttribute("contenido", contenido);
			
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		
		
	}

	
	public String rutaPorDefecto(String ruta , HttpServletRequest request) {
		String regexp = "^[a-z]{1,}.txt$";
		Path path =null;
		File directorio =null;
		try {
			if(ruta!=null) {
				path = Paths.get(ruta);
				directorio = new File(ruta.replaceAll("[a-z]{1,}.txt$", ""));	
			}else {
				return null;
			}
			 
		}catch(Exception ex){
			
		}

		if (Files.exists(path) || directorio.exists() ) {
			System.out.println("A");
			
			return ruta;
		} else if (Pattern.matches(regexp, ruta)) {
			System.out.println("b");
			String direccion = request.getServletContext().getRealPath("") + File.separator + "WEB-INF" + File.separator
					+ request.getSession().getId();
		
			File carpeta = new File(direccion);
			 if (!carpeta.exists())
				 carpeta.mkdir();
			return direccion + File.separator + ruta;
		}else {
			System.out.println("c");
			return null;
		}
		
	}


}

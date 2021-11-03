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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		if (request.getParameter("rutaGuardar")!=null ) {
			
			String rutaGuardar =rutaPorDefecto(request.getParameter("rutaGuardar"),request);
			String contenido = request.getParameter("contenido");
			ManejoFichero mf = new ManejoFichero(rutaGuardar);
			mf.guardar(contenido);
			request.getSession().setAttribute("rutaGuardar", rutaGuardar);
			request.getSession().setAttribute("contenido", contenido);
			
			
		}
		if (request.getParameter("rutaCargar")!=null) {
			String rutaCargar =rutaPorDefecto(request.getParameter("rutaCargar"),request);
			ManejoFichero mf = new ManejoFichero(rutaCargar);
			String contenido = mf.leer();
			request.getSession().setAttribute("rutaGuardar", rutaCargar);
			request.getSession().setAttribute("contenido", contenido);
			
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		
		
	}

	
	public String rutaPorDefecto(String ruta , HttpServletRequest request) {
		String regexp = "^[a-z]{1,}.txt$";
		Path path = Paths.get(ruta);
		File directorio = new File(ruta.replaceAll("[a-z]{1,}.txt$", ""));


		if (Files.exists(path) || directorio.exists() ) {
			
			return ruta;
		} else if (Pattern.matches(regexp, ruta)) {
			String direccion = request.getServletContext().getRealPath("") + File.separator + "WEB-INF" + File.separator
					+ request.getSession().getId();
		
			File carpeta = new File(direccion);
			 if (!carpeta.exists())
				 carpeta.mkdir();
			return direccion + File.separator + ruta;
		}
		return null;
	}


}

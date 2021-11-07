package es.iespuertodelacruz.adrian.instituto.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.iespuertodelacruz.adrian.instituto.dao.AlumnoDAO;
import es.iespuertodelacruz.adrian.instituto.dao.GestorConexionDDBB;
import es.iespuertodelacruz.adrian.instituto.modelo.Alumno;
import es.iespuertodelacruz.adrian.lapices.modelo.Lapiz;

/**
 * Servlet implementation class GestorAlumno
 */
public class GestorAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestorAlumno() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("alumno.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getSession().setAttribute("lapiz", null);
		request.getSession().setAttribute("lapices",null);
		GestorConexionDDBB gc= (GestorConexionDDBB) request.getServletContext().getAttribute("gc");
		AlumnoDAO alumnoDao = new AlumnoDAO(gc);
		String agregarParameter = request.getParameter("agregar");
		String editarParameter = request.getParameter("editar");
		String borrarParameter = request.getParameter("borrar");
		String buscarParameter = request.getParameter("buscar");
		
		if (agregarParameter != null) {
			
			String nombreParameter = request.getParameter("nombreAgregar");
			String apellidosParameter = request.getParameter("apellidosAgregar");
			String nacimientoParameter = request.getParameter("nacimientoParameter");
			String dniParameter = request.getParameter("dniAgregar");
			if (nombreParameter != null && !nombreParameter.isEmpty() && dniParameter != null
					&& !dniParameter.isEmpty()) {
				
				Alumno alumno =	AlumnoDAO.save(new Alumno());
				request.getSession().setAttribute("lapiz", lapiz);

			}
		}
		
	}

}

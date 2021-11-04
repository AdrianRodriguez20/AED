package es.iespuertodelacruz.adrian.lapices.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.iespuertodelacruz.adrian.lapices.dao.LapizDAO;
import es.iespuertodelacruz.adrian.lapices.modelo.Lapiz;

/**
 * Servlet implementation class GestionLapices
 */
public class GestionLapices extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GestionLapices() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().setAttribute("lapiz", null);
		request.getSession().setAttribute("lapices",null);
		LapizDAO lapizDAO = (LapizDAO) request.getServletContext().getAttribute("lapizDAO");
		String agregarParameter = request.getParameter("agregar");
		String editarParameter = request.getParameter("editar");
		String borrarParameter = request.getParameter("borrar");
		String buscarParameter = request.getParameter("buscar");
		if (agregarParameter != null) {
			
			String marcaParameter = request.getParameter("marcaAgregar");
			String numeroParameter = request.getParameter("numeroAgregar");
			if (marcaParameter != null && !marcaParameter.equals("") && numeroParameter != null
					&& !numeroParameter.equals("")) {
				
				Lapiz lapiz =	lapizDAO.save(new Lapiz(marcaParameter, Integer.parseInt(numeroParameter)));
				request.getSession().setAttribute("lapiz", lapiz);

			}
		}

		if (editarParameter != null) {
			String idLapizParameter = request.getParameter("idLapizEditar");
			String marcaParameter = request.getParameter("marcaEditar");
			String numeroParameter = request.getParameter("numeroEditar");

			if (marcaParameter != null && !marcaParameter.equals("") && numeroParameter != null
					&& !numeroParameter.equals("") && idLapizParameter != null && !idLapizParameter.equals("")) {

				lapizDAO.update(new Lapiz(Integer.parseInt(idLapizParameter), marcaParameter,
						Integer.parseInt(numeroParameter)));
			}

		}

		if (borrarParameter != null) {
			String idLapizParameter = request.getParameter("idLapizBorrar");
			if (idLapizParameter != null && !idLapizParameter.equals("")) {

				lapizDAO.delete(idLapizParameter);
			}

		}

		if (buscarParameter != null) {
		
			
			String buscarPor = request.getParameter("opcionBuscar");
			String lapizBuscarParameter = request.getParameter("lapizBuscar");

			if (lapizBuscarParameter != null && !lapizBuscarParameter.equals("")) {
				
				if (buscarPor.equals("idLapizBuscar")) {
					
				Lapiz lapiz =	lapizDAO.findById(lapizBuscarParameter);
				request.getSession().setAttribute("lapiz", lapiz);
				} else {
					ArrayList<Lapiz> lapices = lapizDAO.findByMarca(lapizBuscarParameter);
				
				request.getSession().setAttribute("lapices", lapices);
				}
			}
			
			if (lapizBuscarParameter == null || lapizBuscarParameter.equals("")) {
				ArrayList<Lapiz> lapices = lapizDAO.findAll();
				request.getSession().setAttribute("lapices", lapices);
			}
			

		}

		request.getRequestDispatcher("index.jsp").forward(request, response);

	}
}

package es.iespuertodelacruz.adrian.foro.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.iespuertodelacruz.adrian.foro.modelo.Mensaje;

/**
 * Servlet implementation class ForoWeb
 */

public class ForoWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ForoWeb() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub
		Vector<Mensaje> lista = (Vector<Mensaje>)request.getServletContext().getAttribute("mensajes");
		if (lista == null) {
			lista = new Vector<Mensaje>();
			request.getServletContext().setAttribute("mensajes", lista);
		}

		request.getRequestDispatcher("viewforo.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
		String nombre = request.getParameter("nombre");
		String mensaje = request.getParameter("mensaje");
		
		
		if (nombre!=null && !nombre.isEmpty() && mensaje!=null && !mensaje.isEmpty() ) {

			if(request.getSession().getAttribute(nombre)==null) {
				request.getSession().setAttribute("nombre", nombre);
			}
			
			Vector<Mensaje> lista = (Vector<Mensaje>)request.getServletContext().getAttribute("mensajes");
		
			lista.add(new Mensaje(nombre,mensaje));
			request.getServletContext().setAttribute("mensajes", lista);
		}
		response.sendRedirect("viewforo.jsp");
	}

}

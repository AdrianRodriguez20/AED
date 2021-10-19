package es.iespuertodelacruz.adrian.foro.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		// TODO Auto-generated method stub
		ArrayList<String> lista = (ArrayList<String>) request.getServletContext().getAttribute("mensajes");
		if (lista == null) {
			lista = new ArrayList<String>();
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
		 Cookie[] cookie=request.getCookies();

		 HashMap<String, String> cookiesNombre = (HashMap<String, String>) request.getServletContext().getAttribute("cookiesNombre");
			if (cookiesNombre == null) {
				cookiesNombre = new HashMap<String, String>();
				request.getServletContext().setAttribute("cookiesNombre", cookiesNombre);
			}
		
	
		String nombre="" ;
		if(cookiesNombre.containsKey(cookie[0].getValue()) ) {
			nombre = cookiesNombre.get(cookie[0].getValue());
		}else {
			nombre=request.getParameter("nombre");
			cookiesNombre.put(cookie[0].getValue(),request.getParameter("nombre"));
			request.getServletContext().setAttribute("cookiesNombre", cookiesNombre);
		}

		String mensaje = request.getParameter("mensaje");

		
		ArrayList<String> lista = (ArrayList<String>) request.getServletContext().getAttribute("mensajes");

		lista.add(nombre + " : " + mensaje);

		request.getServletContext().setAttribute("mensajes", lista);
		 
		request.getRequestDispatcher("viewforo.jsp").forward(request, response);

	}

}

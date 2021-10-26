package es.iespuertodelacruz.adrian.acertarnumero.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.iespuertodelacruz.adrian.acertarnumero.modelo.Jugador;
import es.iespuertodelacruz.adrian.acertarnumero.modelo.Secreto;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nickParameter = (String) request.getSession().getAttribute("nick");
		if (nickParameter == null) {
			request.getRequestDispatcher("crearusuario.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("jugar.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ArrayList <Jugador> listaJugadores=(ArrayList<Jugador>) request.getServletContext().getAttribute("listaJugadores");	
		if (listaJugadores==null){
			listaJugadores= new ArrayList<Jugador>();
			request.getServletContext().setAttribute("listaJugadores", listaJugadores);
		}
		
		String nickParameter = (String) request.getSession().getAttribute("nick");
		if (nickParameter == null) {
			String nick = request.getParameter("nick");
			if (nick != null && !nick.isEmpty()) {
				request.getSession().setAttribute("nick", nick);
				request.getRequestDispatcher("jugar.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("crearusuario.jsp").forward(request, response);
			}
		}else apostarNumero(request, response);
	
		response.sendRedirect("Principal");
	}

	public void apostarNumero(HttpServletRequest request, HttpServletResponse response) {
		
		ArrayList <Jugador> listaJugadores=(ArrayList<Jugador>) request.getServletContext().getAttribute("listaJugadores");	
		Secreto secretoParameter = (Secreto) request.getServletContext().getAttribute("secreto");		
		Jugador jugador = (Jugador) request.getSession().getAttribute("jugador");
		System.out.println(secretoParameter.getNum());

		if (jugador == null) {
			jugador = new Jugador();
			String nickParameter = (String) request.getSession().getAttribute("nick");
			jugador.setNick(nickParameter);
			request.getSession().setAttribute("jugador", jugador);
			listaJugadores.add(jugador);
		
		}

		Date fecha = new Date();
		Integer apuesta = Integer.parseInt(request.getParameter("apuesta"));
		jugador.getListaApuestas().put(fecha, apuesta);
		
		if(jugador.getListaApuestas().containsValue(secretoParameter.getNum())) {
			
			for (Jugador player : listaJugadores) {
				player.clearListaApuestas(fecha);
			}
			System.out.println("Acertaste! Secreto="+secretoParameter.getNum() );
			Secreto secreto = new Secreto();
			request.getServletContext().setAttribute("secreto", secreto);
			
		}

	}

}

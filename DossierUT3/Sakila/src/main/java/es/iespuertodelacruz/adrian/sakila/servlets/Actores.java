package es.iespuertodelacruz.adrian.sakila.servlets;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.iespuertodelacruz.adrian.sakila.repositories.ActorRepository;
import es.iespuertodelacruz.adrian.sakila.entities.Actor;
import es.iespuertodelacruz.adrian.sakila.entities.Film;


/**
 * Servlet implementation class Actores
 */
public class Actores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Actores() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		EntityManagerFactory emf =(EntityManagerFactory)request.getServletContext().getAttribute("emf");
		ActorRepository actorR = new ActorRepository(emf);
	

			List<Actor>actores = actorR.findAll();
			request.getSession().setAttribute("actores", actores);
			String	redirect="user/listado_actores.jsp";
		

		response.sendRedirect(redirect);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

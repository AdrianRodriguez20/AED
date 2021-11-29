package es.iespuertodelacruz.adrian.sakila.servlets;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.iespuertodelacruz.adrian.sakila.entities.Film;
import es.iespuertodelacruz.adrian.sakila.repositories.ActorRepository;
import es.iespuertodelacruz.adrian.sakila.repositories.CategoryRepository;
import es.iespuertodelacruz.adrian.sakila.repositories.FilmRepository;

/**
 * Servlet implementation class Pelicula
 */
public class Pelicula extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pelicula() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		EntityManagerFactory emf =(EntityManagerFactory)request.getServletContext().getAttribute("emf");
		FilmRepository filmR = new FilmRepository(emf);
	
		String redirect="";
		if (request.getParameter("film")!=null) {
			int filmId = Integer.parseInt(request.getParameter("film"));
			Film pelicula = filmR.findById((short) filmId);
			request.getSession().setAttribute("pelicula", pelicula);
			redirect="pelicula.jsp";
		
		
		}else if(request.getParameter("actor")!=null) {
			ActorRepository actorR = new ActorRepository(emf);
			int actorId = Integer.parseInt(request.getParameter("actor"));
			List<Film> peliculas = actorR.findFilmsByActor((short) actorId);
			request.getSession().setAttribute("peliculas", peliculas);
			redirect = "listado_peliculas.jsp";

		}else if (request.getParameter("categoria")!=null) {
			CategoryRepository categoryR = new CategoryRepository(emf);
			int categoryId = Integer.parseInt(request.getParameter("categoria"));
			List<Film> peliculas = categoryR.findFilmsByCategory((short) categoryId);
			request.getSession().setAttribute("peliculas", peliculas);
			redirect = "listado_peliculas.jsp";
		}else  {
			List<Film>peliculas = filmR.findAll();
			request.getSession().setAttribute("peliculas", peliculas);
			redirect="user/listado_peliculas.jsp";

		}
		
		response.sendRedirect(redirect);
	}


}

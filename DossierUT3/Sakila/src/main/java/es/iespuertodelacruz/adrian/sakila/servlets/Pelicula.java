package es.iespuertodelacruz.adrian.sakila.servlets;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.iespuertodelacruz.adrian.sakila.entities.Film;
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
		
		
		}else {
			List<Film>peliculas = filmR.findAll();
			request.getSession().setAttribute("peliculas", peliculas);
			redirect="user/listado_peliculas.jsp";
		
		}

	//	request.getRequestDispatcher("/user/listado_peliculas.jsp").forward(request, response);
		response.sendRedirect(redirect);
	}


}

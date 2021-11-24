package es.iespuertodelacruz.adrian.sakila.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.iespuertodelacruz.adrian.sakila.entities.Film;
import es.iespuertodelacruz.adrian.sakila.repositories.FilmRepository;
import es.iespuertodelacruz.adrian.sakila.repositories.StaffRepository;

/**
 * Servlet implementation class GestionPeliculas
 */
public class GestionPeliculas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionPeliculas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EntityManagerFactory emf =(EntityManagerFactory)request.getServletContext().getAttribute("emf");
		FilmRepository filmR = new FilmRepository(emf);
		List<Film>peliculas = filmR.findAll();
		request.getSession().setAttribute("peliculas", peliculas);
	//	request.getRequestDispatcher("/user/listado_peliculas.jsp").forward(request, response);
		response.sendRedirect("user/listado_peliculas.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

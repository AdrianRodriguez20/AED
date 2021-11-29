package es.iespuertodelacruz.adrian.sakila.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.iespuertodelacruz.adrian.sakila.entities.*;
import es.iespuertodelacruz.adrian.sakila.repositories.*;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;

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
		EntityManagerFactory emf =(EntityManagerFactory)request.getServletContext().getAttribute("emf");
		FilmRepository filmR = new FilmRepository(emf);
		ActorRepository actorR = new ActorRepository(emf);
		CategoryRepository categoryR = new CategoryRepository(emf);
		LanguageRepository languageR = new LanguageRepository(emf);

		String redirect="";
		if (request.getParameter("film")!=null) {

			List<Actor>actors = actorR.findAll();
			request.getSession().setAttribute("actors", actors);
			List<Category>categories = categoryR.findAll();
			request.getSession().setAttribute("categories", categories);
			List<Language>languages = languageR.findAll();
			request.getSession().setAttribute("languages", languages);

			int filmId = Integer.parseInt(request.getParameter("film"));
			Film pelicula = filmR.findById((short) filmId);
			request.getSession().setAttribute("pelicula", pelicula);
			redirect="update_peliculas.jsp";

		
		}else if (request.getParameter("create")!=null) {
			List<Actor>actors = actorR.findAll();
			request.getSession().setAttribute("actors", actors);
			List<Category>categories = categoryR.findAll();
			request.getSession().setAttribute("categories", categories);
			List<Language>languages = languageR.findAll();
			request.getSession().setAttribute("languages", languages);
			redirect="insert_peliculas.jsp";
			
		}else if (request.getParameter("getAll")!=null) {
			List<Film>peliculas = filmR.findAll();
			request.getSession().setAttribute("peliculas", peliculas);
			redirect="admin/listado_peliculas.jsp";
		
		}

		response.sendRedirect(redirect);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String valuePelicula = request.getParameter("submit");


		switch (valuePelicula) {
			case "insertar":
				agregarPelicula(request, response);
				break;
			case "editar":
				editarPelicula(request, response);
				break;
			case "borrar":
				eliminarPelicula(request, response);
				break;
			case "buscar":
				//buscarPelicula(request, response);
				break;
			default:
				break;
		}
	}


	private void agregarPelicula(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String titulo = request.getParameter("title");
		String descripcion = request.getParameter("description");
		String releaseYear = request.getParameter("releaseYear");
		String languageId = request.getParameter("languageId");
		String length = request.getParameter("length");
		String[] actores = request.getParameterValues("actors");
		String[] categorias = request.getParameterValues("categories");


		if(titulo!=null && !titulo.isEmpty() &&
				descripcion!=null && !descripcion.isEmpty() &&
				releaseYear!=null && !releaseYear.isEmpty() &&
				languageId!=null && !languageId.isEmpty() &&
				length!=null && !length.isEmpty() &&  actores!=null &&
				actores.length>0 &&  categorias!=null &&  categorias.length>0 ) {

			EntityManagerFactory emf =(EntityManagerFactory)request.getServletContext().getAttribute("emf");
			FilmRepository filmR = new FilmRepository(emf);

			Film pelicula = new Film();
			pelicula.setTitle(titulo);
			pelicula.setDescription(descripcion);
			pelicula.setReleaseYear(releaseYear);
			pelicula.setLanguageId(new Language((short)Integer.parseInt(languageId)));
			pelicula.setOriginalLanguageId(null);
			pelicula.setRentalDuration((short) 7);
			pelicula.setRentalRate(new java.math.BigDecimal(1));
			pelicula.setLength((short) Integer.parseInt(length));
			pelicula.setReplacementCost(new java.math.BigDecimal(10.99));
			pelicula.setLastUpdate(new Date());

			List<FilmActor> actors = new ArrayList<>(actores.length);

			for (String actorId : actores) {
				actors.add(new FilmActor(new FilmActorPK((short) Integer.parseInt(actorId),(short) 0),new Date()));
			}

			List<FilmCategory> categories = new ArrayList<>(categorias.length);

			for (String categoryId : categorias) {
				categories.add(new FilmCategory(new FilmCategoryPK((short) 0,(short) Integer.parseInt(categoryId)),new Date()));
			}

			pelicula.setFilmActorList(actors);
			pelicula.setFilmCategoryList(categories);
			pelicula.setInventoryList(null);

			filmR.save(pelicula);


		}

		response.sendRedirect("/sakila/GestionPeliculas?getAll=true");
	}

	private void editarPelicula(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String titulo = request.getParameter("title");
		String descripcion = request.getParameter("description");
		String releaseYear = request.getParameter("releaseYear");
		String languageId = request.getParameter("languageId");
		String length = request.getParameter("length");
		String[] actores = request.getParameterValues("actors");
		String[] categorias = request.getParameterValues("categories");
		String id = request.getParameter("id");


		if(titulo!=null && !titulo.isEmpty() &&
				descripcion!=null && !descripcion.isEmpty() &&
				releaseYear!=null && !releaseYear.isEmpty() &&
				languageId!=null && !languageId.isEmpty() &&
				length!=null && !length.isEmpty() &&  actores!=null &&
				actores.length>0 &&  categorias!=null &&  categorias.length>0 ) {

			EntityManagerFactory emf = (EntityManagerFactory) request.getServletContext().getAttribute("emf");
			FilmRepository filmR = new FilmRepository(emf);


			Film pelicula = new Film();
			pelicula.setFilmId((short) Integer.parseInt(id));
			pelicula.setTitle(titulo);
			pelicula.setDescription(descripcion);
			pelicula.setReleaseYear(releaseYear);
			pelicula.setLanguageId(new Language((short) Integer.parseInt(languageId)));
			pelicula.setOriginalLanguageId(null);
			pelicula.setRentalDuration((short) 7);
			pelicula.setRentalRate(new java.math.BigDecimal(1));
			pelicula.setLength((short) Integer.parseInt(length));
			pelicula.setReplacementCost(new java.math.BigDecimal(10.99));
			pelicula.setLastUpdate(new Date());

			List<FilmActor> actors = new ArrayList<>(actores.length);

			for (String actorId : actores) {
				actors.add(new FilmActor(new FilmActorPK((short) Integer.parseInt(actorId), (short) Integer.parseInt(id)), new Date()));
			}

			List<FilmCategory> categories = new ArrayList<>(categorias.length);

			for (String categoryId : categorias) {
				categories.add(new FilmCategory(new FilmCategoryPK((short) Integer.parseInt(id), (short) Integer.parseInt(categoryId)), new Date()));
			}

			pelicula.setFilmActorList(actors);
			pelicula.setFilmCategoryList(categories);
			pelicula.setInventoryList(null);

			filmR.update(pelicula);
		}
		
		response.sendRedirect("/sakila/GestionPeliculas?getAll=true");
	}

	private void eliminarPelicula(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		System.out.println("Id"+id);
		EntityManagerFactory emf = (EntityManagerFactory) request.getServletContext().getAttribute("emf");
		FilmRepository filmR = new FilmRepository(emf);
		filmR.delete((short) Integer.parseInt(id));

		response.sendRedirect("/sakila/GestionPeliculas?getAll=true");
    }


}

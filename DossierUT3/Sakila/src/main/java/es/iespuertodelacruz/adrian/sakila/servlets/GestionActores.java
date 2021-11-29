package es.iespuertodelacruz.adrian.sakila.servlets;

import es.iespuertodelacruz.adrian.sakila.entities.Actor;
import es.iespuertodelacruz.adrian.sakila.entities.Category;
import es.iespuertodelacruz.adrian.sakila.repositories.ActorRepository;
import es.iespuertodelacruz.adrian.sakila.repositories.CategoryRepository;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GestionActores
 */
public class GestionActores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionActores() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory emf =(EntityManagerFactory)request.getServletContext().getAttribute("emf");
		ActorRepository actorR = new ActorRepository(emf);
		String redirect="";

		if (request.getParameter("actor")!=null) {

			int actorId = Integer.parseInt(request.getParameter("actor"));
			Actor actor= actorR.findById((short) actorId);
			request.getSession().setAttribute("actor", actor);
			redirect="update_actores.jsp";


		}else if (request.getParameter("create")!=null) {

			redirect="insert_actores.jsp";

		}else if (request.getParameter("getAll")!=null) {
			List<Actor> actores = actorR.findAll();
			request.getSession().setAttribute("actores", actores);
			redirect="admin/listado_actores.jsp";

		}

		response.sendRedirect(redirect);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String valueActor = request.getParameter("submit");

		switch (valueActor) {
			case "insertar":
				agregarActor(request, response);
				break;
			case "editar":
				editarActor(request, response);
				break;
			case "borrar":
				eliminarActor(request, response);
				break;
			case "buscar":
				//buscarPelicula(request, response);
				break;
			default:
				break;
		}
	}

	private void eliminarActor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		EntityManagerFactory emf =(EntityManagerFactory)request.getServletContext().getAttribute("emf");
		ActorRepository actorR = new ActorRepository(emf);
		actorR.delete((short) Integer.parseInt(id));

		response.sendRedirect("/sakila/GestionActores?getAll=true");
	}

	private void editarActor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");

		if(id!=null && !id.trim().isEmpty() && nombre!=null && !nombre.trim().isEmpty() && apellidos!=null && !apellidos.trim().isEmpty()){
			EntityManagerFactory emf =(EntityManagerFactory)request.getServletContext().getAttribute("emf");
			ActorRepository actorR = new ActorRepository(emf);
			Actor actor = new Actor();
			actor.setActorId((short) Integer.parseInt(id));
			actor.setFirstName(nombre);
			actor.setLastName(apellidos);
			actor.setLastUpdate(new Date());
			actorR.update(actor);
		}
		response.sendRedirect("/sakila/GestionActores?getAll=true");
	}

	private void agregarActor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");

		if(nombre!=null && !nombre.isEmpty() && apellidos!=null && !apellidos.isEmpty()) {
			Actor actor = new Actor();
			actor.setFirstName(nombre);
			actor.setLastName(apellidos);
			actor.setLastUpdate(new Date());

			EntityManagerFactory emf =(EntityManagerFactory)request.getServletContext().getAttribute("emf");
			ActorRepository actorR = new ActorRepository(emf);

			actorR .save(actor);


		}
		response.sendRedirect("/sakila/GestionActores?getAll=true");
	}

}

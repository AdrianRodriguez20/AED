package es.iespuertodelacruz.adrian.sakila.servlets;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import es.iespuertodelacruz.adrian.sakila.entities.Category;
import es.iespuertodelacruz.adrian.sakila.repositories.CategoryRepository;


/**
 * Servlet implementation class GestionCategorias
 */
public class GestionCategorias extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionCategorias() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EntityManagerFactory emf =(EntityManagerFactory)request.getServletContext().getAttribute("emf");
		CategoryRepository categoryR = new CategoryRepository(emf);
		String redirect="";

		if (request.getParameter("categoria")!=null) {

			int categoriaId = Integer.parseInt(request.getParameter("categoria"));
			Category category= categoryR.findById((short) categoriaId);
			request.getSession().setAttribute("categoria", category);
			redirect="update_categorias.jsp";

		
		}else if (request.getParameter("create")!=null) {

			redirect="insert_categorias.jsp";
			
		}else if (request.getParameter("getAll")!=null) {
			List<Category>categorias = categoryR.findAll();
			request.getSession().setAttribute("categorias", categorias);
			redirect="admin/listado_categorias.jsp";
		
		}

		response.sendRedirect(redirect);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String valueCategoria = request.getParameter("submit");


		switch (valueCategoria) {
			case "insertar":
				agregarCategoria(request, response);
				break;
			case "editar":
				editarCategoria(request, response);
				break;
			case "borrar":
				eliminarCategoria(request, response);
				break;
			case "buscar":
				//buscarPelicula(request, response);
				break;
			default:
				break;
		}
	}

	private void eliminarCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		EntityManagerFactory emf =(EntityManagerFactory)request.getServletContext().getAttribute("emf");
		CategoryRepository categoryR = new CategoryRepository(emf);
		categoryR.delete((short) Integer.parseInt(id));
		response.sendRedirect("/sakila/GestionCategorias?getAll=true");
	}

	private void editarCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");

		if(id!=null && !id.trim().isEmpty() && nombre!=null && !nombre.trim().isEmpty()) {
			EntityManagerFactory emf =(EntityManagerFactory)request.getServletContext().getAttribute("emf");
			CategoryRepository categoryR = new CategoryRepository(emf);
			Category category = new Category();
			category.setCategoryId((short) Integer.parseInt(id));
			category.setName(nombre);
			category.setLastUpdate(new Date());
			categoryR.update(category);
		}
		response.sendRedirect("/sakila/GestionCategorias?getAll=true");
	}

	private void agregarCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		if(nombre!=null && !nombre.isEmpty() ) {
			Category category = new Category();
			category.setName(nombre);
			category.setLastUpdate(new Date());
			EntityManagerFactory emf =(EntityManagerFactory)request.getServletContext().getAttribute("emf");
			CategoryRepository categoryR = new CategoryRepository(emf);

			categoryR.save(category);


		}
		response.sendRedirect("/sakila/GestionCategorias?getAll=true");
	}
	
	
	
	

}

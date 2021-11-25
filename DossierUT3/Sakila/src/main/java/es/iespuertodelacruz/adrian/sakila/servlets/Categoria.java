package es.iespuertodelacruz.adrian.sakila.servlets;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.iespuertodelacruz.adrian.sakila.entities.Category;
import es.iespuertodelacruz.adrian.sakila.repositories.CategoryRepository;



/**
 * Servlet implementation class Categoria
 */
public class Categoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Categoria() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EntityManagerFactory emf =(EntityManagerFactory)request.getServletContext().getAttribute("emf");
		CategoryRepository categoryR = new CategoryRepository(emf);
	
		String redirect="";
		if (request.getParameter("category")!=null) {
			int categoryId = Integer.parseInt(request.getParameter("category"));
			Category categoria = categoryR.findById((short) categoryId);
			request.getSession().setAttribute("categoria", categoria);
			redirect="categoria.jsp";
		
		
		}else {
			List<Category>categorias = categoryR.findAll();
			request.getSession().setAttribute("categorias", categorias);
			redirect="user/listado_categorias.jsp";
		
		}

	//	request.getRequestDispatcher("/user/listado_peliculas.jsp").forward(request, response);
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

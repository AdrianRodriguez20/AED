package es.iespuertodelacruz.adrian.sakila.servlets;

import java.io.IOException;
import java.util.Date;

import javax.persistence.EntityManagerFactory;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import es.iespuertodelacruz.adrian.sakila.entities.Address;
import es.iespuertodelacruz.adrian.sakila.entities.Staff;
import es.iespuertodelacruz.adrian.sakila.entities.Store;
import es.iespuertodelacruz.adrian.sakila.repositories.StaffRepository;

/**
 * Servlet implementation class Registro
 */
public class Registro extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Registro() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userParameter = request.getParameter("user");
		String passwParameter = request.getParameter("password");
		String passwConfParameter = request.getParameter("passwordConfirmation");

		if (userParameter != null && !userParameter.trim().isEmpty() && passwParameter != null
				&& !passwParameter.trim().isEmpty() && passwConfParameter != null
				&& !passwConfParameter.trim().isEmpty()) {
			if (passwParameter.equals(passwConfParameter)) {
				
				EntityManagerFactory emf =(EntityManagerFactory)request.getServletContext().getAttribute("emf");
				StaffRepository staffR = new StaffRepository(emf);
				
				String enHash = BCrypt.hashpw(passwParameter, BCrypt.gensalt(10));
				Staff staff = new Staff(null ,"Adrian","Rodríguez", false, userParameter, new Date());
				staff.setPassword(enHash);
				staff.setAddressId(new Address((short) 1));
				staff.setStoreId(new Store((short) 1));
				staffR.save(staff);
			}
		}

	}

}

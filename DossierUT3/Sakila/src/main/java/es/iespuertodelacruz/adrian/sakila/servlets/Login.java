package es.iespuertodelacruz.adrian.sakila.servlets;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;

import es.iespuertodelacruz.adrian.sakila.entities.Staff;
import es.iespuertodelacruz.adrian.sakila.repositories.StaffRepository;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Staff user = (Staff)session.getAttribute("user");
		String redirect = "inicio.html";
		if(user != null)
			redirect="admin/menu_admin.jsp";
		else {
			String paramUser = request.getParameter("user");
			String paramPassword = request.getParameter("password");
			EntityManagerFactory emf =(EntityManagerFactory)request.getServletContext().getAttribute("emf");
			StaffRepository staffR = new StaffRepository(emf);
			
			Staff staff = staffR.findByUser(paramUser);
			
			if(staff != null) {
				
				boolean okLogin = BCrypt.checkpw(paramPassword,staff.getPassword());

				if( okLogin) {
					request.getSession().setAttribute("staff", staff);
					redirect="admin/menu_admin.jsp";
				}
				
			}
		}
		response.sendRedirect(redirect);
	}

}

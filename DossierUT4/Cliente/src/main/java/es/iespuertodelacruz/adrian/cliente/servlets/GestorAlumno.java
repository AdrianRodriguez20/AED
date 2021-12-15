package es.iespuertodelacruz.adrian.cliente.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;

import org.glassfish.jersey.jackson.JacksonFeature;


/**
 * Servlet implementation class GestorAlumno
 */
public class GestorAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestorAlumno() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        cleanSession(request);
        request.getRequestDispatcher("alumno.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String valueAlumno = request.getParameter("submit");


        switch (valueAlumno) {
            case "agregar":
                agregarAlumno(request, response);
                break;
            case "editar":
                editarAlumno(request, response);
                break;
            case "borrar":
                borrarAlumno(request, response);
                break;
            case "buscar":
                buscarAlumno(request, response);
                break;
            default:
                break;
        }

        request.getRequestDispatcher("alumno.jsp").forward(request, response);
	}
	
	private void agregarAlumno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        cleanSession(request);
      
        String nombreParameter = request.getParameter("nombreAgregar");
        String apellidosParameter = request.getParameter("apellidosAgregar");
        String nacimientoParameter = request.getParameter("nacimientoAgregar");

     
    }

    private void editarAlumno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        cleanSession(request);
      

    }

    private void borrarAlumno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
    }

    private void buscarAlumno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        cleanSession(request);

        String dniParameter = request.getParameter("dniBuscar");
        String nombreParameter = request.getParameter("nombreBuscar");

        
        if (dniParameter != null && !dniParameter.trim().isEmpty()) {
        
       
        } else if (nombreParameter != null && !nombreParameter.trim().isEmpty()) {
          

        } else {
        	
            Client client = ClientBuilder.newBuilder()
                    .register(JacksonFeature.class)
                    .build();

            WebTarget target = client.target("http://localhost:8080/api/").path("/alumnos");
            String alumnos = target.request().get().readEntity(String.class);
            
            request.getSession().setAttribute("alumnos", alumnos);
            
        }
      
    }

    private void cleanSession(HttpServletRequest request){
        request.getSession().removeAttribute("alumno");
        request.getSession().removeAttribute("alumnos");
        request.getSession().removeAttribute("mensaje");
    }




}
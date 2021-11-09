package es.iespuertodelacruz.adrian.instituto.servlets;


import es.iespuertodelacruz.adrian.instituto.dao.AsignaturaDAO;
import es.iespuertodelacruz.adrian.instituto.dao.GestorConexionDDBB;
import es.iespuertodelacruz.adrian.instituto.modelo.Asignatura;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GestorAsignatura
 */
public class GestorAsignatura extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestorAsignatura() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.getRequestDispatcher("asignaturas.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String valueAsignatura = request.getParameter("submit");

        //switch para gestionar las opciones de la pagina
        switch (valueAsignatura) {
            case "agregar":
                agregarAsignatura(request, response);
                break;
            case "editar":
                editarAsignatura(request, response);
                break;
            case "borrar":
                borrarAsignatura(request, response);
                break;
            case "buscar":
                buscarAsignatura(request, response);
                break;
            default:
                break;
        }
        request.getRequestDispatcher("asignaturas.jsp").forward(request, response);

    }

    private void agregarAsignatura(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GestorConexionDDBB gc = (GestorConexionDDBB) request.getServletContext().getAttribute("gc");
        AsignaturaDAO asignaturaDAO = new AsignaturaDAO(gc);

        String nombreParameter = request.getParameter("nombreAgregar");
        String cursoParameter = request.getParameter("cursoAgregar");

        if(nombreParameter != null && nombreParameter.trim().isEmpty() && cursoParameter != null && cursoParameter.trim().isEmpty()){

            Asignatura asignatura = asignaturaDAO.save(new Asignatura(nombreParameter, cursoParameter));
            request.setAttribute("asignatura", asignatura);
        }


    }
    private void editarAsignatura(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GestorConexionDDBB gc = (GestorConexionDDBB) request.getServletContext().getAttribute("gc");
        AsignaturaDAO asignaturaDAO = new AsignaturaDAO(gc);

        String idParameter = request.getParameter("idEditar");
        String nombreParameter = request.getParameter("nombreEditar");
        String cursoParameter = request.getParameter("cursoEditar");

        if(idParameter != null && idParameter.trim().isEmpty()
                && nombreParameter != null && nombreParameter.trim().isEmpty()
                && cursoParameter != null && cursoParameter.trim().isEmpty()){
            asignaturaDAO.update(new Asignatura(Integer.parseInt(idParameter),nombreParameter, cursoParameter));
        }

    }
    private void borrarAsignatura(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GestorConexionDDBB gc = (GestorConexionDDBB) request.getServletContext().getAttribute("gc");
        AsignaturaDAO asignaturaDAO = new AsignaturaDAO(gc);

        String idParameter = request.getParameter("idBorrar");

        if(idParameter != null && idParameter.trim().isEmpty()){
            asignaturaDAO.delete(Integer.parseInt(idParameter));
        }

    }
    private void buscarAsignatura(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GestorConexionDDBB gc = (GestorConexionDDBB) request.getServletContext().getAttribute("gc");
        AsignaturaDAO asignaturaDAO = new AsignaturaDAO(gc);
        String idParameter = request.getParameter("idBuscar");
        String nombreParameter = request.getParameter("nombreBuscar");
        if(idParameter != null && idParameter.trim().isEmpty()){
            Asignatura asignatura = asignaturaDAO.findById(Integer.parseInt(idParameter));
        }else if(nombreParameter != null && nombreParameter.trim().isEmpty()){
            Asignatura asignatura = asignaturaDAO.findByNombre(nombreParameter);
        }else{
            ArrayList<Asignatura> asignatura = asignaturaDAO.findAll();
            request.setAttribute("asignatura", asignatura);
        }

    }





}


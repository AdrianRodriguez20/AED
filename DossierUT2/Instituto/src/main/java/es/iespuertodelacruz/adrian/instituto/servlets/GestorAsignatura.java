package es.iespuertodelacruz.adrian.instituto.servlets;


import es.iespuertodelacruz.adrian.instituto.dao.AsignaturaDAO;
import es.iespuertodelacruz.adrian.instituto.dao.GestorConexionDDBB;
import es.iespuertodelacruz.adrian.instituto.modelo.Asignatura;
import es.iespuertodelacruz.adrian.instituto.modelo.Mensaje;
import es.iespuertodelacruz.adrian.instituto.utils.Mensajes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

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
        request.getSession().setAttribute("mensaje", null);
        request.getSession().setAttribute("asignatura", null);
        request.getSession().setAttribute("asignaturas", null);
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

        if (nombreParameter != null && !nombreParameter.trim().isEmpty() && cursoParameter != null && !cursoParameter.trim().isEmpty()) {
        	Asignatura asignaturaPrev =new Asignatura(nombreParameter, cursoParameter);
            Asignatura asignatura = asignaturaDAO.save(asignaturaPrev);
            if (asignatura != null) {

                request.getSession().setAttribute("asignatura", asignatura);
                request.getSession().setAttribute("mensaje", new Mensaje(Mensajes.SUBJECT_SAVE_SUCCESS, Mensaje.tipoMensaje.SUCCESS));

            } else {
                if (asignaturaPrev.equals(asignaturaDAO.findEquals(nombreParameter, cursoParameter))) {
                    request.getSession().setAttribute("mensaje", new Mensaje(Mensajes.SUBJECT_SAVE_ERROR_DUPLICATE, Mensaje.tipoMensaje.ERROR));
                } else {
                    request.getSession().setAttribute("mensaje", new Mensaje(Mensajes.SUBJECT_SAVE_ERROR, Mensaje.tipoMensaje.ERROR));
                }
            }

        } else {
            request.getSession().setAttribute("mensaje", new Mensaje(Mensajes.SUBJECT_SAVE_INCOMPLETE, Mensaje.tipoMensaje.WARNING));
        }


    }

    private void editarAsignatura(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GestorConexionDDBB gc = (GestorConexionDDBB) request.getServletContext().getAttribute("gc");
        AsignaturaDAO asignaturaDAO = new AsignaturaDAO(gc);

        String idParameter = request.getParameter("idEditar");
        String nombreParameter = request.getParameter("nombreEditar");
        String cursoParameter = request.getParameter("cursoEditar");

        if (idParameter != null && !idParameter.trim().isEmpty()
                && nombreParameter != null && !nombreParameter.trim().isEmpty()
                && cursoParameter != null && !cursoParameter.trim().isEmpty()) {
            Asignatura asignatura = new Asignatura(Integer.parseInt(idParameter), nombreParameter, cursoParameter);
            boolean exito = asignaturaDAO.update(asignatura);
            if (exito) {
                request.getSession().setAttribute("mensaje", new Mensaje(Mensajes.SUBJECT_UPDATE_SUCCESS, Mensaje.tipoMensaje.SUCCESS));
            } else {
                if (asignaturaDAO.findById(Integer.parseInt(idParameter)) == null) {
                    request.getSession().setAttribute("mensaje", new Mensaje(Mensajes.SUBJECT_UPDATE_ERROR_NOT_FOUND, Mensaje.tipoMensaje.ERROR));
                } else if (asignatura.equals(asignaturaDAO.findEquals(nombreParameter, cursoParameter))) {
                    request.getSession().setAttribute("mensaje", new Mensaje(Mensajes.SUBJECT_UPDATE_ERROR_DUPLICATE, Mensaje.tipoMensaje.ERROR));
                } else {
                    request.getSession().setAttribute("mensaje", new Mensaje(Mensajes.SUBJECT_UPDATE_ERROR, Mensaje.tipoMensaje.ERROR));
                }
            }
        } else {
            request.getSession().setAttribute("mensaje", new Mensaje(Mensajes.SUBJECT_UPDATE_INCOMPLETE, Mensaje.tipoMensaje.WARNING));
        }

    }

    private void borrarAsignatura(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GestorConexionDDBB gc = (GestorConexionDDBB) request.getServletContext().getAttribute("gc");
        AsignaturaDAO asignaturaDAO = new AsignaturaDAO(gc);

        String idParameter = request.getParameter("idBorrar");

        if (idParameter != null && !idParameter.trim().isEmpty()) {
            boolean exito = asignaturaDAO.delete(Integer.parseInt(idParameter));

            if (exito) {
                request.getSession().setAttribute("mensaje", new Mensaje(Mensajes.SUBJECT_DELETE_SUCCESS, Mensaje.tipoMensaje.SUCCESS));
            } else {
                if (asignaturaDAO.findById(Integer.parseInt(idParameter)) == null) {
                    request.getSession().setAttribute("mensaje", new Mensaje(Mensajes.SUBJECT_DELETE_ERROR_NOT_FOUND, Mensaje.tipoMensaje.ERROR));
                } else {
                    request.getSession().setAttribute("mensaje", new Mensaje(Mensajes.SUBJECT_DELETE_ERROR, Mensaje.tipoMensaje.ERROR));
                }
            }
        } else {
            request.getSession().setAttribute("mensaje", new Mensaje(Mensajes.SUBJECT_DELETE_INCOMPLETE, Mensaje.tipoMensaje.WARNING));
        }


    }

    private void buscarAsignatura(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GestorConexionDDBB gc = (GestorConexionDDBB) request.getServletContext().getAttribute("gc");
        AsignaturaDAO asignaturaDAO = new AsignaturaDAO(gc);
        String idParameter = request.getParameter("idBuscar");
        String nombreParameter = request.getParameter("nombreBuscar");

        if (idParameter != null && !idParameter.trim().isEmpty()) {
            Asignatura asignatura = asignaturaDAO.findById(Integer.parseInt(idParameter));
            if (asignatura != null) {
                request.getSession().setAttribute("asignatura", asignatura);
                request.getSession().setAttribute("mensaje", new Mensaje(Mensajes.SUBJECT_FIND_SUCCESS, Mensaje.tipoMensaje.SUCCESS));
            }else{
                request.getSession().setAttribute("mensaje", new Mensaje(Mensajes.SUBJECT_FIND_NOT_FOUND, Mensaje.tipoMensaje.INFO));
            }

        } else if (nombreParameter != null && !nombreParameter.trim().isEmpty()) {
            Asignatura asignatura = asignaturaDAO.findByNombre(nombreParameter);

            if (asignatura != null) {
                request.getSession().setAttribute("asignatura", asignatura);
                request.getSession().setAttribute("mensaje", new Mensaje(Mensajes.SUBJECT_FIND_SUCCESS, Mensaje.tipoMensaje.SUCCESS));
            }else{
                request.getSession().setAttribute("mensaje", new Mensaje(Mensajes.SUBJECT_FIND_NOT_FOUND, Mensaje.tipoMensaje.INFO));
            }
        } else {
            ArrayList<Asignatura> asignaturas = asignaturaDAO.findAll();

            if (asignaturas != null) {
                request.getSession().setAttribute("asignaturas", asignaturas);
                request.getSession().setAttribute("mensaje", new Mensaje(Mensajes.SUBJECT_FIND_SUCCESS, Mensaje.tipoMensaje.SUCCESS));
            } else {
                request.getSession().setAttribute("mensaje", new Mensaje(Mensajes.SUBJECT_FIND_NOT_FOUND, Mensaje.tipoMensaje.INFO));
            }

        }

    }


}


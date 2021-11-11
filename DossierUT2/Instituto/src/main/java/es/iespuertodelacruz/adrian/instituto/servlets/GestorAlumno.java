package es.iespuertodelacruz.adrian.instituto.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.iespuertodelacruz.adrian.instituto.dao.AlumnoDAO;
import es.iespuertodelacruz.adrian.instituto.dao.GestorConexionDDBB;
import es.iespuertodelacruz.adrian.instituto.dao.MatriculaDAO;
import es.iespuertodelacruz.adrian.instituto.modelo.Alumno;
import es.iespuertodelacruz.adrian.instituto.modelo.Mensaje;
import es.iespuertodelacruz.adrian.instituto.utils.Mensajes;

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
        GestorConexionDDBB gc = (GestorConexionDDBB) request.getServletContext().getAttribute("gc");
        AlumnoDAO alumnoDao = new AlumnoDAO(gc);

        String nombreParameter = request.getParameter("nombreAgregar");
        String apellidosParameter = request.getParameter("apellidosAgregar");
        String nacimientoParameter = request.getParameter("nacimientoAgregar");

        String dniParameter = request.getParameter("dniAgregar");
        if (nombreParameter != null && !nombreParameter.trim().isEmpty() && dniParameter != null
                && !dniParameter.trim().isEmpty()) {

            Date fechaNacimiento= null;
            try {
                fechaNacimiento = new SimpleDateFormat("dd/MM/yyyy").parse(nacimientoParameter);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Alumno alumno = alumnoDao.save(new Alumno(dniParameter,nombreParameter, apellidosParameter, fechaNacimiento));

            if (alumno != null) {
                request.getSession().setAttribute("mensaje", new Mensaje(Mensajes.STUDENT_SAVE_SUCCESS, Mensaje.tipoMensaje.SUCCESS));
                request.getSession().setAttribute("alumno", alumno);
            }else{
                if (alumnoDao.findById(dniParameter) != null) {
                    request.getSession().setAttribute("mensaje", new Mensaje(Mensajes.STUDENT_SAVE_ERROR_DUPLICATE, Mensaje.tipoMensaje.ERROR));
                }else{
                    request.getSession().setAttribute("mensaje", new Mensaje(Mensajes.STUDENT_SAVE_ERROR, Mensaje.tipoMensaje.ERROR));
                }
            }


        }else{
            request.getSession().setAttribute("mensaje", new Mensaje(Mensajes.STUDENT_SAVE_INCOMPLETE, Mensaje.tipoMensaje.WARNING));
        }
    }

    private void editarAlumno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        cleanSession(request);
        GestorConexionDDBB gc = (GestorConexionDDBB) request.getServletContext().getAttribute("gc");
        AlumnoDAO alumnoDao = new AlumnoDAO(gc);

        String nombreParameter = request.getParameter("nombreEditar");
        String apellidosParameter = request.getParameter("apellidosEditar");
        String nacimientoParameter = request.getParameter("nacimientoEditar");
        String dniParameter = request.getParameter("dniEditar");

        if (nombreParameter != null && !nombreParameter.isEmpty() && dniParameter != null
                && !dniParameter.trim().isEmpty()) {

            Date fechaNacimiento= null;
            try {
                fechaNacimiento = new SimpleDateFormat("dd/MM/yyyy").parse(nacimientoParameter);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            boolean exito = alumnoDao.update(new Alumno(dniParameter,nombreParameter, apellidosParameter, fechaNacimiento));

            if (exito) {
                request.getSession().setAttribute("mensaje", new Mensaje(Mensajes.STUDENT_UPDATE_SUCCESS, Mensaje.tipoMensaje.SUCCESS));
            }else{
                if (alumnoDao.findById(dniParameter) == null) {
                    request.getSession().setAttribute("mensaje", new Mensaje(Mensajes.STUDENT_UPDATE_ERROR_NOT_FOUND, Mensaje.tipoMensaje.ERROR));
                }else {
                    request.getSession().setAttribute("mensaje", new Mensaje(Mensajes.STUDENT_UPDATE_ERROR, Mensaje.tipoMensaje.ERROR));
                }
            }
        }else{
            request.getSession().setAttribute("mensaje", new Mensaje(Mensajes.STUDENT_UPDATE_INCOMPLETE, Mensaje.tipoMensaje.WARNING));
        }

    }

    private void borrarAlumno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        cleanSession(request);
        GestorConexionDDBB gc = (GestorConexionDDBB) request.getServletContext().getAttribute("gc");
        AlumnoDAO alumnoDao = new AlumnoDAO(gc);

        String dniParameter = request.getParameter("dniBorrar");
        if (dniParameter != null && !dniParameter.trim().isEmpty()) {

          boolean exito =  alumnoDao.delete(dniParameter);
          if(exito){
              request.getSession().setAttribute("mensaje", new Mensaje(Mensajes.STUDENT_DELETE_SUCCESS, Mensaje.tipoMensaje.SUCCESS));
          }else{
              if(alumnoDao.findById(dniParameter) == null){
                  request.getSession().setAttribute("mensaje", new Mensaje(Mensajes.STUDENT_DELETE_ERROR_NOT_FOUND, Mensaje.tipoMensaje.ERROR));
              }else{
                  MatriculaDAO matriculaDao = new MatriculaDAO(gc);
                  if (matriculaDao.findByDni(dniParameter) != null) {
                      request.getSession().setAttribute("mensaje", new Mensaje(Mensajes.STUDENT_DELETE_ERROR_TUITION, Mensaje.tipoMensaje.ERROR));
                  }else{
                      request.getSession().setAttribute("mensaje", new Mensaje(Mensajes.STUDENT_DELETE_ERROR, Mensaje.tipoMensaje.ERROR));
                  }

              }
          }
        }
    }

    private void buscarAlumno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GestorConexionDDBB gc = (GestorConexionDDBB) request.getServletContext().getAttribute("gc");
        AlumnoDAO alumnoDao = new AlumnoDAO(gc);
        cleanSession(request);

        String dniParameter = request.getParameter("dniBuscar");
        String nombreParameter = request.getParameter("nombreBuscar");

        if (dniParameter != null && !dniParameter.trim().isEmpty()) {
            Alumno alumno = alumnoDao.findById(dniParameter);
            if(alumno!=null){
                request.getSession().setAttribute("alumno", alumno);
                request.getSession().setAttribute("mensaje", new Mensaje(Mensajes.STUDENT_FIND_SUCCESS, Mensaje.tipoMensaje.SUCCESS));
            }else{
                request.getSession().setAttribute("mensaje", new Mensaje(Mensajes.STUDENT_FIND_ERROR_NOT_FOUND, Mensaje.tipoMensaje.INFO));
            }
        } else if (nombreParameter != null && !nombreParameter.trim().isEmpty()) {
            List<Alumno> alumnos = alumnoDao.findByNombre(nombreParameter);
            if(alumnos!=null){
                request.getSession().setAttribute("alumnos", alumnos);
                request.getSession().setAttribute("mensaje", new Mensaje(Mensajes.STUDENT_FIND_SUCCESS, Mensaje.tipoMensaje.SUCCESS));
            }else{
                request.getSession().setAttribute("mensaje", new Mensaje(Mensajes.STUDENT_FIND_ERROR_NOT_FOUND, Mensaje.tipoMensaje.INFO));
            }
        } else {
            List<Alumno> alumnos = alumnoDao.findAll();
            if(alumnos!=null){
                request.getSession().setAttribute("alumnos", alumnos);
                request.getSession().setAttribute("mensaje", new Mensaje(Mensajes.STUDENT_FIND_SUCCESS, Mensaje.tipoMensaje.SUCCESS));
            }else{
                request.getSession().setAttribute("mensaje", new Mensaje(Mensajes.STUDENT_FIND_ERROR_NOT_FOUND, Mensaje.tipoMensaje.INFO));
            }
        }
    }

    private void cleanSession(HttpServletRequest request){
        request.getSession().removeAttribute("alumno");
        request.getSession().removeAttribute("alumnos");
        request.getSession().removeAttribute("mensaje");
    }




}

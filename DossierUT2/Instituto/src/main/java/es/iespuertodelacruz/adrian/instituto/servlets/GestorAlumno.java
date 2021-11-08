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
import es.iespuertodelacruz.adrian.instituto.modelo.Alumno;

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
        request.getRequestDispatcher("alumno.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getSession().setAttribute("alumno", null);
        request.getSession().setAttribute("alumnos", null);
        GestorConexionDDBB gc = (GestorConexionDDBB) request.getServletContext().getAttribute("gc");
        AlumnoDAO alumnoDao = new AlumnoDAO(gc);
        String agregarParameter = request.getParameter("agregar");
        String editarParameter = request.getParameter("editar");
        String borrarParameter = request.getParameter("borrar");
        String buscarParameter = request.getParameter("buscar");

        if (agregarParameter != null) {

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

                request.getSession().setAttribute("alumno", alumno);

            }
        }

        if (editarParameter != null) {

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
               alumnoDao.update(new Alumno(dniParameter,nombreParameter, apellidosParameter, fechaNacimiento));
            }
        }

        if (borrarParameter != null) {
            String dniParameter = request.getParameter("dniBorrar");
            if (dniParameter != null && !dniParameter.trim().isEmpty()) {

                alumnoDao.delete(dniParameter);
            }

        }

        if (buscarParameter != null) {
            String dniParameter = request.getParameter("dniBuscar");
            String nombreParameter = request.getParameter("nombreBuscar");

            if (dniParameter != null && !dniParameter.trim().isEmpty()) {
                Alumno alumno = alumnoDao.findById(dniParameter);
                if(alumno!=null){
                    request.getSession().setAttribute("alumno", alumno);
                }
            } else if (nombreParameter != null && !nombreParameter.trim().isEmpty()) {
                List<Alumno> alumnos = alumnoDao.findByNombre(nombreParameter);
                if(alumnos!=null){
                    request.getSession().setAttribute("alumnos", alumnos);
                }
            } else {
                List<Alumno> alumnos = alumnoDao.findAll();
                if(alumnos!=null){
                    request.getSession().setAttribute("alumnos", alumnos);
                }
            }

        }
        request.getRequestDispatcher("alumno.jsp").forward(request, response);
    }

}

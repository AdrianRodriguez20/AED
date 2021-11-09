package es.iespuertodelacruz.adrian.instituto.servlets;

import es.iespuertodelacruz.adrian.instituto.dao.AlumnoDAO;
import es.iespuertodelacruz.adrian.instituto.dao.AsignaturaDAO;
import es.iespuertodelacruz.adrian.instituto.dao.GestorConexionDDBB;
import es.iespuertodelacruz.adrian.instituto.dao.MatriculaDAO;
import es.iespuertodelacruz.adrian.instituto.modelo.Alumno;
import es.iespuertodelacruz.adrian.instituto.modelo.Asignatura;
import es.iespuertodelacruz.adrian.instituto.modelo.Matricula;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GestorMatricula
 */
public class GestorMatricula extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestorMatricula() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("matriculas.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String valueMatricula = request.getParameter("submit");


        switch (valueMatricula) {
            case "agregar":
                agregarMatricula(request, response);
                break;
            case "editar":
                editarMatricula(request, response);
                break;
            case "borrar":
                borrarMatricula(request, response);
                break;
            case "buscar":
                buscarMatricula(request, response);
                break;
            default:
                break;
        }


        request.getRequestDispatcher("matriculas.jsp").forward(request, response);
    }

    private void agregarMatricula(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("matricula", null);
        request.getSession().setAttribute("matriculas", null);
        GestorConexionDDBB gc = (GestorConexionDDBB) request.getServletContext().getAttribute("gc");
        MatriculaDAO matriculaDAO = new MatriculaDAO(gc);

        String dniParameter = request.getParameter("dniAgregar");
        String anioParameter = request.getParameter("anioAgregar");
        String asignaturasParameter = request.getParameter("asignaturasAgregar");

        String[] asignaturasStr = asignaturasParameter.split(",");
        if (dniParameter != null && !dniParameter.trim().isEmpty() && anioParameter != null
                && !anioParameter.trim().isEmpty() && asignaturasParameter != null
                && !asignaturasParameter.trim().isEmpty()) {

            AlumnoDAO alumnoDAO = new AlumnoDAO(gc);
            AsignaturaDAO asignaturaDAO = new AsignaturaDAO(gc);

            Alumno alumno = alumnoDAO.findById(dniParameter);

            if (alumno != null) {

                ArrayList<Asignatura> asignaturas = new ArrayList<>();

                for (String asignaturaStr : asignaturasStr) {
                    Asignatura asignatura = asignaturaDAO.findById(Integer.parseInt(asignaturaStr));
                    asignaturas.add(asignatura);

                }

                if (asignaturas.size() > 0) {
                    Matricula matricula = new Matricula(alumno, Integer.parseInt(anioParameter), asignaturas);
                    matricula = matriculaDAO.save(matricula);
                    request.getSession().setAttribute("matricula", matricula);
                }
            }

        }
    }

    private void editarMatricula(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GestorConexionDDBB gc = (GestorConexionDDBB) request.getServletContext().getAttribute("gc");
        MatriculaDAO matriculaDAO = new MatriculaDAO(gc);

        String idParameter = request.getParameter("idMatriculaEditar");
        String dniParameter = request.getParameter("dniEditar");
        String anioParameter = request.getParameter("anioEditar");
        String asignaturasParameter = request.getParameter("asignaturasEditar");


        if (idParameter != null && !idParameter.trim().isEmpty()
                && dniParameter != null && !dniParameter.trim().isEmpty()
                && anioParameter != null && !anioParameter.trim().isEmpty()
                && asignaturasParameter != null && !asignaturasParameter.trim().isEmpty()) {

            String[] asignaturasStr = asignaturasParameter.split(",");
            AlumnoDAO alumnoDAO = new AlumnoDAO(gc);
            AsignaturaDAO asignaturaDAO = new AsignaturaDAO(gc);

            Alumno alumno = alumnoDAO.findById(dniParameter);

            if (alumno != null) {

                ArrayList<Asignatura> asignaturas = new ArrayList<>();

                for (String asignaturaStr : asignaturasStr) {
                    Asignatura asignatura = asignaturaDAO.findById(Integer.parseInt(asignaturaStr));
                    asignaturas.add(asignatura);

                }

                if (asignaturas.size() > 0) {
                    Matricula matricula = new Matricula(Integer.parseInt(idParameter), alumno, Integer.parseInt(anioParameter), asignaturas);
                    System.out.println(matricula);
                    matriculaDAO.update(matricula);

                }
            }
        }
    }

    private void borrarMatricula(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GestorConexionDDBB gc = (GestorConexionDDBB) request.getServletContext().getAttribute("gc");
        MatriculaDAO matriculaDAO = new MatriculaDAO(gc);

        String idParameter = request.getParameter("idMatriculaBorrar");
        if (idParameter != null && !idParameter.trim().isEmpty()) {
            matriculaDAO.delete(Integer.parseInt(idParameter));
        }
    }

    private void buscarMatricula(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("matricula", null);
        request.getSession().setAttribute("matriculas", null);
        GestorConexionDDBB gc = (GestorConexionDDBB) request.getServletContext().getAttribute("gc");
        MatriculaDAO matriculaDAO = new MatriculaDAO(gc);

        String anioParameter = request.getParameter("anioBuscar");
        String dniParameter = request.getParameter("dniBuscar");

        if (anioParameter != null && !anioParameter.trim().isEmpty() && dniParameter != null
                && !dniParameter.trim().isEmpty()) {

            Matricula matricula = matriculaDAO.findById(dniParameter, Integer.parseInt(anioParameter));
            if (matricula != null) {
                request.getSession().setAttribute("matricula", matricula);
            }

        } else if (anioParameter != null && !anioParameter.trim().isEmpty()) {

            ArrayList<Matricula> matriculas = matriculaDAO.findByAnio(Integer.parseInt(anioParameter));
            if (matriculas != null) {
                request.getSession().setAttribute("matriculas", matriculas);
            }

        } else if (dniParameter != null && !dniParameter.trim().isEmpty()) {

            ArrayList<Matricula> matriculas = matriculaDAO.findByDni(dniParameter);
            if (matriculas != null) {
                request.getSession().setAttribute("matriculas", matriculas);
            }

        } else {

            ArrayList<Matricula> matriculas = matriculaDAO.findAll();
            if (matriculas != null) {
                request.getSession().setAttribute("matriculas", matriculas);
            }

        }
    }

}

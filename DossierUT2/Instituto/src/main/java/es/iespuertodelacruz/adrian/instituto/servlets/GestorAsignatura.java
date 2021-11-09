package es.iespuertodelacruz.adrian.instituto.servlets;

import java.io.IOException;
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


    }

    private void agregarAsignatura(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private void editarAsignatura(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private void borrarAsignatura(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private void buscarAsignatura(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }





}


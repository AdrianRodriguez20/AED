package es.iespuertodelacruz.adrian.instituto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import es.iespuertodelacruz.adrian.instituto.modelo.Alumno;

public class AlumnoDAO implements Crud<Alumno, String> {

    GestorConexionDDBB gc;

    public AlumnoDAO(GestorConexionDDBB gc) {
        this.gc = gc;
    }

    public Alumno save(Alumno dao) {

        String sql = "INSERT INTO alumnos (dni,nombre, apellidos, fechanacimiento) VALUES(?,?,?,?)";

        Alumno alumno = null;
        try (Connection conn = gc.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, dao.getDni());
            pstmt.setString(2, dao.getNombre());

            if(dao.getApellidos()!=null && !dao.getApellidos().isEmpty()){
                pstmt.setString(3, dao.getApellidos());
                
            }else{
                pstmt.setNull(3, java.sql.Types.VARCHAR);
            }

            if (dao.getFechanacimiento() != null && dao.getFechanacimiento().getTime()>0) {
                pstmt.setLong(4, dao.getFechanacimiento().getTime());
            } else {
                pstmt.setNull(4, java.sql.Types.DATE);
            }

            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                Date fechaNacimiento = null;
                if (dao.getFechanacimiento() != null) {
                    fechaNacimiento =new Date(dao.getFechanacimiento().getTime());
                }
                alumno = new Alumno(dao.getDni(), dao.getNombre(), dao.getApellidos(),fechaNacimiento);
            }
        } catch (SQLException e) {
            System.out.println("Se ha producido un error almacenando en la BBDD:" + e.getMessage());
        }

        return alumno;
    }

    public Alumno findById(String id) {


        String sql = "SELECT dni,nombre, apellidos, fechanacimiento FROM alumnos WHERE  dni = ?";

        ArrayList<Alumno> alumnos = null;
        try (Connection conn = gc.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);

            ResultSet resultSet = pstmt.executeQuery();
            alumnos = resultSetToList(resultSet);
        } catch (SQLException e) {
            System.out.println("Se ha producido un error realizando la consulta en la BBDD:" + e.getMessage());
        }

        if (alumnos != null && alumnos.size() > 0) {
            return alumnos.get(0);
        } else {

            return null;
        }
    }

    public ArrayList<Alumno> findByNombre(String nombre) {

        String sql = "SELECT dni,nombre, apellidos, fechanacimiento FROM alumnos WHERE  nombre = ?";

        ArrayList<Alumno> alumnos = null;
        try (Connection conn = gc.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);

            ResultSet resultSet = pstmt.executeQuery();
            alumnos = resultSetToList(resultSet);
        } catch (SQLException e) {
            System.out.println("Se ha producido un error realizando la consulta en la BBDD:" + e.getMessage());
        }
        return alumnos;
    }

    public boolean update(Alumno dao) {

        String sql = "UPDATE alumnos SET nombre = ?, apellidos = ? , fechanacimiento = ? WHERE dni= ?";
        Boolean exito = false;

        try (Connection conn = gc.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, dao.getNombre());

            if(dao.getApellidos()!=null && !dao.getApellidos().trim().isEmpty()){
                pstmt.setString(2, dao.getApellidos());
            }else{
                pstmt.setNull(2, java.sql.Types.VARCHAR);
            }
            if (dao.getFechanacimiento() != null) {
                pstmt.setLong(3, dao.getFechanacimiento().getTime());
            } else {
                pstmt.setNull(3, java.sql.Types.DATE);
            }
            pstmt.setString(4, dao.getDni());
            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {

                exito = true;
            }

        } catch (SQLException e) {
            System.out.println("Se ha producido un error actualizando en la BBDD:" + e.getMessage());
        }

        return exito;
    }

    public boolean delete(String id) {

        String sql = "DELETE FROM alumnos  WHERE  dni = ?";
        Boolean exito = false;
        try (Connection conn = gc.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);

            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                exito = true;
            }

        } catch (SQLException e) {
            System.out.println("Se ha producido un error eliminando en la BBDD:" + e.getMessage());
        }

        return exito;
    }

    public ArrayList<Alumno> findAll() {

        ArrayList<Alumno> alumnos = new ArrayList<Alumno>();

        String sql = "SELECT dni,nombre, apellidos, fechanacimiento FROM alumnos";

        try {
            Connection conn = gc.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet resultSet = pstmt.executeQuery();
            alumnos = resultSetToList(resultSet);

        } catch (SQLException e) {
            System.out.println("Se ha producido un error realizando la consulta en la BBDD:" + e.getMessage());
        }
        return alumnos;
    }

    /*
     * Funcion que transforma un resultSet en una lista de alumnos
     * @param resultSet
     * @return
     */

    static ArrayList<Alumno> resultSetToList(ResultSet resultSet) {
        ArrayList<Alumno> alumnos = new ArrayList<Alumno>();

        try {
            while (resultSet.next()) {
                alumnos.add(
                        new Alumno(
                                resultSet.getString(1),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                new Date(resultSet.getLong(4))
                        ));
            }
        } catch (SQLException sqlException) {
            System.out.println("Se ha producido un error transformando los datos de la consulta:" + sqlException.getMessage());

        }

        return alumnos;
    }


}
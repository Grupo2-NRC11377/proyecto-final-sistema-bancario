package repositorio;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.time.LocalDateTime;
import conexión.ConexiónMySQL;
import modelo.Cliente;
import modelo.Empleado;
import modelo.Solicitud;
import modelo.Transaccion;

public class RepositorioSolicitud {
	public static ArrayList<Solicitud> getSolicituds() {
		Connection connection = null;
    	CallableStatement callableStatement = null;
        ArrayList<Solicitud> solicitudes = new ArrayList<>();
        try {
        	connection = ConexiónMySQL.getconexión();
        	callableStatement = connection.prepareCall("{CALL sp_listarSolicitud()}");
            ResultSet rs = callableStatement.executeQuery();
            Solicitud solicitud;
            while (rs.next()) {
            	Cliente cliente = new Cliente();
            	Empleado empleado = new Empleado();
                cliente.setIdPersona(rs.getString("id_persona"));
                empleado.setIdPersona(rs.getString("id_empleado"));
                cliente.setDni(rs.getString("dni"));
                cliente.setNombres(rs.getString("nombres"));
                cliente.setApellidos(rs.getString("apellidos"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setCorreo(rs.getString("correo"));
                cliente.setContraseña(rs.getString("contraseña"));
                solicitud = new Solicitud();
                solicitud.setIdSolicitud(rs.getString("id_solicitud"));
                solicitud.setFechaCreacion(rs.getDate("fecha_creacion").toLocalDate());
                solicitud.setFechaResolucion(rs.getDate("fecha_resolucion").toLocalDate());
                solicitud.setEstado(rs.getString("estado"));
                solicitud.setCliente(cliente);
                solicitud.setEmpleado(empleado);
                solicitudes.add(solicitud);
            }

        } catch (Exception e) {
            System.out.println("Error al listar las solicitudes: " + e);
        }
         return solicitudes;
        }
	public static boolean agregarSolicitud(Solicitud solicitud) {
        try (Connection cnx = ConexiónMySQL.getconexión();
             CallableStatement stmt = cnx.prepareCall("{CALL sp_insertarSolicitud(?, ?, ?, ?, ?, ?, ?)}")) {

            stmt.setString(1, solicitud.getIdSolicitud());
            stmt.setString(2, solicitud.getAsunto());
            stmt.setString(3, solicitud.getEstado());
            stmt.setDate(4, Date.valueOf(solicitud.getFechaCreacion()));
            stmt.setDate(5, Date.valueOf(solicitud.getFechaResolucion()));
            stmt.setString(6, solicitud.getCliente().getIdPersona());
            stmt.setString(8, solicitud.getEmpleado().getIdPersona());
            
            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error al insertar la transacción: " + e);
            return false;
        }
    }
	public static void eliminarSolicitud(String idSolicitud) {
    	Connection connection = null;
    	CallableStatement callableStatement = null;
        try {
        	String proceAlmacenado = "{CALL sp_eliminarSolicitud(?)}";
        	connection = ConexiónMySQL.getconexión();
        	callableStatement = connection.prepareCall(proceAlmacenado);
        	callableStatement.setString(1, idSolicitud);
        	callableStatement.executeQuery();
        } catch (Exception e) {
            System.out.println("Error al eliminar solicitud: " + e);
        }
	}
	public static void actualizarSolicitud(Solicitud solicitud) {
    	Connection connection = null;
    	CallableStatement callableStatement = null;
        try {
        	String proceAlmacenado = "{CALL sp_actualizarSolicitud(?, ?, ?)}";
        	connection = ConexiónMySQL.getconexión();
        	callableStatement = connection.prepareCall(proceAlmacenado);
        	callableStatement.setString(1, solicitud.getIdSolicitud());
        	callableStatement.setString(3, solicitud.getEstado());
        	callableStatement.setDate(5, Date.valueOf(solicitud.getFechaResolucion()));
        	callableStatement.executeQuery();
        } catch (Exception e) {
            System.out.println("Error al actualizar solicitud: " + e);
        }
	}
	public static Solicitud consultarSolicitud(String idSolicitud) {
    	Connection connection = null;
    	CallableStatement callableStatement = null;
    	ResultSet rs = null;
    	Solicitud solicitud = null;
        try {
        	String proceAlmacenado = "{CALL sp_consultarIdSolicitud(?)}";
        	connection = ConexiónMySQL.getconexión();
        	callableStatement = connection.prepareCall(proceAlmacenado);
        	callableStatement.setString(1, idSolicitud);
            rs = callableStatement.executeQuery();
            if (rs.next()) {
            	Cliente cliente = new Cliente();
            	Empleado empleado = new Empleado();
                cliente.setIdPersona(rs.getString("id_persona"));
                empleado.setIdPersona(rs.getString("id_empleado"));
                cliente.setDni(rs.getString("dni"));
                cliente.setNombres(rs.getString("nombres"));
                cliente.setApellidos(rs.getString("apellidos"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setCorreo(rs.getString("correo"));
                cliente.setContraseña(rs.getString("contraseña"));
                solicitud = new Solicitud();
                solicitud.setIdSolicitud(rs.getString("id_solicitud"));
                solicitud.setFechaCreacion(rs.getDate("fecha_creacion").toLocalDate());
                solicitud.setFechaResolucion(rs.getDate("fecha_resolucion").toLocalDate());
                solicitud.setEstado(rs.getString("estado"));
                solicitud.setCliente(cliente);
                solicitud.setEmpleado(empleado);
            }
        } catch (Exception e) {
            System.out.println("Error al consultar la solicitud: " + e);
        }
        return solicitud;
    }
	
}

package repositorio;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import conexión.ConexiónMySQL;
import modelo.Cliente;

public class RepositorioCliente {
	public static ArrayList<Cliente> listarCliente(){
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet resultSet = null;
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		try {
			String procedimientoAlmacenado = "{CALL sp_listarCliente()}";
			connection = ConexiónMySQL.getconexión();
			callableStatement = connection.prepareCall(procedimientoAlmacenado);
			resultSet = callableStatement.executeQuery();
			Cliente cliente;
			while (resultSet.next()) {
				cliente = new Cliente();
				cliente.setIdPersona(resultSet.getString("id_persona"));
                cliente.setDni(resultSet.getString("dni"));
                cliente.setNombres(resultSet.getString("nombres"));
                cliente.setApellidos(resultSet.getString("apellidos"));
                cliente.setTelefono(resultSet.getString("telefono"));
                cliente.setDireccion(resultSet.getString("direccion"));
                cliente.setCorreo(resultSet.getString("correo"));
                cliente.setContraseña(resultSet.getString("contraseña"));
                Timestamp fechaHoraBloqueo = resultSet.getTimestamp("fecha_hora_bloqueo");
                cliente.setFechaHoraBloqueo(fechaHoraBloqueo == null? null:fechaHoraBloqueo.toLocalDateTime());
				clientes.add(cliente);
			}
		} catch (Exception e) {
			System.out.println("Error al listar cliente: " + e);
		} finally {
			try {
				if(connection != null) connection.close();
				if(callableStatement != null) callableStatement.close();
				if(resultSet != null) resultSet.close();
			} catch (Exception e) {
				System.out.println("Error: " + e);
			}
		}
		return clientes;
	}
	public static void insertarCliente(Cliente cliente) {
		Connection connection = null;
		CallableStatement callableStatement = null;
		try {
			String procedimientoAlmacenado = "{CALL sp_insertarCliente(?,?,?,?,?,?,?,?,?)}";
			connection = ConexiónMySQL.getconexión();
			callableStatement = connection.prepareCall(procedimientoAlmacenado);
			callableStatement.setString(1, cliente.getIdPersona());
			callableStatement.setString(2, cliente.getDni());
			callableStatement.setString(3, cliente.getNombres());
			callableStatement.setString(4, cliente.getApellidos());
			callableStatement.setString(5, cliente.getTelefono());
			callableStatement.setString(6, cliente.getDireccion());
			callableStatement.setString(7, cliente.getCorreo());
			callableStatement.setString(8, cliente.getContraseña());
			callableStatement.setTimestamp(9, Timestamp.valueOf(cliente.getFechaHoraBloqueo()));
			callableStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al insertar cliente: " + e);
		} finally {
			try {
				if(connection != null) connection.close();
				if(callableStatement != null) callableStatement.close();
			} catch (Exception e) {
				System.out.println("Error: " + e);
			}
		}
	}
	public static void actualizarCliente(Cliente cliente) {
		Connection connection = null;
		CallableStatement callableStatement = null;
		try {
			String procedimientoAlmacenado = "{CALL sp_actualizarCliente(?,?,?,?,?,?,?,?,?)}";
			connection = ConexiónMySQL.getconexión();
			callableStatement = connection.prepareCall(procedimientoAlmacenado);
			callableStatement.setString(1, cliente.getIdPersona());
			callableStatement.setString(2, cliente.getDni());
			callableStatement.setString(3, cliente.getNombres());
			callableStatement.setString(4, cliente.getApellidos());
			callableStatement.setString(5, cliente.getTelefono());
			callableStatement.setString(6, cliente.getDireccion());
			callableStatement.setString(7, cliente.getCorreo());
			callableStatement.setString(8, cliente.getContraseña());
			callableStatement.setTimestamp(9, Timestamp.valueOf(cliente.getFechaHoraBloqueo()));
			callableStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al actualizar cliente: " + e);
		} finally {
			try {
				if(connection != null) connection.close();
				if(callableStatement != null) callableStatement.close();
			} catch (Exception e) {
				System.out.println("Error: " + e);
			}
		}
	}
	public static void eliminarCliente(String idPersona) {
    	Connection connection = null;
    	CallableStatement callableStatement = null;
        try {
        	String procedimientoAlmacenado = "{CALL sp_eliminarCliente(?)}";
        	connection = ConexiónMySQL.getconexión();
        	callableStatement = connection.prepareCall(procedimientoAlmacenado);
        	callableStatement.setString(1, idPersona);
        	callableStatement.executeQuery();
        } catch (Exception e) {
            System.out.println("Error al eliminar cliente: " + e);
        } finally {
			try {
				if(connection != null) connection.close();
				if(callableStatement != null) callableStatement.close();
			} catch (Exception e) {
				System.out.println("Error: " + e);
			}
		}
    }
	public static Cliente consultarIdCliente(String idPersona) {
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet resultSet = null;
		Cliente cliente = null;
		try {
			String procedimientoAlmacenado = "{CALL sp_consultarIdCliente(?)}";
			connection = ConexiónMySQL.getconexión();
			callableStatement = connection.prepareCall(procedimientoAlmacenado);
			callableStatement.setString(1, idPersona);
			resultSet = callableStatement.executeQuery();
			if (resultSet.next()) {
				cliente = new Cliente();
				cliente.setIdPersona(resultSet.getString("id_persona"));
                cliente.setDni(resultSet.getString("dni"));
                cliente.setNombres(resultSet.getString("nombres"));
                cliente.setApellidos(resultSet.getString("apellidos"));
                cliente.setTelefono(resultSet.getString("telefono"));
                cliente.setDireccion(resultSet.getString("direccion"));
                cliente.setCorreo(resultSet.getString("correo"));
                cliente.setContraseña(resultSet.getString("contraseña"));
                Timestamp fechaHoraBloqueo = resultSet.getTimestamp("fecha_hora_bloqueo");
                cliente.setFechaHoraBloqueo(fechaHoraBloqueo == null? null:fechaHoraBloqueo.toLocalDateTime());
			}
		} catch (Exception e) {
			System.out.println("Error al consultar id de cliente: " + e);
		} finally {
			try {
				if(connection != null) connection.close();
				if(callableStatement != null) callableStatement.close();
				if(resultSet != null) resultSet.close();
			} catch (Exception e) {
				System.out.println("Error: " + e);
			}
		}
		return cliente;
	}
	public static Cliente consultarClienteDni(String dni) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Cliente cliente = null;
		try {
			String consulta = "SELECT * FROM personas p "
					+ "INNER JOIN clientes c ON p.id_persona = c.id_cliente "
					+ "WHERE p.dni = ?;";
			connection = ConexiónMySQL.getconexión();
			preparedStatement = connection.prepareStatement(consulta);
			preparedStatement.setString(1, dni);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				cliente = new Cliente();
				cliente.setIdPersona(resultSet.getString("id_persona"));
                cliente.setDni(resultSet.getString("dni"));
                cliente.setNombres(resultSet.getString("nombres"));
                cliente.setApellidos(resultSet.getString("apellidos"));
                cliente.setTelefono(resultSet.getString("telefono"));
                cliente.setDireccion(resultSet.getString("direccion"));
                cliente.setCorreo(resultSet.getString("correo"));
                cliente.setContraseña(resultSet.getString("contraseña"));
                Timestamp fechaHoraBloqueo = resultSet.getTimestamp("fecha_hora_bloqueo");
                cliente.setFechaHoraBloqueo(fechaHoraBloqueo == null? null:fechaHoraBloqueo.toLocalDateTime());
			}
		} catch (Exception e) {
			System.out.println("Error al consultar cliente por dni: " + e);
		} finally {
			try {
				if(connection != null) connection.close();
				if(preparedStatement != null) preparedStatement.close();
				if(resultSet != null) resultSet.close();
			} catch (Exception e) {
				System.out.println("Error: " + e);
			}
		}
		return cliente;
	}
	public static Cliente consultarCliente(String correo) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Cliente cliente = null;
		try {
			String consulta = "SELECT * FROM personas p "
					+ "INNER JOIN clientes c ON p.id_persona = c.id_cliente "
					+ "WHERE p.correo = ?;";
			connection = ConexiónMySQL.getconexión();
			preparedStatement = connection.prepareStatement(consulta);
			preparedStatement.setString(1, correo);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				cliente = new Cliente();
				cliente.setIdPersona(resultSet.getString("id_persona"));
                cliente.setDni(resultSet.getString("dni"));
                cliente.setNombres(resultSet.getString("nombres"));
                cliente.setApellidos(resultSet.getString("apellidos"));
                cliente.setTelefono(resultSet.getString("telefono"));
                cliente.setDireccion(resultSet.getString("direccion"));
                cliente.setCorreo(resultSet.getString("correo"));
                cliente.setContraseña(resultSet.getString("contraseña"));
                Timestamp fechaHoraBloqueo = resultSet.getTimestamp("fecha_hora_bloqueo");
                cliente.setFechaHoraBloqueo(fechaHoraBloqueo == null? null:fechaHoraBloqueo.toLocalDateTime());
			}
		} catch (Exception e) {
			System.out.println("Error al consultar cliente por correo: " + e);
		} finally {
			try {
				if(connection != null) connection.close();
				if(preparedStatement != null) preparedStatement.close();
				if(resultSet != null) resultSet.close();
			} catch (Exception e) {
				System.out.println("Error: " + e);
			}
		}
		return cliente;
	}
	public static Cliente consultarCliente(String correo, String contraseña) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Cliente cliente = null;
		try {
			String consulta = "SELECT * FROM personas p "
					+ "INNER JOIN clientes c ON p.id_persona = c.id_cliente "
					+ "WHERE p.correo = ? AND p.contraseña = ?;";
			connection = ConexiónMySQL.getconexión();
			preparedStatement = connection.prepareStatement(consulta);
			preparedStatement.setString(1, correo);
			preparedStatement.setString(2, contraseña);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				cliente = new Cliente();
				cliente.setIdPersona(resultSet.getString("id_persona"));
                cliente.setDni(resultSet.getString("dni"));
                cliente.setNombres(resultSet.getString("nombres"));
                cliente.setApellidos(resultSet.getString("apellidos"));
                cliente.setTelefono(resultSet.getString("telefono"));
                cliente.setDireccion(resultSet.getString("direccion"));
                cliente.setCorreo(resultSet.getString("correo"));
                cliente.setContraseña(resultSet.getString("contraseña"));
                Timestamp fechaHoraBloqueo = resultSet.getTimestamp("fecha_hora_bloqueo");
                cliente.setFechaHoraBloqueo(fechaHoraBloqueo == null? null:fechaHoraBloqueo.toLocalDateTime());
			}
		} catch (Exception e) {
			System.out.println("Error al consultar cliente por correo y contraseña: " + e);
		} finally {
			try {
				if(connection != null) connection.close();
				if(preparedStatement != null) preparedStatement.close();
				if(resultSet != null) resultSet.close();
			} catch (Exception e) {
				System.out.println("Error: " + e);
			}
		}
		return cliente;
	}
	public static ArrayList<Cliente> consultarCliente(String dni, String nombres, String apellidos){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		try {
			String consulta = "SELECT * FROM clientes c "
					+ "INNER JOIN personas p ON p.id_persona = c.id_cliente "
					+ "WHERE p.dni LIKE '%" + dni + "%' AND p.nombres LIKE '%" + nombres + "%' AND p.apellidos LIKE '%" + apellidos + "%';";
			connection = ConexiónMySQL.getconexión();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(consulta);
			Cliente cliente;
			while (resultSet.next()) {
				cliente = new Cliente();
				cliente.setIdPersona(resultSet.getString("id_persona"));
                cliente.setDni(resultSet.getString("dni"));
                cliente.setNombres(resultSet.getString("nombres"));
                cliente.setApellidos(resultSet.getString("apellidos"));
                cliente.setTelefono(resultSet.getString("telefono"));
                cliente.setDireccion(resultSet.getString("direccion"));
                cliente.setCorreo(resultSet.getString("correo"));
                cliente.setContraseña(resultSet.getString("contraseña"));
                Timestamp fechaHoraBloqueo = resultSet.getTimestamp("fecha_hora_bloqueo");
                cliente.setFechaHoraBloqueo(fechaHoraBloqueo == null? null:fechaHoraBloqueo.toLocalDateTime());
				clientes.add(cliente);
			}
		} catch (Exception e) {
			System.out.println("Error al consultar cliente por dni, nombre y apellidos: " + e);
		} finally {
			try {
				if(connection != null) connection.close();
				if(statement != null) statement.close();
				if(resultSet != null) resultSet.close();
			} catch (Exception e) {
				System.out.println("Error: " + e);
			}
		}
		return clientes;
	}
}

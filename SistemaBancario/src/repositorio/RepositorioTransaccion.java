package repositorio;

import java.sql.*;
import java.util.ArrayList;

import conexión.ConexiónMySQL;
import modelo.Cliente;
import modelo.Transaccion;

public class RepositorioTransaccion {
	public static ArrayList<Transaccion> listarTransaccion() {
    	Connection connection = null;
    	CallableStatement callableStatement = null;
        ArrayList<Transaccion> transacciones = new ArrayList<Transaccion>();
        try {
        	connection = ConexiónMySQL.getconexión();
        	callableStatement = connection.prepareCall("{CALL sp_listarTransaccion()}");
            ResultSet resultSet = callableStatement.executeQuery();
            Transaccion transaccion;
            while (resultSet.next()) {
            	Cliente cliente = new Cliente();
                cliente.setIdPersona(resultSet.getString("id_persona"));
                cliente.setDni(resultSet.getString("dni"));
                cliente.setNombres(resultSet.getString("nombres"));
                cliente.setApellidos(resultSet.getString("apellidos"));
                cliente.setTelefono(resultSet.getString("telefono"));
                cliente.setDireccion(resultSet.getString("direccion"));
                cliente.setCorreo(resultSet.getString("correo"));
                cliente.setContraseña(resultSet.getString("contraseña"));
                transaccion = new Transaccion();
                transaccion.setIdTransaccion(resultSet.getString("id_transaccion"));
                transaccion.setTipoTransaccion(resultSet.getString("tipo_transaccion"));
                transaccion.setDescripcion(resultSet.getString("descripcion"));
                transaccion.setFechaHora(resultSet.getTimestamp("fecha_hora").toLocalDateTime());
                transaccion.setEstado(resultSet.getString("estado"));
                transaccion.setMonto(resultSet.getDouble("monto"));
                transaccion.setCliente(cliente);
                transacciones.add(transaccion);
            }
        } catch (Exception e) {
            System.out.println("Error al listar transacción: " + e);
        } finally {
			try {
				if(connection != null) connection.close();
				if(callableStatement != null) callableStatement.close();
			} catch (Exception e) {
				System.out.println("Error: " + e);
			}
		}
        return transacciones;
	}
	public static void insertarTransaccion(Transaccion transaccion) {
    	Connection connection = null;
    	CallableStatement callableStatement = null;
        try {
        	String procedimientoAlmacenado = "{CALL sp_insertarTransaccion(?, ?, ?, ?, ?, ?, ?)}";
        	connection = ConexiónMySQL.getconexión();
            callableStatement = connection.prepareCall(procedimientoAlmacenado);
            callableStatement.setString(1, transaccion.getIdTransaccion());
            callableStatement.setString(2, transaccion.getTipoTransaccion());
            callableStatement.setString(3, transaccion.getDescripcion());
            callableStatement.setTimestamp(4, Timestamp.valueOf((transaccion.getFechaHora())));
            callableStatement.setString(5, transaccion.getEstado());
            callableStatement.setDouble(6, transaccion.getMonto());
            callableStatement.setString(7, transaccion.getCliente().getIdPersona());
            callableStatement.executeQuery();
        } catch (Exception e) {
            System.out.println("Error al insertar transacción: " + e);
        } finally {
			try {
				if(connection != null) connection.close();
				if(callableStatement != null) callableStatement.close();
			} catch (Exception e) {
				System.out.println("Error: " + e);
			}
		}
	}
	public static void eliminarTransaccion(String idTransaccion) {
    	Connection connection = null;
    	CallableStatement callableStatement = null;
        try {
        	String procedimientoAlmacenado = "{CALL sp_eliminarTransaccion(?)}";
        	connection = ConexiónMySQL.getconexión();
        	callableStatement = connection.prepareCall(procedimientoAlmacenado);
        	callableStatement.setString(1, idTransaccion);
        	callableStatement.executeQuery();
        } catch (Exception e) {
            System.out.println("Error al eliminar transacción: " + e);
        } finally {
			try {
				if(connection != null) connection.close();
				if(callableStatement != null) callableStatement.close();
			} catch (Exception e) {
				System.out.println("Error: " + e);
			}
		}
    }
	public static void actualizarTransaccion(Transaccion transaccion) {
    	Connection connection = null;
    	CallableStatement callableStatement = null;
        try {
        	String procedimientoAlmacenado = "{CALL sp_actualizarTransaccion(?, ?)}";
        	connection = ConexiónMySQL.getconexión();
        	callableStatement = connection.prepareCall(procedimientoAlmacenado);
        	callableStatement.setString(1, transaccion.getIdTransaccion());
        	callableStatement.setString(2, transaccion.getEstado());
        	callableStatement.executeQuery();
        } catch (Exception e) {
            System.out.println("Error al actualizar transacción: " + e);
        } finally {
			try {
				if(connection != null) connection.close();
				if(callableStatement != null) callableStatement.close();
			} catch (Exception e) {
				System.out.println("Error: " + e);
			}
		}
    }
	public static Transaccion consultarIdTransaccion(String idTransaccion) {
    	Connection connection = null;
    	CallableStatement callableStatement = null;
    	ResultSet resultSet = null;
    	Transaccion transaccion= null;
        try {
        	String procedimientoAlmacenado = "{CALL sp_consultarIdTransaccion(?)}";
        	connection = ConexiónMySQL.getconexión();
        	callableStatement = connection.prepareCall(procedimientoAlmacenado);
        	callableStatement.setString(1, idTransaccion);
            resultSet = callableStatement.executeQuery();
            if (resultSet.next()) {
            	Cliente cliente = new Cliente();
                cliente.setIdPersona(resultSet.getString("id_persona"));
                cliente.setDni(resultSet.getString("dni"));
                cliente.setNombres(resultSet.getString("nombres"));
                cliente.setApellidos(resultSet.getString("apellidos"));
                cliente.setTelefono(resultSet.getString("telefono"));
                cliente.setDireccion(resultSet.getString("direccion"));
                cliente.setCorreo(resultSet.getString("correo"));
                cliente.setContraseña(resultSet.getString("contraseña"));
                transaccion = new Transaccion();
                transaccion.setIdTransaccion(resultSet.getString("id_transaccion"));
                transaccion.setTipoTransaccion(resultSet.getString("tipo_transaccion"));
                transaccion.setDescripcion(resultSet.getString("descripcion"));
                transaccion.setFechaHora(resultSet.getTimestamp("fecha_hora").toLocalDateTime());
                transaccion.setEstado(resultSet.getString("estado"));
                transaccion.setMonto(resultSet.getDouble("monto"));
                transaccion.setCliente(cliente);
            }
        } catch (Exception e) {
            System.out.println("Error al consultar id de transacción: " + e);
        } finally {
			try {
				if(connection != null) connection.close();
				if(callableStatement != null) callableStatement.close();
				if(resultSet != null) resultSet.close();
			} catch (Exception e) {
				System.out.println("Error: " + e);
			}
		}
        return transaccion;
    }
	public static ArrayList<Transaccion> consultarTransaccionNumeroCuenta(String numeroCuenta) {
    	Connection connection = null;
    	Statement statement = null;
    	ResultSet resultSet = null;
    	ArrayList<Transaccion> transacciones = new ArrayList<Transaccion>();
        try {
        	String consulta = "SELECT * FROM transacciones t "
        			+ "INNER JOIN clientes c ON c.id_persona = t.id_cliente "
        			+ "INNER JOIN personas p ON p.id_persona = c.id_persona "
        			+ "WHERE t.descripcion LIKE '%" + numeroCuenta + "%';";
        	connection = ConexiónMySQL.getconexión();
        	statement = connection.createStatement();
            resultSet = statement.executeQuery(consulta);
            Transaccion transaccion;
            while (resultSet.next()) {
            	Cliente cliente = new Cliente();
                cliente.setIdPersona(resultSet.getString("id_persona"));
                cliente.setDni(resultSet.getString("dni"));
                cliente.setNombres(resultSet.getString("nombres"));
                cliente.setApellidos(resultSet.getString("apellidos"));
                cliente.setTelefono(resultSet.getString("telefono"));
                cliente.setDireccion(resultSet.getString("direccion"));
                cliente.setCorreo(resultSet.getString("correo"));
                cliente.setContraseña(resultSet.getString("contraseña"));
                transaccion = new Transaccion();
                transaccion.setIdTransaccion(resultSet.getString("id_transaccion"));
                transaccion.setTipoTransaccion(resultSet.getString("tipo_transaccion"));
                transaccion.setDescripcion(resultSet.getString("descripcion"));
                transaccion.setFechaHora(resultSet.getTimestamp("fecha_hora").toLocalDateTime());
                transaccion.setEstado(resultSet.getString("estado"));
                transaccion.setMonto(resultSet.getDouble("monto"));
                transaccion.setCliente(cliente);
                transacciones.add(transaccion);
            }
        } catch (Exception e) {
            System.out.println("Error al consultar transacción por número de cuenta: " + e);
        } finally {
			try {
				if(connection != null) connection.close();
				if(statement != null) statement.close();
				if(resultSet != null) resultSet.close();
			} catch (Exception e) {
				System.out.println("Error: " + e);
			}
		}
        return transacciones;
    }
	public static ArrayList<Transaccion> consultarTransaccion(String idCliente) {
    	Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	ResultSet resultSet = null;
    	ArrayList<Transaccion> transacciones = new ArrayList<Transaccion>();
        try {
        	String consulta = "SELECT * FROM transacciones t "
        			+ "INNER JOIN clientes c ON c.id_persona = t.id_cliente "
        			+ "INNER JOIN personas p ON p.id_persona = c.id_persona "
        			+ "WHERE t.id_cliente = ?;";
        	connection = ConexiónMySQL.getconexión();
        	preparedStatement = connection.prepareStatement(consulta);
        	preparedStatement.setString(1, idCliente);
            resultSet = preparedStatement.executeQuery();
            Transaccion transaccion;
            while (resultSet.next()) {
            	Cliente cliente = new Cliente();
                cliente.setIdPersona(resultSet.getString("id_persona"));
                cliente.setDni(resultSet.getString("dni"));
                cliente.setNombres(resultSet.getString("nombres"));
                cliente.setApellidos(resultSet.getString("apellidos"));
                cliente.setTelefono(resultSet.getString("telefono"));
                cliente.setDireccion(resultSet.getString("direccion"));
                cliente.setCorreo(resultSet.getString("correo"));
                cliente.setContraseña(resultSet.getString("contraseña"));
                transaccion = new Transaccion();
                transaccion.setIdTransaccion(resultSet.getString("id_transaccion"));
                transaccion.setTipoTransaccion(resultSet.getString("tipo_transaccion"));
                transaccion.setDescripcion(resultSet.getString("descripcion"));
                transaccion.setFechaHora(resultSet.getTimestamp("fecha_hora").toLocalDateTime());
                transaccion.setEstado(resultSet.getString("estado"));
                transaccion.setMonto(resultSet.getDouble("monto"));
                transaccion.setCliente(cliente);
                transacciones.add(transaccion);
            }
        } catch (Exception e) {
            System.out.println("Error al consultar transacción por id de cliente: " + e);
        } finally {
			try {
				if(connection != null) connection.close();
				if(preparedStatement != null) preparedStatement.close();
				if(resultSet != null) resultSet.close();
			} catch (Exception e) {
				System.out.println("Error: " + e);
			}
		}
        return transacciones;
    }
	public static ArrayList<Transaccion> consultarTransaccion(String idCliente, String tipoTransaccion, String descripcion) {
    	Connection connection = null;
    	Statement statement = null;
    	ResultSet resultSet = null;
    	ArrayList<Transaccion> transacciones = new ArrayList<Transaccion>();
        try {
        	String consulta = "SELECT * FROM transacciones t "
        			+ "INNER JOIN clientes c ON c.id_persona = t.id_cliente "
        			+ "INNER JOIN personas p ON p.id_persona = c.id_persona "
        			+ "WHERE t.id_cliente = " + idCliente + " AND t.tipo_transaccion LIKE '%" + tipoTransaccion + "%' AND t.descripcion LIKE '%" + descripcion + "%';";
        	connection = ConexiónMySQL.getconexión();
        	statement = connection.createStatement();
            resultSet = statement.executeQuery(consulta);
            Transaccion transaccion;
            while (resultSet.next()) {
            	Cliente cliente = new Cliente();
                cliente.setIdPersona(resultSet.getString("id_persona"));
                cliente.setDni(resultSet.getString("dni"));
                cliente.setNombres(resultSet.getString("nombres"));
                cliente.setApellidos(resultSet.getString("apellidos"));
                cliente.setTelefono(resultSet.getString("telefono"));
                cliente.setDireccion(resultSet.getString("direccion"));
                cliente.setCorreo(resultSet.getString("correo"));
                cliente.setContraseña(resultSet.getString("contraseña"));
                transaccion = new Transaccion();
                transaccion.setIdTransaccion(resultSet.getString("id_transaccion"));
                transaccion.setTipoTransaccion(resultSet.getString("tipo_transaccion"));
                transaccion.setDescripcion(resultSet.getString("descripcion"));
                transaccion.setFechaHora(resultSet.getTimestamp("fecha_hora").toLocalDateTime());
                transaccion.setEstado(resultSet.getString("estado"));
                transaccion.setMonto(resultSet.getDouble("monto"));
                transaccion.setCliente(cliente);
                transacciones.add(transaccion);
            }
        } catch (Exception e) {
            System.out.println("Error al consultar transacción por id de cliente, tipo de transacción y descripción: " + e);
        } finally {
			try {
				if(connection != null) connection.close();
				if(statement != null) statement.close();
				if(resultSet != null) resultSet.close();
			} catch (Exception e) {
				System.out.println("Error: " + e);
			}
		}
        return transacciones;
    }
}

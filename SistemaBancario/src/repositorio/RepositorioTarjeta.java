package repositorio;

import java.sql.*;
import java.util.ArrayList;

import conexión.ConexiónMySQL;
import modelo.Tarjeta;

public class RepositorioTarjeta {
	public static ArrayList<Tarjeta> listarTarjeta() {
    	Connection connection = null;
    	CallableStatement callableStatement = null;
        ArrayList<Tarjeta> tarjetas = new ArrayList<Tarjeta>();
        try {
        	connection = ConexiónMySQL.getconexión();
        	callableStatement = connection.prepareCall("{CALL sp_listarTarjeta()}");
            ResultSet resultSet = callableStatement.executeQuery();
            Tarjeta tarjeta;
            while (resultSet.next()) {
                tarjeta = new Tarjeta();
                tarjeta.setNumeroTarjeta(resultSet.getString(1));
                tarjeta.setEstado(resultSet.getString(2));
                tarjeta.setTipoTarjeta(resultSet.getString(3));
                tarjeta.setFechaVencimiento(resultSet.getDate(4).toLocalDate());
                tarjeta.setCliente(RepositorioCliente.consultarIdCliente(resultSet.getString(5)));
                tarjetas.add(tarjeta);
            }
        } catch (Exception e) {
            System.out.println("Error al listar tarjeta: " + e);
        } finally {
			try {
				if(connection != null) connection.close();
				if(callableStatement != null) callableStatement.close();
			} catch (Exception e) {
				System.out.println("Error: " + e);
			}
		}
        return tarjetas;
    }
	public static void insertarTarjeta(Tarjeta tarjeta) {
    	Connection connection = null;
    	CallableStatement callableStatement = null;
        try {
        	String procedimientoAlmacenado = "{CALL sp_insertarTarjeta(?, ?, ?, ?, ?)}";
        	connection = ConexiónMySQL.getconexión();
            callableStatement = connection.prepareCall(procedimientoAlmacenado);
            callableStatement.setString(1, tarjeta.getNumeroTarjeta());
            callableStatement.setString(2, tarjeta.getEstado());
            callableStatement.setString(3, tarjeta.getTipoTarjeta());
            callableStatement.setDate(4, Date.valueOf(tarjeta.getFechaVencimiento()));
            callableStatement.setString(5, tarjeta.getCliente().getIdPersona());
            callableStatement.executeQuery();
        } catch (Exception e) {
            System.out.println("Error al insertar tarjeta: " + e);
        } finally {
			try {
				if(connection != null) connection.close();
				if(callableStatement != null) callableStatement.close();
			} catch (Exception e) {
				System.out.println("Error: " + e);
			}
		}
    }
	public static void actualizarTarjeta(Tarjeta tarjeta) {
    	Connection connection = null;
    	CallableStatement callableStatement = null;
        try {
        	String procedimientoAlmacenado = "{CALL sp_actualizarTarjeta(?, ?)}";
        	connection = ConexiónMySQL.getconexión();
        	callableStatement = connection.prepareCall(procedimientoAlmacenado);
        	callableStatement.setString(1, tarjeta.getNumeroTarjeta());
        	callableStatement.setString(2, tarjeta.getEstado());
        	callableStatement.executeQuery();
        } catch (Exception e) {
            System.out.println("Error al actualizar tarjeta: " + e);
        } finally {
			try {
				if(connection != null) connection.close();
				if(callableStatement != null) callableStatement.close();
			} catch (Exception e) {
				System.out.println("Error: " + e);
			}
		}
    }
	/*
	public static void eliminarTarjeta(String numeroTarjeta) {
    	Connection connection = null;
    	CallableStatement callableStatement = null;
        try {
        	String procedimientoAlmacenado = "{CALL sp_eliminarTarjeta(?)}";
        	connection = ConexiónMySQL.getconexión();
        	callableStatement = connection.prepareCall(procedimientoAlmacenado);
        	callableStatement.setString(1, numeroTarjeta);
        	callableStatement.executeQuery();
        } catch (Exception e) {
            System.out.println("Error al eliminar tarjeta: " + e);
        } finally {
			try {
				if(connection != null) connection.close();
				if(callableStatement != null) callableStatement.close();
			} catch (Exception e) {
				System.out.println("Error: " + e);
			}
		}
    }*/
	public static Tarjeta consultarNumeroTarjeta(String numeroTarjeta) {
    	Connection connection = null;
    	CallableStatement callableStatement = null;
    	ResultSet resultSet = null;
        Tarjeta tarjeta = null;
        try {
        	String procedimientoAlmacenado = "{CALL sp_consultarNumeroTarjeta(?)}";
        	connection = ConexiónMySQL.getconexión();
        	callableStatement = connection.prepareCall(procedimientoAlmacenado);
        	callableStatement.setString(1, numeroTarjeta);
            resultSet = callableStatement.executeQuery();
            if (resultSet.next()) {
            	tarjeta = new Tarjeta();
            	tarjeta.setNumeroTarjeta(resultSet.getString(1));
                tarjeta.setEstado(resultSet.getString(2));
                tarjeta.setTipoTarjeta(resultSet.getString(3));
                tarjeta.setFechaVencimiento(resultSet.getDate(4).toLocalDate());
                tarjeta.setCliente(RepositorioCliente.consultarIdCliente(resultSet.getString(5)));
            }
        } catch (Exception e) {
            System.out.println("Error al consultar número de tarjeta: " + e);
        } finally {
			try {
				if(connection != null) connection.close();
				if(callableStatement != null) callableStatement.close();
				if(resultSet != null) resultSet.close();
			} catch (Exception e) {
				System.out.println("Error: " + e);
			}
		}
        return tarjeta;
    }
	public static ArrayList<Tarjeta> consultarTarjeta(String idCliente) {
    	Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	ResultSet resultSet = null;
    	ArrayList<Tarjeta> tarjetas = new ArrayList<Tarjeta>();
        try {
        	String consulta = "SELECT * FROM tarjetas "
        			+ "WHERE id_cliente = ?;";
        	connection = ConexiónMySQL.getconexión();
        	preparedStatement = connection.prepareCall(consulta);
        	preparedStatement.setString(1, idCliente);
            resultSet = preparedStatement.executeQuery();
            Tarjeta tarjeta;
            while (resultSet.next()) {
            	tarjeta = new Tarjeta();
            	tarjeta.setNumeroTarjeta(resultSet.getString(1));
                tarjeta.setEstado(resultSet.getString(2));
                tarjeta.setTipoTarjeta(resultSet.getString(3));
                tarjeta.setFechaVencimiento(resultSet.getDate(4).toLocalDate());
                tarjeta.setCliente(RepositorioCliente.consultarIdCliente(resultSet.getString(5)));
                tarjetas.add(tarjeta);
            }
        } catch (Exception e) {
            System.out.println("Error al consultar tarjeta por id del cliente: " + e);
        } finally {
			try {
				if(connection != null) connection.close();
				if(preparedStatement != null) preparedStatement.close();
				if(resultSet != null) resultSet.close();
			} catch (Exception e) {
				System.out.println("Error: " + e);
			}
		}
        return tarjetas;
    }
}

package repositorio;

import java.sql.*;
import java.util.ArrayList;

import conexión.ConexiónMySQL;
import modelo.Cliente;
import modelo.Cuenta;
import modelo.Tarjeta;
import modelo.Transaccion;

public class RepositorioTransaccion {
	 public static ArrayList<Transaccion> getTransaccions() {
	        ArrayList<Transaccion> transacciones = new ArrayList<>();
	        try (Connection cnx = ConexiónMySQL.getconexión();
	             CallableStatement stmt = cnx.prepareCall("{CALL sp_listarTransaccion()}")) {

	            ResultSet rs = stmt.executeQuery();

	            while (rs.next()) {
	                Cliente cliente = new Cliente();
	                cliente.setIdPersona(rs.getString(7)); //id del cliente
	                
	                Transaccion transaccion = new Transaccion(rs.getString(2), rs.getString(3), rs.getDouble(6), cliente);
	                
	                transaccion.getClass().getDeclaredField("idTransaccion").setAccessible(true);
	                transaccion.getClass().getDeclaredField("idTransaccion").set(transaccion, rs.getString(1));
	                
	                
	                transaccion.setEstado(rs.getString(5));
	                transaccion.getClass().getDeclaredField("getFechaHora").setAccessible(true);
	                transaccion.getClass().getDeclaredField("getFechaHora").set(transaccion, rs.getDate(4).toLocalDate());

	                transacciones.add(transaccion);
	            }

	        } catch (Exception e) {
	            System.out.println("Error al listar las transacciones: " + e);
	        }
	        return transacciones;
	    }
	 public static boolean agregarTransaccion(Transaccion transaccion) {
	        try (Connection cnx = ConexiónMySQL.getconexión();
	             CallableStatement stmt = cnx.prepareCall("{CALL sp_insertarTransaccion(?, ?, ?, ?, ?, ?, ?)}")) {

	            stmt.setString(1, transaccion.getIdTransaccion());
	            stmt.setString(2, transaccion.getTipo());
	            stmt.setString(3, transaccion.getDescripcion());
	            stmt.setDate(4, Date.valueOf(transaccion.getFechaHora()));
	            stmt.setString(5, transaccion.getEstado());
	            stmt.setDouble(6, transaccion.getMonto());
	            stmt.setString(7, transaccion.getCliente().getIdPersona());

	            return stmt.executeUpdate() > 0;

	        } catch (Exception e) {
	            System.out.println("Error al insertar la transacción: " + e);
	            return false;
	        }
	    }
	 public static boolean eliminarTransaccion(String idtransaccion) {
	        try (Connection cnx = ConexiónMySQL.getconexión();
	             CallableStatement stmt = cnx.prepareCall("{sp_eliminarTransaccion(?)}")) {

	            stmt.setString(1, idtransaccion);
	            return stmt.executeUpdate() > 0;

	        } catch (Exception e) {
	            System.out.println("Error al eliminar transaccion: " + e);
	            return false;
	        }
	    }
	 
	 public static boolean actualizarTransaccion(String idtransaccion, String estadoactua) {
	        try (Connection cnx = ConexiónMySQL.getconexión();
	             CallableStatement stmt = cnx.prepareCall("{CALL sp_actualizarTransaccion(?, ?)}")) {

	            stmt.setString(1, idtransaccion);
	            stmt.setString(2, estadoactua);
	            return stmt.executeUpdate() > 0;

	        } catch (Exception e) {
	            System.out.println("Error al actualizar estado de transacción: " + e);
	            return false;
	        }
	    }
	 public static Transaccion buscarTransaccion(String idTransaccion) {
	        Transaccion transaccion = null;
	        try (Connection cnx = ConexiónMySQL.getconexión();
	             CallableStatement cstmt = cnx.prepareCall("{CALL sp_buscarIdTransaccion(?)}")) {

	            cstmt.setString(1, idTransaccion);
	            ResultSet rs = cstmt.executeQuery();

	            if (rs.next()) {
	                Cliente cliente = new Cliente();
	                cliente.setIdPersona(rs.getString(7));

	                transaccion = new Transaccion(rs.getString(2), rs.getString(3), rs.getDouble(6), cliente);
	                
	                transaccion.getClass().getDeclaredField("idTransaccion").setAccessible(true);
	                transaccion.getClass().getDeclaredField("idTransaccion").set(transaccion, rs.getString(1));
	                
	                
	                transaccion.setEstado(rs.getString(5));
	                transaccion.getClass().getDeclaredField("getFechaHora").setAccessible(true);
	                transaccion.getClass().getDeclaredField("getFechaHora").set(transaccion, rs.getDate(4).toLocalDate());
	            }

	        } catch (Exception e) {
	            System.out.println("Error al buscar una transacción: " + e);
	        } return transaccion;
	    }

	 
	

}

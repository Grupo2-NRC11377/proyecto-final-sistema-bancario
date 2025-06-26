package repositorio;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conexión.ConexiónMySQL;
import modelo.Cliente;

public class RepositorioCliente {
	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();

	public static ArrayList<Cliente> getClientes(){
		try {
			Connection cnx = ConexiónMySQL.getconexión();
			CallableStatement csta = cnx.prepareCall("{CALL sp_listarCliente()}");
			ResultSet resultSet = csta.executeQuery();
			Cliente cliente;
			while (resultSet.next()) {
				cliente = new Cliente();
				cliente.setIdPersona(resultSet.getString(1));
				cliente.setDni(resultSet.getString(2));
				cliente.setNombres(resultSet.getString(3));
				cliente.setApellidos(resultSet.getString(4));
				cliente.setTelefono(resultSet.getString(5));
				cliente.setDireccion(resultSet.getString(6));
				cliente.setCorreo(resultSet.getString(7));
				cliente.setContraseña(resultSet.getString(8));
				clientes.add(cliente);
			}
		} catch (Exception e) {
			System.out.println("Error al obtener clientes: " + e);
		}
		return clientes;
	}
	
	public static void agregarCliente(Cliente cliente) {
		try {
			Connection cnx = ConexiónMySQL.getconexión();
			CallableStatement csta = cnx.prepareCall("{CALL sp_insertarCliente(?,?,?,?,?,?,?,?)}");
			csta.setString(1, cliente.getIdPersona());
			csta.setString(2, cliente.getDni());
			csta.setString(3, cliente.getNombres());
			csta.setString(4, cliente.getApellidos());
			csta.setString(5, cliente.getTelefono());
			csta.setString(6, cliente.getDireccion());
			csta.setString(7, cliente.getCorreo());
			csta.setString(8, cliente.getContraseña());
			csta.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al insertar cliente: " + e);
		}
	}
	
	public static Cliente buscarCliente(String correo) {
		Cliente cliente = null;
		try {
			Connection cnx = ConexiónMySQL.getconexión();
			PreparedStatement ps = cnx.prepareStatement("{CALL sp_buscarCorreoCliente(?)}");
			ps.setString(1, correo);
			ResultSet resultSet = ps.executeQuery();
			if (resultSet.next()) {
				cliente = new Cliente();
				cliente.setIdPersona(resultSet.getString(1));
				cliente.setDni(resultSet.getString(2));
				cliente.setNombres(resultSet.getString(3));
				cliente.setApellidos(resultSet.getString(4));
				cliente.setTelefono(resultSet.getString(5));
				cliente.setDireccion(resultSet.getString(6));
				cliente.setCorreo(resultSet.getString(7));
				cliente.setContraseña(resultSet.getString(8));
			}
		} catch (Exception e) {
			System.out.println("Error al buscar cliente por correo: " + e);
		}
		return cliente;
	}
	public static Cliente buscarCliente(String correo, String contraseña) {
		Cliente cliente = null;
		try {
			Connection cnx = ConexiónMySQL.getconexión();
			PreparedStatement ps = cnx.prepareStatement("{CALL sp_buscarCorreoContraseñaCliente(?,?)}");
			ps.setString(1, correo);
			ps.setString(2, contraseña);
			ResultSet resultSet = ps.executeQuery();
			if (resultSet.next()) {
				cliente = new Cliente();
				cliente.setIdPersona(resultSet.getString(1));
				cliente.setDni(resultSet.getString(2));
				cliente.setNombres(resultSet.getString(3));
				cliente.setApellidos(resultSet.getString(4));
				cliente.setTelefono(resultSet.getString(5));
				cliente.setDireccion(resultSet.getString(6));
				cliente.setCorreo(resultSet.getString(7));
				cliente.setContraseña(resultSet.getString(8));
			}
		} catch (Exception e) {
			System.out.println("Error al buscar cliente por correo y contraseña: " + e);
		}
		return cliente;
	}
	public static Cliente buscarClientePorDni(String dni) {
		Cliente cliente = null;
		try {
			Connection cnx = ConexiónMySQL.getconexión();
			PreparedStatement ps = cnx.prepareStatement("{CALL sp_buscarDniCliente(?)}");
			ps.setString(1, dni);
			ResultSet resultSet = ps.executeQuery();
			if (resultSet.next()) {
				cliente = new Cliente();
				cliente.setIdPersona(resultSet.getString(1));
				cliente.setDni(resultSet.getString(2));
				cliente.setNombres(resultSet.getString(3));
				cliente.setApellidos(resultSet.getString(4));
				cliente.setTelefono(resultSet.getString(5));
				cliente.setDireccion(resultSet.getString(6));
				cliente.setCorreo(resultSet.getString(7));
				cliente.setContraseña(resultSet.getString(8));
			}
		} catch (Exception e) {
			System.out.println("Error al buscar cliente por DNI: " + e);
		}
		return cliente;
	}
}

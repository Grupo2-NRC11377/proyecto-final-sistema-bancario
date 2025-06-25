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
		ArrayList<Cliente> clientes = new ArrayList<>();
		try {
			Connection cnx = ConexiónMySQL.getconexión();
			CallableStatement csta = cnx.prepareCall("{call sp_listar_clientes()}");
			ResultSet rs = csta.executeQuery();
			while (rs.next()) {
				String dni = rs.getString("dni");
				PreparedStatement ps = cnx.prepareStatement("SELECT * FROM persona WHERE dni = ?");
				ps.setString(1, dni);
				ResultSet rsPersona = ps.executeQuery();
				if (rsPersona.next()) {
					Cliente cliente = new Cliente(
						dni,
						rsPersona.getString("nombres"),
						rsPersona.getString("apellidos"),
						rsPersona.getString("telefono"),
						rsPersona.getString("direccion"),
						rsPersona.getString("correo"),
						rsPersona.getString("contraseña")
					);
					clientes.add(cliente);
				}
			}
		} catch (Exception e) {
			System.out.println("Error al obtener clientes: " + e);
		}
		return clientes;
	}
	
	public static void agregarCliente(Cliente cliente) {
		try {
			Connection cnx = ConexiónMySQL.getconexión();
			CallableStatement csta = cnx.prepareCall("{call sp_insertar_cliente(?,?,?,?,?,?,?)}");
			csta.setString(1, cliente.getDni());
			csta.setString(2, cliente.getNombres());
			csta.setString(3, cliente.getApellidos());
			csta.setString(4, cliente.getTelefono());
			csta.setString(5, cliente.getDireccion());
			csta.setString(6, cliente.getCorreo());
			csta.setString(7, cliente.getContraseña());
			csta.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al insertar cliente: " + e);
		}
	}
	
	public static Cliente buscarCliente(String correo) {
		Cliente cliente = null;
		try {
			Connection cnx = ConexiónMySQL.getconexión();
			PreparedStatement ps = cnx.prepareStatement("{call sp_buscar_cliente_correo(?)}?");
			ps.setString(1, correo);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				cliente = new Cliente(
					rs.getString("dni"),
					rs.getString("nombres"),
					rs.getString("apellidos"),
					rs.getString("telefono"),
					rs.getString("direccion"),
					rs.getString("correo"),
					rs.getString("contraseña")
				);
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
			PreparedStatement ps = cnx.prepareStatement("{call sp_buscar_cliente_correo_contraseña(?,?)}");
			ps.setString(1, correo);
			ps.setString(2, contraseña);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				cliente = new Cliente(
					rs.getString("dni"),
					rs.getString("nombres"),
					rs.getString("apellidos"),
					rs.getString("telefono"),
					rs.getString("direccion"),
					rs.getString("correo"),
					rs.getString("contraseña")
				);
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
			PreparedStatement ps = cnx.prepareStatement("{call sp_buscar_cliente_dni(?)}");
			ps.setString(1, dni);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				cliente = new Cliente(
					rs.getString("dni"),
					rs.getString("nombres"),
					rs.getString("apellidos"),
					rs.getString("telefono"),
					rs.getString("direccion"),
					rs.getString("correo"),
					rs.getString("contraseña")
				);
			}
		} catch (Exception e) {
			System.out.println("Error al buscar cliente por DNI: " + e);
		}
		return cliente;
	}
}

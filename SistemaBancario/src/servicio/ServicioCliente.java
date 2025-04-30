package servicio;

import java.util.ArrayList;

import modelo.Cliente;

public class ServicioCliente {
	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	public static void agregarCliente(Cliente cliente) {
		clientes.add(cliente);
	}
	
	public static Cliente buscarCliente(String correo) {
		for(Cliente cliente : clientes) {
			if(cliente.getCorreo().equals(correo)) return cliente;
		}
		return null;
	}
	public static Cliente buscarCliente(String correo, String contraseña) {
		for(Cliente cliente : clientes) {
			if(cliente.getCorreo().equals(correo) && cliente.getContraseña().equals(contraseña)) return cliente;
		}
		return null;
	}

}

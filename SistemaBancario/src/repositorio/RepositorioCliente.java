package repositorio;

import java.util.ArrayList;

import modelo.Cliente;

public class RepositorioCliente {
	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();

	static {
		clientes.add(new Cliente("00000001","Carlos","Martínez Sánchez","955501003","Jirón Desconocido 456, Urb. Modelo, Ciudad Ejemplo","carlos.martinez@email.com","ClaveEjemplo#1"));
		clientes.add(new Cliente("00000002","Ana","Gonzales Castillo","933112233","Pasaje Inventado 789, Zona Test, Ciudad Ejemplo","ana.gonzales@email.com","ClaveEjemplo#2"));
	}
	
	public static void agregarCliente(Cliente cliente) {
		clientes.add(cliente);
	}
	
	public static Cliente buscarCliente(String correo) {
		for(Cliente cliente : clientes) 
			if(cliente.getCorreo().equals(correo)) 
				return cliente;
		return null;
	}
	public static Cliente buscarCliente(String correo, String contraseña) {
		for(Cliente cliente : clientes)
			if(cliente.getCorreo().equals(correo) && cliente.getContraseña().equals(contraseña)) 
				return cliente;
		return null;
	}
	public static Cliente buscarClientePorDni(String dni) {
		for(Cliente cliente : clientes) 
			if(cliente.getDni().equals(dni)) 
				return cliente;
		return null;
	}
}

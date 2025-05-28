package repositorio;

import java.util.ArrayList;
import java.util.Random;

import modelo.Empleado;

public class RepositorioEmpleado {
	private static ArrayList<Empleado> empleados = new ArrayList<Empleado>();
	
	static {
		empleados.add(new Empleado("00000001","Juan","Pérez García","987654321","Calle Falsa 123, Distrito Imaginario, Ciudad Ejemplo","juan.perez@empleado.com","ClaveEjemplo#1"));
		empleados.add(new Empleado("00000002","María","López Rodríguez","912345678","Avenida Siempre Viva 742, Sector Demo, Ciudad Ejemplo","maria.lopez@empleado.com","ClaveEjemplo#2"));
	}
	
	public static void agregarEmpleado(Empleado empleado) {
		empleados.add(empleado);
	}
	
	public static Empleado buscarEmpleado(String correo) {
		for(Empleado empleado : empleados) 
			if(empleado.getCorreo().equals(correo)) 
				return empleado;
		return null;
	}
	
	public static Empleado buscarEmpleado(String correo, String contraseña) {
		for(Empleado empleado : empleados) 
			if(empleado.getCorreo().equals(correo) && empleado.getContraseña().equals(contraseña)) 
				return empleado;
		return null;
	}
	
	public static Empleado buscarEmpleadoPorDni(String dni) {
		for(Empleado empleado : empleados) 
			if(empleado.getCorreo().equals(dni)) 
				return empleado;
		return null;
	}
	
	public static Empleado obtenerEmpleadoAleatorio() {
		if(empleados.size() == 0) return null;
		Random rand = new Random();
		return empleados.get(rand.nextInt(empleados.size()));
	}
}

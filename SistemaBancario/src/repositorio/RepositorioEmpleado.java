package repositorio;

import java.util.ArrayList;
import java.util.Random;

import modelo.Empleado;

public class RepositorioEmpleado {
	private static ArrayList<Empleado> empleados = new ArrayList<Empleado>();
	
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

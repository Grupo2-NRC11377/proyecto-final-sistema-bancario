package modelo;
import java.util.ArrayList;

public class Cliente extends Persona {
	 private ArrayList<Cuenta> cuentas;

	    public Cliente(String nombres, String apellidos, int telefono, String direccion, String correo, String contraseña) {
	        super(nombres, apellidos, telefono, direccion, correo, contraseña);
	        this.cuentas = new ArrayList<>();
	    }

	    public boolean agregarCuenta(Cuenta cuenta) {
	        if (buscarCuenta(cuenta.getNumeroCuenta()) != null) {
	            return false;
	        }
	        return cuentas.add(cuenta);
	    }

	    public Cuenta buscarCuenta(long numeroDeCuenta) {
	        for (Cuenta cuenta : cuentas) {
	            if (cuenta.getNumeroCuenta() == numeroDeCuenta) {
	                return cuenta;
	            }
	        }
	        return null;
	    }

	    public ArrayList<Cuenta> getCuentas() {
	        return cuentas;
	    }
}

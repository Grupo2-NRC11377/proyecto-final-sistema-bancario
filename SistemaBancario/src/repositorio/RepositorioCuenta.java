package repositorio;

import java.util.ArrayList;

import modelo.Cuenta;

public class RepositorioCuenta {
	private static ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
	
    public static ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }

	public static boolean agregarCuenta(Cuenta cuenta) {
        if (buscarCuenta(cuenta.getNumeroCuenta()) != null) return false;
        return cuentas.add(cuenta);
    }

    public static Cuenta buscarCuenta(String numeroCuenta) {
        for (Cuenta cuenta : cuentas) 
        	if (cuenta.getNumeroCuenta().equals(numeroCuenta)) 
        		return cuenta;
        return null;
    }
}

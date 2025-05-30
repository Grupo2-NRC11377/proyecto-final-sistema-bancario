package modelo;
import java.util.ArrayList;

public class Cliente extends Persona {
	private ArrayList<Cuenta> cuentas;
	private ArrayList<Tarjeta> tarjetas;
	private ArrayList<Transaccion> transacciones;

    public Cliente(String dni, String nombres, String apellidos, String telefono, String direccion, String correo,
			String contraseña) {
		super(dni, nombres, apellidos, telefono, direccion, correo, contraseña);
		cuentas = new ArrayList<Cuenta>();
		tarjetas = new ArrayList<Tarjeta>();
		transacciones = new ArrayList<Transaccion>();
	}
    
    public ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }

	public boolean agregarCuenta(Cuenta cuenta) {
        if (buscarCuenta(cuenta.getNumeroCuenta()) != null) return false;
        return cuentas.add(cuenta);
    }

    public Cuenta buscarCuenta(String numeroCuenta) {
        for (Cuenta cuenta : cuentas) 
        	if (cuenta.getNumeroCuenta().equals(numeroCuenta)) 
        		return cuenta;
        return null;
    }
    
    public ArrayList<Tarjeta> getTarjetas() {
		return tarjetas;
	}
    
    public boolean agregarTarjeta(Tarjeta tarjeta) {
        if (buscarTarjeta(tarjeta.getNumeroTarjeta()) != null) return false;
        return tarjetas.add(tarjeta);
    }
    
    public Tarjeta buscarTarjeta(String numeroTarjeta) {
        for (Tarjeta tarjeta : tarjetas) 
        	if (tarjeta.getNumeroTarjeta().equals(numeroTarjeta)) 
        		return tarjeta;
        return null;
    }
    
    public ArrayList<Transaccion> getTransacciones() {
		return transacciones;
	}
    
    public boolean agregarTransaccion(Transaccion transaccion) {
        if (buscarTransaccion(transaccion.getIdTransaccion()) != null) return false;
        return transacciones.add(transaccion);
    }
    
    public Transaccion buscarTransaccion(String idTransaccion) {
        for (Transaccion transaccion : transacciones) 
        	if (transaccion.getIdTransaccion().equals(idTransaccion)) 
        		return transaccion;
        return null;
    }
}

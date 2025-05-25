package modelo;
import java.util.ArrayList;

public class Cliente extends Persona {
	private ArrayList<Cuenta> cuentas;
	private ArrayList<Tarjeta> tarjetas;

    public Cliente(String nombres, String apellidos, int telefono, String direccion, String correo, String contraseña) {
        super(nombres, apellidos, telefono, direccion, correo, contraseña);
        this.cuentas = new ArrayList<>();
		this.tarjetas = new ArrayList<>();
        agregarCuenta(new Cuenta("Cuenta de ahorro"));
		agregarCuenta(new Cuenta("Cuenta corriente"));
		agregarTarjeta(new Tarjeta("Débito"));
		agregarTarjeta(new Tarjeta("Crédito"));
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
    
    public Cuenta eliminarCuenta(String numeroCuenta) {
    	Cuenta cuenta = buscarCuenta(numeroCuenta);
    	if(cuenta == null || cuenta.getEstado().equals("cancelada")) return null;
    	cuentas.remove(cuenta);
        return cuenta;
    }

    public ArrayList<Cuenta> getCuentas() {
        return cuentas;
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
    
    public ArrayList<Tarjeta> getTarjetas() {
		return tarjetas;
	}
}

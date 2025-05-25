package modelo;

import java.util.HashMap;
import java.util.Set;

//Clase temporal para simular cuentas y probar las transacciones (luego la cambiaremos al vincular con una base de datos)
public class SimulaciónCuentas {
	private static HashMap<String, Double> cuentas = new HashMap<>();

	static {
		// Simulación de cuentas con saldos
		cuentas.put("123", 1000.0);
		cuentas.put("456", 1500.0);
		cuentas.put("789", 500.0);
	}

	public static boolean existeCuenta(String nroCuenta) {
		return cuentas.containsKey(nroCuenta);
	}

	public static double obtenerSaldo(String nroCuenta) {
		return cuentas.getOrDefault(nroCuenta, 0.0);
	}

	public static boolean transferir(String origen, String destino, double monto) {
		if (!existeCuenta(origen) || !existeCuenta(destino)) return false;
		if (cuentas.get(origen) < monto) return false;

		cuentas.put(origen, cuentas.get(origen) - monto);
		cuentas.put(destino, cuentas.get(destino) + monto);
		
		// Registro de la transacción en el historial
		Transacción.agregarTransacción("Transferencia", monto, "Exitosa", origen);
		return true;
	}

	public static boolean pagar(String cuenta, double monto) {
		if (!existeCuenta(cuenta)) return false;
		if (cuentas.get(cuenta) < monto) return false;

		cuentas.put(cuenta, cuentas.get(cuenta) - monto);
		
		// Registro de la transacción en el historial
		Transacción.agregarTransacción("Pago", monto, "Exitosa", cuenta);
		return true;
	}
	
	public static Set<String> obtenerTodasLasCuentas() {
		return cuentas.keySet();
	}
}

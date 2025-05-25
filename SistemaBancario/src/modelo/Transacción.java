package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Transacción {
	public int idTransacción;
	public String tipoTransacción;
	public LocalDateTime FechaYhora;
	public double montoTransacción;
	public String estadoTransacción;
	private String cuenta;
	
	// Lista estática para almacenar todas las transacciones realizadas
    private static List<Transacción> historialTransacciones = new ArrayList<>();
    private static int contadorId = 1;
	
	public Transacción(int idTransacción, String tipoTransacción, LocalDateTime fechaYhora, double montoTransacción,
			String estadoTransacción, String cuenta) {
		super();
		this.idTransacción = idTransacción;
		this.tipoTransacción = tipoTransacción;
		FechaYhora = fechaYhora;
		this.montoTransacción = montoTransacción;
		this.estadoTransacción = estadoTransacción;
		this.cuenta = cuenta;
	}
	public int getIdTransacción() {
		return idTransacción;
	}
	public void setIdTransacción(int idTransacción) {
		this.idTransacción = idTransacción;
	}
	public String getTipoTransacción() {
		return tipoTransacción;
	}
	public void setTipoTransacción(String tipoTransacción) {
		this.tipoTransacción = tipoTransacción;
	}
	public LocalDateTime getFechaYhora() {
		return FechaYhora;
	}
	public void setFechaYhora(LocalDateTime fechaYhora) {
		FechaYhora = fechaYhora;
	}
	public double getMontoTransacción() {
		return montoTransacción;
	}
	public void setMontoTransacción(double montoTransacción) {
		this.montoTransacción = montoTransacción;
	}
	public String getEstadoTransacción() {
		return estadoTransacción;
	}
	public void setEstadoTransacción(String estadoTransacción) {
		this.estadoTransacción = estadoTransacción;
	}
	public String getCuenta() {
		return cuenta;
	}
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	

	
	 // MÉTODOS ESTÁTICOS para manejar el historial
	// Agrega una transacción exitosa al historial con id automático 
    public static void agregarTransacción(String tipo, double monto, String estado, String cuenta) {
        Transacción t = new Transacción(contadorId++, tipo, LocalDateTime.now(), monto, estado, cuenta);
        historialTransacciones.add(t);
    }

    /** Devuelve todas las transacciones almacenadas */
    public static List<Transacción> obtenerTransacciones() {
        return historialTransacciones;
    }

    /** Filtra transacciones por tipo (si tipoFiltro es null o vacío devuelve todas) */
    public static List<Transacción> filtrarPorTipo(String tipoFiltro) {
        List<Transacción> filtrado = new ArrayList<>();
        if (tipoFiltro == null || tipoFiltro.isEmpty()) {
            filtrado.addAll(historialTransacciones);
        } else {
            for (Transacción t : historialTransacciones) {
                if (t.getTipoTransacción().toLowerCase().contains(tipoFiltro.toLowerCase())) {
                    filtrado.add(t);
                }
            }
        }
        return filtrado;
    }
}

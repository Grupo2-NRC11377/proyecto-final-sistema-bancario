package modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Transaccion {
	private String idTransaccion;
	private String tipo;
	private String descripcion;
	private LocalDateTime fechaHora;
	private String estado;
	private double monto;
	private Cliente Cliente;
	
	public Transaccion(String tipo, String descripcion, double monto, Cliente Cliente) {
		this.idTransaccion = UUID.randomUUID().toString();
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.fechaHora = LocalDateTime.now();
		this.estado = "pendiente";
		this.monto = monto;
		this.Cliente= Cliente;
	}

	public String getIdTransaccion() {
		return idTransaccion;
	}

	public String getTipo() {
		return tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getFechaHora() {
		return fechaHora.format(DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss"));
	}

	public String getEstado() {
		return estado;
	}

	public double getMonto() {
		return monto;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Cliente getCliente() {
		return Cliente;
	}
	
}

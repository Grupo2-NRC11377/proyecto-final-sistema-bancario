package modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Tarjeta {
	private String numeroTarjeta;
	private String tipoTarjeta;
	private String estado;
	private Cliente cliente;
	private LocalDateTime fechaVencimiento;

	public Tarjeta(String tipoTarjeta, Cliente cliente) {
		this.cliente = cliente;
	    this.tipoTarjeta = tipoTarjeta;
	    this.numeroTarjeta = generarNumeroTarjeta();
	    this.estado = "activa";
	    this.fechaVencimiento = LocalDateTime.now().plusYears(2);
	}

	private String generarNumeroTarjeta() {
		Random rand = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 16; i++) {
			sb.append(rand.nextInt(10));
		}
		return sb.toString();
	}

	public String getFechaVencimiento() {
		return fechaVencimiento.format(DateTimeFormatter.ofPattern("MM/yy"));
	}

	public String getNumeroTarjeta() {
		String numero = "";
		for (int i = 0; i < numeroTarjeta.length(); i++) {
			if(i % 4 == 0) numero += " ";
			numero += numeroTarjeta.charAt(i);
		}
	    return numero;
	}

	public String getTipoTarjeta() {
		return tipoTarjeta;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	public void setFechaVencimiento(LocalDateTime fechaVencimiento) {
	    this.fechaVencimiento = fechaVencimiento;
	}
}

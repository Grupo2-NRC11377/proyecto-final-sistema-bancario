package modelo;

import java.util.Random;

public class Tarjeta {
	private String numero;
	private String tipo;
	private String estado;
	private String fechaVencimiento;

	public Tarjeta(String tipo) {
	    this.tipo = tipo;
	    this.numero = generarNumeroTarjeta();
	    this.estado = "activa";
	    this.fechaVencimiento = generarFechaVencimiento();
	}

	private String generarNumeroTarjeta() {
		Random rand = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 16; i++) {
			sb.append(rand.nextInt(10));
		}
		return sb.toString();
	}
	private String generarFechaVencimiento() {
	    int mes = (int)(Math.random() * 12) + 1; 
	    int año = 28 + (int)(Math.random() * 3);
	    return String.format("%02d/%02d", mes, año);
	}

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getNumero() {
	    return numero.replaceAll("(.{4})(?!$)", "$1 ");
	}

	public String getTipo() {
		return tipo;
	}

	public String getEstado() {
		return estado;
	}

	public void bloquear() {
		this.estado = "bloqueada";
	}

	public boolean estaActiva() {
		return "activa".equals(estado);
	}	
}

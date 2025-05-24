package modelo;
import java.util.Random;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class Cuenta {
	protected String numeroCuenta;
	protected int saldoContable;
	protected int saldoDisponible;
	protected LocalDate fechaCreacion;
	protected String estado;
	protected String tipoCuenta;
	public Cuenta(String tipoCuenta) {
		this.numeroCuenta = generarNumeroCuenta();
		this.saldoContable = this.saldoDisponible = 0;
		this.fechaCreacion = LocalDate.now();
		this.estado = "activa";
		this.tipoCuenta = tipoCuenta;
	}
	private String generarNumeroCuenta() {
		Random rand = new Random();
		String numero = "";
		for (int i = 0; i < 10; i++)
	    {
	        int n = rand.nextInt(10);
	        numero += Integer.toString(n);
	    }
		return numero;
	}
	public boolean retirar(int monto) {
		if(monto > saldoDisponible || monto < 0) return false;
		saldoContable -= monto;
		saldoDisponible -= monto;
		return true;
	}
	public boolean depositar(int monto) {
		if(monto < 0) return false;
		saldoContable += monto;
		saldoDisponible += monto;
		return true;
	}
	public void cancelar() {
		this.estado = "cancelada";
	}
	public String getNumeroCuenta() {
		return numeroCuenta.substring(0, 3) + "-" + numeroCuenta.substring(3);
	}
	public int getSaldoContable() {
		return saldoContable;
	}
	public int getSaldoDisponible() {
		return saldoDisponible;
	}
	public String getFechaCreacion() {
		return fechaCreacion.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	public String getEstado() {
		return estado;
	}
	public String getTipoCuenta() {
		return tipoCuenta;
	}
}

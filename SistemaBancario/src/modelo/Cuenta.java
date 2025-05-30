package modelo;
import java.util.Random;
import java.time.format.DateTimeFormatter;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

public class Cuenta {
	private String numeroCuenta;
	private double saldoContable;
	private double saldoDisponible;
	private LocalDate fechaCreacion;
	private String estado;
	private String tipoCuenta;
	private String moneda;
	private ArrayList<Transaccion> transacciones;

	public Cuenta(String tipoCuenta, String moneda) {
		this.numeroCuenta = generarNumeroCuenta();
		this.saldoContable = this.saldoDisponible = 0;
		this.fechaCreacion = LocalDate.now();
		this.estado = "activa";
		this.tipoCuenta = tipoCuenta;
		this.moneda = moneda;
		this.transacciones = new ArrayList<Transaccion>();
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
	
	public void setSaldoContable(double saldoContable) {
		this.saldoContable = saldoContable;
	}
	public void setSaldoDisponible(double saldoDisponible) {
		this.saldoDisponible = saldoDisponible;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getNumeroCuenta() {
		return numeroCuenta.substring(0, 3) + "-" + numeroCuenta.substring(3);
	}
	public double getSaldoContable() {
		return saldoContable;
	}
	public double getSaldoDisponible() {
		return saldoDisponible;
	}
	@SuppressWarnings("deprecation")
	public String getSaldoContableFormateado() {
		Locale locale;
		switch (moneda) {
	        case "dólares":
	        	locale = new Locale("en", "US");
	            break;
	        case "euros":
	        	locale = new Locale("es", "ES");
	            break;
	        case "libras":
	        	locale = new Locale("en", "GB");
	            break;
	        default:
	        	locale = new Locale("es", "PE");
	            break;
	    }
	    NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
		return numberFormat.format(saldoContable);
	}
	@SuppressWarnings("deprecation")
	public String getSaldoDisponibleFormateado() {
		Locale locale;
		switch (moneda) {
	        case "dólares":
	        	locale = new Locale("en", "US");
	            break;
	        case "euros":
	        	locale = new Locale("es", "ES");
	            break;
	        case "libras":
	        	locale = new Locale("en", "GB");
	            break;
	        default:
	        	locale = new Locale("es", "PE");
	            break;
	    }
	    NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
		return numberFormat.format(saldoDisponible);
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
	public ArrayList<Transaccion> getTransacciones() {
		return transacciones;
	}
	public void agregarTransaccion(Transaccion transaccion) {
		transacciones.add(transaccion);
	}
	public String getMoneda() {
		return moneda;
	}
}
